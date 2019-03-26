package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.jfoenix.controls.JFXButton;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;

import clientServerConnection.ConnectionCalls;
import clientServerConnection.RmxCalls;
import datenbank.InsertIntoTable;
import datenbank.ReadFromTable;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NeueLokController implements Initializable {
	// Neue Lok
	@FXML
	private JFXButton lokback_btn;

	@FXML
	private JFXTextField Namebox;

	// Das ist der Spinner
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
		
		//Funktion zum f�llen von adressspinner
		ReadFromTable r = new ReadFromTable();
		
		String b = r.getZugNr();
		//String[] s = b.split(";");
		//s[0] enth�lt Zugnummer
		
		//TODO Liste machen von denen ZugNr abgezogen werden
		
			Scanner scanner = new Scanner(b);
			String line = scanner.nextLine();
			String[] s = line.split(";");
			Integer[] n = new Integer[s.length];

		ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(n));
		

		//Value mit verf�gbaren Zahlen f�llen
		ObservableList<Integer> zugNr = FXCollections.observableArrayList(arrayList);
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<Integer>(zugNr);
	    this.adressespinner.setValueFactory(valueFactory);
	 
	      
	     // Default value
	     valueFactory.setValue(null);
	     adressespinner.setValueFactory(valueFactory);

	
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
		String b = "24";
		String c = "126";

		listtyp.addAll(a, b, c);
		TypBox.getItems().addAll(listtyp);

	}
	// SubmitButton Funktion

	private int getChoice(ChoiceBox<String> TypBox) {
		String Fahrstufen = TypBox.getValue();
		int FS = Integer.parseInt(Fahrstufen);
		System.out.println(FS);
		return FS;
	}

	private int getAdresse(Spinner<Integer> adressespinner) {
		int adresse = adressespinner.getValue().intValue();
		System.out.println(adresse);
		return adresse;
	}

	private String getName(JFXTextField Namebox) {
		String Name = Namebox.getText();
		System.out.println(Name);
		return Name;
	}

	
	//Fahrstufen f�r datenbank
	public int dataFS() {
		int sub = getChoice(TypBox);
		return sub;
	}
	
	//Fahrstufen f�r datenbank
		public int dataZugNr() {
			int zugnummer = getAdresse(adressespinner);
			return zugnummer;
		}
	
	//Zugname f�r datenbank
			public String dataName() {
				String zugname = getName(Namebox);
				return zugname;
			}

	@FXML
	void submit_neueLok(ActionEvent event) throws IOException {
		int zugnummer = getAdresse(adressespinner);
		int sub = getChoice(TypBox);
		String zugname = getName(Namebox);
		ConnectionCalls c = new ConnectionCalls();
		InsertIntoTable t = new InsertIntoTable();
		RmxCalls rmx = new RmxCalls();
		byte OPMODE = 0;

		// Test welche Fahrstufe in TextBox ausgw�hlt wurde
		if (sub == 14) {
			OPMODE = 0x09;
			System.out.println("FS14");
		} else if (sub == 24) {
			OPMODE = 0x0C;
			System.out.println("FS24");
		} else if (sub == 126) {
			OPMODE = 0x0F;
			System.out.println("FS126");
		} else {
			throw new IllegalArgumentException("Fahrstufenauswahl fehlgeschlagen!");
		}

		
		int fahrstufen = sub;
		
		/** Fehler int COUNT = NAME.length;**/
		InsertIntoTable.zugData(zugnummer, zugname, fahrstufen);
		RmxCalls r = new RmxCalls();
		byte COUNT = r.intToByte(zugname.length()+7);
		byte ZUGNR = r.intToByte(zugnummer);
		byte[] NAME = zugname.getBytes();
		
		//ConnectionCalls.ZugErstellen(COUNT, ZUGNR, OPMODE, NAME);
		
		//TODO Fenster zur Best�tigung der Zuganlage ausgeben
		
	}
}
