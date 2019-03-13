package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;

import clientServerConnection.ConnectionCalls;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.awt.*;

public class NeueLokController implements Initializable {
// Neue Lok
	@FXML
	private JFXButton lokback_btn;

	@FXML
	private JFXTextField Namebox;

//Das ist der Spinner
	@FXML
	private Spinner<Integer> adressespinner;

	@FXML
	private Text TypBoxLabel;

	@FXML
	private ChoiceBox<String> TypBox;

	// Das ist der Submit Button
	@FXML
	private JFXButton submit_btn;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Startet get Choice Methode um die Auswahl der TypBox anzuzeigen
		submit_btn.setOnAction(e -> getChoice(TypBox));
		// L�dt die Daten der Choice Box
		loaddata();
		RequiredFieldValidator validator = new RequiredFieldValidator();

		Namebox.getValidators().add(validator);
		validator.setMessage("Noch keine Eingabe");

		Namebox.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (!newValue) {
					Namebox.validate();
				}

			}
		});

		// Spinner von 1-100
		SpinnerValueFactory<Integer> adresse = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 1);
		this.adressespinner.setValueFactory(adresse);
	}

	@FXML
	void backtohome(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		if (event.getSource() == lokback_btn) {
			stage = (Stage) lokback_btn.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Home.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}

	// F�llt die Typ ChoiceBox
	ObservableList listtyp = FXCollections.observableArrayList();

	private void loaddata() {
		// Typ
		listtyp.removeAll(listtyp);
		String a = "14";
		String b = "28";
		String c = "126";

		listtyp.addAll(a, b, c);
		TypBox.getItems().addAll(listtyp);

	}
//SubmitButton Funktion

	private void getChoice(ChoiceBox<String> TypBox) {
		String Fahrstufen = TypBox.getValue();
		System.out.print(Fahrstufen);
	}



	@FXML
	void submit_neueLok(ActionEvent event) {

		ConnectionCalls c = new ConnectionCalls();
		//byte COUNT, byte ZUGNR, byte OPMODE, byte[] NAME
		byte[] NAME = null;
		int COUNT = NAME.length; 
		//c.ZugErstellen();
		submit_btn.setOnAction(e -> getChoice(TypBox));

	}

}
