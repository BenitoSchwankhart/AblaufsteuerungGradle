package clientServerConnection;

import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;



/**
 * Beherbergt den ConnectionThread, welcher sich via Zustandsverwaltung der
 * Verbindung um alle Verbindungszustaende kuemmert. Zentrale Klasse des
 * communication-Pakets.</BR></BR> 
 * 
 * Zum herstellen einer Verbindung:</BR>
 * Connection myConnection = Connection.getConnection();</BR>
 * myConnection.setConnecting();</BR></BR>
 * 
 * Zum trennen einer Verbindung: </BR> 
 * myConnection.setDisconnecting();</BR></BR> 
 * 
 * 
 * 
 * @author Corinna Coels
 */
public class Connection {

	// Singleton-Vorarbeiten: =======================================

	/**
	 * Verwaltet die TCP-Verbindung. Singleton-Objekt.
	 */
	private static Connection connectionInstance;
	
	/**
	 * Objekt fuer den ConnectionThread. Wird benutzt um den Thread zu starten,
	 * zu terminieren und bei Bedarf erneut starten zu koennen.
	 */
	private static Thread cThread = null;

	/**
	 * Konstruktor. Private. Stellt sicher das niemand das Objekt instanzieren
	 * kann, auﬂer der Connection-Klasse.
	 */
	private Connection() {

	}

	/**
	 * Gibt die Connection zurueck. Synchronisiert um bei parallelen Zugriffen
	 * ueber Threads Probleme zu vermeiden.
	 * 
	 * @return Connection - Singleton-Objekt
	 */
	public static synchronized Connection getConnection() {
		if (connectionInstance == null) {
			connectionInstance = new Connection();
		}
		return connectionInstance;
	}

	/**
	 * Klonen des Objects via Vererbung nicht erlaubt. Nur eine weitere
	 * Sicherheit, dass die Singleton-Eigenschaft nicht umgangen wird.
	 */
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	// Ende der Singleton-Vorarbeiten. ==============================
	// Beginn der restlichen Klasseneigenschaften ===================

	protected static Socket socket;
	private static InputStream input;
	/**
	 * Hilfsvariable. Wird vor jedem ausgehend verschickten Paket auf false
	 * gesetzt. Erst nach eingehender Positivquittung/sonstiger Bestaetigung
	 * wieder true. Erst bei true-Wert kann wieder ein weiteres ausgehender
	 * Befehl versandt werden.</br>
	 * Faustregel: </br>
	 * Send-Commands setzen Wert auf false. </br>
	 * Receive-Commands koennen auf true setzen (sofern Bestaetigungsnachricht). 
	 * </br>
	 * Connection: Prueft den aktuellen Wert und trifft somit Entscheidungen. 
	 */
	protected static boolean lastCommandFinished = false;

	// Konstanten des RMX-Protokolls
	public static final byte HEADBYTE = 0x7c;
	public static final byte RMXVERSION = 0x01;

	// Wichtige RMX-Default-Pakete bzw. statische Pakete
	public static final byte[] MSG_POSITIVEHANDSHAKE = new byte[] { HEADBYTE,
			0x04, 0x00, 0x00 };
	public static final byte[] MSG_INITIALIZE = new byte[] { HEADBYTE, 0x05,
			0x03, 0x02, RMXVERSION };
	public static final byte[] MSG_READALLTRAININFOS = new byte[] { HEADBYTE, 0x04, 0x08, 0x01 };
	public static final byte[] MSG_READSTATUS = new byte[] { HEADBYTE, 0x03, 0x04 };
	public static final byte[] MSG_POWERON = new byte[] { HEADBYTE, 0x04, 0x03,
			(byte) 128 };
	public static final byte[] MSG_POWEROFF = new byte[] { HEADBYTE, 0x04,
			0x03, 0x40 };
	public static final byte[] MSG_PANIC = new byte[] { HEADBYTE, 0x04, 0x03,
			0x08 };

	// Konstanten des Verbindungsstatus
	private static final int NULL = 0;
	private static final int CONNECTING = 1;
	private static final int CONNECTED = 2;
	private static final int DISCONNECTING = 3;
	private static final int DISCONNECTED = 4;

