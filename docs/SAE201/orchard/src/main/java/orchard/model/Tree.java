package orchard.model;

import java.util.HashMap;
import java.util.Map;

import orchard.model.crow.Position;

/**{@link Tree} of the orchard game
 * @see Orchard#Orchard()*/
public class Tree {

	private final FruitColor fruitColor;
	private Map<Position, Fruit> fruits;

	/**Constructs a new Tree with a new {@link Map}<{@link Position}, {@link Fruit}> of 10 objects
	 * @param fruitColor color associated to the tree
	 */
	public Tree(FruitColor fruitColor) {

		this(fruitColor, new HashMap<>());
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				Position position = new Position(i, j);
				this.fruits.put(position, new Fruit(fruitColor, position));
			}
		}
		Position position = new Position(2, 0);
		this.fruits.put(position, new Fruit(fruitColor, position));
		position = new Position(2, 1);
		this.fruits.put(position, new Fruit(fruitColor, position));

	}

	
	/**Constructs a new {@link Tree}*/
	private Tree(FruitColor fruitColor, Map<Position, Fruit> fruits) {
		this.fruitColor = fruitColor;
		this.fruits = fruits;
	}
	
	/**Remove a fruit from the tree
	 * @param fruit fruit that need to be removed from the {@link Tree}
	 * @return false if there was no fruits on the tree
	 */
	public Boolean removeFruit(Fruit fruit) {
		if (!fruits.isEmpty()) {
	this.fruits.remove(fruit.getPosition());
			return true;
		}
		return false;
	}

	public FruitColor getFruitColor() {
		return fruitColor;
	}

	public Map<Position, Fruit> getFruits() {
		return fruits;
	}

}
