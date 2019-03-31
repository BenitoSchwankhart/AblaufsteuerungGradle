package datenbank;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.sql.Statement;  

//Soll bei neuinstallation des systems angelest werden
public class CreateTable { 
   // JDBC driver name and database URL 
   static final String JDBC_DRIVER = "org.h2.Driver";   
   static final String DB_URL = "jdbc:h2:~/.AblaufsteuerungGradle\\H2Datenbank";  
   
   //  Database credentials 
   static final String USER = ""; 
   static final String PASS = ""; 
   
   
   //Erstellung der Tabelle für den aktuellen Zug
   public static void createAktuellZug() {
	   Connection conn = null; 
	   Statement stmt = null; 
	      try { 
	         // STEP 1: Register JDBC driver 
	         Class.forName(JDBC_DRIVER); 
	             
	         //STEP 2: Open a connection 
	         System.out.println("Connecting to database..."); 
	         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
	         
	         //STEP 3: Execute a query 
	         System.out.println("Creating table in given database..."); 
	         stmt = conn.createStatement(); 
	         String sql =  "CREATE TABLE   aktueller_zug" + 
	                 "(zugnummer INTEGER not NULL, " + 
	                 " zugname VARCHAR(255), " + 
	                 " fahrstufen INTEGER, " + 
	                 " PRIMARY KEY ( zugnummer ))";  
	         stmt.executeUpdate(sql);
	         System.out.println("Created table in given database..."); 
	         
	         // STEP 4: Clean-up environment 
	         stmt.close(); 
	         conn.close(); 
	      } catch(SQLException se) { 
	         //Handle errors for JDBC 
	         se.printStackTrace(); 
	      } catch(Exception e) { 
	         //Handle errors for Class.forName 
	         e.printStackTrace(); 
	      } finally { 
	         //finally block used to close resources 
	         try{ 
	            if(stmt!=null) stmt.close(); 
	         } catch(SQLException se2) { 
	         } // nothing we can do 
	         try { 
	            if(conn!=null) conn.close(); 
	         } catch(SQLException se){ 
	            se.printStackTrace(); 
	         } //end finally try 
	      } //end try 
	      System.out.println("Goodbye!");
	   } 
   
 //Erstellung der Tabelle für einen Zug
   public static void createZug() {
	  Connection conn = null; 
      Statement stmt = null; 
      try { 
         // STEP 1: Register JDBC driver 
         Class.forName(JDBC_DRIVER); 
             
         //STEP 2: Open a connection 
         System.out.println("Connecting to database..."); 
         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
         
         //STEP 3: Execute a query 
         System.out.println("Creating table in given database..."); 
         stmt = conn.createStatement(); 
         String sql =  "CREATE TABLE   zug" + 
            "(zugnummer INTEGER not NULL, " + 
            " zugname VARCHAR(255), " +  
            " fahrstufen INTEGER, " +  
            " PRIMARY KEY ( zugnummer ))";  
         stmt.executeUpdate(sql);
         System.out.println("Created table in given database..."); 
         
         // STEP 4: Clean-up environment 
         stmt.close(); 
         conn.close(); 
      } catch(SQLException se) { 
         //Handle errors for JDBC 
         se.printStackTrace(); 
      } catch(Exception e) { 
         //Handle errors for Class.forName 
         e.printStackTrace(); 
      } finally { 
         //finally block used to close resources 
         try{ 
            if(stmt!=null) stmt.close(); 
         } catch(SQLException se2) { 
         } // nothing we can do 
         try { 
            if(conn!=null) conn.close(); 
         } catch(SQLException se){ 
            se.printStackTrace(); 
         } //end finally try 
      } //end try 
      System.out.println("Goodbye!");
   } 
   
  
 //Zum Speichern der FS für Ablauf
   public static void createFSSave() {
	  Connection conn = null; 
      Statement stmt = null; 
      try { 
         // STEP 1: Register JDBC driver 
         Class.forName(JDBC_DRIVER); 
             
         //STEP 2: Open a connection 
         System.out.println("Connecting to database..."); 
         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
         
         //STEP 3: Execute a query 
         System.out.println("Creating table in given database..."); 
         stmt = conn.createStatement(); 
         String sql =  "CREATE TABLE   fs_save" + 
            "(fs INTEGER not NULL)";  
         stmt.executeUpdate(sql);
         System.out.println("Created table in given database..."); 
         
         // STEP 4: Clean-up environment 
         stmt.close(); 
         conn.close(); 
      } catch(SQLException se) { 
         //Handle errors for JDBC 
         se.printStackTrace(); 
      } catch(Exception e) { 
         //Handle errors for Class.forName 
         e.printStackTrace(); 
      } finally { 
         //finally block used to close resources 
         try{ 
            if(stmt!=null) stmt.close(); 
         } catch(SQLException se2) { 
         } // nothing we can do 
         try { 
            if(conn!=null) conn.close(); 
         } catch(SQLException se){ 
            se.printStackTrace(); 
         } //end finally try 
      } //end try 
      System.out.println("Goodbye!");
   } 
   