	/**
	 * Hilfsvariable zur Steuerung des Verbindungsstatus.</BR>Thread startet im
	 * nicht verbundenen Zustand, erst durch Aufruf der setConnecting()-Methode
	 * wird versucht eine Verbindung zum angegebenen Server herzustellen.
	 */
	private static int connectionStatus = DISCONNECTED;
	
	/**
	 * Gibt den aktuellen Verbindungszustand des Clients zurueck. Kann benutzt
	 * werden, damit externe Pakete die Konnektivitaet bzw. den Zustand abfragen
	 * und/oder beobachten koennen. </BR></BR>
	 * 
	 * Zustandswerte: </BR>
	 * 0 - NULL - Nicht verbunden, Thread ist dabei zu terminieren!</BR>
	 * 1 - CONNECTING - Verbindungsaufbau, Einrichten der Verbindung usw. </BR>
	 * 2 - CONNECTED - Verbunden, Normalbetrieb der Verbindung</BR>
	 * 3 - DISCONNECTING - Verbindungsabbau, Schliessen der Verbindung usw. </BR>
	 * 4 - DISCONNECTED - Nicht verbunden</BR>
	 * 
	 * @return int
	 */
	public static int getConnectionStatus() {
		return connectionStatus;
	}

	/**
	 * Hilfsvariable. Prueft ob der ConnectionThread terminiert werden soll. 
	 */
	private static boolean askToTerminate = false; 
	
	/**
	 * Alle aufgetretenen Exceptions und Fehler werden in der Liste abgelegt.
	 * Diese kann dann ueber den Getter von extern beobachtet werden. Wenn die
	 * Liste einen Inhalt hat, kann der Fehlerstring auf der GUI ausgegeben
	 * werden. Danach sollte die Liste ueber die clear-Methode geleert werden.
	 */
	protected static List<String> errorList = new ArrayList<String>();
	
	/**
	 * Gibt die Fehlerliste zurueck, welche alle bis dahin aufgetretenen
	 * Fehlermeldungen enthaelt (z.B. ConnectionTimeouts usw.)
	 * 
	 * @return Liste aus Strings
	 */
	public static List<String> getErrorList() {
		return errorList;
	}

	/**
	 * Leert die Fehlerliste. Es wird empfohlen die Liste nach dem Auslesen zu
	 * leeren.
	 */
	public static void clearErrorList() {
		errorList.clear();
	}

	/**
	 * Veranlasst den ConnectionThread die Verbindung zu initialisieren. 
	 */
	public void setConnecting() {
		// Falls kein aktueller Thread besteht... neuen starten
		if (cThread == null) {
			cThread = new Thread(new ConnectionThread());
			
			// Exception Handler fuer potentiell nicht gefangene Exceptions: 
			Thread.UncaughtExceptionHandler h = new Thread.UncaughtExceptionHandler() {
			    public void uncaughtException(Thread th, Throwable ex) {
			        Connection.errorList.add("Exception in ConnectionThread: " + ex);
			    }
			};
			cThread.setUncaughtExceptionHandler(h);
			
			cThread.start();
		}
		if (connectionStatus == DISCONNECTED || connectionStatus == NULL) {
			connectionStatus = CONNECTING; 
			askToTerminate = false; 
		}
	}
	
	/**
	 * Veranlasst den ConnectionThread die Verbindung zu abzubauen. 
	 */
	public void setDisconnecting() {
		if (connectionStatus == CONNECTED
				|| connectionStatus == CONNECTING) {
			connectionStatus = DISCONNECTING;
		}
	}
	
	/**
	 * Veranlasst den ConnectionThread die Verbindung abzubauen und danach sich
	 * selbst zu terminieren. Wird in aller Regel nur benoetigt, wenn die
	 * zugehoerige Anwendung geschlossen wird.
	 */
	public void terminateThread() {
		setDisconnecting();
		askToTerminate = true; 
	}

	/**
	 * Stellt die Verbindung her. Socket-Objekt in Connections-Klasse wird
	 * dadurch initialisiert.
	 * 
	 * @param timeout
	 *            - int - Timeout fuer den Verbindungsversuch in Millisekunden.
	 *            0 steht fuer unendlich.
	 * 
	 * @throws UnknownHostException
	 * @throws IOException
	 * @throws ConnectException
	 */
	
		}
