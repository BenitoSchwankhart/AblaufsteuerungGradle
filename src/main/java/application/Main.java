package application;

import java.io.IOException;
import java.net.UnknownHostException;

import clientServerConnection.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	@Override

	public void start(Stage primaryStage) throws UnknownHostException, IOException {
		// Checking if Server is connected
		/*ClientConnection c = new ClientConnection();
		c.main(null);
		RmxCalls rmx = new RmxCalls();
		if (rmx.getVerbindung() == 2) {*/
			try {
				AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Test.fxml"));
				Scene scene = new Scene(root, 400, 400);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
	//	} else {
	//		System.out.println("Keine Verbindung zum Server");
		}

	//}

	public static void main(String[] args) {
		launch(args);
	}
}