 //Erstellung der Tabelle für einen Ablauf
   public static void createAblauf() {
	  Connection conn = null; 
      Statement stmt = null; 
      try { 
         // STEP 1: Register JDBC driver 
         Class.forName(JDBC_DRIVER); 
             
         //STEP 2: Open a connection 
         System.out.println("Connecting to database..."); 
         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
         
         //STEP 3: Execute a query 
         System.out.println("Creating table in given database..."); 
         stmt = conn.createStatement(); 
         String sql =  "CREATE TABLE   ablauf" + 
            "(zugnummer INTEGER not NULL, " + 
            " SPEED INTEGER, " +  
            " WARTE INTEGER, " +
            " LICHT INTEGER, " + 
            " RICHTUNG INTEGER, " + 
            " PRIMARY KEY ( zugnummer ))";  
         stmt.executeUpdate(sql);
         System.out.println("Created table in given database..."); 
         
         // STEP 4: Clean-up environment 
         stmt.close(); 
         conn.close(); 
      } catch(SQLException se) { 
         //Handle errors for JDBC 
         se.printStackTrace(); 
      } catch(Exception e) { 
         //Handle errors for Class.forName 
         e.printStackTrace(); 
      } finally { 
         //finally block used to close resources 
         try{ 
            if(stmt!=null) stmt.close(); 
         } catch(SQLException se2) { 
         } // nothing we can do 
         try { 
            if(conn!=null) conn.close(); 
         } catch(SQLException se){ 
            se.printStackTrace(); 
         } //end finally try 
      } //end try 
      System.out.println("Goodbye!");
   } 
   
   //Erstellung der Tabelle für eine Reihenfolge der Abläufe
   public static void createReihe() {
	  Connection conn = null; 
      Statement stmt = null; 
      try { 
         // STEP 1: Register JDBC driver 
         Class.forName(JDBC_DRIVER); 
             
         //STEP 2: Open a connection 
         System.out.println("Connecting to database..."); 
         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
         
         //STEP 3: Execute a query 
         System.out.println("Creating table in given database..."); 
         stmt = conn.createStatement(); 
         String sql =  "CREATE TABLE   reihe" + 
            "(zugnummer INTEGER not NULL, " + 
            " drop1 VARCHAR(255), " +
            " drop2 VARCHAR(255), " +
            " drop3 VARCHAR(255), " +
            " drop4 VARCHAR(255), " +
            " drop5 VARCHAR(255), " +
            " drop6 VARCHAR(255), " +
            " drop7 VARCHAR(255), " +
            " PRIMARY KEY ( zugnummer ))";  
         stmt.executeUpdate(sql);
         System.out.println("Created table in given database..."); 
         
         // STEP 4: Clean-up environment 
         stmt.close(); 
         conn.close(); 
      } catch(SQLException se) { 
         //Handle errors for JDBC 
         se.printStackTrace(); 
      } catch(Exception e) { 
         //Handle errors for Class.forName 
         e.printStackTrace(); 
      } finally { 
         //finally block used to close resources 
         try{ 
            if(stmt!=null) stmt.close(); 
         } catch(SQLException se2) { 
         } // nothing we can do 
         try { 
            if(conn!=null) conn.close(); 
         } catch(SQLException se){ 
            se.printStackTrace(); 
         } //end finally try 
      } //end try 
      System.out.println("Goodbye!");
   }
   
