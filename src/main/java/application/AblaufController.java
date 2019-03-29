package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXToggleButton;

import Zugsteuerung.Zugablauf;
import clientServerConnection.RmxCalls;
import datenbank.ReadFromTable;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

import javafx.scene.layout.Pane;

import javafx.stage.Modality;
import javafx.stage.Stage;

public class AblaufController implements Initializable {
	@FXML
	private JFXButton ok;
	@FXML
	private JFXButton delete_btn1;

	@FXML
	private JFXButton delete_btn2;

	@FXML
	private JFXButton delete_btn3;

	@FXML
	private JFXButton delete_btn4;

	@FXML
	private JFXButton delete_btn5;

	@FXML
	private JFXButton delete_btn6;

	@FXML
	private JFXButton delete_btn7;
	@FXML
	private JFXButton loeschen;
	@FXML
	private Pane black_pane;
	@FXML
	private JFXButton delete;
	@FXML
	private JFXButton ziel;

	@FXML
	private JFXButton ziel4;

	@FXML
	private JFXButton ziel3;

	@FXML
	private JFXButton ziel2;

	@FXML
	private MaterialDesignIconView zeiger;

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
	private JFXButton richtungswechsel;

	@FXML
	private JFXButton funktion4;

	@FXML
	private JFXButton back;

	@FXML
	private JFXButton starting_btn;

	@FXML
	private JFXButton nothalt_btn;

	@FXML
	private JFXToggleButton poweroff_btn;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

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

//Drag and Drop der verschiedenen Elemente
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
	void handleDragRichtungrichtungswechsel(MouseEvent event) {
		Dragboard db = richtungswechsel.startDragAndDrop(TransferMode.ANY);

		ClipboardContent cb = new ClipboardContent();
		cb.putString(richtungswechsel.getText());

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
		RmxCalls r = new RmxCalls();
		ReadFromTable f = new ReadFromTable();
		POPUPSPEEDController p = new POPUPSPEEDController();
		String b = f.getFSAktiverZug();
		String[] s = b.split(";");

		byte ZUGNR = r.intToByte(Integer.parseInt(s[0]));
		byte SPEED = r.intToByte(p.submitfahrstufen(event));
		byte DIR = (Byte) null;
		Zugablauf z = new Zugablauf();
		z.ZugFahrEinstellungen(ZUGNR, SPEED, DIR);

	}

	// Hier Nothalt Funktion implementieren
	@FXML
	void nothalt(ActionEvent event) throws IOException {
		// ConnectionCalls c = new ConnectionCalls();
		// c.Notfall();
		System.out.println("Nothalt");
	}

	// Öffenet Speed-POPUP
	public void popupspeed() throws IOException {
		Stage stage;
		Parent root;
		stage = new Stage();
		root = FXMLLoader.load(getClass().getResource("POPUPSPEED.fxml"));
		stage.setScene(new Scene(root));
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initOwner(ziel.getScene().getWindow());
		stage.showAndWait();
	}

//Öffenet Licht-POPUP
	public void popuplicht() throws IOException {
		Stage stage;
		Parent root;
		stage = new Stage();
		root = FXMLLoader.load(getClass().getResource("POPUPLICHT.fxml"));
		stage.setScene(new Scene(root));
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initOwner(ziel.getScene().getWindow());
		stage.showAndWait();

	}

//Öffnet Richtungswechsel-POPUP
	public void popuprw() throws IOException {
		Stage stage;
		Parent root;
		stage = new Stage();
		root = FXMLLoader.load(getClass().getResource("POPUPRW.fxml"));
		stage.setScene(new Scene(root));
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initOwner(ziel.getScene().getWindow());
		stage.showAndWait();

	}
	// Hier POPUP implementieren

	@FXML
	void popup1(ActionEvent event) throws IOException {

		if (!ziel.getText().equals(" ")) {
			if (ziel.getText().equals("Licht")) {
				if (event.getSource() == ziel) {
					popuplicht();

				}
			} else if (ziel.getText().equals("Speed")) {
				if (event.getSource() == ziel) {
					popupspeed();

				}
			} else if (ziel.getText().equals("Richtungswechsel")) {
				if (event.getSource() == ziel) {
					popuprw();

				}
			} else {
				System.out.println("Ziehe erst ein Element in die Ablaufsteuerung");
			}
		}
	}

	@FXML
	void popup2(ActionEvent event) throws IOException {

		if (!ziel2.getText().equals(" ")) {
			if (ziel2.getText().equals("Licht")) {
				if (event.getSource() == ziel2) {
					popuplicht();
				}
			} else if (ziel2.getText().equals("Speed")) {
				if (event.getSource() == ziel2) {
					popupspeed();
				}
			} else if (ziel2.getText().equals("Richtungswechsel")) {
				if (event.getSource() == ziel) {
					popuprw();

				}
			} else {
				System.out.println("Ziehe erst ein Element in die Ablaufsteuerung");
			}
		}
	}

