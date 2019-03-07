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

public class ConnectionCalls {
	
//* sendet eine Positivquittung um die Verbindung zu testen, und setzt dann die Verbindung auf Connected//
	public static void Verbindung() throws IOException {
		int port = 9090;
		byte[] answer;
		byte[] sendMessage;
		RmxCalls rmx = new RmxCalls();
		InetAddress address = InetAddress.getLocalHost();

		Socket socket = new Socket(address, port);
		OutputStream os = socket.getOutputStream();

		System.out.println("Start...");
		answer = rmx.Positivquittung;

		sendMessage = answer;
		DataOutputStream bw = new DataOutputStream(os);
		bw.write(sendMessage);
		bw.flush();
		System.out.println("Try to connect to server:");
		rmx.Hexaprint(sendMessage);

		InputStream is = socket.getInputStream();
		byte[] bytes = IOUtils.toByteArray(is);
		System.out.println("\nConnected!: ");
		rmx.Hexaprint(bytes);

		socket.close();

		rmx.setVerbindungCONNECTED();
	}
//* Setzt das Rmx-System auf Start//
	public static void PowerOn() throws IOException {
		int port = 9090;
		byte[] answer;
		byte[] sendMessage;
		InetAddress address = InetAddress.getLocalHost();

		Socket socket = new Socket(address, port);
		OutputStream os = socket.getOutputStream();

		System.out.println("Start...");
		RmxCalls rmx = new RmxCalls();
		answer = rmx.PowerOn;

		sendMessage = answer;
		DataOutputStream bw = new DataOutputStream(os);
		bw.write(sendMessage);
		bw.flush();
		System.out.println("Try switch power on");
		rmx.Hexaprint(sendMessage);

		InputStream is = socket.getInputStream();
		byte[] bytes = IOUtils.toByteArray(is);
		System.out.println("\nPower on!:");
		rmx.Hexaprint(bytes);

		socket.close();
	}
//* Setzt das Rmx-System auf Stop//
	public static void PowerOff() throws IOException {
		int port = 9090;
		byte[] answer;
		byte[] sendMessage;
		InetAddress address = InetAddress.getLocalHost();

		Socket socket = new Socket(address, port);
		OutputStream os = socket.getOutputStream();

		System.out.println("Start...");
		RmxCalls rmx = new RmxCalls();
		answer = rmx.PowerOff;

		sendMessage = answer;
		DataOutputStream bw = new DataOutputStream(os);
		bw.write(sendMessage);
		bw.flush();
		System.out.println("Try to turn power off:");
		rmx.Hexaprint(sendMessage);

		InputStream is = socket.getInputStream();
		byte[] bytes = IOUtils.toByteArray(is);
		System.out.println("Power off! : ");
		rmx.Hexaprint(bytes);

		socket.close();
	}
//* Das System macht Nothalt aller Loks//
	public static void Notfall() throws IOException {
		int port = 9090;
		byte[] answer;
		byte[] sendMessage;
		InetAddress address = InetAddress.getLocalHost();

		Socket socket = new Socket(address, port);
		OutputStream os = socket.getOutputStream();

		System.out.println("Start...");
		RmxCalls rmx = new RmxCalls();
		answer = rmx.Notfall;

		sendMessage = answer;
		DataOutputStream bw = new DataOutputStream(os);
		bw.write(sendMessage);
		bw.flush();
		System.out.println("Initialisiere Nothalt:");
		rmx.Hexaprint(sendMessage);

		InputStream is = socket.getInputStream();
		byte[] bytes = IOUtils.toByteArray(is);
		System.out.println("\nAngehalten!: ");
		rmx.Hexaprint(bytes);

		socket.close();
	}
//* Gibt die Zugnummer und den Zugnamen zurück//
	public static void ZugInfo() throws IOException {
		int port = 9090;
		byte[] answer;
		byte[] sendMessage;
		InetAddress address = InetAddress.getLocalHost();

		Socket socket = new Socket(address, port);
		OutputStream os = socket.getOutputStream();

		System.out.println("Start...");
		RmxCalls rmx = new RmxCalls();
		answer = rmx.ZugInfo;

		sendMessage = answer;
		DataOutputStream bw = new DataOutputStream(os);
		bw.write(sendMessage);
		bw.flush();
		System.out.println("ZugInfo wird Abgefragt:");
		rmx.Hexaprint(sendMessage);
		InputStream is = socket.getInputStream();
		byte[] bytes = IOUtils.toByteArray(is);
		System.out.println("\nZugdaten: ");
		System.out.println(bytes.length);
		rmx.Hexaprint(bytes);
		rmx.ASCIIprint(bytes);

		socket.close();
	}
//* Gibt erst Protokollversion, dann die Businhalte (Betriebsdaten) beider RMX-Busse,  danach die Fahrdaten von RMX0. 
//* Nach jeder Kanalinfo werden ebenfalls die Steuerungsdaten der jeweiligen Lok ausgegeben. Zuerst
//* die Antwort Loksteuerung Geschwindigkeit und Richtung. Danach die Antwort Loksteuerung Funktionen.
//* Als letztes wird zur Kennzeichnung der vollständigen Ausgabe noch die Antwort auf eine
//* Statusabfrage an den Client gesendet

	public static void Status() throws IOException {
		int port = 9090;
		byte[] answer;
		byte[] sendMessage;
		InetAddress address = InetAddress.getLocalHost();

		Socket socket = new Socket(address, port);
		OutputStream os = socket.getOutputStream();

		System.out.println("\nStart...");
		RmxCalls rmx = new RmxCalls();
		answer = rmx.Status;

		sendMessage = answer;
		DataOutputStream bw = new DataOutputStream(os);
		bw.write(sendMessage);
		bw.flush();
		System.out.println("Verbindung wird abgefragt:");
		rmx.Hexaprint(sendMessage);

		InputStream is = socket.getInputStream();
		byte[] bytes = IOUtils.toByteArray(is);
		System.out.println("\n "
				+ "<0x7c><0x04><0x04><STATUS>"
				+ "Bit 5 und 6: 1 Initialisierung erfolgreich\r\n" + 
				"Bit 7: 0 Zentrale Aus\r\n" + 
				"Bit 7: 1 Zentrale Ein\r\n" + 
				": ");
		rmx.Hexaprint(bytes);

		socket.close();
	}

	public static void main(String[] args) throws IOException {
		ZugInfo();
	}
/*Positivquittung<0x7C><0x06><0x00><0x01> Anz. Highbytes,Anz. Lowbytes
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
