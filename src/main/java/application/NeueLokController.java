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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.sql.ResultSet;

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
	
	@FXML
	private TableView<String[]> tableView;
	  
	@FXML
	private TableColumn<String[], String> adresse;

	@FXML
	private TableColumn<String[], String> name;

	@FXML
	private TableColumn<String[], String> fahrstufe;

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
				}}});
		
//----------Funktion zum füllen von adressspinner---------------------------------------------------------------------------
		ReadFromTable r = new ReadFromTable();
		String b = r.getZugNr();

		//Gibt alle Zugnummern aus und speichert sie in als Integer in n
		Integer[] array = new Integer[100];
		Scanner scanner = new Scanner(b);
		String line = scanner.nextLine();
		String[] h = line.split(";");
		int[] n = new int[h.length];
		for(int i = 0;i < h.length;i++) {
		n[i] = Integer.parseInt(h[i]);
		}
	
		//Array mit 100 Elementen 0-99 erstellen
		for (int i = 0; i < array.length; i++) {
				array[i] = i;
				}
		
		ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(array));
		
		for (int i = 0; i < array.length; i++) {
			arrayList.get(i);
			}

		//Vorhandene Zugnummern löschen
		for (int i = 0; i < n.length; ++i) {
			for (int j = 0; j < arrayList.size(); ++j) {
				if (n[i] == arrayList.get(j)) {
					arrayList.remove(j);
				}
			}
		}
		
		
			//Value mit verfügbaren Zahlen füllen
			ObservableList<Integer> zugNr = FXCollections.observableArrayList(arrayList);
			SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<Integer>(zugNr);
		    this.adressespinner.setValueFactory(valueFactory);
		 
		      
		     // Default value
		     valueFactory.setValue(arrayList.get(0));
		     adressespinner.setValueFactory(valueFactory);	

//----------Initialisierung der Lok-Tabelle---------------------------------------------------------------------------
				
		     
		   //erstellt die Spalten in der Tabelle
				adresse.setCellValueFactory(new PropertyValueFactory<String[], String> ("Adresse"));
				name.setCellValueFactory(new PropertyValueFactory<String[], String>("Name"));
				fahrstufe.setCellValueFactory(new PropertyValueFactory<String[], String> ("Fahrstufe"));
				
				tableView.setItems(getZuege());
	}

//-------------------Ende von Initialise--------------------------------------
	
	
	public ObservableList<String[]> getZuege() {
		ObservableList<String[]> zuege = FXCollections.observableArrayList();
		
		ReadFromTable r = new ReadFromTable();
		String a = r.getAllData();
		String[] h = a.split(";");
		ArrayList done = new ArrayList();
		int j = 0;
		
		for (int i = 0; i < h.length/3; i=+3) {
			done.add(h[i] + h[i+1] + h[i+2]);
			j++;
		}
		
		for (int i = 0; i < h.length/3; i++) {
			System.out.print(done);
		}
		
		
		zuege.addAll(done);
		
		return zuege;
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

	
	//Fahrstufen für datenbank
	public int dataFS() {
		int sub = getChoice(TypBox);
		return sub;
	}
	
	//Fahrstufen für datenbank
		public int dataZugNr() {
			int zugnummer = getAdresse(adressespinner);
			return zugnummer;
		}
	
	//Zugname für datenbank
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

		// Test welche Fahrstufe in TextBox ausgwählt wurde
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
		
		//TODO Fenster zur Bestätigung der Zuganlage ausgeben
		
	}
}
