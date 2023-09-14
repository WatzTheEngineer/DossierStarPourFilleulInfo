package orchard.model;

import orchard.model.crow.CrowPiece;
import orchard.model.crow.CrowPuzzle;
import orchard.model.dice.DiceFace;
import orchard.model.dice.GameDice;


/**{@link Player} of the Orchard game
 * @see Orchard#Orchard()*/
public class Player {

	private String nickname;

	private GameDice gameDice;

	private int turnNumber;

	private final Orchard orchard;

	private Boolean canPlay;

	/**Constructs a new {@link Player}*/
	private Player(String nickname, GameDice gameDice, int turnNumber, Orchard orchard, Boolean canPlay) {
		this.nickname = nickname;
		this.gameDice = gameDice;
		this.turnNumber = turnNumber;
		this.orchard = orchard;
		this.canPlay = canPlay;
	}

	/**Constructs a new {@link Player} with default value of canPlay to false*/
	public Player(String nickname, GameDice gameDice, int turnNumber, Orchard orchard) {
		this(nickname,gameDice,turnNumber,orchard,false);
	}

	
	/**Pick a {@link Fruit} and placed it in a {@link Basket}
	 * @param fruit fruit that is picked
	 * @param basket basket that receive the picked fruit
	 * @return true if the fruit was picked up and placed in the baskets
	 */
	public Boolean pickFruit(Fruit fruit, Basket basket) {
		for (Tree tree : this.orchard.getTrees()) {
			if (tree.getFruitColor() == fruit.getFruitColor() && !tree.getFruits().isEmpty()) {
				tree.removeFruit(fruit);
				basket.getFruits().add(fruit);
				return true;
			}
		}
		return false;
	}

	/**Allow player to throw the dice and get a random {@link DiceFace}
	 * @return {@link DiceFace} selected by the {@link GameDice#chooseRandomFace()} method*/
	public DiceFace throwDice() {
		return gameDice.chooseRandomFace();
	}

	/**Increment the turn counter*/
	public void incrementTurn() {
		this.turnNumber++;
	}

	/**Allow player to pick a piece of the {@link CrowPuzzle}
	 * @param piece piece of the puzzle picked by the player
	 */
	public void pickCrowPiece(CrowPiece piece) {
		CrowPuzzle puzzle = this.orchard.getPuzzle();
		puzzle.placePiece(piece);
	}

	/**Build a string used to display turn number with JavaFX
	 * @return {@link String} used to display turn number
	 * @see Player#getTurnNumber()
	 */
	public String turnNumberToString() {
		return "Turn #" + getTurnNumber();
	}

	/**Allow player to get the current face of the dice
	 * @return {@link DiceFace} first DiceFace in the list of faces
	 * @see GameDice#getFaces()
	 */
	public DiceFace currentDiceFace() {
		return gameDice.getFaces().get(0);
	}

	public Boolean getCanPlay() {
		return canPlay;
	}

	public Boolean setCanPlay(Boolean canPlay) {
		Boolean oldCanPlay = this.canPlay;
		this.canPlay = canPlay;
		return oldCanPlay;
	}

	public int getTurnNumber() {
		return turnNumber;
	}

	public void setTurnNumber(int roundNumer) {
		this.turnNumber = roundNumer;
	}

	public String getNickname() {
		return nickname;
	}

	public GameDice getGameDice() {
		return gameDice;
	}

	public Orchard getOrchard() {
		return orchard;
	}

}
