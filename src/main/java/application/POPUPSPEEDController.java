package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXSlider;

import datenbank.ReadFromTable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class POPUPSPEEDController implements Initializable {

	ReadFromTable r = new ReadFromTable();
	String a = r.getData();
	String h[] = a.split(";");

	@FXML
	private JFXSlider slider14;

	@FXML
	private JFXSlider slider24;

	@FXML
	private JFXSlider slider126;

	int fahrstufen = 126;

	public void fahrstufenlesen() {
		if (fahrstufen == 14) {
			slider14.toFront();

		} else if (fahrstufen == 24) {
			slider24.toFront();

		} else if (fahrstufen == 126) {
			slider126.toFront();

		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		fahrstufenlesen();

	}
}
