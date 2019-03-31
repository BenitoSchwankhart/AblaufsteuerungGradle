package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;

import datenbank.DeleteFromTable;
import datenbank.InsertIntoTable;
import datenbank.ReadFromTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class POPUPWARTENController {

	@FXML
	private JFXButton submit_btn;

	@FXML
	private JFXSlider dauer;

	@FXML
	void submit(ActionEvent event) {
		
		double s = dauer.getValue();

		int ergebnis = (int) (s);

		ReadFromTable r = new ReadFromTable();
		InsertIntoTable t = new InsertIntoTable();
		DeleteFromTable d = new DeleteFromTable();
		d.deleteTime(r.getZugNrAktiverZug());
		t.setWarten(ergebnis);
		
		Stage stage = (Stage) submit_btn.getScene().getWindow();
		stage.close();
	}
}