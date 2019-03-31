package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;

import datenbank.DeleteFromTable;
import datenbank.InsertIntoTable;
import datenbank.ReadFromTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class POPUPLICHT {

	@FXML
	private JFXButton submit_btn;

	@FXML
	private JFXButton an_btn;

	@FXML
	private JFXButton aus;

	@FXML
	private JFXSlider dauerslider;


	@FXML
	void lichtan(ActionEvent event) {
		ReadFromTable r = new ReadFromTable();
		InsertIntoTable t = new InsertIntoTable();
		DeleteFromTable d = new DeleteFromTable();
		d.deleteLicht(r.getZugNrAktiverZug());
		t.setLicht(1);
	}

	@FXML
	void lichtaus(ActionEvent event) {
		ReadFromTable r = new ReadFromTable();
		InsertIntoTable t = new InsertIntoTable();
		DeleteFromTable d = new DeleteFromTable();
		d.deleteLicht(r.getZugNrAktiverZug());
		t.setLicht(0);
	}

	@FXML
	void submit(ActionEvent event) {
		 double s = dauerslider.getValue();

			int ergebnis = (int) (s);
			
			InsertIntoTable t = new InsertIntoTable();
			DeleteFromTable d = new DeleteFromTable();
			d.deleteTempLicht();
			t.setTempLicht(ergebnis);
		
		
		Stage stage = (Stage) submit_btn.getScene().getWindow();
		stage.close();

	}

}
