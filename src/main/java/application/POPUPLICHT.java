package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class POPUPLICHT {

	@FXML
	private JFXButton submit_btn;

	@FXML
	private Text zeit;

	@FXML
	private JFXButton ok_btn;

	@FXML
	private Spinner<Integer> start;

	@FXML
	private Spinner<Integer> ende;

	@FXML
	void ok(ActionEvent event) {

	}

	@FXML
	void submit(ActionEvent event) {
		Stage stage = (Stage) submit_btn.getScene().getWindow();
		stage.close();
	}
}
