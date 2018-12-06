package clientServerConnection;

import java.net.*;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.*;

public class client {
public static void main(String[]args) throws UnknownHostException, IOException {
      //Scanner input = new Scanner(System.in); --> For upcoming Scanner
      int port = 9090;
      String host= "192.168.178.29";
      byte[] answer; 
      byte[] sendMessage;
      InetAddress address = InetAddress.getByName(host);
  
      Socket socket= new Socket(address,port);

      OutputStream os = socket.getOutputStream();
      OutputStreamWriter osw = new OutputStreamWriter(os);

      System.out.println("Start...");
      RmxCalls rmx = new RmxCalls();
      answer = rmx.ZugInfo;
      //Server answer must be fixed

      sendMessage = answer;
      DataOutputStream bw = new DataOutputStream(os);
	  bw.write(sendMessage);
      bw.flush();
      System.out.println("Message sent to server: "+sendMessage);
      
      InputStream is = socket.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);
      String output = br.lines().collect(Collectors.joining());
      System.out.println("Message received from server : " + output);
      
      socket.close();
      }
}
