package application;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;

public class RMXFehlerController {
	
	@FXML
    private AnchorPane menu_pane;

    @FXML
    private Hyperlink Link;

    @FXML
    void hyper(ActionEvent event) {
    	try {
			Runtime.getRuntime().exec(
					"rundll32 url.dll,FileProtocolHandler "
							+ "https://www.rautenhaus-digital.de/download/send/7-rmx-pc-zentrale-2/57-rmx-pc-zentrale2.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
