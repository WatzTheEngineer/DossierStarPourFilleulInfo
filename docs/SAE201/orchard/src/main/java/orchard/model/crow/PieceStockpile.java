package orchard.model.crow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**pile of {@link CrowPiece} (before they're placed into a {@link CrowPuzzle})
 * @see CrowPuzzle#CrowPuzzle()
 */
public class PieceStockpile {
	private final List<CrowPiece> pieces;

	/**Constructs a new {@link PieceStockpile}*/
	private PieceStockpile(List<CrowPiece> reserve) {
		this.pieces = reserve;
	}

	/**Constructs a new {@link PieceStockpile}, add it all existing pieces of the {@link CrowPuzzle} (9) and shuffle it*/
	public PieceStockpile() {
		this(new ArrayList<>());

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				pieces.add(new CrowPiece(new Position(i, j)));
			}
		}
		Collections.shuffle(pieces);
	}

	public List<CrowPiece> getpiece() {
		return this.pieces;
	}

}