   //Zum Speichern der Zeit für Ablauf
   public static void createTimeSave() {
	  Connection conn = null; 
      Statement stmt = null; 
      try { 
         // STEP 1: Register JDBC driver 
         Class.forName(JDBC_DRIVER); 
             
         //STEP 2: Open a connection 
         System.out.println("Connecting to database..."); 
         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
         
         //STEP 3: Execute a query 
         System.out.println("Creating table in given database..."); 
         stmt = conn.createStatement(); 
         String sql =  "CREATE TABLE   time_save" + 
            "(time INTEGER not NULL)";  
         stmt.executeUpdate(sql);
         System.out.println("Created table in given database..."); 
         
         // STEP 4: Clean-up environment 
         stmt.close(); 
         conn.close(); 
      } catch(SQLException se) { 
         //Handle errors for JDBC 
         se.printStackTrace(); 
      } catch(Exception e) { 
         //Handle errors for Class.forName 
         e.printStackTrace(); 
      } finally { 
         //finally block used to close resources 
         try{ 
            if(stmt!=null) stmt.close(); 
         } catch(SQLException se2) { 
         } // nothing we can do 
         try { 
            if(conn!=null) conn.close(); 
         } catch(SQLException se){ 
            se.printStackTrace(); 
         } //end finally try 
      } //end try 
      System.out.println("Goodbye!");
   } 
   
   //Zum Speichern der FS für Ablauf
   public static void createLichtSave() {
	  Connection conn = null; 
      Statement stmt = null; 
      try { 
         // STEP 1: Register JDBC driver 
         Class.forName(JDBC_DRIVER); 
             
         //STEP 2: Open a connection 
         System.out.println("Connecting to database..."); 
         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
         
         //STEP 3: Execute a query 
         System.out.println("Creating table in given database..."); 
         stmt = conn.createStatement(); 
         String sql =  "CREATE TABLE   licht_save" + 
            "(licht INTEGER not NULL)";  
         stmt.executeUpdate(sql);
         System.out.println("Created table in given database..."); 
         
         // STEP 4: Clean-up environment 
         stmt.close(); 
         conn.close(); 
      } catch(SQLException se) { 
         //Handle errors for JDBC 
         se.printStackTrace(); 
      } catch(Exception e) { 
         //Handle errors for Class.forName 
         e.printStackTrace(); 
      } finally { 
         //finally block used to close resources 
         try{ 
            if(stmt!=null) stmt.close(); 
         } catch(SQLException se2) { 
         } // nothing we can do 
         try { 
            if(conn!=null) conn.close(); 
         } catch(SQLException se){ 
            se.printStackTrace(); 
         } //end finally try 
      } //end try 
      System.out.println("Goodbye!");
   } 
   
