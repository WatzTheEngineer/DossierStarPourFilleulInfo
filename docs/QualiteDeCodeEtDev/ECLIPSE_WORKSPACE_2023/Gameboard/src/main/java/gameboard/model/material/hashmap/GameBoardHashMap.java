package gameboard.model.material.hashmap;

import java.util.HashMap;
import java.util.Map;

import gameboard.model.material.Disc;
import gameboard.model.material.IGameBoard;
import gameboard.model.material.Position;

public class GameBoardHashMap implements IGameBoard {

	private final Map<Position, Disc> discs;

	public GameBoardHashMap() {
		this.discs = new HashMap<>();
	}

	public Map<Position, Disc> discs() {
		return discs;
	}

	public boolean isDiscAt(Position position) {
		return discs.get(position) != Disc.NO;
	}

	public boolean isEmpty() {
		return discs.isEmpty();
	}

	public boolean put(Position position, Disc disc) {
		if(!isDiscAt(position)) {
			discs.put(position, disc);
			return true;
		}
		return false;
	}

	public void clear() {
		// TODO : one line instruction : see javadoc ;-)
	}

	public int howManyDiscsOnBoard() {
		return 0;
		// TODO : one line instruction : see in javadoc ;-)
	}

	public Disc discAt(Position position) {
		return null;
		// TODO : one line instruction : see in javadoc ;-)
	}

	public Disc removeDiscAt(Position position) {
		return null;
		// TODO : one line instruction : see in javadoc ;-)
	}

	public String toAscii() {
		return "";
		// TODO
	}

}