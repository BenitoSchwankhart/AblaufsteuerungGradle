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

	public static void Initialisieren() throws IOException {
		int port = 9090;
		byte[] answer;
		byte[] sendMessage;
		InetAddress address = InetAddress.getLocalHost();

		Socket socket = new Socket(address, port);
		OutputStream os = socket.getOutputStream();

		System.out.println("\nStart...");
		RmxCalls rmx = new RmxCalls();
		answer = rmx.Initialisieren;

		sendMessage = answer;
		DataOutputStream bw = new DataOutputStream(os);
		bw.write(sendMessage);
		bw.flush();
		System.out.println("Verbindung wird initialisiert:");
		rmx.Hexaprint(sendMessage);

		InputStream is = socket.getInputStream();
		byte[] bytes = IOUtils.toByteArray(is);
		System.out.println("\nDaten: ");
		rmx.Hexaprint(bytes);

		socket.close();
	}

	public static void main(String[] args) throws IOException {
		ZugInfo();
	}

}
