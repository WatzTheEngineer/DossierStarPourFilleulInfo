package orchard.model.dice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import orchard.model.FruitColor;
import orchard.model.Orchard;

/**{@link GameDice} of the orchard game
 * @see Orchard#Orchard()*/
public class GameDice {

	public final List<DiceFace> faces;

	/**Constructs a new {@link GameDice}*/
	private GameDice(List<DiceFace> faces) {
		this.faces = faces;
	}
	
	/**Constructs a new {@link GameDice} with empty {@link List} of {@link DiceFace} filled with
	 * 4 {@link FaceColor} (one for each available color), 
	 * 1 {@link FaceCrow},
	 * 1 {@link FaceBasket}
	 * @see DiceFace*/
	public GameDice() {
		
		this(new ArrayList<>());

		for (FruitColor fruitColor : FruitColor.values()) {
			this.faces.add(new FaceColor(fruitColor));
		}

		this.faces.add(new FaceCrow());
		this.faces.add(new FaceBasket());
	}


	/**Shuffle all elements of {@link GameDice#faces} and get the new first one.
	 * @return first {@link DiceFace} of the list after shuffle
	 */
	public DiceFace chooseRandomFace() {

		Collections.shuffle(faces);
		return faces.get(0);
	}

	public List<DiceFace> getFaces() {
		return faces;
	}

}
