package application;

import java.io.IOException;
import java.net.UnknownHostException;
import clientServerConnection.ClientConnection;
import clientServerConnection.ConnectionCalls;
import clientServerConnection.RmxCalls;
import datenbank.CreateTable;
import datenbank.InsertIntoTable;
import datenbank.ReadFromTable;
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
	if(RMXAppTest.isRmxRunning() == true) {
	RmxCalls rmx = new RmxCalls();
	InsertIntoTable i = new InsertIntoTable();
	ReadFromTable r = new ReadFromTable();
	CreateTable.createZug();
	InsertIntoTable.zugData(111, "DEMO-ZUG", 14);
	ConnectionCalls.ZugErstellen(rmx.intToByte("DEMO-ZUG".length()+7), rmx.intToByte(111), rmx.intToByte(14), "DEMO-Zug".getBytes());
	CreateTable.createAktuellZug();
	i.setAktuellZug(111, "DEMO-ZUG", 14);
	CreateTable.createFSSave();
	CreateTable.createTimeSave();
	CreateTable.createLichtSave();
	CreateTable.createDirSave();
	CreateTable.createAblauf();
	//i.setAktuellAblauf(Integer.parseInt(r.getZugNrAktiverZug()), 0, 0, 0, 0);
	CreateTable.createTempSpeedSave();
	CreateTable.createTempLichtSave();
	CreateTable.createReihe();
	i.setDefaultReihe(Integer.parseInt(r.getZugNrAktiverZug()));
	i.setDir(0);
	}
	else {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("RMXFehler.fxml"));
			Scene scene = new Scene(root, 900, 450);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			//Open RMX Net
			Process p = Runtime.getRuntime().exec("C:\\Program Files (x86)\\rautenhaus digital\\RMX-PC-Zentrale 2.0\\RMXPCZ2.exe");
			DeleteInitialisierung j = new DeleteInitialisierung();
			j.delete();
		} 
		catch (Exception t) {
			t.printStackTrace();
							}
		}
}

//Falls RMX-Server läuft wird main gestartet
if(RMXAppTest.isRmxRunning() == true) {
			//Überprüft ob Server richtig verbunden ist
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
			//Wenn Server verbunden ist
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
			}
	}

//Wenn RMX-Server nicht ausgeführt wird --> Fehlermeldung
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
