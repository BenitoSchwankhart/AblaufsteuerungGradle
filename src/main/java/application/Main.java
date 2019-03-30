package application;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.UnknownHostException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

import javax.naming.NameNotFoundException;

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
		
//Testen ob RMX bereits läuft return true falls bereits läuft
RMXAppTest a = new RMXAppTest();
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

String rmxapp = "RMX-PC-Zentrale 2.0";
if(a.isOtherInstanceRunning(rmxapp) == true) {
		try {
			// Checking if Server is connected
			ClientConnection c = new ClientConnection();
			c.main(null);
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
			
	}
	catch (IOException e) {
		try {
		//Open RMX Net
		Process p = Runtime.getRuntime().exec("C:\\Program Files (x86)\\rautenhaus digital\\RMX-PC-Zentrale 2.0\\RMXPCZ2.exe");
		}
		catch (IOException h) {
			try {
				AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("RMXFehler.fxml"));
				Scene scene = new Scene(root, 900, 450);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			} 
			catch (Exception t) {
				t.printStackTrace();
								}
			}
		}
	}
else {
	try {
		AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("RMXunaktiv.fxml"));
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
