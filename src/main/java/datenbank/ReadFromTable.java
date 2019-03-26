package datenbank;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement;  

public class ReadFromTable { 
   // JDBC driver name and database URL 
   static final String JDBC_DRIVER = "org.h2.Driver";   
   static final String DB_URL = "jdbc:h2:~/.AblaufsteuerungGradle\\H2Datenbank";  
   
   //  Database credentials 
   static final String USER = ""; 
   static final String PASS = ""; 
   
   @SuppressWarnings("null")
   public String getData() {
	   String z = "";
       
	   Connection conn = null; 
	   Statement stmt = null; 
	      try { 
	    	  
	         // STEP 1: Register JDBC driver 
	         Class.forName(JDBC_DRIVER); 
	         
	         // STEP 2: Open a connection 
	         System.out.println("Connecting to database..."); 
	         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
	         
	         // STEP 3: Execute a query 
	         System.out.println("Connected database successfully..."); 
	         stmt = conn.createStatement(); 
	         String sql = "SELECT zugnummer, zugname, fahrstufen FROM zug"; 
	         ResultSet rs = stmt.executeQuery(sql); 
	         
	         // STEP 4: Extract data from result set 
	         while(rs.next()) { 
	            // Retrieve by column name 
	            int zugnummer  = rs.getInt("zugnummer"); 
	            String zugname = rs.getString("zugname"); 
	            int fahrstufen = rs.getInt("fahrstufen");   
	            
	            // Display values 
	            System.out.print(zugnummer + "-"); 
	            System.out.print(zugname + "\n"); 
	            //System.out.print(fahrstufen); 
	            
	            String zn = Integer.toString(zugnummer);
	            //String fs = Integer.toString(fahrstufen);

	            //z wird mit Zugbezeichnungen gefüllt
	            z += zn + ";"+ zugname + ";";
	            
	         }
	         
	         // STEP 5: Clean-up environment 
	         rs.close(); 
	      }catch(SQLException se) { 
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
	      
	      System.out.println("End of Reading!");
	    return z;
	   } 
   
   @SuppressWarnings("null")
   public String getZugNr() {
	   String z = "";
       
	   Connection conn = null; 
	   Statement stmt = null; 
	      try { 
	    	  
	         // STEP 1: Register JDBC driver 
	         Class.forName(JDBC_DRIVER); 
	         
	         // STEP 2: Open a connection 
	         System.out.println("Connecting to database..."); 
	         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
	         
	         // STEP 3: Execute a query 
	         System.out.println("Connected database successfully..."); 
	         stmt = conn.createStatement(); 
	         String sql = "SELECT zugnummer, zugname, fahrstufen FROM zug"; 
	         ResultSet rs = stmt.executeQuery(sql); 
	         
	         // STEP 4: Extract data from result set 
	         while(rs.next()) { 
	            // Retrieve by column name 
	            int zugnummer  = rs.getInt("zugnummer"); 
	            String zugname = rs.getString("zugname"); 
	            int fahrstufen = rs.getInt("fahrstufen");   
	            
	            // Display values 
	            //System.out.print(zugnummer + "-"); 
	            //System.out.print(zugname + "\n"); 
	            //System.out.print(fahrstufen); 
	            
	            String zn = Integer.toString(zugnummer);
	            //String fs = Integer.toString(fahrstufen);

	            //z wird mit Zugbezeichnungen gefüllt
	            z += zn + ";";
	            
	         }
	         
	         // STEP 5: Clean-up environment 
	         rs.close(); 
	      }catch(SQLException se) { 
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
	      
	      System.out.println("End of Reading!");
	    return z;
	   } 
   
   public static void main(String[] args) { 

   }

}
