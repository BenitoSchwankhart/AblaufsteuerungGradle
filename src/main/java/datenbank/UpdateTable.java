package datenbank;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement;  

public class UpdateTable { 
   // JDBC driver name and database URL 
   static final String JDBC_DRIVER = "org.h2.Driver";   
   static final String DB_URL = "jdbc:h2:~/.AblaufsteuerungGradle\\H2Datenbank";  
   
   // Database credentials 
   static final String USER = ""; 
   static final String PASS = ""; 
   
   public static void setDrop1(int zugnummer, String Ablauf) {
   Connection conn = null; 
   Statement stmt = null; 
   try { 
      // STEP 1: Register JDBC driver 
      Class.forName(JDBC_DRIVER); 
      
      // STEP 2: Open a connection 
      System.out.println("Connecting to a database..."); 
      conn = DriverManager.getConnection(DB_URL,USER,PASS);  
      
      // STEP 3: Execute a query 
      System.out.println("Connected database successfully..."); 
      stmt = conn.createStatement(); 
      String sql = "UPDATE reihe " + "SET drop1 = "+ "'" + Ablauf+ "'" + " WHERE zugnummer = " + zugnummer + ""; 
      stmt.executeUpdate(sql);  
      
      // Now you can extract all the records 
      // to see the updated records 
      sql = "SELECT zugnummer, drop1 FROM reihe"; 
      ResultSet rs = stmt.executeQuery(sql);  
      
      while(rs.next()){ 
         // Retrieve by column name 
         int zugNR  = rs.getInt("zugnummer"); 
         String drop1 = rs.getString("drop1");
         
         // Display values 
         System.out.print("ZugNr: " + zugNR); 
         System.out.print("Ablauf: " + drop1);  
      } 
      rs.close();    
   } catch(SQLException se) { 
      // Handle errors for JDBC 
      se.printStackTrace(); 
   } catch(Exception e) { 
      // Handle errors for Class.forName 
      e.printStackTrace(); 
   } finally { 
      // finally block used to close resources  
      try { 
         if(stmt!=null) stmt.close(); 
      } catch(SQLException se2) { 
      } // nothing we can do 
      try { 
         if(conn!=null) conn.close(); 
      } catch(SQLException se) { 
         se.printStackTrace(); 
      } // end finally try 
   } // end try 
   System.out.println("Goodbye!"); 
} 
   
