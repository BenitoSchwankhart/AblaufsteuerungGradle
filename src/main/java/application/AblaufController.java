package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXNodesList;
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
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
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
	private JFXButton ziel1;

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
	private JFXButton warten;

	@FXML
	private JFXButton back;

	@FXML
	private JFXButton starting_btn;

	@FXML
	private JFXButton nothalt_btn;

	@FXML
	private JFXToggleButton poweroff_btn;
	@FXML
	private Spinner<Integer> dauer;
	@FXML
	private Label label;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 120);
		this.dauer.setValueFactory(valueFactory);
	}

	@FXML
	void loggezeit(ActionEvent event) {
this.label.setVisible(true);
this.label.setText(this.dauer.getValue().toString());
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
	void handleDragRichtungwarten(MouseEvent event) {
		Dragboard db = warten.startDragAndDrop(TransferMode.ANY);

		ClipboardContent cb = new ClipboardContent();
		cb.putString(warten.getText());

		db.setContent(cb);
		event.consume();
	}

	@FXML
	void handledenDrop(DragEvent event) {
		String str = event.getDragboard().getString();
		ziel1.setStyle("-fx-background-color:  #4f474c;");
		ziel1.setText(str);
	}

	@FXML
	void handledenDrop2(DragEvent event) {
		String str = event.getDragboard().getString();
		ziel2.setStyle("-fx-background-color:  #4f474c;");
		ziel2.setText(str);
	}

	@FXML
	void handledenDrop3(DragEvent event) {
		String str = event.getDragboard().getString();
		ziel3.setStyle("-fx-background-color:  #4f474c;");
		ziel3.setText(str);
	}

	@FXML
	void handledenDrop4(DragEvent event) {
		String str = event.getDragboard().getString();
		ziel4.setStyle("-fx-background-color:  #4f474c;");
		ziel4.setText(str);

	}

	@FXML
	void handledenDrop5(DragEvent event) {
		String str = event.getDragboard().getString();
		ziel5.setStyle("-fx-background-color:  #4f474c;");
		ziel5.setText(str);

	}

	@FXML
	void handledenDrop6(DragEvent event) {
		String str = event.getDragboard().getString();
		ziel6.setStyle("-fx-background-color:  #4f474c;");
		ziel6.setText(str);

	}

	@FXML
	void handledenDrop7(DragEvent event) {
		String str = event.getDragboard().getString();
		ziel7.setStyle("-fx-background-color:  #4f474c;");
		ziel7.setText(str);

	}

	@FXML
	void starteAblauf(ActionEvent event) throws IOException {
		zeiger.setFill(javafx.scene.paint.Color.GREEN);
		RmxCalls r = new RmxCalls();
		ReadFromTable f = new ReadFromTable();
		POPUPSPEEDController p = new POPUPSPEEDController();
		ReadFromTable t = new ReadFromTable();
		String l = t.getZugNrAktiverZug();
		String b = f.getFSAktiverZug();

		byte ZUGNR = r.intToByte(Integer.parseInt(l));
		byte SPEED = r.intToByte(Integer.parseInt(f.getTempFS()));
		// TODO
		// Noch anpassen
		byte DIR = r.intToByte(1);
		Zugablauf z = new Zugablauf();
		z.ZugFahrEinstellungen(ZUGNR, SPEED, DIR);

	}

	// Hier Nothalt Funktion implementieren
	@FXML
	void nothalt(ActionEvent event) throws IOException {
		// ConnectionCalls c = new ConnectionCalls();
		// c.Notfall();
		zeiger.setFill(javafx.scene.paint.Color.RED);
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
		stage.initOwner(ziel1.getScene().getWindow());
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
		stage.initOwner(ziel1.getScene().getWindow());
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
		stage.initOwner(ziel1.getScene().getWindow());
		stage.showAndWait();

	}// Öffnet Warten-POPUP

	public void popupwarten() throws IOException {
		Stage stage;
		Parent root;
		stage = new Stage();
		root = FXMLLoader.load(getClass().getResource("POPUPWARTEN.fxml"));
		stage.setScene(new Scene(root));
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initOwner(ziel1.getScene().getWindow());
		stage.showAndWait();

	}
	// Hier POPUP implementieren

	@FXML
	void popup1(ActionEvent event) throws IOException {

		if (!ziel1.getText().equals(" ")) {
			if (ziel1.getText().equals("Licht")) {
				if (event.getSource() == ziel1) {
					popuplicht();

				}
			} else if (ziel1.getText().equals("Speed")) {
				if (event.getSource() == ziel1) {
					popupspeed();

				}
			} else if (ziel1.getText().equals("Richtungswechsel")) {
				if (event.getSource() == ziel1) {
					popuprw();
				}
			} else if (ziel1.getText().equals("Warten")) {
				if (event.getSource() == ziel1) {
					popupwarten();

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
				if (event.getSource() == ziel2) {
					popuprw();
				}
			} else if (ziel2.getText().equals("Warten")) {
				if (event.getSource() == ziel2) {
					popupwarten();

				}
			}
		} else {
			System.out.println("Ziehe erst ein Element in die Ablaufsteuerung");
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
				if (event.getSource() == ziel3) {
					popuprw();
				}
			} else if (ziel3.getText().equals("Warten")) {
				if (event.getSource() == ziel3) {
					popupwarten();

				}
			}
		} else {
			System.out.println("Ziehe erst ein Element in die Ablaufsteuerung");
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
				if (event.getSource() == ziel4) {
					popuprw();
				}
			} else if (ziel4.getText().equals("Warten")) {
				if (event.getSource() == ziel4) {
					popupwarten();

				}
			}
		} else {
			System.out.println("Ziehe erst ein Element in die Ablaufsteuerung");
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
				if (event.getSource() == ziel5) {
					popuprw();
				}
			} else if (ziel5.getText().equals("Warten")) {
				if (event.getSource() == ziel5) {
					popupwarten();

				}
			}
		} else {
			System.out.println("Ziehe erst ein Element in die Ablaufsteuerung");
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
				if (event.getSource() == ziel6) {
					popuprw();
				}
			} else if (ziel6.getText().equals("Warten")) {
				if (event.getSource() == ziel6) {
					popupwarten();

				}
			}

		} else {
			System.out.println("Ziehe erst ein Element in die Ablaufsteuerung");
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
				if (event.getSource() == ziel7) {
					popuprw();
				}
			} else if (ziel7.getText().equals("Warten")) {
				if (event.getSource() == ziel7) {
					popupwarten();

				}
			}
		} else {
			System.out.println("Ziehe erst ein Element in die Ablaufsteuerung");
		}
	}

	@FXML
	void delete1(ActionEvent event) {
		ziel1.setStyle("-fx-background-color: #000000;");
		ziel1.setText(" ");
		delete_btn1.toBack();

	}

	@FXML
	void delete2(ActionEvent event) {
		ziel2.setStyle("-fx-background-color: #000000;");
		ziel2.setText(" ");
		delete_btn2.toBack();
	}

	@FXML
	void delete3(ActionEvent event) {
		ziel3.setStyle("-fx-background-color: #000000;");
		ziel3.setText(" ");
		delete_btn3.toBack();
	}

	@FXML
	void delete4(ActionEvent event) {
		ziel4.setStyle("-fx-background-color: #000000;");
		ziel4.setText(" ");
		delete_btn4.toBack();
	}

	@FXML
	void delete5(ActionEvent event) {
		ziel5.setStyle("-fx-background-color: #000000;");
		ziel5.setText(" ");
		delete_btn5.toBack();
	}

	@FXML
	void delete6(ActionEvent event) {
		ziel6.setStyle("-fx-background-color: #000000;");
		ziel6.setText(" ");
		delete_btn6.toBack();
	}

	@FXML
	void delete7(ActionEvent event) {
		ziel7.setStyle("-fx-background-color: #000000;");
		ziel7.setText(" ");
		delete_btn7.toBack();
	}

