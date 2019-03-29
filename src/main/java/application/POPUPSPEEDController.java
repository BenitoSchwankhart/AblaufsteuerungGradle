package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;

import datenbank.ReadFromTable;
import javafx.collections.ListChangeListener.Change;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;

public class POPUPSPEEDController implements Initializable {

	ReadFromTable r = new ReadFromTable();
	String a = r.getFSAktiverZug();
	int fahrstufen = 14;

	@FXML
	private JFXSlider slider14;

	@FXML
	private JFXSlider slider28;

	@FXML
	private JFXSlider slider126;

	@FXML
	private JFXButton submit;

	public void fahrstufenlesen() {
		if (fahrstufen == 14) {
			slider14.toFront();
			System.out.println();
		} else if (fahrstufen == 24) {
			slider28.toFront();

		} else if (fahrstufen == 126) {
			slider126.toFront();

		}
	}

	@FXML
	void submitfahrstufen(ActionEvent event) {
		if (fahrstufen == 14) {

			System.out.println(slider14.getValue());
		} else if (fahrstufen == 24) {

		} else if (fahrstufen == 126) {

			System.out.println(slider126.getValue());
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		fahrstufenlesen();

	}
}
