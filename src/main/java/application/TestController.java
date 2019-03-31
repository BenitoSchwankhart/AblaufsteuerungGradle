package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import datenbank.ReadFromTable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import javafx.stage.Stage;

public class TestController implements Initializable {

	@FXML
	private AnchorPane menu_pane;
	@FXML
	private AnchorPane logpane;
	@FXML
	private Pane pane_settings;

	@FXML
	private Pane pane_ablauf;

	@FXML
	private JFXButton start_btn;

	@FXML
	private JFXButton start_btn1;

	@FXML
	private Pane neuelok;

	@FXML
	private JFXButton neuelok_btn;

	@FXML
	private JFXButton lokauswahl_btn;

	@FXML
	private Text aktuell;

	@FXML
	private JFXButton zuege;

	@FXML
	private JFXButton ablauf;

	@FXML
	private JFXButton settings;
	@FXML
	private JFXButton defaultabflauf_btn;
	@FXML
	private JFXButton handbuch_btn;

	@FXML
	void open(ActionEvent event) {
		// Hier Pdf öffnen

	}

	@FXML
	void defaultstarten(ActionEvent event) throws IOException {
		String Bedingung = null;
		String Erfüllt = null;
		if (Bedingung == Erfüllt) {

			Stage stage;
			Parent root;
			if (event.getSource() == defaultabflauf_btn) {
				stage = (Stage) defaultabflauf_btn.getScene().getWindow();
				root = FXMLLoader.load(getClass().getResource("DemoAblauf.fxml"));
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ReadFromTable r = new ReadFromTable();
		System.out.println(r.getNameAktiverZug());
		if (r.getNameAktiverZug() != null) {
			aktuell.setText(r.getNameAktiverZug());
		} else {
			aktuell.setText("Kein Zug ausgewählt!");
		}
	}

// Nicht Verwendet++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	/*
	 * @FXML void makeLogin(ActionEvent event) throws IOException { String user =
	 * username.getText(); String pass = password.getText();
	 * 
	 * if (user.equals("user") && pass.equals("user")) {
	 * System.out.println("Willkommen User!"); weiter(event); } else {
	 * System.out.println("Fehler"); }
	 * 
	 * }
	 */
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	@FXML
	void lokauswahl_btn(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		if (event.getSource() == lokauswahl_btn) {
			stage = (Stage) lokauswahl_btn.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("LokAuswahl.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		}

	}

	@FXML
	void bittestarten(ActionEvent event) throws IOException {
		String Bedingung = null;
		String Erfüllt = null;
		if (Bedingung == Erfüllt) {

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
	}

	@FXML
	void menuOnClick(ActionEvent event) {
		if (event.getSource() == zuege) {
			neuelok.toFront();
		} else if (event.getSource() == settings) {
			pane_settings.toFront();
		} else if (event.getSource() == ablauf) {
			pane_ablauf.toFront();
		}
	}

//Neue Lok Fenster

	@FXML
	void neuelok(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		if (event.getSource() == neuelok_btn) {
			stage = (Stage) neuelok_btn.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("NeueLok.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		}
	}

}
