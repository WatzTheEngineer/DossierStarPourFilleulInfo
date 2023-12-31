package card.model;

public class Card {

	private final Rank rank;
	private final Suit suit;

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Rank rank() {
		return rank;
	}

	public Suit suit() {
		return suit;
	}

	public String toText() {
		return this.rank.code() + this.suit.code();
	}
	
	@Override
	public String toString() {
		return rank + " of " + suit;
	}
	
}
