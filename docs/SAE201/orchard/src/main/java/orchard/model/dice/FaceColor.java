package orchard.model.dice;

import orchard.model.FruitColor;

/**specific type of {@link DiceFace} that work a {@link FruitColor}
 */
public class FaceColor extends DiceFace {
	private final FruitColor fruitColor;
	
	/**Constructs a new {@link FaceColor}*/
	private FaceColor(String name, FruitColor fruitColor) {
		super(name);
		this.fruitColor = fruitColor;
	}

	/**Constructs a new {@link FaceColor} named from the associated color
	 * @param fruitColor color associated to the face
	 */
	public FaceColor(FruitColor fruitColor) {
		this(fruitColor.color(), fruitColor);
	}

	public FruitColor getFruitColor() {
		return fruitColor;
	}

}
