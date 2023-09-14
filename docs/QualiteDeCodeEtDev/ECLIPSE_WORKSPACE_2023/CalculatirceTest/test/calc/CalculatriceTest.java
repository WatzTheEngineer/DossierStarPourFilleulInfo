package calc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import calc.model.Calculatrice;
import calc.util.DivisionParZeroException;

class CalculatriceTest {
	private Calculatrice calculatrice;
	
	@BeforeEach
	public void instanciationCalculatrice() {
		calculatrice = new Calculatrice();
	}
	
	@Test
	void doitAdditionnerDeuxEntier() {

		int terme1 = 80;
		int terme2 = 20;

		int somme = calculatrice.additionner(terme1, terme2);

		assertEquals(100, somme);

	}

	@Test
	void doitSoustraireDeuxEntier() {

		int terme1 = 30;
		int terme2 = 50;

		int difference = calculatrice.soustraire(terme1, terme2);

		assertEquals(-20, difference);

	}

	@Test
	void doitMultiplierDeuxEntier() {

		int facteur1 = 20;
		int facteur2 = 10;

		int produit = calculatrice.multiplier(facteur1, facteur2);

		assertEquals(200, produit);

	}

	@Test
	void doitDiviserDeuxEntier() throws DivisionParZeroException {

		int facteur1 = 20;
		int facteur2 = 10;

		int division = calculatrice.diviser(facteur1, facteur2);

		assertEquals(2, division);

	}
	
	@Test
	void doitLeverUneBatExceptionSiDivisionParZero() throws DivisionParZeroException {
		
		DivisionParZeroException exception = assertThrows(DivisionParZeroException.class, () -> calculatrice.diviser(1, 0));
		assertEquals("BatException", exception.getMessage());
		
	}
}
