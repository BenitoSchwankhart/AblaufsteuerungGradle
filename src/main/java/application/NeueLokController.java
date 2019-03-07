package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import com.sun.glass.ui.ClipboardAssistance;
import clientServerConnection.*;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NeueLokController implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loaddata();
	}

	// Neue Lok
	@FXML
	private JFXButton lokback_btn;

	@FXML
	void backtohome(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		if (event.getSource() == lokback_btn) {
			stage = (Stage) lokback_btn.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Home.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}

	@FXML
	private Text TypBoxLabel;

	@FXML
	private ChoiceBox<String> TypBox;

	@FXML
	private ChoiceBox<String> AdresslaengeBox;

	@FXML
	private Button OK_btn;
	ObservableList listtyp = FXCollections.observableArrayList();
	ObservableList listadresslaenge = FXCollections.observableArrayList();

	private void loaddata() {
		// Typ
		listtyp.removeAll(listtyp);
		String a = "DCC STandard (NRMA)";
		String b = "SX1 Parameter";
		String c = "SX1 Erweitert";
		String d = "SX1 Standard";
		String e = "SX2 Standard";
		listtyp.addAll(a, b, c, d, e);
		TypBox.getItems().addAll(listtyp);

		// Adresslaenge
		listadresslaenge.removeAll(listadresslaenge);
		String eins = "eins";
		String zwei = "zwei";
		String drei = "drei";

		listadresslaenge.addAll(eins, zwei, drei);
		AdresslaengeBox.getItems().addAll(listadresslaenge);

	}
}