//Schaut ob alle Ziele leer sind
	public boolean zieleleer() {
		if ((!ziel1.getText().equals(" ")) || (!ziel2.getText().equals(" ")) || (!ziel3.getText().equals(" "))
				|| (!ziel4.getText().equals(" ")) || (!ziel5.getText().equals(" ")) || (!ziel6.getText().equals(" "))
				|| (!ziel7.getText().equals(" "))) {
			return false;
		}
		return true;
	}

	@FXML
	void loescheneinleiten(ActionEvent event) {
		if (zieleleer() == false) {

			ok.toFront();
			if (!ziel1.getText().equals(" ")) {
				delete_btn1.toFront();
			}
			if (!ziel2.getText().equals(" ")) {
				delete_btn2.toFront();
			}
			if (!ziel3.getText().equals(" ")) {
				delete_btn3.toFront();
			}
			if (!ziel4.getText().equals(" ")) {
				delete_btn4.toFront();
			}
			if (!ziel5.getText().equals(" ")) {
				delete_btn5.toFront();
			}
			if (!ziel6.getText().equals(" ")) {
				delete_btn6.toFront();
			}
			if (!ziel7.getText().equals(" ")) {
				delete_btn7.toFront();
			}
		}
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

	@FXML
	private JFXButton neu;

	@FXML
	void neuerbtn(ActionEvent event) throws IOException {

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
 * /* stage = (Stage) ziel1.getScene().getWindow(); root =
 * FXMLLoader.load(getClass().getResource("POPUP.fxml")); Scene scene = new
 * Scene(root); stage.setScene(scene);
 * stage.initModality(Modality.APPLICATION_MODAL); stage.show();
 */
