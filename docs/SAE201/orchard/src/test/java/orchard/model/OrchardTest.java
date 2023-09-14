package orchard.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class OrchardTest {
	
	Orchard orchard;

	@BeforeEach
	void reset() {
		this.orchard = new Orchard();
	}
	
	@Test
	void gameCanNotBeOverOnFirstRound() {
		assertFalse(orchard.isGameOver());
	}

	@ParameterizedTest
	@EnumSource(FruitColor.class)
	void mustReturnTheRightTreeWhenGotByColor(FruitColor color) throws Exception {
		Tree tree = orchard.getTreeByColor(color);
		assertEquals(color, tree.getFruitColor());
	}

	@Test
	void mustReturnAlreadyExistingInstanceWhenOrchardIsAlreadyCreated() {
		Orchard instance = Orchard.getInstance();
		Orchard otherInstance = Orchard.getInstance();
		
		assertTrue(instance == otherInstance); // Comparing references, hence the use of == and not assertEquals
	}

}
