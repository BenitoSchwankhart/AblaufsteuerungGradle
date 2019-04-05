package datenbank;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.sql.Statement;  

public class DeleteFromTable { 
   // JDBC driver name and database URL 
   static final String JDBC_DRIVER = "org.h2.Driver";   
   static final String DB_URL = "jdbc:h2:~/.AblaufsteuerungGradle\\H2Datenbank";  
   
   // Database credentials 
   static final String USER = ""; 
   static final String PASS = ""; 
   
   //löscht den aktuellen Zug
   public void deleteAktuellerZug() {
	   Connection conn = null; 
	   Statement stmt = null; 
	      try { 
	         // STEP 1: Register JDBC driver 
	         Class.forName(JDBC_DRIVER);  
	         
	         // STEP 2: Open a connection 
	         System.out.println("Connecting to database..."); 
	         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
	         
	         // STEP 3: Execute a query
	         System.out.println("Creating table in given database..."); 
	         stmt = conn.createStatement();  
	         String sql = "DELETE FROM aktueller_zug "; 
	         stmt.executeUpdate(sql);  
	         
	         System.out.println("Zug gelöscht!-Bitte neu anlegen");
	          
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
   
   //löscht einen Zug
   public void deleteZug(String zugnummer) {
	   Connection conn = null; 
	   Statement stmt = null; 
	      try { 
	         // STEP 1: Register JDBC driver 
	         Class.forName(JDBC_DRIVER);  
	         
	         // STEP 2: Open a connection 
	         System.out.println("Connecting to database..."); 
	         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
	         
	         // STEP 3: Execute a query
	         System.out.println("Creating table in given database..."); 
	         stmt = conn.createStatement();  
	         String sql = "DELETE FROM zug WHERE zugnummer =" + zugnummer + "";
	         stmt.executeUpdate(sql);  
	         
	         System.out.println("Zug gelöscht!");
	          
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
   
   //löscht die FS
   public void deleteFS(String zugnummer) {
	   Connection conn = null; 
	   Statement stmt = null; 
	      try { 
	         // STEP 1: Register JDBC driver 
	         Class.forName(JDBC_DRIVER);  
	         
	         // STEP 2: Open a connection 
	         System.out.println("Connecting to database..."); 
	         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
	         
	         // STEP 3: Execute a query
	         System.out.println("Creating table in given database..."); 
	         stmt = conn.createStatement();  
	         String sql = "DELETE FROM fs_save" ;
	         stmt.executeUpdate(sql);  
	         
	         System.out.println("Neue FS anlegen!");
	          
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
   
   //löscht einen Ablauf
   public void deleteAblauf(String zugnummer) {
	   Connection conn = null; 
	   Statement stmt = null; 
	      try { 
	         // STEP 1: Register JDBC driver 
	         Class.forName(JDBC_DRIVER);  
	         
	         // STEP 2: Open a connection 
	         System.out.println("Connecting to database..."); 
	         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
	         
	         // STEP 3: Execute a query
	         System.out.println("Creating table in given database..."); 
	         stmt = conn.createStatement();  
	         String sql = "DELETE FROM ablauf WHERE zugnummer =" + zugnummer +"";
	         stmt.executeUpdate(sql);  
	         
	         System.out.println("Ablauf gelöscht!");
	          
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
   
   //löscht die Reihe
   public void deleteReihe(String zugnummer) {
	   Connection conn = null; 
	   Statement stmt = null; 
	      try { 
	         // STEP 1: Register JDBC driver 
	         Class.forName(JDBC_DRIVER);  
	         
	         // STEP 2: Open a connection 
	         System.out.println("Connecting to database..."); 
	         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
	         
	         // STEP 3: Execute a query
	         System.out.println("Creating table in given database..."); 
	         stmt = conn.createStatement();  
	         String sql = "DELETE FROM reihe WHERE zugnummer =" + zugnummer + "";
	         stmt.executeUpdate(sql);  
	         
	         System.out.println("Ablauf gelöscht!");
	          
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
   
   //löscht die FS
   public void deleteTime(String zugnummer) {
	   Connection conn = null; 
	   Statement stmt = null; 
	      try { 
	         // STEP 1: Register JDBC driver 
	         Class.forName(JDBC_DRIVER);  
	         
	         // STEP 2: Open a connection 
	         System.out.println("Connecting to database..."); 
	         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
	         
	         // STEP 3: Execute a query
	         System.out.println("Creating table in given database..."); 
	         stmt = conn.createStatement();  
	         String sql = "DELETE FROM time_save" ;
	         stmt.executeUpdate(sql);  
	         
	         System.out.println("Neue Zeit anlegen!");
	          
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
   
   //löscht die FS
   public void deleteLicht(String zugnummer) {
	   Connection conn = null; 
	   Statement stmt = null; 
	      try { 
	         // STEP 1: Register JDBC driver 
	         Class.forName(JDBC_DRIVER);  
	         
	         // STEP 2: Open a connection 
	         System.out.println("Connecting to database..."); 
	         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
	         
	         // STEP 3: Execute a query
	         System.out.println("Creating table in given database..."); 
	         stmt = conn.createStatement();  
	         String sql = "DELETE FROM licht_save" ;
	         stmt.executeUpdate(sql);  
	         
	         System.out.println("Neues Licht anlegen!");
	          
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
   //löscht die FS
   public void deleteDir(String zugnummer) {
	   Connection conn = null; 
	   Statement stmt = null; 
	      try { 
	         // STEP 1: Register JDBC driver 
	         Class.forName(JDBC_DRIVER);  
	         
	         // STEP 2: Open a connection 
	         System.out.println("Connecting to database..."); 
	         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
	         
	         // STEP 3: Execute a query
	         System.out.println("Creating table in given database..."); 
	         stmt = conn.createStatement();  
	         String sql = "DELETE FROM dir_save" ;
	         stmt.executeUpdate(sql);  
	         
	         System.out.println("Neue Richtung anlegen!");
	          
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
   
 //löscht die temporäre zeit für Speed
   public void deleteTempSpeed() {
	   Connection conn = null; 
	   Statement stmt = null; 
	      try { 
	         // STEP 1: Register JDBC driver 
	         Class.forName(JDBC_DRIVER);  
	         
	         // STEP 2: Open a connection 
	         System.out.println("Connecting to database..."); 
	         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
	         
	         // STEP 3: Execute a query
	         System.out.println("Creating table in given database..."); 
	         stmt = conn.createStatement();  
	         String sql = "DELETE FROM temp_speed_save" ;
	         stmt.executeUpdate(sql);  
	         
	         System.out.println("Gelöscht!");
	          
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
   
 //löscht die temporäre zeit für Licht
   public void deleteTempLicht() {
	   Connection conn = null; 
	   Statement stmt = null; 
	      try { 
	         // STEP 1: Register JDBC driver 
	         Class.forName(JDBC_DRIVER);  
	         
	         // STEP 2: Open a connection 
	         System.out.println("Connecting to database..."); 
	         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
	         
	         // STEP 3: Execute a query
	         System.out.println("Creating table in given database..."); 
	         stmt = conn.createStatement();  
	         String sql = "DELETE FROM temp_licht_save" ;
	         stmt.executeUpdate(sql);  
	         
	         System.out.println("Gelöscht!");
	          
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
