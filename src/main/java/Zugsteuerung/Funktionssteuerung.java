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
	
	static byte ZUGNR = 0x01;//Lowbyte der Lok
	static byte F0F7a = 0x03;//Funktionen 0(Licht)-7 an (hier funktion 3 an)
	static byte F0F7b = 0x00;//Funktionen 0(Licht)-7 aus
	static byte F8F15a = 0x01;//Funktionen 8 bis 15 an 
	static byte F8F15b = 0x00;//Funktionen 8 bis 15 aus
	static byte F16F23a = 0x01;//Funktionen 16 bis 23 an 
	static byte F16F23b = 0x00;//Funktionen 16 bis 23 aus

	public static final byte[] FKTAN = new byte[] {0x7c, 0x08, 0x28, 0x00, ZUGNR, F0F7a, F8F15a, F16F23a};
	public static final byte[] FKTAUS = new byte[] {0x7c, 0x08, 0x28, 0x00, ZUGNR, F0F7b, F8F15b, F16F23b};
	
	static byte[] FahrstromEin = new byte[] {0x7c,0x04,0x03,(byte) 0x80}; 
	static byte[] FahrstromAus = new byte[] {0x7c,0x04, 0x03,0x40};
	static byte[] Nothalt = new byte[] {0x7c, 0x04, 0x03, 0x08};
	
	public static void StromAn() throws IOException {
	      int port = 9090;
	      byte[] answer; 
	      byte[] sendMessage;
	      InetAddress address = InetAddress.getLocalHost();

	      Socket socket= new Socket(address,port);
	      OutputStream os = socket.getOutputStream();

	      System.out.println("\nStart...");
	      RmxCalls rmx = new RmxCalls();
	      answer = FahrstromEin;

	      sendMessage = answer;
	      DataOutputStream bw = new DataOutputStream(os);
		  bw.write(sendMessage);
	      bw.flush();
	      System.out.println("StromAn:");
	      rmx.Hexaprint(sendMessage);
	      
	      InputStream is = socket.getInputStream();
	      byte[] bytes = IOUtils.toByteArray(is);
	      System.out.println("\nFeedback: ");
	      rmx.Hexaprint(bytes);
	      
	      socket.close();
	      }
	
	public static void StromAus() throws IOException {
	      int port = 9090;
	      byte[] answer; 
	      byte[] sendMessage;
	      InetAddress address = InetAddress.getLocalHost();

	      Socket socket= new Socket(address,port);
	      OutputStream os = socket.getOutputStream();

	      System.out.println("\nStart...");
	      RmxCalls rmx = new RmxCalls();
	      answer = FahrstromAus;

	      sendMessage = answer;
	      DataOutputStream bw = new DataOutputStream(os);
		  bw.write(sendMessage);
	      bw.flush();
	      System.out.println("StromAus:");
	      rmx.Hexaprint(sendMessage);
	      
	      InputStream is = socket.getInputStream();
	      byte[] bytes = IOUtils.toByteArray(is);
	      System.out.println("\nFeedback: ");
	      rmx.Hexaprint(bytes);
	      
	      socket.close();
	      }
	
	public static void Nothalt() throws IOException {
	      int port = 9090;
	      byte[] answer; 
	      byte[] sendMessage;
	      InetAddress address = InetAddress.getLocalHost();

	      Socket socket= new Socket(address,port);
	      OutputStream os = socket.getOutputStream();

	      System.out.println("\nStart...");
	      RmxCalls rmx = new RmxCalls();
	      answer = Nothalt;

	      sendMessage = answer;
	      DataOutputStream bw = new DataOutputStream(os);
		  bw.write(sendMessage);
	      bw.flush();
	      System.out.println("StromAn:");
	      rmx.Hexaprint(sendMessage);
	      
	      InputStream is = socket.getInputStream();
	      byte[] bytes = IOUtils.toByteArray(is);
	      System.out.println("\nFeedback: ");
	      rmx.Hexaprint(bytes);
	      
	      socket.close();
	      }
	
	public static void LichtAn(byte ZUGNR) throws IOException {
		final byte[] FKTAN = new byte[] {0x7c, 0x08, 0x28, 0x00, ZUGNR, 0x03, 0x00, 0x00};
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
	
	public static void LichtAus(byte ZUGNR) throws IOException {
		final byte[] FKTAN = new byte[] {0x7c, 0x08, 0x28, 0x00, ZUGNR, 0x00, 0x00, 0x00};
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
	
		  public static void FunktionenAn() throws IOException {
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
		StromAus();
	}
}
	
