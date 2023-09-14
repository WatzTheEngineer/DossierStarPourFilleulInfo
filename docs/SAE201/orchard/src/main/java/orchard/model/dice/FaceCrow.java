package orchard.model.dice;

/**specific type of {@link DiceFace}
 */
public class FaceCrow extends DiceFace {

	/**Constructs a new {@link FaceCrow}*/
	private FaceCrow(String name) {
		super(name);
	}
	
	/**Constructs a new {@link FaceCrow} named "CROW"*/
	public FaceCrow() {
		this("CROW");
	}

}
