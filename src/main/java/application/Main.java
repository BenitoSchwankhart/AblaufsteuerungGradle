package application;

import java.io.IOException;
import java.net.UnknownHostException;

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

		//*Checking if Server is connected
		/*clientConnection c = new clientConnection();
		c.main(null);
		RmxCalls rmx = new RmxCalls();
		if (rmx.getVerbindung() == 2) {*/
		CreateTable c = new CreateTable();
		c.createAktuellZug();
		c.createZugDB();
		InsertIntoTable i = new InsertIntoTable();
		i.zugData(222, "DEMO_ZUG", 14);
		i.setAktuellZug(222, "DEMO_ZUG");
		try {
				AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Home.fxml"));
				Scene scene = new Scene(root, 900, 450);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			}
		catch (Exception e) {
				e.printStackTrace();
			}
		}

		/*} else {
		System.out.println("Keine Verbindung zum Server");
	}*/

	public static void main(String[] args) {
		launch(args);
	}
}
