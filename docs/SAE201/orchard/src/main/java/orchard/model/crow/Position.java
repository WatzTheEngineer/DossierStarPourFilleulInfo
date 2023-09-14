package orchard.model.crow;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
/**rule position of {@link Fruit} and {@link CrowPiece}*/
public class Position implements Serializable {

	private final int x;
	private final int y;

	
	/**Constructs a new position*/
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		return x == other.x && y == other.y;
	}
}
