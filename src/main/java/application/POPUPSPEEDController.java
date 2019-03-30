package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;

import datenbank.InsertIntoTable;
import datenbank.ReadFromTable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class POPUPSPEEDController implements Initializable {

	ReadFromTable r = new ReadFromTable();
	String a = r.getFSAktiverZug();
	Integer fahrstufen = Integer.parseInt(a);

	@FXML
	private JFXSlider slider14;

	@FXML
	private JFXSlider slider28;

	@FXML
	private JFXSlider slider126;
	@FXML
	private JFXSlider dauer;
	@FXML
	private Text zeit;
	@FXML
	private JFXButton submit;
	@FXML
	private JFXButton ok_btn;

	public void fahrstufenlesen() {
		if (fahrstufen == 14) {
			slider14.toFront();
		} else if (fahrstufen == 28) {
			slider28.toFront();
		} else if (fahrstufen == 126) {
			slider126.toFront();

		}
	}

	@FXML

	public int submitfahrstufen(ActionEvent event) {
		int i = 0;
		if (fahrstufen == 14) {
			double d = slider14.getValue();
			i = (int) d;
		} else if (fahrstufen == 28) {
			double d = slider28.getValue();
			i = (int) d;
		} else if (fahrstufen == 126) {
			double d = slider126.getValue();
			i = (int) d;
			System.out.println(slider126.getValue());
		}
		InsertIntoTable t = new InsertIntoTable();
		t.setFS(i);
		Stage stage = (Stage) submit.getScene().getWindow();
		stage.close();
		return i;

	}

	@FXML
	void ok(ActionEvent event) {
		double s = dauer.getValue();

		int ergebnis = (int) (s);

		String numberAsString = Double.toString(ergebnis);
		zeit.setText(numberAsString + "min");

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		fahrstufenlesen();

	}
}
