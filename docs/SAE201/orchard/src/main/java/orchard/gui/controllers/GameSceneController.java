package orchard.gui.controllers;

import java.io.IOException;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import orchard.model.Basket;
import orchard.model.Fruit;
import orchard.model.FruitColor;
import orchard.model.Orchard;
import orchard.model.Tree;
import orchard.model.crow.Position;
import orchard.model.dice.DiceFace;
import orchard.model.dice.FaceBasket;
import orchard.model.dice.FaceColor;
import orchard.model.dice.FaceCrow;
import orchard.model.exceptions.TreeNotFoundException;
import orchard.utils.DisplayPopup;
import orchard.utils.FXMLLoad;
import orchard.utils.FXMLPath;
import orchard.utils.ImagePath;

public class GameSceneController {
	private Orchard orchard = Orchard.getInstance();

	@FXML
	private BorderPane borderPane;

	@FXML
	private StackPane spBackground;

	@FXML
	private GridPane gdpTree;
	
	private AnchorPane acpTree;

	@FXML
	private StackPane spBlueTree;

	@FXML
	private GridPane gdpBlueTree;

	@FXML
	private StackPane spRedTree;

	@FXML
	private GridPane gdpRedTree;

	@FXML
	private StackPane spGreenTree;

	@FXML
	private GridPane gdpGreenTree;

	@FXML
	private StackPane spYellowTree;

	@FXML
	private GridPane gdpYellowTree;

	@FXML
	private VBox vbLeft;

	@FXML
	private ImageView imgGreenBasket;

	@FXML
	private Label lblGreenFruitsNumber;

	@FXML
	private ImageView imgYellowBasket;

	@FXML
	private Label lblYellowFruitsNumber;

	@FXML
	private ImageView imgRedBasket;

	@FXML
	private Label lblRedFruitsNumber;

	@FXML
	private ImageView imgBlueBasket;

	@FXML
	private Label lblBlueFruitsNumber;

	@FXML
	private Label lblTurn;

	@FXML
	private ImageView imgViewDiceFAce;

	@FXML
	private Button btnThrowDice;

	@FXML
	private Button btnCrow;

	private int countPlay = 0;

	private GridPane insertFruitIntoGdp(Tree tree) {
		GridPane gdp = new GridPane();
		gdp.getChildren().clear();

		String PATH = "FRUIT_" + tree.getFruitColor() + ".png";

		for (Map.Entry<Position, Fruit> fruit : tree.getFruits().entrySet()) {
			Image img = new Image(getClass().getClassLoader().getResourceAsStream(PATH), 30, 30, true, true);
			ImageView imgView = new ImageView(img);
			imgView.setUserData(fruit.getValue());

			imgView.setOnDragDetected(new EventHandler<Event>() {

				@Override
				public void handle(Event event) {

					ImageView img = (ImageView) event.getSource();
					Fruit fruit = (Fruit) img.getUserData();

					Dragboard dragboard = img.startDragAndDrop(TransferMode.MOVE);
					dragboard.clear();
					ClipboardContent content = new ClipboardContent();

					content.put(DataFormat.PLAIN_TEXT, fruit);
					content.putImage(img.getImage());
					dragboard.setContent(content);

					event.consume();

				}

			});

			gdp.add(imgView, fruit.getKey().getY(), fruit.getKey().getX());
		}

		return gdp;
	}

	private GridPane clearGridPane(GridPane gdp) {
		gdp.getChildren().clear();
		return gdp;
	}