   public static void setDrop2(int zugnummer, String Ablauf) {
	   Connection conn = null; 
	   Statement stmt = null; 
	   try { 
	      // STEP 1: Register JDBC driver 
	      Class.forName(JDBC_DRIVER); 
	      
	      // STEP 2: Open a connection 
	      System.out.println("Connecting to a database..."); 
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);  
	      
	      // STEP 3: Execute a query 
	      System.out.println("Connected database successfully..."); 
	      stmt = conn.createStatement(); 
	      String sql = "UPDATE reihe " + "SET drop2 = "+ "'" + Ablauf+ "'"+ " WHERE zugnummer = " + zugnummer + ""; 
	      stmt.executeUpdate(sql);  
	      
	      // Now you can extract all the records 
	      // to see the updated records 
	      sql = "SELECT zugnummer, drop2 FROM reihe"; 
	      ResultSet rs = stmt.executeQuery(sql);  
	      
	      while(rs.next()){ 
	         // Retrieve by column name 
	         int zugNR  = rs.getInt("zugnummer"); 
	         String drop2 = rs.getString("drop2");
	         
	         // Display values 
	         System.out.print("ZugNr: " + zugNR); 
	         System.out.print("Ablauf: " + drop2);  
	      } 
	      rs.close();    
	   } catch(SQLException se) { 
	      // Handle errors for JDBC 
	      se.printStackTrace(); 
	   } catch(Exception e) { 
	      // Handle errors for Class.forName 
	      e.printStackTrace(); 
	   } finally { 
	      // finally block used to close resources  
	      try { 
	         if(stmt!=null) stmt.close(); 
	      } catch(SQLException se2) { 
	      } // nothing we can do 
	      try { 
	         if(conn!=null) conn.close(); 
	      } catch(SQLException se) { 
	         se.printStackTrace(); 
	      } // end finally try 
	   } // end try 
	   System.out.println("Goodbye!"); 
	} 
   
   public static void setDrop3(int zugnummer, String Ablauf) {
	   Connection conn = null; 
	   Statement stmt = null; 
	   try { 
	      // STEP 1: Register JDBC driver 
	      Class.forName(JDBC_DRIVER); 
	      
	      // STEP 2: Open a connection 
	      System.out.println("Connecting to a database..."); 
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);  
	      
	      // STEP 3: Execute a query 
	      System.out.println("Connected database successfully..."); 
	      stmt = conn.createStatement(); 
	      String sql = "UPDATE reihe " + "SET drop3 = "+ "'" + Ablauf+ "'"+ " WHERE zugnummer = " + zugnummer + ""; 
	      stmt.executeUpdate(sql);  
	      
	      // Now you can extract all the records 
	      // to see the updated records 
	      sql = "SELECT zugnummer, drop3 FROM reihe"; 
	      ResultSet rs = stmt.executeQuery(sql);  
	      
	      while(rs.next()){ 
	         // Retrieve by column name 
	         int zugNR  = rs.getInt("zugnummer"); 
	         String drop3 = rs.getString("drop3");
	         
	         // Display values 
	         System.out.print("ZugNr: " + zugNR); 
	         System.out.print("Ablauf: " + drop3);  
	      } 
	      rs.close();    
	   } catch(SQLException se) { 
	      // Handle errors for JDBC 
	      se.printStackTrace(); 
	   } catch(Exception e) { 
	      // Handle errors for Class.forName 
	      e.printStackTrace(); 
	   } finally { 
	      // finally block used to close resources  
	      try { 
	         if(stmt!=null) stmt.close(); 
	      } catch(SQLException se2) { 
	      } // nothing we can do 
	      try { 
	         if(conn!=null) conn.close(); 
	      } catch(SQLException se) { 
	         se.printStackTrace(); 
	      } // end finally try 
	   } // end try 
	   System.out.println("Goodbye!"); 
	} 
   
   public static void setDrop4(int zugnummer, String Ablauf) {
	   Connection conn = null; 
	   Statement stmt = null; 
	   try { 
	      // STEP 1: Register JDBC driver 
	      Class.forName(JDBC_DRIVER); 
	      
	      // STEP 2: Open a connection 
	      System.out.println("Connecting to a database..."); 
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);  
	      
	      // STEP 3: Execute a query 
	      System.out.println("Connected database successfully..."); 
	      stmt = conn.createStatement(); 
	      String sql = "UPDATE reihe " + "SET drop4 = "+ "'" + Ablauf+ "'"+ " WHERE zugnummer = " + zugnummer + ""; 
	      stmt.executeUpdate(sql);  
	      
	      // Now you can extract all the records 
	      // to see the updated records 
	      sql = "SELECT zugnummer, drop4 FROM reihe"; 
	      ResultSet rs = stmt.executeQuery(sql);  
	      
	      while(rs.next()){ 
	         // Retrieve by column name 
	         int zugNR  = rs.getInt("zugnummer"); 
	         String drop4 = rs.getString("drop4");
	         
	         // Display values 
	         System.out.print("ZugNr: " + zugNR); 
	         System.out.print("Ablauf: " + drop4);  
	      } 
	      rs.close();    
	   } catch(SQLException se) { 
	      // Handle errors for JDBC 
	      se.printStackTrace(); 
	   } catch(Exception e) { 
	      // Handle errors for Class.forName 
	      e.printStackTrace(); 
	   } finally { 
	      // finally block used to close resources  
	      try { 
	         if(stmt!=null) stmt.close(); 
	      } catch(SQLException se2) { 
	      } // nothing we can do 
	      try { 
	         if(conn!=null) conn.close(); 
	      } catch(SQLException se) { 
	         se.printStackTrace(); 
	      } // end finally try 
	   } // end try 
	   System.out.println("Goodbye!"); 
	} 
   
   public static void setDrop5(int zugnummer, String Ablauf) {
	   Connection conn = null; 
	   Statement stmt = null; 
	   try { 
	      // STEP 1: Register JDBC driver 
	      Class.forName(JDBC_DRIVER); 
	      
	      // STEP 2: Open a connection 
	      System.out.println("Connecting to a database..."); 
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);  
	      
	      // STEP 3: Execute a query 
	      System.out.println("Connected database successfully..."); 
	      stmt = conn.createStatement(); 
	      String sql = "UPDATE reihe " + "SET drop5 = "+ "'" + Ablauf+ "'"+ " WHERE zugnummer = " + zugnummer + ""; 
	      stmt.executeUpdate(sql);  
	      
	      // Now you can extract all the records 
	      // to see the updated records 
	      sql = "SELECT zugnummer, drop5 FROM reihe"; 
	      ResultSet rs = stmt.executeQuery(sql);  
	      
	      while(rs.next()){ 
	         // Retrieve by column name 
	         int zugNR  = rs.getInt("zugnummer"); 
	         String drop5 = rs.getString("drop5");
	         
	         // Display values 
	         System.out.print("ZugNr: " + zugNR); 
	         System.out.print("Ablauf: " + drop5);  
	      } 
	      rs.close();    
	   } catch(SQLException se) { 
	      // Handle errors for JDBC 
	      se.printStackTrace(); 
	   } catch(Exception e) { 
	      // Handle errors for Class.forName 
	      e.printStackTrace(); 
	   } finally { 
	      // finally block used to close resources  
	      try { 
	         if(stmt!=null) stmt.close(); 
	      } catch(SQLException se2) { 
	      } // nothing we can do 
	      try { 
	         if(conn!=null) conn.close(); 
	      } catch(SQLException se) { 
	         se.printStackTrace(); 
	      } // end finally try 
	   } // end try 
	   System.out.println("Goodbye!"); 
	} 
   
   public static void setDrop6(int zugnummer, String Ablauf) {
	   Connection conn = null; 
	   Statement stmt = null; 
	   try { 
	      // STEP 1: Register JDBC driver 
	      Class.forName(JDBC_DRIVER); 
	      
	      // STEP 2: Open a connection 
	      System.out.println("Connecting to a database..."); 
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);  
	      
	      // STEP 3: Execute a query 
	      System.out.println("Connected database successfully..."); 
	      stmt = conn.createStatement(); 
	      String sql = "UPDATE reihe " + "SET drop6 = "+ "'" + Ablauf+ "'"+ " WHERE zugnummer = " + zugnummer + ""; 
	      stmt.executeUpdate(sql);  
	      
	      // Now you can extract all the records 
	      // to see the updated records 
	      sql = "SELECT zugnummer, drop6 FROM reihe"; 
	      ResultSet rs = stmt.executeQuery(sql);  
	      
	      while(rs.next()){ 
	         // Retrieve by column name 
	         int zugNR  = rs.getInt("zugnummer"); 
	         String drop6 = rs.getString("drop6");
	         
	         // Display values 
	         System.out.print("ZugNr: " + zugNR); 
	         System.out.print("Ablauf: " + drop6);  
	      } 
	      rs.close();    
	   } catch(SQLException se) { 
	      // Handle errors for JDBC 
	      se.printStackTrace(); 
	   } catch(Exception e) { 
	      // Handle errors for Class.forName 
	      e.printStackTrace(); 
	   } finally { 
	      // finally block used to close resources  
	      try { 
	         if(stmt!=null) stmt.close(); 
	      } catch(SQLException se2) { 
	      } // nothing we can do 
	      try { 
	         if(conn!=null) conn.close(); 
	      } catch(SQLException se) { 
	         se.printStackTrace(); 
	      } // end finally try 
	   } // end try 
	   System.out.println("Goodbye!"); 
	} 
   
   public static void setDrop7(int zugnummer, String Ablauf) {
	   Connection conn = null; 
	   Statement stmt = null; 
	   try { 
	      // STEP 1: Register JDBC driver 
	      Class.forName(JDBC_DRIVER); 
	      
	      // STEP 2: Open a connection 
	      System.out.println("Connecting to a database..."); 
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);  
	      
	      // STEP 3: Execute a query 
	      System.out.println("Connected database successfully..."); 
	      stmt = conn.createStatement(); 
	      String sql = "UPDATE reihe " + "SET drop7 = "+ "'" + Ablauf+ "'"+ " WHERE zugnummer = " + zugnummer + ""; 
	      stmt.executeUpdate(sql);  
	      
	      // Now you can extract all the records 
	      // to see the updated records 
	      sql = "SELECT zugnummer, drop7 FROM reihe"; 
	      ResultSet rs = stmt.executeQuery(sql);  
	      
	      while(rs.next()){ 
	         // Retrieve by column name 
	         int zugNR  = rs.getInt("zugnummer"); 
	         String drop7 = rs.getString("drop7");
	         
	         // Display values 
	         System.out.print("ZugNr: " + zugNR); 
	         System.out.print("Ablauf: " + drop7);  
	      } 
	      rs.close();    
	   } catch(SQLException se) { 
	      // Handle errors for JDBC 
	      se.printStackTrace(); 
	   } catch(Exception e) { 
	      // Handle errors for Class.forName 
	      e.printStackTrace(); 
	   } finally { 
	      // finally block used to close resources  
	      try { 
	         if(stmt!=null) stmt.close(); 
	      } catch(SQLException se2) { 
	      } // nothing we can do 
	      try { 
	         if(conn!=null) conn.close(); 
	      } catch(SQLException se) { 
	         se.printStackTrace(); 
	      } // end finally try 
	   } // end try 
	   System.out.println("Goodbye!"); 
	} 
   
   
   public static void main(String[] args) { 
      } 
}