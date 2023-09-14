package card.model;

public enum Suit {
	CLUBS("\u2763"),
	DIAMONDS("\u2766"),
	HEARTS("\u2765"),
	SPADES("\u2760");
	
	private String code;
	
	private Suit(String code) {
		this.code = code;
	}
	
	public String code() {
		return this.code;
	}
	
}