   //Zum Speichern der Richtung für Ablauf
   public static void createDirSave() {
	  Connection conn = null; 
      Statement stmt = null; 
      try { 
         // STEP 1: Register JDBC driver 
         Class.forName(JDBC_DRIVER); 
             
         //STEP 2: Open a connection 
         System.out.println("Connecting to database..."); 
         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
         
         //STEP 3: Execute a query 
         System.out.println("Creating table in given database..."); 
         stmt = conn.createStatement(); 
         String sql =  "CREATE TABLE   dir_save" + 
            "(dir INTEGER not NULL)";  
         stmt.executeUpdate(sql);
         System.out.println("Created table in given database..."); 
         
         // STEP 4: Clean-up environment 
         stmt.close(); 
         conn.close(); 
      } catch(SQLException se) { 
         //Handle errors for JDBC 
         se.printStackTrace(); 
      } catch(Exception e) { 
         //Handle errors for Class.forName 
         e.printStackTrace(); 
      } finally { 
         //finally block used to close resources 
         try{ 
            if(stmt!=null) stmt.close(); 
         } catch(SQLException se2) { 
         } // nothing we can do 
         try { 
            if(conn!=null) conn.close(); 
         } catch(SQLException se){ 
            se.printStackTrace(); 
         } //end finally try 
      } //end try 
      System.out.println("Goodbye!");
   }
   
   //Zum Speichern die Zeit für Speed in Ablauf
   public static void createTempSpeedSave() {
	  Connection conn = null; 
      Statement stmt = null; 
      try { 
         // STEP 1: Register JDBC driver 
         Class.forName(JDBC_DRIVER); 
             
         //STEP 2: Open a connection 
         System.out.println("Connecting to database..."); 
         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
         
         //STEP 3: Execute a query 
         System.out.println("Creating table in given database..."); 
         stmt = conn.createStatement(); 
         String sql =  "CREATE TABLE   temp_speed_save" + 
            "(time INTEGER not NULL)";  
         stmt.executeUpdate(sql);
         System.out.println("Created table in given database..."); 
         
         // STEP 4: Clean-up environment 
         stmt.close(); 
         conn.close(); 
      } catch(SQLException se) { 
         //Handle errors for JDBC 
         se.printStackTrace(); 
      } catch(Exception e) { 
         //Handle errors for Class.forName 
         e.printStackTrace(); 
      } finally { 
         //finally block used to close resources 
         try{ 
            if(stmt!=null) stmt.close(); 
         } catch(SQLException se2) { 
         } // nothing we can do 
         try { 
            if(conn!=null) conn.close(); 
         } catch(SQLException se){ 
            se.printStackTrace(); 
         } //end finally try 
      } //end try 
      System.out.println("Goodbye!");
   }
   
   //Zum Speichern die Zeit für Licht in Ablauf
   public static void createTempLichtSave() {
	  Connection conn = null; 
      Statement stmt = null; 
      try { 
         // STEP 1: Register JDBC driver 
         Class.forName(JDBC_DRIVER); 
             
         //STEP 2: Open a connection 
         System.out.println("Connecting to database..."); 
         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
         
         //STEP 3: Execute a query 
         System.out.println("Creating table in given database..."); 
         stmt = conn.createStatement(); 
         String sql =  "CREATE TABLE   temp_licht_save" + 
            "(time INTEGER not NULL)";  
         stmt.executeUpdate(sql);
         System.out.println("Created table in given database..."); 
         
         // STEP 4: Clean-up environment 
         stmt.close(); 
         conn.close(); 
      } catch(SQLException se) { 
         //Handle errors for JDBC 
         se.printStackTrace(); 
      } catch(Exception e) { 
         //Handle errors for Class.forName 
         e.printStackTrace(); 
      } finally { 
         //finally block used to close resources 
         try{ 
            if(stmt!=null) stmt.close(); 
         } catch(SQLException se2) { 
         } // nothing we can do 
         try { 
            if(conn!=null) conn.close(); 
         } catch(SQLException se){ 
            se.printStackTrace(); 
         } //end finally try 
      } //end try 
      System.out.println("Goodbye!");
   }
   
//---------------------------------------------------MAIN--------------------------------------------
  
   public static void main(String[] args) { 
	   createTempSpeedSave();
	   createTempLichtSave();
   }
}