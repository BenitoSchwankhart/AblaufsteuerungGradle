package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class RWController implements Initializable {

	@FXML
	private JFXButton ruekwaerts_btn;

	@FXML
	private JFXButton vorwaerts_btn;

	@FXML
	public int ruekwaerts(ActionEvent event) {
		int i = 1;

		return i;
	}

	@FXML
	public int vorwaerts(ActionEvent event) {
		int i = 0;

		return i;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
