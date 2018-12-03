package clientServerConnection;

import java.net.*;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.*;

public class client {
public static void main(String[]args) throws UnknownHostException, IOException {
      //Scanner input = new Scanner(System.in); --> For upcoming Scanner
      int port = 9090;
      String host= "192.168.2.107";
      String answer; 
      String sendMessage;
      InetAddress address = InetAddress.getByName(host);
  
      Socket socket= new Socket(address,port);

      OutputStream os = socket.getOutputStream();
      OutputStreamWriter osw = new OutputStreamWriter(os);
      BufferedWriter bw = new BufferedWriter(osw);

      System.out.println("Start...");
      RmXCalls rmx = new RmXCalls();
      answer = rmx.postitivquittung;
      //Server answer must be fixed

      sendMessage = answer;
      bw.write(sendMessage);
      bw.newLine();
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
