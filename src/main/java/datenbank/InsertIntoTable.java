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
   
   //Gibt der Datenbank einen neuen Zug inklusive aller Daten 
   public static void zugData(int zugnummer, String zugname, int fahrstufen){
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
	         System.out.println("Test");
	         
	         stmt = conn.createStatement();  
	         String sql = "INSERT INTO zug " + "VALUES" + "(" + zugnummer + "," + "'" + zugname + "'" + "," + fahrstufen + ")"; 
	         
	         stmt.executeUpdate(sql); 
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
   
   //Speichert den aktuellen Zug mit Name, Zugnummer und Fahrstufen
   public void setAktuellZug(int zugnummer,String zugname, int fahrstufe){
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
	         System.out.println("Test");
	         
	         stmt = conn.createStatement();  
	         String sql = "INSERT INTO aktueller_zug " + "VALUES" + "(" + zugnummer + "," + "'" + zugname + "'" + "," + fahrstufe + ")";  
	         
	         stmt.executeUpdate(sql); 
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
   
   //Speichert den aktuellen FS für temporäre Ablaufsteuerung
   public void setFS(int fs){
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
	         System.out.println("Test");
	         
	         stmt = conn.createStatement();  
	         String sql = "INSERT INTO fs_save " + "VALUES" + "(" + fs + ")";  
	         
	         stmt.executeUpdate(sql); 
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
   
 //Speichert den aktuellen Ablauf 
   public void setAktuellAblauf(int zugnummer,int speed,int warten, int licht, int dir){
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
	         System.out.println("Test");
	         
	         stmt = conn.createStatement();  
	         String sql = "INSERT INTO ablauf " + "VALUES" + "(" + zugnummer + "," +  speed +  "," + warten + "," 
	         + licht + "," + dir + ")";  
	         
	         stmt.executeUpdate(sql); 
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
   
   //Speichert den aktuellen Ablauf 
   public void setDefaultReihe(int zugnummer){
	   Connection conn = null; 
	   Statement stmt = null; 
	   String drop1= null,drop2 = null,drop3= null,drop4= null,drop5= null,drop6= null,drop7 = null;
	      
	      try{
	         // STEP 1: Register JDBC driver 
	         Class.forName(JDBC_DRIVER);  
	         
	         // STEP 2: Open a connection 
	         System.out.println("Connecting to a selected database..."); 
	         conn = DriverManager.getConnection(DB_URL,USER,PASS); 
	         System.out.println("Connected database successfully..."); 
	         
	         // STEP 3: Execute a query 
	         System.out.println("Test");
	         
	         stmt = conn.createStatement();  
	         String sql = "INSERT INTO reihe " + "VALUES" + "(" + zugnummer + "," +  drop1 +  "," + drop2 + "," 
	         + drop3 + "," + drop4 + "," + drop5 + "," + drop6 + "," + drop7 +")";  
	         
	         stmt.executeUpdate(sql); 
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
   
   //Speichert den speed für temporäre Ablaufsteuerung
   public void set(int fs){
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
	         System.out.println("Test");
	         
	         stmt = conn.createStatement();  
	         String sql = "INSERT INTO fs_save " + "VALUES" + "(" + fs + ")";  
	         
	         stmt.executeUpdate(sql); 
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
   
   //Speichert die wartezeit für temporäre Ablaufsteuerung
   public void setWarten(int time){
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
	         System.out.println("Test");
	         
	         stmt = conn.createStatement();  
	         String sql = "INSERT INTO time_save " + "VALUES" + "(" + time + ")";  
	         
	         stmt.executeUpdate(sql); 
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
   
   //Speichert die lichteinstellung für temporäre Ablaufsteuerung
   public void setLicht(int licht){
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
	         System.out.println("Test");
	         
	         stmt = conn.createStatement();  
	         String sql = "INSERT INTO licht_save " + "VALUES" + "(" + licht + ")";  
	         
	         stmt.executeUpdate(sql); 
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
   
   //Speichert die richtung für temporäre Ablaufsteuerung
   public void setDir(int dir){
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
	         System.out.println("Test");
	         
	         stmt = conn.createStatement();  
	         String sql = "INSERT INTO dir_save " + "VALUES" + "(" + dir + ")";  
	         
	         stmt.executeUpdate(sql); 
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

 //Speichert die temporäre Zeit für Speed
   public void setTempSpeed(int time){
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
	         System.out.println("Test");
	         
	         stmt = conn.createStatement();  
	         String sql = "INSERT INTO temp_speed_save " + "VALUES" + "(" + time + ")";  
	         
	         stmt.executeUpdate(sql); 
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
   
   //Speichert die temporäre Zeit für Licht
   public void setTempLicht(int time){
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
	         System.out.println("Test");
	         
	         stmt = conn.createStatement();  
	         String sql = "INSERT INTO temp_licht_save " + "VALUES" + "(" + time + ")";  
	         
	         stmt.executeUpdate(sql); 
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
   
   
  
  public static void main(String[] args) { 

  }
}
