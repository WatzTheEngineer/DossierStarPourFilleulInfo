package orchard.model;

import java.util.List;

/**{@link Basket} of the orchard game
 * @see Orchard#Orchard()*/
public class Basket {

	/**Constant that rule how many {@link Fruit} can be contained in a {@link Basket}*/
	private static final int MAX_FRUIT_AMOUNT = 10;

	private List<Fruit> fruits;

	/**Constructs a new Basket
	 * @param fruits list that contains {@link Fruit} stored in the basket
	 */
	public Basket(List<Fruit> fruits) {
		this.fruits = fruits;
	}

	/**Build a string to display how many fruits are stored in the {@link Basket}
	 * @return {@link String} built string
	 */
	public String fruitNumber() {
		if (fruits.size() > 1)
			return "There are " + fruits.size() + " fruits in the basket";
		return "There is " + fruits.size() + " fruit in the basket";
	}

	/**Add a {@link Fruit} to the {@link Basket}
	 * @param fruit fruit added to the basket
	 * @return true if {@link Basket} is not full
	 */
	public boolean putFruit(Fruit fruit) {
		if (!this.isFull()) {
			return this.fruits.add(fruit);
		}
		return false;
	}

	/**Check if the {@link Basket} is full
	 * @return {@link Boolean} true if the basket is full
	 * @see Basket#MAX_FRUIT_AMOUNT
	 */
	public Boolean isFull() {
		return this.fruits.size() == MAX_FRUIT_AMOUNT;
	}

	/**Check if the {@link Basket} is empty (contains 0 {@link Fruit})
	 * @return {@link Boolean} true if the basket is empty
	 */
	public Boolean isEmpty() {
		return fruits.isEmpty();
	}

	public List<Fruit> getFruits() {
		return fruits;
	}

}
