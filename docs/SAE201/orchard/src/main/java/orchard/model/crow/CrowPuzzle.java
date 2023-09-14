package orchard.model.crow;

import java.util.HashMap;
import java.util.Map;

import orchard.model.Orchard;

/**
 * puzzle made out of {@link CrowPiece}
 * 
 * @see Orchard#Orchard()
 */
public class CrowPuzzle {
	private final Map<Position, CrowPiece> crowPieces;
	private final PieceStockpile pile;

	/** Constructs a new {@link CrowPuzzle} */
	private CrowPuzzle(Map<Position, CrowPiece> puzzle, PieceStockpile pile) {
		this.crowPieces = puzzle;
		this.pile = pile;
	}

	/**
	 * Constructs a new {@link CrowPuzzle} with a new {@link Map} of
	 * {@link Position} and {@link CrowPiece} and a new {@link PieceStockpile}
	 */
	public CrowPuzzle() {
		this(new HashMap<>(), new PieceStockpile());
	}

	/**
	 * Pick a {@link CrowPiece} in the pile to add it to the {@link CrowPuzzle}
	 * 
	 * @param piece {@link CrowPiece} that need to be placed in the puzzle
	 * @return true if the puzzle now contains the piece
	 */
	public Boolean placePiece(CrowPiece piece) {
		crowPieces.put(piece.getPosition(), piece);
		removePieceOfStock(piece);
		return crowPieces.containsValue(piece);
	}

	/**remove {@link CrowPiece} from the {@link PieceStockpile}
	 * @param piece removed piece
	 * @return true if piece was removed
	 * @see CrowPuzzle#pile
	 */
	public Boolean removePieceOfStock(CrowPiece piece) {
		for (int i = 0; i < pile.getpiece().size(); i++) {
			if (pile.getpiece().get(i).equals(piece)) {
				pile.getpiece().remove(i);
				return true;
			}
		}
		return false;
	}

	public Map<Position, CrowPiece> getCrowPieces() {
		return crowPieces;
	}

	public PieceStockpile getPile() {
		return this.pile;
	}

}
