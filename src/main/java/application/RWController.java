package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import datenbank.DeleteFromTable;
import datenbank.InsertIntoTable;
import datenbank.ReadFromTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class RWController implements Initializable {

	@FXML
	private JFXButton ruekwaerts_btn;

	@FXML
	private JFXButton vorwaerts_btn;
	@FXML
	private JFXButton submit_btn;

	@FXML
	void ok(ActionEvent event) {

	}

	@FXML
	public void ruekwaerts(ActionEvent event) {
		ReadFromTable r = new ReadFromTable();
		InsertIntoTable t = new InsertIntoTable();
		DeleteFromTable d = new DeleteFromTable();
		d.deleteDir(r.getZugNrAktiverZug());
		t.setDir(1);
	}

	@FXML
	public void vorwaerts(ActionEvent event) {
		ReadFromTable r = new ReadFromTable();
		InsertIntoTable t = new InsertIntoTable();
		DeleteFromTable d = new DeleteFromTable();
		d.deleteDir(r.getZugNrAktiverZug());
		t.setDir(0);
	}

	@FXML
	void submit(ActionEvent event) {
		Stage stage = (Stage) submit_btn.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
