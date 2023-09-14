package testspractice;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class DateUtilsTest {

	@Test
	void should_be_a_PreJulianYear_before_1582_not_a_leap_year() {
		assertFalse(DateUtils.isLeapYear(1163));
		assertTrue(DateUtils.isPreJulianYear(1163));
	}
	
	@Test
	void should_be_not_a_PreJulianYear_after_1582() {
		assertFalse(DateUtils.isPreJulianYear(1600));
	}
	
	@Test
	void should_be_a_leap_year_when_divisible_by_400() {
		assertTrue(DateUtils.isLeapYear(1600));
	}
	
	@Test
	void should_be_a_leap_year_when_divisible_by_4_but_not_by_100 () {
		assertTrue(DateUtils.isLeapYear(2012));
	 }
	
	@Test
	void should_not_be_a_leap_year_when_divisible_by_100_but_not_by_400 () {
		assertFalse(DateUtils.isLeapYear(2500));
	}
	
	@Test
	void should_not_be_a_leap_year() {
		assertFalse(DateUtils.isLeapYear(2019));
	}
	
}

