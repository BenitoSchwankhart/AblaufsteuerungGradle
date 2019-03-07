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

public class TestController implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@FXML
	private AnchorPane logpane;

	@FXML
	private JFXTextField username;

	@FXML
	private JFXPasswordField password;

	@FXML
	private JFXButton login;

	@FXML
	private JFXButton signup;

	@FXML
	void makeLogin(ActionEvent event) throws IOException {
		String user = username.getText();
		String pass = password.getText();

		if (user.equals("user") && pass.equals("user")) {
			System.out.println("Willkommen User!");
			weiter(event);
		} else {
			System.out.println("Fehler");
		}

	}

	void weiter(ActionEvent event) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource("Home.fxml"));
		logpane.getChildren().setAll(pane);
	}

	@FXML
	private AnchorPane menu_pane;

	@FXML
	private Pane pane_settings;

	@FXML
	private Pane neuelok;

	@FXML
	private Pane pane_ablauf;

	@FXML
	private JFXButton start_btn;

	@FXML
	private JFXButton nothalt_btn;

	@FXML
	private JFXButton zuege;

	@FXML
	private JFXButton ablauf;

	@FXML
	private JFXButton settings;

	@FXML
	private JFXButton back;

	@FXML
	void bittestarten(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		if (event.getSource() == start_btn) {
			stage = (Stage) start_btn.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("GUIAblaufssteuerung.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}

	@FXML
	void menuOnClick(ActionEvent event) {
		if (event.getSource() == zuege) {
			neuelok.toFront();
		} else if (event.getSource() == settings) {
			pane_settings.toFront();
		} else if (event.getSource() == ablauf) {
			pane_ablauf.toFront();
		}
	}

	// Zurueck Button
	@FXML
	void backonstart(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		if (event.getSource() == back) {
			stage = (Stage) back.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("Home.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}

//Neue Lok Fenster
	@FXML
	private JFXButton neuelok_btn;

	@FXML
	void neuelok(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		if (event.getSource() == neuelok_btn) {
			stage = (Stage) neuelok_btn.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("NeueLok.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		}
	}

	// Drag and Drop
	@FXML
	private Pane black_pane;

	@FXML
	private JFXButton ziel;
	@FXML
	private JFXButton ziel4;

	@FXML
	private JFXButton ziel3;

	@FXML
	private JFXButton ziel2;
	@FXML
	private JFXButton ziel5;

	@FXML
	private JFXButton ziel6;

	@FXML
	private JFXButton ziel7;

	@FXML
	private JFXButton licht;

	@FXML
	private JFXButton speed;

	@FXML
	private JFXButton funktion4;

	@FXML
	private JFXButton funktion3;

	@FXML
	private JFXButton starting_btn;

	@FXML
	private MaterialDesignIconView zeiger;

	@FXML
	void handleDragOver(DragEvent event) {
		event.acceptTransferModes(TransferMode.ANY);
	}

	@FXML
	void handleDragRichtung(MouseEvent event) {
		Dragboard db = licht.startDragAndDrop(TransferMode.ANY);

		ClipboardContent cb = new ClipboardContent();
		cb.putString(licht.getText());

		db.setContent(cb);
		event.consume();
	}

	@FXML
	void handleDragRichtungSpeed(MouseEvent event) {
		Dragboard db = speed.startDragAndDrop(TransferMode.ANY);

		ClipboardContent cb = new ClipboardContent();
		cb.putString(speed.getText());

		db.setContent(cb);
		event.consume();
	}

	@FXML
	void handleDragRichtungFunktion3(MouseEvent event) {
		Dragboard db = funktion3.startDragAndDrop(TransferMode.ANY);

		ClipboardContent cb = new ClipboardContent();
		cb.putString(funktion3.getText());

		db.setContent(cb);
		event.consume();
	}

	@FXML
	void handleDragRichtungFunktion4(MouseEvent event) {
		Dragboard db = funktion4.startDragAndDrop(TransferMode.ANY);

		ClipboardContent cb = new ClipboardContent();
		cb.putString(funktion4.getText());

		db.setContent(cb);
		event.consume();
	}

	@FXML
	void handledenDrop(DragEvent event) {
		String str = event.getDragboard().getString();
		ziel.setStyle("-fx-background-color: #009688;");
		ziel.setText(str);
	}

	@FXML
	void handledenDrop2(DragEvent event) {
		String str = event.getDragboard().getString();
		ziel2.setStyle("-fx-background-color: #009688;");
		ziel2.setText(str);
	}

	@FXML
	void handledenDrop3(DragEvent event) {
		String str = event.getDragboard().getString();
		ziel3.setStyle("-fx-background-color: #009688;");
		ziel3.setText(str);
	}

	@FXML
	void handledenDrop4(DragEvent event) {
		String str = event.getDragboard().getString();
		ziel4.setStyle("-fx-background-color: #009688;");
		ziel4.setText(str);

	}

	@FXML
	void handledenDrop5(DragEvent event) {
		String str = event.getDragboard().getString();
		ziel5.setStyle("-fx-background-color: #009688;");
		ziel5.setText(str);

	}

	@FXML
	void handledenDrop6(DragEvent event) {
		String str = event.getDragboard().getString();
		ziel6.setStyle("-fx-background-color: #009688;");
		ziel6.setText(str);

	}

	@FXML
	void handledenDrop7(DragEvent event) {
		String str = event.getDragboard().getString();
		ziel7.setStyle("-fx-background-color: #009688;");
		ziel7.setText(str);

	}

	@FXML
	void starteAblauf(ActionEvent event) throws IOException {
		zeiger.setFill(javafx.scene.paint.Color.GREEN);
		// ConnectionCalls c = new ConnectionCalls();
		// c.PowerOn();
	}

	// Hier Nothalt Funktion implementieren
	@FXML
	void nothalt(ActionEvent event) throws IOException {
		// ConnectionCalls c = new ConnectionCalls();
		// c.Notfall();
		System.out.println("Nothalt");
	}

	// Hier POPUP implementieren

	@FXML
	void popup1(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		if (!ziel.getText().equals(" ")) {
			if (ziel.getText().equals("Licht")) {
				if (event.getSource() == ziel) {
					stage = new Stage();
					root = FXMLLoader.load(getClass().getResource("POPUPLICHT.fxml"));
					stage.setScene(new Scene(root));
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.initOwner(ziel.getScene().getWindow());
					stage.showAndWait();
				}
			} else if (ziel.getText().equals("Speed")) {
				if (event.getSource() == ziel) {
					stage = new Stage();
					root = FXMLLoader.load(getClass().getResource("POPUPSPEED.fxml"));
					stage.setScene(new Scene(root));
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.initOwner(ziel.getScene().getWindow());
					stage.showAndWait();
				}
			} else {
				System.out.println("Ziehe erst ein Element in die Ablaufsteuerung");
			}
		}
	}

	@FXML
	void popup2(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		if (!ziel2.getText().equals(" ")) {
			if (ziel2.getText().equals("Licht")) {
				if (event.getSource() == ziel2) {
					stage = new Stage();
					root = FXMLLoader.load(getClass().getResource("POPUPLICHT.fxml"));
					stage.setScene(new Scene(root));
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.initOwner(ziel2.getScene().getWindow());
					stage.showAndWait();
				}
			} else if (ziel2.getText().equals("Speed")) {
				if (event.getSource() == ziel2) {
					stage = new Stage();
					root = FXMLLoader.load(getClass().getResource("POPUPSPEED.fxml"));
					stage.setScene(new Scene(root));
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.initOwner(ziel2.getScene().getWindow());
					stage.showAndWait();
				}
			} else {
				System.out.println("Ziehe erst ein Element in die Ablaufsteuerung");
			}
		}
	}

	@FXML
	void popup3(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		if (!ziel3.getText().equals(" ")) {
			if (ziel3.getText().equals("Licht")) {
				if (event.getSource() == ziel3) {
					stage = new Stage();
					root = FXMLLoader.load(getClass().getResource("POPUPLICHT.fxml"));
					stage.setScene(new Scene(root));
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.initOwner(ziel3.getScene().getWindow());
					stage.showAndWait();
				}
			} else if (ziel3.getText().equals("Speed")) {
				if (event.getSource() == ziel3) {
					stage = new Stage();
					root = FXMLLoader.load(getClass().getResource("POPUPSPEED.fxml"));
					stage.setScene(new Scene(root));
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.initOwner(ziel3.getScene().getWindow());
					stage.showAndWait();
				}
			} else {
				System.out.println("Ziehe erst ein Element in die Ablaufsteuerung");
			}
		}
	}

	@FXML
	void popup4(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		if (!ziel4.getText().equals(" ")) {
			if (ziel4.getText().equals("Licht")) {
				if (event.getSource() == ziel4) {
					stage = new Stage();
					root = FXMLLoader.load(getClass().getResource("POPUPLICHT.fxml"));
					stage.setScene(new Scene(root));
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.initOwner(ziel4.getScene().getWindow());
					stage.showAndWait();
				}
			} else if (ziel4.getText().equals("Speed")) {
				if (event.getSource() == ziel4) {
					stage = new Stage();
					root = FXMLLoader.load(getClass().getResource("POPUPSPEED.fxml"));
					stage.setScene(new Scene(root));
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.initOwner(ziel4.getScene().getWindow());
					stage.showAndWait();
				}
			} else {
				System.out.println("Ziehe erst ein Element in die Ablaufsteuerung");
			}
		}
	}

	@FXML
	void popup5(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		if (!ziel5.getText().equals(" ")) {
			if (ziel5.getText().equals("Licht")) {
				if (event.getSource() == ziel5) {
					stage = new Stage();
					root = FXMLLoader.load(getClass().getResource("POPUPLICHT.fxml"));
					stage.setScene(new Scene(root));
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.initOwner(ziel5.getScene().getWindow());
					stage.showAndWait();
				}
			} else if (ziel5.getText().equals("Speed")) {
				if (event.getSource() == ziel5) {
					stage = new Stage();
					root = FXMLLoader.load(getClass().getResource("POPUPSPEED.fxml"));
					stage.setScene(new Scene(root));
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.initOwner(ziel5.getScene().getWindow());
					stage.showAndWait();
				}
			} else {
				System.out.println("Ziehe erst ein Element in die Ablaufsteuerung");
			}
		}
	}

	@FXML
	void popup6(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		if (!ziel6.getText().equals(" ")) {
			if (ziel6.getText().equals("Licht")) {
				if (event.getSource() == ziel6) {
					stage = new Stage();
					root = FXMLLoader.load(getClass().getResource("POPUPLICHT.fxml"));
					stage.setScene(new Scene(root));
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.initOwner(ziel6.getScene().getWindow());
					stage.showAndWait();
				}
			} else if (ziel6.getText().equals("Speed")) {
				if (event.getSource() == ziel6) {
					stage = new Stage();
					root = FXMLLoader.load(getClass().getResource("POPUPSPEED.fxml"));
					stage.setScene(new Scene(root));
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.initOwner(ziel6.getScene().getWindow());
					stage.showAndWait();
				}
			} else {
				System.out.println("Ziehe erst ein Element in die Ablaufsteuerung");
			}
		}
	}

	@FXML
	void popup7(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		if (!ziel7.getText().equals(" ")) {
			if (ziel7.getText().equals("Licht")) {
				if (event.getSource() == ziel7) {
					stage = new Stage();
					root = FXMLLoader.load(getClass().getResource("POPUPLICHT.fxml"));
					stage.setScene(new Scene(root));
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.initOwner(ziel7.getScene().getWindow());
					stage.showAndWait();
				}
			} else if (ziel7.getText().equals("Speed")) {
				if (event.getSource() == ziel7) {
					stage = new Stage();
					root = FXMLLoader.load(getClass().getResource("POPUPSPEED.fxml"));
					stage.setScene(new Scene(root));
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.initOwner(ziel7.getScene().getWindow());
					stage.showAndWait();
				}
			} else {
				System.out.println("Ziehe erst ein Element in die Ablaufsteuerung");
			}
		}
	}
}
/**
 * } } else if (!ziel3.getText().equals(" ")) { if (event.getSource() == ziel3)
 * { stage = new Stage(); root =
 * FXMLLoader.load(getClass().getResource("POPUP.fxml")); stage.setScene(new
 * Scene(root)); stage.initModality(Modality.APPLICATION_MODAL);
 * stage.initOwner(ziel3.getScene().getWindow()); stage.showAndWait(); } } else
 * if (!ziel4.getText().equals(" ")) { if (event.getSource() == ziel4) { stage =
 * new Stage(); root = FXMLLoader.load(getClass().getResource("POPUP.fxml"));
 * stage.setScene(new Scene(root));
 * stage.initModality(Modality.APPLICATION_MODAL);
 * stage.initOwner(ziel4.getScene().getWindow()); stage.showAndWait(); } } else
 * if (!ziel5.getText().equals(" ")) { if (event.getSource() == ziel5) { stage =
 * new Stage(); root = FXMLLoader.load(getClass().getResource("POPUP.fxml"));
 * stage.setScene(new Scene(root));
 * stage.initModality(Modality.APPLICATION_MODAL);
 * stage.initOwner(ziel5.getScene().getWindow()); stage.showAndWait(); } } else
 * { System.out.println("Ziehe erst ein Element in die Ablaufsteuerung"); } } }
 * 
 * /* stage = (Stage) ziel.getScene().getWindow(); root =
 * FXMLLoader.load(getClass().getResource("POPUP.fxml")); Scene scene = new
 * Scene(root); stage.setScene(scene);
 * stage.initModality(Modality.APPLICATION_MODAL); stage.show();
 */
