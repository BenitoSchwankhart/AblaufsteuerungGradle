package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXSlider;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class POPUPSPEEDController implements Initializable {

	@FXML
	private JFXSlider slider14;

	@FXML
	private JFXSlider slider28;

	@FXML
	private JFXSlider slider128;

	int fahrstufen = 128;

	public void fahrstufenlesen() {
		if (fahrstufen == 14) {
			slider14.toFront();

		} else if (fahrstufen == 28) {
			slider28.toFront();

		} else if (fahrstufen == 128) {
			slider128.toFront();

		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		fahrstufenlesen();

	}
}
