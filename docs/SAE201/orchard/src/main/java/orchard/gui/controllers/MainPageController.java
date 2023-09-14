package orchard.gui.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import orchard.utils.FXMLLoad;
import orchard.utils.FXMLPath;

public class MainPageController {
	@FXML
	private Label lblPlay;

	@FXML
	private AnchorPane anchFondBleue;

	private Paint color;

	@FXML
	void btnPlayClick(MouseEvent event) throws IOException {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		FXMLLoad fxmlLoad = new FXMLLoad();
		fxmlLoad.loadFXMLFile(FXMLPath.GAMESCENE.path(), stage);

	}

	@FXML
	void lblPlayWhiteColor(MouseEvent event) {
		color = lblPlay.getTextFill();
		lblPlay.setTextFill(Color.WHITE);
	}

	@FXML
	void lblPlayBlueColor(MouseEvent event) {
		lblPlay.setTextFill(color);
	}
}
