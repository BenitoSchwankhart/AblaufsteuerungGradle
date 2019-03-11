package clientServerConnection;

import java.net.*;
import java.util.Arrays;
import org.apache.commons.io.IOUtils;
import java.io.*;
import java.util.*;

public class clientConnection {
public void main(String[]args) throws UnknownHostException, IOException{
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
}
