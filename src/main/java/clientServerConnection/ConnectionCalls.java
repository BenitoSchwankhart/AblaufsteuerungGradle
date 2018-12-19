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

	public static void PositivQuittung() throws IOException {
		      int port = 9090;
		      byte[] answer; 
		      byte[] sendMessage;
		      InetAddress address = InetAddress.getLocalHost();

		      Socket socket= new Socket(address,port);
		      OutputStream os = socket.getOutputStream();

		      System.out.println("Start...");
		      RmxCalls rmx = new RmxCalls();
		      answer = rmx.Positivquittung;

		      sendMessage = answer;
		      DataOutputStream bw = new DataOutputStream(os);
			  bw.write(sendMessage);
		      bw.flush();
		      System.out.println("Try to connect to server:"+ Arrays.toString(sendMessage));
		      
		      InputStream is = socket.getInputStream();
		      byte[] bytes = IOUtils.toByteArray(is);
		      System.out.println("Connected! : " + Arrays.toString(bytes));
		      
		      socket.close();
		      
		      rmx.setVerbindungCONNECTED();
		      }
	
	public static void PowerOn() throws IOException {
	      int port = 9090;
	      byte[] answer; 
	      byte[] sendMessage;
	      InetAddress address = InetAddress.getLocalHost();

	      Socket socket= new Socket(address,port);
	      OutputStream os = socket.getOutputStream();

	      System.out.println("Start...");
	      RmxCalls rmx = new RmxCalls();
	      answer = rmx.PowerOn;

	      sendMessage = answer;
	      DataOutputStream bw = new DataOutputStream(os);
		  bw.write(sendMessage);
	      bw.flush();
	      System.out.println("Try switch power on"+ Arrays.toString(sendMessage));
	      
	      InputStream is = socket.getInputStream();
	      byte[] bytes = IOUtils.toByteArray(is);
	      System.out.println("Power on!: " + Arrays.toString(bytes));
	      
	      socket.close();
	      }
	
	public static void PowerOff() throws IOException {
	      int port = 9090;
	      byte[] answer; 
	      byte[] sendMessage;
	      InetAddress address = InetAddress.getLocalHost();

	      Socket socket= new Socket(address,port);
	      OutputStream os = socket.getOutputStream();

	      System.out.println("Start...");
	      RmxCalls rmx = new RmxCalls();
	      answer = rmx.PowerOff;

	      sendMessage = answer;
	      DataOutputStream bw = new DataOutputStream(os);
		  bw.write(sendMessage);
	      bw.flush();
	      System.out.println("Try to turn power off:"+ Arrays.toString(sendMessage));
	      
	      InputStream is = socket.getInputStream();
	      byte[] bytes = IOUtils.toByteArray(is);
	      System.out.println("Power off! : " + Arrays.toString(bytes));
	      
	      socket.close();
	      }

	public static void Notfall() throws IOException {
	      int port = 9090;
	      byte[] answer; 
	      byte[] sendMessage;
	      InetAddress address = InetAddress.getLocalHost();

	      Socket socket= new Socket(address,port);
	      OutputStream os = socket.getOutputStream();

	      System.out.println("Start...");
	      RmxCalls rmx = new RmxCalls();
	      answer = rmx.Notfall;

	      sendMessage = answer;
	      DataOutputStream bw = new DataOutputStream(os);
		  bw.write(sendMessage);
	      bw.flush();
	      System.out.println("Initialisiere Nothalt:"+ Arrays.toString(sendMessage));
	      
	      InputStream is = socket.getInputStream();
	      byte[] bytes = IOUtils.toByteArray(is);
	      System.out.println("Angehalten! : " + Arrays.toString(bytes));
	      
	      socket.close();
	      }

	/*public static void main(String[]args) throws IOException {
		PositivQuittung();
	}*/
	
}
