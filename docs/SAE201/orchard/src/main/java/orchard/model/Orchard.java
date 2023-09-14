package orchard.model;

import java.util.ArrayList;
import java.util.List;

import orchard.model.crow.CrowPuzzle;
import orchard.model.dice.GameDice;
import orchard.model.exceptions.TreeNotFoundException;


/**root object of the Orchard game, ruled by a singleton pattern
 * @see Orchard#getInstance()
 * @see Orchard#Orchard()*/
public class Orchard {

	private static Orchard instance;

	private Player player;

	private final List<Basket> baskets;

	private final List<Tree> trees;

	private final CrowPuzzle puzzle;

	/**Constructs a new Orchard*/
	private Orchard(Player player, List<Tree> trees, List<Basket> baskets, CrowPuzzle puzzle) {
		this.player = player;
		this.trees = trees;
		this.baskets = baskets;
		this.puzzle = puzzle;
	}

	/**Constructs a new {@link Orchard} with a new {@link Player} named "Player 1", a new list of 4 {@link Basket}, a new list of 4 {@link Tree}
	 * (Blue,Red,Green,Yellow), and a new {@link CrowPuzzle}
	 * @see Orchard#getInstance()*/
	public Orchard() {

		this(null, new ArrayList<>(), new ArrayList<>(), new CrowPuzzle());

		this.player = new Player("Player 1", new GameDice(), 0, this);

		for (int i = 0; i < 4; i++) {
			this.baskets.add(new Basket(new ArrayList<>()));
		}

		for (FruitColor fruitColor : FruitColor.values()) {
			this.trees.add(new Tree(fruitColor));
		}
	}

	/**@return true if the crow puzzle is complete or if all fruits have been picked up*/
	public Boolean isGameOver() {
		if (this.getPuzzle().getCrowPieces().size() == 9) {
			return true;
		}

		for (Tree tree : this.getTrees()) {

			if (!tree.getFruits().isEmpty()) {
				return false;
			}
		}

		return true;
	}

	/**At the end of an orchard game, check whether the game has been won or lost. Otherwise returns false.
	 * @return true if crow puzzle is complete when orchard game end*/
	public Boolean isGameLose() {

		if (isGameOver() && puzzle.getCrowPieces().size() == 9) {
			return true;
		}

		return false;
	}

	/**Use a specific color from Enum {@link FruitColor} to get the associated tree
	 * @param color color of the wanted tree
	 * @return {@link Tree} with a fruitColor attribute equivalent to color parameter
	 * @throws TreeNotFoundException throws if there is no tree with this color in the Orchard*/
	public Tree getTreeByColor(FruitColor color) throws TreeNotFoundException {
		for (Tree tree : trees) {
			if (tree.getFruitColor().equals(color)) {
				return tree;
			}
		}
		throw new TreeNotFoundException("Tree could not be found in orchard");
	}
	
	public Basket basket(int index) {
		return this.getBaskets().get(index);
	}

	public Player getPlayer() {
		return player;
	}

	public List<Basket> getBaskets() {
		return this.baskets;
	}

	public List<Tree> getTrees() {
		return trees;
	}

	public CrowPuzzle getPuzzle() {
		return this.puzzle;
	}

	/**Used by singleton pattern for {@link Orchard} instead of constructor {@link Orchard#Orchard()}
	 * @return {@link Orchard}
	 */
	public static Orchard getInstance() {
		if (instance == null) {
			instance = new Orchard();
		}
		return instance;
	}

}
