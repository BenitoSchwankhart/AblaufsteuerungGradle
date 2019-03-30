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
	private JFXSlider start;

	@FXML
	private JFXSlider ende;
	@FXML
	private JFXButton ok_btn;
	@FXML
	private Text zeit;

	@FXML
	void ok(ActionEvent event) {
		double s = start.getValue();
		double e = ende.getValue();
		int ergebnis = (int) (e - s);
		if (ergebnis > 0) {
			String numberAsString = Double.toString(ergebnis);
			zeit.setText(numberAsString + "min");
		} else {
			zeit.setStyle("-fx-background-color:  #4f474c;");
			zeit.setText("Wert negativ!");
		}

	}

	@FXML
	void submit(ActionEvent event) {
		Stage stage = (Stage) submit_btn.getScene().getWindow();
		stage.close();
	}
}
