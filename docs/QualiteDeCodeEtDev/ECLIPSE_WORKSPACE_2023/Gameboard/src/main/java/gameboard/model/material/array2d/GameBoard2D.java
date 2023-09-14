package gameboard.model.material.array2d;

import gameboard.model.material.Constants;
import gameboard.model.material.Disc;
import gameboard.model.material.IGameBoard;
import gameboard.model.material.Position;

public class GameBoard2D implements IGameBoard {

	Disc[][] discs;

	public GameBoard2D() {
		this.discs = new Disc[Constants.ROWS][Constants.COLUMNS];
	}

	@Override
	public Disc[][] discs() {
		return discs;
	}

	@Override
	public boolean isDiscAt(Position position) {
		Integer row = position.row();
		Integer col = position.column();
		return discs[row-1][col-1] != Disc.NO;
	}

	@Override
	public boolean isEmpty() {
		for (Disc[] columns: discs) {
		    for (Disc disc: columns) {
		    	if (disc != Disc.NO) {
		    		return false;
		    	}
		    }
		}
		return true;
	}

	@Override
	public boolean put(Position position, Disc disc) {
		Integer row = position.row();
		Integer col = position.column();
		if(!isDiscAt(position)) {
			discs[row-1][col-1] = disc;
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		// TODO
	}

	@Override
	public int howManyDiscsOnBoard() {
		return 0;
		// TODO
	}

	@Override
	public Disc discAt(Position position) {
		return null;
		// TODO
	}

	@Override
	public Disc removeDiscAt(Position position) {
		return null;
		// TODO
	}

	@Override
	public String toAscii() {
		return "";
		// TODO
	}
}
