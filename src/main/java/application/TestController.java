package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import com.sun.glass.ui.ClipboardAssistance;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TestController implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@FXML
	private AnchorPane logpane;

	@FXML
	private JFXTextField username;

	@FXML
	private JFXPasswordField password;

	@FXML
	private JFXButton login;

	@FXML
	private JFXButton signup;

	@FXML
	void makeLogin(ActionEvent event) throws IOException {
		String user = username.getText();
		String pass = password.getText();

		if (user.equals("user") && pass.equals("user")) {
			System.out.println("Willkommen");
			weiter(event);
		} else {
			System.out.println("Fehler");
		}

	}

	void weiter(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Home.fxml"));
		logpane.getChildren().setAll(pane);
	}

	@FXML
	private AnchorPane menu_pane;

	@FXML
	private Pane pane_settings;

	@FXML
	private Pane pane_zuege;

	@FXML
	private Pane pane_ablauf;

	@FXML
	private JFXButton start_btn;

	@FXML
	private JFXButton zuege;

	@FXML
	private JFXButton ablauf;

	@FXML
	private JFXButton settings;

	@FXML
	void bittestarten(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		if (event.getSource() == start_btn) {
			stage = (Stage) start_btn.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("GUIAblaufssteuerung.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}

	@FXML
	void menuOnClick(ActionEvent event) {
		if (event.getSource() == zuege) {
			pane_zuege.toFront();
		} else if (event.getSource() == settings) {
			pane_settings.toFront();
		} else if (event.getSource() == ablauf) {
			pane_ablauf.toFront();
		}
	}

	// Drag and Drop
	@FXML
	private Pane black_pane;

	@FXML
	private JFXButton ziel;
	@FXML
	private JFXButton ziel4;

	@FXML
	private JFXButton ziel3;

	@FXML
	private JFXButton ziel2;
	@FXML
	private JFXButton licht;

	@FXML
	private JFXButton speed;

	@FXML
	private JFXButton funktion4;

	@FXML
	private JFXButton funktion3;

	@FXML
	private JFXButton starting_btn;

	@FXML
	private MaterialDesignIconView zeiger;

	@FXML
	void handleDragOver(DragEvent event) {
		event.acceptTransferModes(TransferMode.ANY);
	}

	@FXML
	void handleDragRichtung(MouseEvent event) {
		Dragboard db = licht.startDragAndDrop(TransferMode.ANY);

		ClipboardContent cb = new ClipboardContent();
		cb.putString(licht.getText());

		db.setContent(cb);
		event.consume();
	}

	@FXML
	void handleDragRichtungSpeed(MouseEvent event) {
		Dragboard db = speed.startDragAndDrop(TransferMode.ANY);

		ClipboardContent cb = new ClipboardContent();
		cb.putString(speed.getText());

		db.setContent(cb);
		event.consume();
	}

	@FXML
	void handleDragRichtungFunktion3(MouseEvent event) {
		Dragboard db = funktion3.startDragAndDrop(TransferMode.ANY);

		ClipboardContent cb = new ClipboardContent();
		cb.putString(funktion3.getText());

		db.setContent(cb);
		event.consume();
	}

	@FXML
	void handleDragRichtungFunktion4(MouseEvent event) {
		Dragboard db = funktion4.startDragAndDrop(TransferMode.ANY);

		ClipboardContent cb = new ClipboardContent();
		cb.putString(funktion4.getText());

		db.setContent(cb);
		event.consume();
	}

	@FXML
	void handledenDrop(DragEvent event) {
		String str = event.getDragboard().getString();
		ziel.setStyle("-fx-background-color: #009688;");
		ziel.setText(str);
	}

	@FXML
	void handledenDrop2(DragEvent event) {
		String str = event.getDragboard().getString();
		ziel2.setStyle("-fx-background-color: #009688;");
		ziel2.setText(str);
	}

	@FXML
	void handledenDrop3(DragEvent event) {
		String str = event.getDragboard().getString();
		ziel3.setStyle("-fx-background-color: #009688;");
		ziel3.setText(str);
	}

	@FXML
	void handledenDrop4(DragEvent event) {
		String str = event.getDragboard().getString();
		ziel4.setStyle("-fx-background-color: #009688;");
		ziel4.setText(str);

	}

	@FXML
	void starteAblauf(ActionEvent event) {
		zeiger.setFill(javafx.scene.paint.Color.GREEN);
	}
}
