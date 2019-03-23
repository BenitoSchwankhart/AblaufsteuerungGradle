package Zugsteuerung;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import org.apache.commons.io.IOUtils;

import clientServerConnection.RmxCalls;

public class Funktionssteuerung {
	
	
	
	static byte ADRH = 0x00;//Higbyte der Lok
	static byte ADRL = 0x01;//Lowbyte der Lok
	static byte F0F7a = 0x03;//Funktionen 0(Licht)-7 an (hier funktion 3 an)
	static byte F0F7b = 0x00;//Funktionen 0(Licht)-7 aus
	static byte F8F15a = 0x01;//Funktionen 8 bis 15 an 
	static byte F8F15b = 0x00;//Funktionen 8 bis 15 aus
	static byte F16F23a = 0x01;//Funktionen 16 bis 23 an 
	static byte F16F23b = 0x00;//Funktionen 16 bis 23 aus

	public static final byte[] FKTAN = new byte[] {0x7c, 0x08, 0x28, ADRH, ADRL, F0F7a, F8F15a, F16F23a};
	public static final byte[] FKTAUS = new byte[] {0x7c, 0x08, 0x28, ADRH, ADRL, F0F7b, F8F15b, F16F23b};
	
	
	public static void FunktionenAn() throws IOException {
	      int port = 9090;
	      byte[] answer; 
	      byte[] sendMessage;
	      InetAddress address = InetAddress.getLocalHost();

	      Socket socket= new Socket(address,port);
	      OutputStream os = socket.getOutputStream();

	      System.out.println("\nStart...");
	      RmxCalls rmx = new RmxCalls();
	      answer = FKTAN;

	      sendMessage = answer;
	      DataOutputStream bw = new DataOutputStream(os);
		  bw.write(sendMessage);
	      bw.flush();
	      System.out.println("Fahrstufe wird angepasst:");
	      rmx.Hexaprint(sendMessage);
	      
	      InputStream is = socket.getInputStream();
	      byte[] bytes = IOUtils.toByteArray(is);
	      System.out.println("\nFeedback: ");
	      rmx.Hexaprint(bytes);
	      
	      socket.close();
	      }
	
	public static void FunktionenAus() throws IOException {
	      int port = 9090;
	      byte[] answer; 
	      byte[] sendMessage;
	      InetAddress address = InetAddress.getLocalHost();

	      Socket socket= new Socket(address,port);
	      OutputStream os = socket.getOutputStream();

	      System.out.println("\nStart...");
	      RmxCalls rmx = new RmxCalls();
	      answer = FKTAUS;

	      sendMessage = answer;
	      DataOutputStream bw = new DataOutputStream(os);
		  bw.write(sendMessage);
	      bw.flush();
	      System.out.println("Fahrstufe wird angepasst:");
	      rmx.Hexaprint(sendMessage);
	      
	      InputStream is = socket.getInputStream();
	      byte[] bytes = IOUtils.toByteArray(is);
	      System.out.println("\nFeedback: ");
	      rmx.Hexaprint(bytes);
	      
	      socket.close();
	      }
	
	public static void main(String[]args) throws IOException {
		FunktionenAn();
	}
}
