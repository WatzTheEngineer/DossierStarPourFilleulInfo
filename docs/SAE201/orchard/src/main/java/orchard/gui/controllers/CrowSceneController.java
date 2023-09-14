package orchard.gui.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import orchard.model.Orchard;
import orchard.model.crow.CrowPiece;
import orchard.model.crow.Position;
import orchard.model.dice.FaceCrow;
import orchard.utils.DisplayPopup;
import orchard.utils.FXMLLoad;
import orchard.utils.FXMLPath;
import orchard.utils.ImagePath;

public class CrowSceneController {

	Orchard orchard = Orchard.getInstance();

	@FXML
	private GridPane gdpPuzzle;

	@FXML
	private ImageView imgBackGroundCrow;

	@FXML
	private VBox vbLeft;

	@FXML
	private ImageView imgArrow;

	@FXML
	private GridPane gdpReserve;

	@FXML
	void back(MouseEvent event) throws IOException {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		FXMLLoad fxmlLoad = new FXMLLoad();
		fxmlLoad.loadFXMLFile(FXMLPath.GAMESCENE.path(), stage);
	}

	@FXML
	void initialize() {
		imgArrow.setImage(new Image(getClass().getClassLoader().getResourceAsStream(ImagePath.ARROW.path())));
		imgArrow.setRotate(180);
		if (diceFaceIsCrow() && orchard.getPlayer().getCanPlay()) {
			imgArrow.setVisible(false);
		}

		imgBackGroundCrow
				.setImage(new Image(getClass().getClassLoader().getResourceAsStream(ImagePath.CROWFACE.path())));

		displayPuzzle();
		displayStockPile();

		gdpPuzzle.setOnDragOver(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {

				if (diceFaceIsCrow() && orchard.getPlayer().getCanPlay()) {
					event.acceptTransferModes(TransferMode.MOVE);

				}
			}
		});

		gdpPuzzle.setOnDragDropped(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				Dragboard db = event.getDragboard();
				CrowPiece piece = (CrowPiece) db.getContent(DataFormat.PLAIN_TEXT);
				orchard.getPlayer().pickCrowPiece(piece);
				displayPuzzle();
				displayStockPile();
				orchard.getPlayer().setCanPlay(false);
				imgArrow.setVisible(true);

				if (orchard.isGameLose()) {
					DisplayPopup.displayLosePopup(orchard);
				}
				event.consume();
			}
		});
	}

	Boolean diceFaceIsCrow() {

		if (orchard.getPlayer().currentDiceFace() instanceof FaceCrow) {
			return true;
		}

		return false;
	}

	void displayPuzzle() {

		for (Map.Entry<Position, CrowPiece> piece : orchard.getPuzzle().getCrowPieces().entrySet()) {
			String path = "CROW_PIECE_" + piece.getKey().getX() + "_" + piece.getKey().getY() + ".png";
			Image img = new Image(getClass().getClassLoader().getResourceAsStream(path), 199, 199, true, true);
			ImageView imgView = new ImageView(img);
			imgView.setUserData(piece);

			gdpPuzzle.add(imgView, piece.getKey().getY(), piece.getKey().getX());
			gdpPuzzle.setAlignment(Pos.CENTER);
			GridPane.setHalignment(imgView, HPos.CENTER);
		}

	}

	void displayStockPile() {
		List<CrowPiece> piece = orchard.getPuzzle().getPile().getpiece();
		gdpReserve.getChildren().clear();

		for (int i = 0; i < piece.size(); i++) {

			String path = "CROW_PIECE_" + piece.get(i).getPosition().getX() + "_" + piece.get(i).getPosition().getY()
					+ ".png";
			Image img = new Image(getClass().getClassLoader().getResourceAsStream(path), 96, 96, true, true);
			ImageView imgView = new ImageView(img);
			imgView.setUserData(piece.get(i));

			imgView.setOnDragDetected(new EventHandler<Event>() {

				@Override
				public void handle(Event event) {
					ImageView img = (ImageView) event.getSource();
					CrowPiece piece = (CrowPiece) img.getUserData();

					Dragboard db = img.startDragAndDrop(TransferMode.MOVE);

					ClipboardContent content = new ClipboardContent();

					content.putImage(img.getImage());
					content.put(DataFormat.PLAIN_TEXT, piece);
					db.setContent(content);

					event.consume();
				}
			});
			gdpReserve.add(imgView, i % 3, i / 3);

		}
	}

}
