package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;

import datenbank.DeleteFromTable;
import datenbank.InsertIntoTable;
import datenbank.ReadFromTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class POPUPWARTENController {

	@FXML
	private JFXButton submit_btn;

	@FXML
	private JFXSlider dauer;

	@FXML
	private Text zeit;

	@FXML
	private JFXButton ok_btn;

	@FXML
	void ok(ActionEvent event) {
		double s = dauer.getValue();

		int ergebnis = (int) (s);

		String numberAsString = Double.toString(ergebnis);
		ReadFromTable r = new ReadFromTable();
		zeit.setText(numberAsString + "min");
		InsertIntoTable t = new InsertIntoTable();
		DeleteFromTable d = new DeleteFromTable();
		d.deleteTime(r.getZugNrAktiverZug());
		t.setWarten(ergebnis);
	}

	@FXML
	void submit(ActionEvent event) {
	}
}