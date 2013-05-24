package Server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Game.Card;
import Game.Deck;
import Game.Pile;
import Game.Player;

public class UnoGame {
	private Deck deck;
	private Pile pile;
	private Card.Color color;
	private List<Player> players = new ArrayList<Player>();
	
	public UnoGame() {
		deck = new Deck();
		deck.makeDeck();
		deck.shuffle();
		pile = new Pile();
	}
	
	public void addPileToDeck() {
		List<Card> pileCards = pile.getCards();
		Card last = pileCards.get(pileCards.size()-1);
		Iterator<Card> it = pileCards.iterator();
		while(it.hasNext()){
			Card c = it.next();
			if (c == last) {
				break;
			}
			deck.addCard(c);
			it.remove();
		}
		deck.shuffle();
	}
	
	public void addPlayer(Player p) {
		players.add(p);
	}
	
	public Player getPlayer(String name) {
		for(Player p : players) {
			if(p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}
	
	public Card getLastPileCard() {
		List<Card> pileCards = pile.getCards();
		Card last = pileCards.get(pileCards.size()-1);
		return last;
	}
	
}
