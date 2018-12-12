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
      //Scanner input = new Scanner(System.in); --> For upcoming Scanner
      int port = 9090;
      String host= "192.168.2.107";
      byte[] answer; 
      byte[] sendMessage;
      InetAddress address = InetAddress.getByName(host);

      Socket socket= new Socket(address,port);
      OutputStream os = socket.getOutputStream();
      
      public String convertHexToString(String hex){

    	  StringBuilder sb = new StringBuilder();
    	  StringBuilder temp = new StringBuilder();
    	  
    	  //49204c6f7665204a617661 split into two characters 49, 20, 4c...
    	  for( int i=0; i<hex.length()-1; i+=2 ){
    		  
    	      //grab the hex in pairs
    	      String output = hex.substring(i, (i + 2));
    	      //convert hex to decimal
    	      int decimal = Integer.parseInt(output, 16);
    	      //convert the decimal to character
    	      sb.append((char)decimal);
    		  
    	      temp.append(decimal);
    	  }
    	  System.out.println("Decimal : " + temp.toString());
    	  
    	  return sb.toString();
      }

      System.out.println("Start...");
      RmxCalls rmx = new RmxCalls();
      answer = rmx.Positivquittung;
      //Server answer must be fixed

      sendMessage = answer;
      DataOutputStream bw = new DataOutputStream(os);
	  bw.write(sendMessage);
      bw.flush();
      System.out.println("Message sent to server: "+ String.format( "{0:X4}" , 
    		  sendMessage));
      
      InputStream is = socket.getInputStream();
      byte[] bytes = IOUtils.toByteArray(is);
      System.out.println("Message received from server : " + Arrays.toString(bytes));

      
      socket.close();
      }
}
