package orchard.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class BasketTest {

	@ParameterizedTest
	@EnumSource(FruitColor.class)
	void mustReturnThereIsNoFruitInBasketAtStart(FruitColor color) {
		Basket basket = new Basket(new ArrayList<>());
		assertEquals("There is 0 fruit in the basket",basket.fruitNumber());
	}
	
	@ParameterizedTest
	@EnumSource(FruitColor.class)
	void mustReturnRightStringWhenThereIsMoreThanOneFruit(FruitColor color){
		Basket basket = new Basket(new ArrayList<>());
		
		basket.getFruits().add(new Fruit(color, null));
		basket.getFruits().add(new Fruit(color, null));
		
		assertEquals("There are 2 fruits in the basket",basket.fruitNumber());
	}
	
	void fillBasket(Basket basket) {
		for (int i = 0; i <= 10; i++) {
			basket.putFruit(new Fruit(null,null));
		}
	}
	
	@ParameterizedTest
	@EnumSource(FruitColor.class)
	void mustReturnThatBasketIsNotFullAtStart(FruitColor color){
		Basket basket = new Basket(new ArrayList<>());
		assertTrue(basket.isEmpty());
	}
	
	@ParameterizedTest
	@EnumSource(FruitColor.class)
	void isFullMustReturnFalseOrTrueIfBasketIsFullOrNot(FruitColor color) {
		Basket basket = new Basket(new ArrayList<>());
		assertFalse(basket.isFull());
		this.fillBasket(basket);		
		assertTrue(basket.isFull());
	}
	
	@ParameterizedTest
	@EnumSource(FruitColor.class)
	void putFruitMustReturnFalseOrTrueIfBasketIsFullOrNot(FruitColor color) {
		Basket basket = new Basket(new ArrayList<>());
		assertTrue(basket.putFruit(new Fruit(color,null)));
		this.fillBasket(basket);
		assertFalse(basket.putFruit(new Fruit(color,null)));
	}

}