	void pickFruit(Fruit fruit, Basket basket) throws TreeNotFoundException {
		if (orchard.getPlayer().currentDiceFace() instanceof FaceColor) {
			FaceColor diceFace = (FaceColor) orchard.getPlayer().currentDiceFace();

			if (diceFace.getFruitColor() == fruit.getFruitColor()) {
				orchard.getPlayer().pickFruit(fruit, basket);
				btnThrowDice.setVisible(true);
				btnCrow.setVisible(true);
				orchard.getPlayer().setCanPlay(false);
			}

		} else if (orchard.getPlayer().currentDiceFace() instanceof FaceBasket) {
			if (countPlay < 2) {
				orchard.getPlayer().pickFruit(fruit, basket);
				countPlay++;

				if (countPlay >= 2) {
					countPlay = 0;
					btnThrowDice.setVisible(true);
					btnCrow.setVisible(true);
					orchard.getPlayer().setCanPlay(false);
				}

			}
		}

		displayBasketFruitNumber();
		refreshGridPane(fruit);

		if (orchard.isGameOver()) {
			DisplayPopup.displayWinPopup(orchard);
		}

	}

	void refreshGridPane(Fruit fruit) throws TreeNotFoundException {
		switch (fruit.getFruitColor()) {
		case BLUE: {
			clearGridPane(gdpBlueTree);
			gdpBlueTree.getChildren().addAll(insertFruitIntoGdp(orchard.getTreeByColor(FruitColor.BLUE)));
			break;
		}
		case GREEN: {
			clearGridPane(gdpGreenTree);
			gdpGreenTree.getChildren().addAll(insertFruitIntoGdp(orchard.getTreeByColor(FruitColor.GREEN)));
			break;

		}
		case RED: {
			clearGridPane(gdpRedTree);
			gdpRedTree.getChildren().addAll(insertFruitIntoGdp(orchard.getTreeByColor(FruitColor.RED)));
			break;
		}
		case YELLOW: {
			clearGridPane(gdpYellowTree);
			gdpYellowTree.getChildren().addAll(insertFruitIntoGdp(orchard.getTreeByColor(FruitColor.YELLOW)));
			break;
		}
		}
	}

	ImageView getImgOffTree(FruitColor color) throws TreeNotFoundException {
		ImageView imgView = new ImageView();
		imgView.setImage(new Image(getClass().getClassLoader().getResourceAsStream(ImagePath.TREE.path()), 250, 250,
				true, true));
		imgView.setUserData(orchard.getTreeByColor(color));

		return imgView;
	}

