package application;

import java.io.IOException;
import java.net.UnknownHostException;
import clientServerConnection.ClientConnection;
import clientServerConnection.ConnectionCalls;
import clientServerConnection.RmxCalls;
import datenbank.CreateTable;
import datenbank.InsertIntoTable;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	@Override
	

public void start(Stage primaryStage) throws UnknownHostException, IOException {
		
//Tabellen anlegen bei erstem Start
Initialisierung g = new Initialisierung();
if(g.neuesProgramm() == true) {
	System.out.println("Datenbank vorhanden !");
}
else {
	//-->Sicherstellen das Tabellen da sind
	CreateTable d = new CreateTable();
	RmxCalls rmx = new RmxCalls();
	InsertIntoTable i = new InsertIntoTable();
	d.createZug();
	i.zugData(222, "DEMO-ZUG", 14);
	ConnectionCalls.ZugErstellen(rmx.intToByte("DEMO-ZUG".length()+7), rmx.intToByte(222), rmx.intToByte(14), "DEMO-Zug".getBytes());
	d.createAktuellZug();
	i.setAktuellZug(222, "DEMO-ZUG", 14);
	d.createFSSave();
}

RMXAppTest a = new RMXAppTest();
//Falls RMX-Server läuft wird main gestartet
if(RMXAppTest.isRmxRunning() == true) {
			// Checking if Server is connected
			ClientConnection c = new ClientConnection();
			try {
			c.main(null);	
			}
			catch(Exception o) {
				try {
					AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("RMXunaktiv.fxml"));
					Scene scene = new Scene(root, 900, 450);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage.setScene(scene);
					primaryStage.show();
					//Open RMX Net
				} 
				catch (Exception t) {
					t.printStackTrace();
									}
				
			}
			RmxCalls rmx = new RmxCalls();
			if (rmx.getVerbindung() == 2) {
			primaryStage.setResizable(false);

				try {
					AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Home.fxml"));
					Scene scene = new Scene(root, 900, 450);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage.setScene(scene);
					primaryStage.show();
				} 
				catch (Exception t) {
					t.printStackTrace();
									}
		}
			else {
				AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("RMXunaktiv.fxml"));
				Scene scene = new Scene(root, 900, 450);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
				//Open RMX Net
				//Process p = Runtime.getRuntime().exec("C:\\Program Files (x86)\\rautenhaus digital\\RMX-PC-Zentrale 2.0\\RMXPCZ2.exe");
			}
	}

//Wenn RMX-Server nicht ausgeführt Fehlermeldung
else {
	try {
		AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("RMXFehler.fxml"));
		Scene scene = new Scene(root, 900, 450);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		//Open RMX Net
		Process p = Runtime.getRuntime().exec("C:\\Program Files (x86)\\rautenhaus digital\\RMX-PC-Zentrale 2.0\\RMXPCZ2.exe");
	} 
	catch (Exception t) {
		t.printStackTrace();
						}
	}
}

	public static void main(String[] args) {
		launch(args);
	}
}
