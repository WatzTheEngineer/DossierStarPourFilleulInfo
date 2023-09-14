package card.application;

import java.util.ArrayList;
import java.util.Collection;

import card.model.Card;
import card.model.Rank;
import card.model.Suit;

public class CardMain {

	public static void main(String[] args) {
		
		Collection<Card> cards = new ArrayList<>();
		cards.add(new Card(Rank.ACE, Suit.DIAMONDS));
		cards.add(new Card(Rank.QUEEN, Suit.SPADES));
		cards.add(new Card(Rank.FIVE, Suit.HEARTS));
		cards.add(new Card(Rank.THREE, Suit.CLUBS));
		
		createCard(cards);
		
	}
	
	private static void createCard(Collection<Card> cards) {
		
		for (Card card : cards) {
			System.out.println(card + " well created");
			System.out.println("with " + card.rank() + " as rank and " + card.suit() + " as suit");
			System.out.println("The display of this card is : " + card.toText() + '\n');
		}
		
	}
}
