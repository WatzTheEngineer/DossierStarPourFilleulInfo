package orchard.model.dice;

/**specific type of {@link DiceFace}
 */
public class FaceBasket extends DiceFace {

	/**Constructs a new {@link FaceBasket}*/
	private FaceBasket(String name) {
		super(name);
	}
	
	/**Constructs a new {@link FaceBasket} named "BASKET"*/
	public FaceBasket() {
		this("BASKET");
	}

}
