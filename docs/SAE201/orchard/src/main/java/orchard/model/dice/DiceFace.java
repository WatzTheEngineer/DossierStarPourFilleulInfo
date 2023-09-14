package orchard.model.dice;

/**abstract parent object for all faces of the orchard dice
 * @see FaceColor
 * @see FaceBasket
 * @see FaceCrow
 */
public abstract class DiceFace {
	protected final String name;
	
	/**Abstract constructor for {@link DiceFace}*/
	protected DiceFace(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
