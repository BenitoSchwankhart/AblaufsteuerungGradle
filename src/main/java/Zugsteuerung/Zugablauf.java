package Zugsteuerung;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import org.apache.commons.io.IOUtils;

import clientServerConnection.RmxCalls;

public class Zugablauf {
	
	/*static byte ADRH = 0x00;
	static byte ADRL = 0x01;
	static byte SPEED = 0x09;
	static byte DIR = 0x00;
*/
	
	public static void ZugFahrEinstellungen(byte ZUGNR, byte SPEED, byte DIR) throws IOException {
		  byte[] ICE = new byte[] { 0x7c, 0x07, 0x24, 0x00, ZUGNR, SPEED, DIR};
	      int port = 9090;
	      byte[] answer; 
	      byte[] sendMessage;
	      InetAddress address = InetAddress.getLocalHost();

	      Socket socket= new Socket(address,port);
	      OutputStream os = socket.getOutputStream();

	      System.out.println("\nStart...");
	      RmxCalls rmx = new RmxCalls();
	      answer = ICE;

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
		//Zugfahrstufe(ADRH, ADRH, ADRH, ADRH);
	}

}
