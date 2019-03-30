package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class POPUPLICHT {

	@FXML
	private JFXButton submit_btn;
	@FXML
	private JFXSlider dauer;

	@FXML
	private JFXButton ok_btn;
	@FXML
	private Text zeit;

	@FXML
	void ok(ActionEvent event) {
		double s = dauer.getValue();

		int ergebnis = (int) (s);

		String numberAsString = Double.toString(ergebnis);
		zeit.setText(numberAsString + "min");

	}

	@FXML
	void submit(ActionEvent event) {
		Stage stage = (Stage) submit_btn.getScene().getWindow();
		stage.close();
	}
}
