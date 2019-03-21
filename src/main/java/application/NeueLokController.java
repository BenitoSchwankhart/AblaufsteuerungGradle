package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;

import clientServerConnection.ConnectionCalls;
import clientServerConnection.RmxCalls;
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
		// submit_btn.setOnAction(e -> getChoice(TypBox));
		// Lädt die Daten der Choice Box
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

	// Füllt die Typ ChoiceBox
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

	private int getChoice(ChoiceBox<String> TypBox) {
		String Fahrstufen = TypBox.getValue();
		int FS = Integer.parseInt(Fahrstufen);
		System.out.println(FS);
		return FS;
	}

	private int getAdresse(Spinner<Integer> adressespinner2) {
		int adresse = adressespinner2.getValue();
		System.out.println(adresse);
		return adresse;
	}

	private String getName(JFXTextField Namebox) {
		String Name = Namebox.getText();
		System.out.println(Name);
		return Name;
	}




	@FXML
	void submit_neueLok(ActionEvent event) {
		getAdresse(adressespinner);
		int sub = getChoice(TypBox);
		getName(Namebox);
		ConnectionCalls c = new ConnectionCalls();
		RmxCalls rmx = new RmxCalls();
		byte OPMODE = 0;
		//byte COUNT, byte ZUGNR, byte OPMODE, byte[] NAME
		
		//Test welche Fahrstufe in TextBox ausgwählt wurde
		if ( sub == 14) {
			OPMODE = 0x09;
			System.out.println("FS14");
		}
		else if ( sub == 24) {
			OPMODE = 0x0C;
			System.out.println("FS24");
		}
		else if ( sub == 126) {
			OPMODE = 0x0F;
			System.out.println("FS126");
		}
		else {
			throw new IllegalArgumentException ("Fahrstufenauswahl fehlgeschlagen!");
		}
		
		/*byte[] NAME = new byte[20]; //Maximale Länge auf 20 festgelegt
		for(int i=0; i<20; i++) {
			NAME[i] = i;
		}*/
		//int COUNT = NAME.length; 
		//c.ZugErstellen();
		// byte COUNT, byte ZUGNR, byte OPMODE, byte[] NAME
		byte[] NAME = null;
		int COUNT = NAME.length;
		// c.ZugErstellen();

	}

}
