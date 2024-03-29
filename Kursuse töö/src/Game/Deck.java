package Game;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;


public class Deck extends Pile{

	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public Collection<Card> makeDeck() {
		for(Card.Color col : Card.Color.values()) {
			for(Card.Value val : EnumSet.range(Card.Value.ZERO, Card.Value.NINE)) {
				cards.add(new NumberCard(col, val));
			}
			cards.add(new DrawTwoCard(col, Card.Value.DRAWTWO));
			cards.add(new SkipCard(col, Card.Value.SKIP));
			cards.add(new WildCard(col, Card.Value.WILD));
			cards.add(new WildDrawFour(col, Card.Value.WILDDRAWFOUR));
		}
		return cards;
	}

}
