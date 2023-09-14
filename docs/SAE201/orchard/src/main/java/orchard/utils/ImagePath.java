package orchard.utils;

public enum ImagePath {
	FRUITBLUE("FRUIT_BLUE.png"), 
	FRUITGREEN("FRUIT_GREEN.png"), 
	FRUITRED("FRUIT_RED.png"), 
	FRUITYELLOW("FRUIT_YELLOW.png"),
	TREE("TREE.png"),
	BLUEBASKET("BASKET_BLUE.png"),
	REDBASKET("BASKET_RED.png"),
	YELLOWBASKET("BASKET_YELLOW.png"),
	GREENBASKET("BASKET_GREEN.png"),
	ARROW("ARROW.png"),
	BACKGROUND("BACKGROUND.png"),
	CROWFACE("DICE_FACE_CROW.png"),
	BASKET("DICE_FACE_BASKET.png"),
	BASKETFULL("BASKET_FULL.png");

	private final String path;

	public String path() {
		return path;
	}

	private ImagePath(String path) {
		this.path = path;
	}

}
