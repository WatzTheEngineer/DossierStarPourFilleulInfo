package orchard.model;

import java.util.Enumeration;

import orchard.model.dice.FaceColor;
import java.io.Serializable;

/**{@link Enumeration} that rule colors of {@link FaceColor}, {@link Tree}, {@link Fruit}*/
public enum FruitColor implements Serializable {

	BLUE("Blue"), RED("Red"), GREEN("Green"), YELLOW("Yellow");

	/**
	 * @param color string associated with the color
	 * @see FruitColor
	 */
	private FruitColor(String color) {
		this.color = color;
	}

	private String color;

	/**
	 * @return {@link String} associated to a specific color of {@link FruitColor} enum
	 */
	public String color() {
		return color;
	}

}