package testspractice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringUtilsTest {

	@Test
	void shouldBeReversedString() {
		String resultat = StringUtils.reverse("mysuperstring");
		assertEquals("gnirtsrepusym", resultat);
	}
	
	@Test
	void shouldNotBePalindromeWithOdd() {
		assertFalse(StringUtils.isPalindrome("alpha"));
	}
	
	@Test
	void shouldNotBePalindromeWithEven() {
		assertFalse(StringUtils.isPalindrome("beta"));
	}
	
	@Test
	void shouldBePalindromeWithOdd() {
		assertTrue(StringUtils.isPalindrome("sos"));
	}
	
	@Test
	void shouldBePalindromeWithEven() {
		assertTrue(StringUtils.isPalindrome("noon"));
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
	void palindromes(String candidate) {
	    assertTrue(StringUtils.isPalindrome(candidate));
	}

}