	@FXML
	void popup3(ActionEvent event) throws IOException {

		if (!ziel3.getText().equals(" ")) {
			if (ziel3.getText().equals("Licht")) {
				if (event.getSource() == ziel3) {
					popuplicht();
				}
			} else if (ziel3.getText().equals("Speed")) {
				if (event.getSource() == ziel3) {
					popupspeed();
				}
			} else if (ziel3.getText().equals("Richtungswechsel")) {
				if (event.getSource() == ziel) {
					popuprw();

				}
			} else {
				System.out.println("Ziehe erst ein Element in die Ablaufsteuerung");
			}
		}
	}

	@FXML
	void popup4(ActionEvent event) throws IOException {

		if (!ziel4.getText().equals(" ")) {
			if (ziel4.getText().equals("Licht")) {
				if (event.getSource() == ziel4) {
					popuplicht();
				}
			} else if (ziel4.getText().equals("Speed")) {
				if (event.getSource() == ziel4) {
					popupspeed();
				}
			} else if (ziel4.getText().equals("Richtungswechsel")) {
				if (event.getSource() == ziel) {
					popuprw();

				}
			} else {
				System.out.println("Ziehe erst ein Element in die Ablaufsteuerung");
			}
		}
	}

	@FXML
	void popup5(ActionEvent event) throws IOException {

		if (!ziel5.getText().equals(" ")) {
			if (ziel5.getText().equals("Licht")) {
				if (event.getSource() == ziel5) {
					popuplicht();
				}
			} else if (ziel5.getText().equals("Speed")) {
				if (event.getSource() == ziel5) {
					popupspeed();
				}
			} else if (ziel5.getText().equals("Richtungswechsel")) {
				if (event.getSource() == ziel) {
					popuprw();

				}
			} else {
				System.out.println("Ziehe erst ein Element in die Ablaufsteuerung");
			}
		}
	}

	@FXML
	void popup6(ActionEvent event) throws IOException {

		if (!ziel6.getText().equals(" ")) {
			if (ziel6.getText().equals("Licht")) {
				if (event.getSource() == ziel6) {
					popuplicht();
				}
			} else if (ziel6.getText().equals("Speed")) {
				if (event.getSource() == ziel6) {
					popupspeed();
				}
			} else if (ziel6.getText().equals("Richtungswechsel")) {
				if (event.getSource() == ziel) {
					popuprw();

				}

			} else {
				System.out.println("Ziehe erst ein Element in die Ablaufsteuerung");
			}
		}
	}

	@FXML
	void popup7(ActionEvent event) throws IOException {

		if (!ziel7.getText().equals(" ")) {
			if (ziel7.getText().equals("Licht")) {
				if (event.getSource() == ziel7) {
					popuplicht();
				}
			} else if (ziel7.getText().equals("Speed")) {
				if (event.getSource() == ziel7) {
					popupspeed();
				}
			} else if (ziel7.getText().equals("Richtungswechsel")) {
				if (event.getSource() == ziel) {
					popuprw();

				}
			} else {
				System.out.println("Ziehe erst ein Element in die Ablaufsteuerung");
			}
		}
	}

	@FXML
	void delete1(ActionEvent event) {

		ziel.setStyle("-fx-background-color: #000000;");
		ziel.setText(" ");
	}

	@FXML
	void delete2(ActionEvent event) {
		ziel2.setStyle("-fx-background-color: #000000;");
		ziel2.setText(" ");
	}

	@FXML
	void delete3(ActionEvent event) {
		ziel3.setStyle("-fx-background-color: #000000;");
		ziel3.setText(" ");
	}

	@FXML
	void delete4(ActionEvent event) {
		ziel4.setStyle("-fx-background-color: #000000;");
		ziel4.setText(" ");
	}

	@FXML
	void delete5(ActionEvent event) {
		ziel5.setStyle("-fx-background-color: #000000;");
		ziel5.setText(" ");
	}

	@FXML
	void delete6(ActionEvent event) {
		ziel6.setStyle("-fx-background-color: #000000;");
		ziel6.setText(" ");
	}

	@FXML
	void delete7(ActionEvent event) {
		ziel7.setStyle("-fx-background-color: #000000;");
		ziel7.setText(" ");
	}

	@FXML
	void loescheneinleiten(ActionEvent event) {
		ok.toFront();
		delete_btn1.toFront();

		delete_btn2.toFront();

		delete_btn3.toFront();
		delete_btn4.toFront();

		delete_btn5.toFront();

		delete_btn6.toFront();
		delete_btn7.toFront();

	}

	@FXML
	void loeschenbeenden(ActionEvent event) {
		ok.toBack();
		delete_btn1.toBack();

		delete_btn2.toBack();

		delete_btn3.toBack();
		delete_btn4.toBack();

		delete_btn5.toBack();

		delete_btn6.toBack();
		delete_btn7.toBack();

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
