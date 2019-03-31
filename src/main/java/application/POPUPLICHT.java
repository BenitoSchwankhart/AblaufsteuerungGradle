package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;

import datenbank.DeleteFromTable;
import datenbank.InsertIntoTable;
import datenbank.ReadFromTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class POPUPLICHT {

	@FXML
	private JFXButton submit_btn;

	@FXML
	private Text zeit;

	@FXML
	private JFXButton an_btn;

	@FXML
	private JFXButton aus;

	@FXML
	private JFXSlider dauerslider;

	@FXML
	void lichtan(ActionEvent event) {

	}

	@FXML
	void lichtaus(ActionEvent event) {

	}

	@FXML
	void submit(ActionEvent event) {
		Stage stage = (Stage) submit_btn.getScene().getWindow();
		stage.close();
		
		//F�r An und Aus
		ReadFromTable r = new ReadFromTable();
		InsertIntoTable t = new InsertIntoTable();
		DeleteFromTable d = new DeleteFromTable();
		d.deleteLicht(r.getZugNrAktiverZug());
		t.setLicht(0);
		
	}
}
