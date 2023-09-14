package orchard.model;

import java.io.Serializable;

import orchard.model.crow.Position;

@SuppressWarnings("serial")
public class Fruit implements Serializable {
	
/**{@link Fruit} of the orchard trees
 * @see Tree#Tree(FruitColor)*/

	private final FruitColor fruitColor;
	private final Position position;

	/**Constructs a new Fruit
	 * @param fruitColor color of the fruit
	 * @param position position of the fruit in the tree GridPane
	 * @see Position
	 */
	public Fruit(FruitColor fruitColor, Position position) {
		this.fruitColor = fruitColor;
		this.position = position;
	}

	public FruitColor getFruitColor() {
		return fruitColor;
	}

	public Position getPosition() {
		return position;
	}

}