	@FXML
	void initialize() throws Exception {

		displayTurn();

		displayDiceFace();

		gdpBlueTree = insertFruitIntoGdp(orchard.getTreeByColor(FruitColor.BLUE));
		gdpBlueTree.setAlignment(Pos.TOP_CENTER);

		spBlueTree.getChildren().addAll(getImgOffTree(FruitColor.BLUE), gdpBlueTree);
		StackPane.setMargin(gdpBlueTree, new Insets(40));

		gdpRedTree = insertFruitIntoGdp(orchard.getTreeByColor(FruitColor.RED));
		gdpRedTree.setAlignment(Pos.TOP_CENTER);

		spRedTree.getChildren().addAll(getImgOffTree(FruitColor.RED), gdpRedTree);
		StackPane.setMargin(gdpRedTree, new Insets(40));

		gdpGreenTree = insertFruitIntoGdp(orchard.getTreeByColor(FruitColor.GREEN));
		gdpGreenTree.setAlignment(Pos.TOP_CENTER);

		spGreenTree.getChildren().addAll(getImgOffTree(FruitColor.GREEN), gdpGreenTree);
		StackPane.setMargin(gdpGreenTree, new Insets(40));

		gdpYellowTree = insertFruitIntoGdp(orchard.getTreeByColor(FruitColor.YELLOW));
		gdpYellowTree.setAlignment(Pos.TOP_CENTER);

		spYellowTree.getChildren().addAll(getImgOffTree(FruitColor.YELLOW), gdpYellowTree);
		spYellowTree.setAlignment(Pos.TOP_CENTER);
		StackPane.setMargin(gdpYellowTree, new Insets(40));

		gdpTree = new GridPane();
		gdpTree.add(spBlueTree, 0, 0);
		gdpTree.add(spRedTree, 1, 0);
		gdpTree.add(spGreenTree, 0, 1);
		gdpTree.add(spYellowTree, 1, 1);
		gdpTree.setAlignment(Pos.CENTER);
		gdpTree.setHgap(30);
		gdpTree.setVgap(30);
		
		acpTree = new AnchorPane();
		acpTree.getChildren().add(spBlueTree);
		AnchorPane.setTopAnchor(spBlueTree, 180.0);
		AnchorPane.setLeftAnchor(spBlueTree, 140.0);
		AnchorPane.setTopAnchor(spRedTree, 180.0);
		AnchorPane.setLeftAnchor(spRedTree, 530.0);
		AnchorPane.setTopAnchor(spGreenTree, 410.0);
		AnchorPane.setLeftAnchor(spGreenTree, 60.0);
		AnchorPane.setTopAnchor(spYellowTree, 415.0);
		AnchorPane.setLeftAnchor(spYellowTree, 590.0);
		acpTree.getChildren().add(spRedTree);
		acpTree.getChildren().add(spGreenTree);
		acpTree.getChildren().add(spYellowTree);

		spBackground = new StackPane();
		spBackground.getChildren().addAll(new ImageView(
				new Image(getClass().getClassLoader().getResourceAsStream("BACKGROUND.png"), 900, 720, false, false)),
				acpTree);

		displayBasketFruitNumber();
		displayFruitBasket();

		imgBlueBasket.setUserData(orchard.basket(0));
		imgBlueBasket.setOnDragOver(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				dragOver(event);

				event.consume();
			}

		});

		imgBlueBasket.setOnDragDropped(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				dragDrop(event);

				event.consume();

			}

		});

		imgRedBasket.setUserData(orchard.basket(1));
		imgRedBasket.setOnDragOver(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				dragOver(event);

				event.consume();
			}

		});

		imgRedBasket.setOnDragDropped(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				dragDrop(event);

				event.consume();

			}

		});

		imgYellowBasket.setUserData(orchard.basket(2));
		imgYellowBasket.setOnDragOver(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				dragOver(event);

				event.consume();
			}

		});

		imgYellowBasket.setOnDragDropped(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				dragDrop(event);

				event.consume();

			}

		});

		imgGreenBasket.setUserData(orchard.basket(3));
		imgGreenBasket.setOnDragOver(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				dragOver(event);

				event.consume();
			}

		});

		imgGreenBasket.setOnDragDropped(new EventHandler<DragEvent>() {

			@Override
			public void handle(DragEvent event) {
				dragDrop(event);

				event.consume();

			}

		});

		borderPane.setRight(spBackground);

	}

	void dragOver(DragEvent event) {
		Dragboard db = event.getDragboard();
		Fruit fruit = (Fruit) db.getContent(DataFormat.PLAIN_TEXT);
		ImageView target = (ImageView) event.getTarget();
		Basket basket = (Basket) target.getUserData();

		if (dropable(fruit, basket)) {
			event.acceptTransferModes(TransferMode.MOVE);
		}
	}

	void dragDrop(DragEvent event) {
		Dragboard db = event.getDragboard();

		if (db.hasContent(DataFormat.PLAIN_TEXT)) {

			if (orchard.getPlayer().getCanPlay()) {

				Fruit fruit = (Fruit) db.getContent(DataFormat.PLAIN_TEXT);

				ImageView target = (ImageView) event.getTarget();
				Basket basket = (Basket) target.getUserData();

				try {
					pickFruit(fruit, basket);
				} catch (TreeNotFoundException e) {
					e.printStackTrace();
				}

				displayFruitBasket();

			}

		}

	}

	public void displayFruitBasket() {
		if (orchard.basket(0).isFull()) {
			imgBlueBasket
					.setImage(new Image(getClass().getClassLoader().getResourceAsStream(ImagePath.BASKETFULL.path())));
		} else {
			imgBlueBasket.setImage(new Image(getClass().getClassLoader().getResourceAsStream(ImagePath.BASKET.path())));

		}
		if (orchard.basket(1).isFull()) {
			imgRedBasket
					.setImage(new Image(getClass().getClassLoader().getResourceAsStream(ImagePath.BASKETFULL.path())));
		} else {
			imgRedBasket.setImage(new Image(getClass().getClassLoader().getResourceAsStream(ImagePath.BASKET.path())));
		}
		if (orchard.basket(2).isFull()) {
			imgYellowBasket
					.setImage(new Image(getClass().getClassLoader().getResourceAsStream(ImagePath.BASKETFULL.path())));
		} else {
			imgYellowBasket
					.setImage(new Image(getClass().getClassLoader().getResourceAsStream(ImagePath.BASKET.path())));
		}
		if (orchard.basket(3).isFull()) {
			imgGreenBasket
					.setImage(new Image(getClass().getClassLoader().getResourceAsStream(ImagePath.BASKETFULL.path())));
		} else {
			imgGreenBasket
					.setImage(new Image(getClass().getClassLoader().getResourceAsStream(ImagePath.BASKET.path())));
		}
	}

	Boolean dropable(Fruit fruit, Basket basket) {
		Boolean canPlay = orchard.getPlayer().getCanPlay();
		Boolean basketIsFull = basket.isFull();

		if (orchard.getPlayer().currentDiceFace() instanceof FaceColor face
				&& face.getFruitColor() == fruit.getFruitColor() && canPlay && !basketIsFull) {

			return true;

		} else if (orchard.getPlayer().currentDiceFace() instanceof FaceBasket && canPlay && !basketIsFull) {
			return true;
		}

		return false;
	}

	void displayBasketFruitNumber() {
		lblBlueFruitsNumber.setText(orchard.basket(0).fruitNumber());
		lblRedFruitsNumber.setText(orchard.basket(1).fruitNumber());
		lblYellowFruitsNumber.setText(orchard.basket(2).fruitNumber());
		lblGreenFruitsNumber.setText(orchard.basket(3).fruitNumber());

	}

	void displayTurn() {
		lblTurn.setText(orchard.getPlayer().turnNumberToString());
	}

	void displayDiceFace() {
		DiceFace face = orchard.getPlayer().currentDiceFace();

		String PATH = "DICE_FACE_";
		if (face instanceof FaceColor facecolor) {
			FruitColor color = facecolor.getFruitColor();
			switch (color) {
			case BLUE:
				PATH = PATH + FruitColor.BLUE;
				break;
			case RED:
				PATH = PATH + FruitColor.RED;
				break;
			case GREEN:
				PATH = PATH + FruitColor.GREEN;
				break;
			case YELLOW:
				PATH = PATH + FruitColor.YELLOW;
				break;
			}

		} else if (face instanceof FaceCrow) {
			PATH = PATH + "CROW";
		} else if (face instanceof FaceBasket) {
			PATH = PATH + "BASKET";
		}

		PATH = PATH + ".png";
		imgViewDiceFAce
				.setImage(new Image(getClass().getClassLoader().getResourceAsStream(PATH), 100, 100, true, true));

	}

	@FXML
	void clickThrowDice(MouseEvent event) throws TreeNotFoundException, IOException {
		orchard.getPlayer().throwDice();
		orchard.getPlayer().incrementTurn();
		displayTurn();
		orchard.getPlayer().setCanPlay(true);
		btnThrowDice.setVisible(false);
		btnCrow.setVisible(false);

		if (orchard.getPlayer().currentDiceFace() instanceof FaceColor face) {
			if (orchard.getTreeByColor(face.getFruitColor()).getFruits().isEmpty()) {
				btnThrowDice.setVisible(true);
				btnCrow.setVisible(true);

			}
		} else if (orchard.getPlayer().currentDiceFace() instanceof FaceCrow face) {
			btnCrow.setVisible(true);
		}

		displayDiceFace();

		if (orchard.isGameOver()) {

			if (orchard.isGameLose()) {

				DisplayPopup.displayLosePopup(orchard);

			} else {
				DisplayPopup.displayWinPopup(orchard);
			}

		}

	}

	@FXML
	void displayCrowScene(ActionEvent event) throws IOException {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		FXMLLoad fxmlLoad = new FXMLLoad();
		fxmlLoad.loadFXMLFile(FXMLPath.CROWSCENE.path(), stage);

	}

}
