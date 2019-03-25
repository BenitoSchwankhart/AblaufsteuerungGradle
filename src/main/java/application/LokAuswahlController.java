package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LokAuswahlController implements Initializable{
	
	@FXML
	private JFXButton back;
	
	@FXML
	private JFXButton lokauswahl_btn;
	
	@FXML
	private ChoiceBox<String> TrainBox;
	
	@FXML
	private Text TypBoxText;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loaddata();
	}
	
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
	
	// Füllt die Typ ChoiceBox für die Züge
	ObservableList listtyp = FXCollections.observableArrayList();

	private void loaddata() {
		// Typ
		listtyp.removeAll(listtyp);
		String a = "14";
		String b = "24";
		String c = "126";

		listtyp.addAll(a, b, c);
		TrainBox.getItems().addAll(listtyp);

	}
	// SubmitButton Funktion

	private int getChoice(ChoiceBox<String> TrainBox) {
		String Fahrstufen = TrainBox.getValue();
		int FS = Integer.parseInt(Fahrstufen);
		System.out.println(FS);
		return FS;
	}
	
	@FXML
	void backonstart(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		if (event.getSource() == back) {
			stage = (Stage) back.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Home.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}

}
