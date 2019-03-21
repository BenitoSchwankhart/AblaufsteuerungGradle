package datenbank;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.sql.Statement;  

public class InsertIntoTable { 
   // JDBC driver name and database URL 
   static final String JDBC_DRIVER = "org.h2.Driver";   
   static final String DB_URL = "jdbc:h2:~/.AblaufsteuerungGradle\\H2Datenbank";  
   
   //  Database credentials 
   static final String USER = ""; 
   static final String PASS = ""; 
   
   static Statement stmt = null;
   
   //Speichert neuen Zug mit Daten
   public static void  zugDatenbank(int zugnummer, String zugname, int fahrstufen) {
       String sql = "INSERT INTO zug " + "VALUES"+ zugnummer + zugname + fahrstufen; 
       try {
		stmt.executeUpdate(sql);
	} catch (SQLException e) {
		System.out.println("Datenbankfehler");
	} 
      }
   
   //Speichert neuen Ablauf in Datenbank
  /** public static void  ablaufDatenbank() {
     
      }*/
  
   public static void main(String[] args) { 
      Connection conn = null; 
      Statement stmt = null; 
      try{
         // STEP 1: Register JDBC driver 
         Class.forName(JDBC_DRIVER);  
         
         // STEP 2: Open a connection 
         System.out.println("Connecting to a selected database..."); 
         conn = DriverManager.getConnection(DB_URL,USER,PASS); 
         System.out.println("Connected database successfully..."); 
         
         // STEP 3: Execute a query 
         stmt = conn.createStatement();  
         zugDatenbank(0, null, 0);
         System.out.println("Inserted records into the table..."); 
         
         // STEP 4: Clean-up environment 
         stmt.close(); 
         conn.close(); 
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
}
