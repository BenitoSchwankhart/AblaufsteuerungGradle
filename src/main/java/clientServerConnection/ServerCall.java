package clientServerConnection;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import org.apache.commons.io.IOUtils;

public class ServerCall extends ConnectionCalls{
	
public static void serverConnection(byte[] Rmx) throws IOException {
	int port = 9090;
	byte[] answer;
	byte[] sendMessage;
	InetAddress address = InetAddress.getLocalHost();

	Socket socket = new Socket(address, port);
	OutputStream os = socket.getOutputStream();

	System.out.println("\nStart...");
	RmxCalls rmx = new RmxCalls();
	answer = Rmx;

	sendMessage = answer;
	DataOutputStream bw = new DataOutputStream(os);
	bw.write(sendMessage);
	bw.flush();
	System.out.println("Serveranfrage:");
	rmx.Hexaprint(sendMessage);

	InputStream is = socket.getInputStream();
	byte[] bytes = IOUtils.toByteArray(is);
	System.out.println("Serverantwort:");
	rmx.Hexaprint(bytes);

	socket.close();
}

public static void serverConnectionZugCall(byte[] Rmx) throws IOException {
	int port = 9090;
	byte[] answer;
	byte[] sendMessage;
	InetAddress address = InetAddress.getLocalHost();

	Socket socket = new Socket(address, port);
	OutputStream os = socket.getOutputStream();

	System.out.println("\nStart...");
	RmxCalls rmx = new RmxCalls();
	answer = Rmx;

	sendMessage = answer;
	DataOutputStream bw = new DataOutputStream(os);
	bw.write(sendMessage);
	bw.flush();
	System.out.println("Serveranfrage:");
	rmx.Hexaprint(sendMessage);

	InputStream is = socket.getInputStream();
	byte[] bytes = IOUtils.toByteArray(is);
	System.out.println("Serverantwort:");
	rmx.Hexaprint(bytes);
	rmx.ASCIIprint(bytes);

	socket.close();
}
}