package clientServerConnection;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;

public class ConnectionCalls{
	
//* sendet eine Positivquittung um die Verbindung zu testen, und setzt dann die Verbindung auf Connected//
	public void Verbindung() throws IOException {
		RmxCalls rmx = new RmxCalls();
		ServerCall.serverConnection(RmxCalls.Positivquittung);
		rmx.setVerbindungCONNECTED();
	}
	
//* Setzt das Rmx-System auf Start//
	public static void PowerOn() throws IOException {
		ServerCall.serverConnection(RmxCalls.PowerOn);
	}

//* Setzt das Rmx-System auf Stop//
	public static void PowerOff() throws IOException {
		ServerCall.serverConnection(RmxCalls.PowerOff);
	}

//* Das System macht Nothalt aller Loks//
	public static void Notfall() throws IOException {
		ServerCall.serverConnection(RmxCalls.Notfall);
	}

//* Gibt die Zugnummer und den Zugnamen zurück//
	public static void ZugInfo() throws IOException {
		ServerCall.serverConnectionZugCall(RmxCalls.ZugInfo);
	}
	
//* Gibt erst Protokollversion, dann die Businhalte (Betriebsdaten) beider RMX-Busse,  danach die Fahrdaten von RMX0. 
//* Nach jeder Kanalinfo werden ebenfalls die Steuerungsdaten der jeweiligen Lok ausgegeben. Zuerst
//* die Antwort Loksteuerung Geschwindigkeit und Richtung. Danach die Antwort Loksteuerung Funktionen.
//* Als letztes wird zur Kennzeichnung der vollständigen Ausgabe noch die Antwort auf eine
//* Statusabfrage an den Client gesendet
	public static void Status() throws IOException {
		ServerCall.serverConnection(RmxCalls.Status);
	}
	
	//* Erstellt neuen Zug in der Datenbank gilt nur für DCC mit kurzer Adresse
	public static void ZugErstellen(/*byte COUNT, byte ZUGNR, byte OPMODE, byte[] NAME*/)throws IOException { 
		
		//Dient zur DEMO-Zwecken
		byte ZUGNR = 0x03; // Kann selbst gewählt werden
		byte COUNT = 0x0B; // Anzahl der NAME Zeichen + 7 oder 7(0x07) für keine Alphanumerische Zeichen
		byte OPMODE = 0x09;//(0x09)-> 14 FS, (0x0C)-> 28 FS, (0x0F)-> 126 FS
		byte[] NAME = new byte[] {0x44,0x45,0x4D,0x4F}; //0x44,0x45,0x4D, 04F;// (DEMO)
		
		
		byte[] ZugErstellung = new byte[] { 0x7c, COUNT , 0x08, 0x00, ZUGNR, ZUGNR, OPMODE};
		byte[] Zug = ArrayUtils.addAll(ZugErstellung,NAME);
		int port = 9090;
		byte[] answer;
		InetAddress address = InetAddress.getLocalHost();

		Socket socket = new Socket(address, port);
		OutputStream os = socket.getOutputStream();

		System.out.println("\nStart...");
		RmxCalls rmx = new RmxCalls();
		answer = Zug;

		DataOutputStream bw = new DataOutputStream(os);
		bw.write(answer);
		bw.flush();
		System.out.println("Zug wird angelegt:");
		rmx.Hexaprint(answer);

		InputStream is = socket.getInputStream();
		byte[] bytes = IOUtils.toByteArray(is);
		System.out.println("/n Ausgabe muss Eingabe sein:");
		rmx.Hexaprint(bytes);

		socket.close();
	}

	public static void main(String[] args) throws IOException {
		ZugErstellen();
		
	}

/*Ausgabe bei Zuginfo:
Positivquittung<0x7C><0x06><0x00><0x01> Anz. Highbytes,Anz. Lowbytes
<0x00><0x..> Anzahl Züge
Dann Pro Zug:
<0x7c>
<0x07 keine Alphanumerische Zeichen, 0x08 bis 0x1B 1 bis 20 alphanumerische Zeichen>
<0x08>
<ADRH>/Higbytes Loknummer Teil 1(lang) (0x00 für DCC)
<ADRL>/Lowbytes Loknummer Teil 2(lang)
<ADRK> Adresse kurz (angegeben wenn adresse kurz, steuerung über Loknummer) --> Bei DCC Loknummer = Adresse
<OPMODE> Menü über Fahrstufen
<n*AN> Name*/

}
