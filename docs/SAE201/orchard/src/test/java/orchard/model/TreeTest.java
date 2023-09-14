package orchard.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import orchard.model.crow.Position;

class TreeTest {
	Orchard orchard;
	List<Tree> trees;
	Tree tree;
	Map<Position, Fruit> fruits;
	
	@BeforeEach
	void reset() {
		this.orchard = new Orchard();
		this.trees = orchard.getTrees();
		this.tree = trees.get(0);
		this.fruits = tree.getFruits();
	}

	@ParameterizedTest
	@EnumSource(FruitColor.class)
	void fruitPositionMustBeRemovedFromMapWhenPicked(FruitColor color) {
		
		//Vaste fumisterie :
		
		Position fruitPosition = new Position(0,0);
		
		this.tree.removeFruit(new Fruit(color,fruitPosition));
		
		assertThat(this.fruits).doesNotContainKey(fruitPosition);
	}
}
