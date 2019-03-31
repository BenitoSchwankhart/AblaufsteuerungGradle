package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;

import datenbank.DeleteFromTable;
import datenbank.InsertIntoTable;
import datenbank.ReadFromTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

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
	private JFXButton ok_btn;

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
		Stage stage = (Stage) submit_btn.getScene().getWindow();
		stage.close();

		// Für An und Aus

	}

	@FXML
	void ok(ActionEvent event) {
		double s = dauerslider.getValue();

		int ergebnis = (int) (s);

		String numberAsString = Double.toString(ergebnis);
		zeit.setText(numberAsString + "min");
	}
}
