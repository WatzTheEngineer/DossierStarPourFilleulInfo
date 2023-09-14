package cafetoeil.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cafetoeil.model.cafedebase.Colombia;
import cafetoeil.model.cafedebase.Deca;
import cafetoeil.model.cafedebase.Espresso;
import cafetoeil.model.supplement.Caramel;
import cafetoeil.model.supplement.Chantilly;
import cafetoeil.model.supplement.Chocolat;
import cafetoeil.model.supplement.IngredientSupplementaire;

class BoissonTest {

	@Test
	void ColombiaPriceAndDescMustFits() {
		
		Boisson comlombiaTest = new Colombia();
		assertEquals("Pur Colombia", comlombiaTest.description());
		assertEquals(.89,comlombiaTest.prix());
		
	}
	
	@Test
	void EspressoPriceAndDescMustFits() {
		
		Boisson espressoTest = new Espresso();
		assertEquals("Espresso", espressoTest.description());
		assertEquals(1.99,espressoTest.prix());
		
	}
	
	@Test
	void DecaPriceAndDescMustFits() {
		
		Boisson decaTest = new Deca();
		assertEquals("Café déca", decaTest.description());
		assertEquals(1.05,decaTest.prix());
		
	}

	@Test
	void CustomCofeePriceAndDescMustFits() {
		
		Boisson comlombiaTest = new Colombia();
		comlombiaTest = new Caramel(comlombiaTest);
		comlombiaTest = new Caramel(comlombiaTest);
		comlombiaTest = new Chocolat(comlombiaTest);
		comlombiaTest = new Chantilly(comlombiaTest);
		
		assertEquals("Pur Colombia, Caramel, Caramel, Chocolat, Chantilly", comlombiaTest.description());
		assertEquals(1.49, comlombiaTest.prix());
	}
	
}
