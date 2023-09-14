package testspractice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilsTest {

	@Test
	void shouldReturnThatNumberIsDivisible() {
		assertTrue(MathUtils.isDivisibleBy(2, 4));
	}
	
	@Test
	void shouldReturnThatNumberIsNotDivisible() {
		assertFalse(MathUtils.isDivisibleBy(8, 5));
	}

}
