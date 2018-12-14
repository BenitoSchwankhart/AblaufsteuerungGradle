package clientServerConnection;

import java.net.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.IOUtils;

import java.io.*;

public class client {
public static void main(String[]args) throws UnknownHostException, IOException{
	
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
      System.out.println("Message sent to server: "+ Arrays.toString(sendMessage));
      
      InputStream is = socket.getInputStream();
      byte[] bytes = IOUtils.toByteArray(is);
      System.out.println("Message received from server : " + Arrays.toString(bytes));

      
      socket.close();
      }
}
