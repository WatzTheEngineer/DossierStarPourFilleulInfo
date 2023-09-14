package orchard.model.crow;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrowPuzzleTest {
	CrowPuzzle crowPuzzle;
	CrowPiece piece;

	@BeforeEach
	void reset() {
		this.crowPuzzle = new CrowPuzzle();
		this.piece = new CrowPiece(new Position(2, 1));
	}
	
	@Test
	void placePieceMustReturnTrueWhenPieceIsNotThere() {
		assertTrue(this.crowPuzzle.placePiece(this.piece));
	}
	
}
