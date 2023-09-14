package orchard.model.crow;

import java.io.Serializable;
import java.util.Objects;

import javafx.scene.layout.GridPane;

/**piece of the {@link CrowPuzzle}
 * @see CrowPuzzle#CrowPuzzle()*/
@SuppressWarnings("serial")
public class CrowPiece implements Serializable {
	private final Position position;

	/**Constructs a new {@link CrowPiece} with a specific {@link Position} in the {@link GridPane} of the {@link CrowPuzzle}
	 * @param position {@link Position} of the piece in the puzzle grid
	 * */
	public CrowPiece(Position position) {
		this.position = position;
	}
	
	public Position getPosition() {
		return position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CrowPiece other = (CrowPiece) obj;
		return Objects.equals(position, other.position);
	}
	
	

}
