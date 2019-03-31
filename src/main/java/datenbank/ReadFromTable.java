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
   
   
   //Gibt Alle Züge mit Daten aus
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
   
   //Gibt alle Zugnummern aus
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
	         String sql = "SELECT zugnummer FROM zug"; 
	         ResultSet rs = stmt.executeQuery(sql); 
	         
	         // STEP 4: Extract data from result set 
	         while(rs.next()) { 
	            // Retrieve by column name 
	        	 
	            int zugnummer  = rs.getInt("zugnummer");    
	            String zn = Integer.toString(zugnummer);

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
   
   //Gibt den namen des aktuellen Zug aus
   @SuppressWarnings("null")  
   public String getNameAktiverZug() {
	   String zugname = "";
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
	         String sql = "SELECT zugname FROM aktueller_zug"; 
	         ResultSet rs = stmt.executeQuery(sql); 
	         
	         // STEP 4: Extract data from result set 
	         while(rs.next()) { 
	            // Retrieve by column name 
	            zugname = rs.getString("zugname"); 
	            
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
	    return zugname;
	   
   }
   
   //Gibt die Zugnummer des aktuellen Zug aus
   @SuppressWarnings("null")  
   public String getZugNrAktiverZug() {
	   String zugnummer = "";
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
	         String sql = "SELECT zugnummer FROM aktueller_zug"; 
	         ResultSet rs = stmt.executeQuery(sql); 
	         
	         // STEP 4: Extract data from result set 
	         while(rs.next()) { 
	            // Retrieve by column name 
	            zugnummer = rs.getString("zugnummer"); 
	            
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
	    return zugnummer;
	   
   }
   
 //Gibt das fahrstufe des aktuellen Zug aus
   @SuppressWarnings("null")  
   public String getFSAktiverZug() {
	   String fahrstufe = "";
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
	         String sql = "SELECT fahrstufen FROM aktueller_zug"; 
	         ResultSet rs = stmt.executeQuery(sql); 
	         
	         // STEP 4: Extract data from result set 
	         while(rs.next()) { 
	            // Retrieve by column name 
	            fahrstufe = rs.getString("fahrstufen"); 
	            
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
	    return fahrstufe;
	   
   }
   
   //Gibt Alle Züge mit Allen Daten aus
   @SuppressWarnings("null")
   public String getAllData() {
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
	            System.out.print(zugname + "-"); 
	            System.out.print(fahrstufen + "\n"); 
	            
	            String zn = Integer.toString(zugnummer);
	            String fs = Integer.toString(fahrstufen);

	            //z wird mit Zugbezeichnungen + Fahrstufen gefüllt
	            z += zn + ";"+ zugname + ";" + fs + ";";
	            
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
   
   //Gibt die FS des aktuellen Zug aus
   @SuppressWarnings("null")  
   public String getTempFS() {
	   String fs = "";
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
	         String sql = "SELECT fs FROM fs_save"; 
	         ResultSet rs = stmt.executeQuery(sql); 
	         
	         // STEP 4: Extract data from result set 
	         while(rs.next()) { 
	            // Retrieve by column name 
	            fs = rs.getString("fs"); 
	            
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
	    return fs;
	   
   }
   
   //Gibt Alle Daten aus Ablauf aus
   @SuppressWarnings("null")
   public String getAblaufData() {
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
	         String sql = "SELECT zugnummer, speed, warte, licht, richtung FROM ablauf"; 
	         ResultSet rs = stmt.executeQuery(sql); 
	         
	         // STEP 4: Extract data from result set 
	         while(rs.next()) { 
	            // Retrieve by column name 
	            int zugnummer  = rs.getInt("zugnummer"); 
	            int speed = rs.getInt("speed"); 
	            int warte  = rs.getInt("warte"); 
	            int licht  = rs.getInt("licht"); 
	            int richtung  = rs.getInt("richtung"); 
	            
	            // Display values 
	            System.out.print(zugnummer + "-"); 
	            System.out.print(speed + "-"); 
	            System.out.print(warte + "-"); 
	            System.out.print(licht + "-"); 
	            System.out.print(richtung + "\n");

	            //z wird mit Zugbezeichnungen gefüllt
	            z = zugnummer + ";"+ speed + ";" + warte + ";" + licht + ";" + richtung + ";";
	            
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
   
   //Gibt die Richtung des Ablauf aus
   @SuppressWarnings("null")
   public String getAblaufRichtung() {
	   String z = null;
       
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
	         String sql = "SELECT richtung FROM ablauf"; 
	         ResultSet rs = stmt.executeQuery(sql); 
	         
	         // STEP 4: Extract data from result set 
	         while(rs.next()) { 
	            // Retrieve by column name 
	            String richtung  = rs.getString("richtung"); 
	            
	            // Display values 
	            System.out.print(richtung + "\n");

	            //z wird mit Zugbezeichnungen gefüllt
	            z = richtung ;
	            
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
   
 //Gibt Alle Züge mit Daten aus
   @SuppressWarnings("null")
   public String getAblaufReihe(String zugnummer) {
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
	         String sql = "SELECT drop1,drop2,drop3,drop4,drop5,drop6,drop7 FROM reihe"; 
	         ResultSet rs = stmt.executeQuery(sql); 
	         
	         // STEP 4: Extract data from result set 
	         while(rs.next()) { 
	            // Retrieve by column name 
	            String drop1 = rs.getString("drop1"); 
	            String drop2 = rs.getString("drop2"); 
	            String drop3 = rs.getString("drop3");   
	            String drop4 = rs.getString("drop4");
	            String drop5 = rs.getString("drop5");
	            String drop6 = rs.getString("drop6");
	            String drop7 = rs.getString("drop7");
	            
	            // Display values 
	            System.out.print(drop1 + "-"); 
	            System.out.print(drop2 + "-"); 
	            System.out.print(drop3 + "-");
	            System.out.print(drop4 + "-"); 
	            System.out.print(drop5 + "-");
	            System.out.print(drop6 + "-"); 
	            System.out.print(drop7 + "-"); 

	            //z wird mit Zugbezeichnungen gefüllt
	            z = drop1 + ";"+ drop2 + ";"+ drop3 + ";"+ drop4 + ";"+ drop5 + ";"+ drop6 + ";"+ drop7+ ";" ;
	            
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
  
   //Gibt die zeit des aktuellen Ablauf aus
   @SuppressWarnings("null")  
   public String getTempTime() {
	   String fs = "";
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
	         String sql = "SELECT time FROM time_save"; 
	         ResultSet rs = stmt.executeQuery(sql); 
	         
	         // STEP 4: Extract data from result set 
	         while(rs.next()) { 
	            // Retrieve by column name 
	            fs = rs.getString("time"); 
	            
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
	    return fs;
	   
   }
 //Gibt das licht des aktuellen Ablauf aus
   @SuppressWarnings("null")  
   public String getTempLicht() {
	   String fs = "";
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
	         String sql = "SELECT licht FROM licht_save"; 
	         ResultSet rs = stmt.executeQuery(sql); 
	         
	         // STEP 4: Extract data from result set 
	         while(rs.next()) { 
	            // Retrieve by column name 
	            fs = rs.getString("licht"); 
	            
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
	    return fs;
	   
   }
 //Gibt die richtung des aktuellen Ablauf aus
   @SuppressWarnings("null")  
   public String getTempDir() {
	   String fs = "";
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
	         String sql = "SELECT dir FROM dir_save"; 
	         ResultSet rs = stmt.executeQuery(sql); 
	         
	         // STEP 4: Extract data from result set 
	         while(rs.next()) { 
	            // Retrieve by column name 
	            fs = rs.getString("dir"); 
	            
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
	    return fs;
	   
   }
   
   public static void main(String[] args) { 

   }

}
