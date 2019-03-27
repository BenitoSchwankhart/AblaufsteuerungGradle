package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import datenbank.DeleteFromTable;
import datenbank.InsertIntoTable;
import datenbank.ReadFromTable;
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
	private JFXButton submit_btn;

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
	ObservableList<String> listtyp = FXCollections.observableArrayList();

	private void loaddata() {
		
		ReadFromTable r = new ReadFromTable();
		
		String b = r.getData();
		//System.out.println(b+ "funktioniert") ;
		String[] s = b.split(";");
		//s[0] enthält Zugnummer
		
		//Gibt alle Zugnummern aus
		/**for(int i=0;i<s.length;i+=2){
			System.out.println(s[i]);		
		}*/
		
		// Typ
		listtyp.removeAll(listtyp);
		if(s != null && s.length != 0) {
			for(int i=1;i<s.length;i+=2){
				String a = s[i];
				listtyp.addAll(a);		
			}
		}
		TrainBox.getItems().addAll(listtyp);
		
		//if Schleife für Zugauswahl
		/**
		 * if(s[i] == aktuelles Element){
		 * i--;
		 * return s[i] //gibt Zugnummer für Bahn aus
		 * }
		 */

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

	// Ausgewählte Lok wird als aktuelle verwendete Lok submittet
	@FXML
    void submit_Lok(ActionEvent event) {
		if (event.getSource() == submit_btn) {
			if (TrainBox != null) {
				TrainBox.getValue();
			}
		}
		
	// Aktueller Zug wird in die Datenbank gespeichert
	DeleteFromTable d = new DeleteFromTable();
	d.deleteAktuellerZug();
	InsertIntoTable i = new InsertIntoTable();
	i.setAktuellZug(TrainBox.getValue());
    }
}
