package clientServerConnection;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class client {
public static void main(String[]args) throws UnknownHostException, IOException {
      Scanner input = new Scanner(System.in);
      int port = 9090;
      String host= "192.168.2.107";
      String answer; 
      String sendMessage; 
      String receivedMessage;
      InetAddress address = InetAddress.getByName(host);
  
      Socket socket= new Socket(address,port);

      OutputStream os = socket.getOutputStream();
      OutputStreamWriter osw = new OutputStreamWriter(os);
      BufferedWriter bw = new BufferedWriter(osw);

      System.out.println("Start...");
      answer = "<0x7c><0x04<0x0f><0x00>";
      //Server answer must be fixed

      sendMessage = answer;
      bw.write(sendMessage);
      bw.newLine();
      bw.flush();
      System.out.println("Message sent to server: "+sendMessage);
      
      InputStream is = socket.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);
      System.out.println("Message received from server : " + br);
      
      socket.close();
      }
}
