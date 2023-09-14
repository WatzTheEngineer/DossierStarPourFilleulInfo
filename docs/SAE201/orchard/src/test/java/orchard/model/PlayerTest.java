package orchard.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import orchard.model.dice.DiceFace;

class PlayerTest {
	Orchard orchard;
	Player player;
	
	@BeforeEach
	void reset() {
		this.orchard = new Orchard();
		this.player = orchard.getPlayer();
	}
	
	@Test
	void methodMustReturnTurnNumberAsStringReadyToShow() {
		assertEquals("Turn #0", player.turnNumberToString());
	}
	
	@Test
	void throwDiceMethodMustReturnARandomDiceface() {
		assertInstanceOf(DiceFace.class, player.throwDice());
	}
	
	@Test
	void incrementTurnMethodMustIncrementTurnIntegerAttribute() {
		Integer oldTurnNumber = player.getTurnNumber();
		player.incrementTurn();
		assertEquals(oldTurnNumber+1, player.getTurnNumber());
	}
	
	@Test
	void currentDiceFaceMustReturnAValidDiceFace() {
		assertNotNull(player.currentDiceFace());
		assertInstanceOf(DiceFace.class, player.currentDiceFace());
	}
	
	@Test
	void setTurnNumberMustChangeTurnNumber() {
		player.setTurnNumber(10);
		assertEquals(10, player.getTurnNumber());
	}
	
	@Test
	void setCanPlayMustChangeCanPlayAndReturnOldCanPlayValue() {
		assertFalse(player.setCanPlay(true));
		assertTrue(player.setCanPlay(false));
	}

}
