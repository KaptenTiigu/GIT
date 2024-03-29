package Message;

import Game.Card;
import Game.Card.Color;
import Game.Player;
import Klient.Client;
import Server.ClientSession;

/**
 * S�num, milles saadab server kliendile kaardi ja j�rjekorra.
 * @author LehoRaiguma
 *
 */
public class serverCardMessage implements Message {
	private Card kaart;
	private String address;
	private Card.Color varv;
	private String jargmine;

	public serverCardMessage(String next, Card card, Color color) {
		// TODO Auto-generated constructor stub
		this.kaart = card;
		//this.address = address;
		this.varv = color;
		this.jargmine = next;
	}

	public serverCardMessage(/*String address, */String jargmine, Card kaart) {
		this.kaart = kaart;
		//this.address = address;
		this.jargmine = jargmine;
	}
	
	@Override
	public void onReceive(ClientSession s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onReceive(Player c) {
			c.addKillCard(kaart);
			if (varv != null) {
				c.addColor(varv);
			}
			if (jargmine.equals(c.getName())) {
				c.setPermission(true);
			} else {
				c.setPermission(false);
			}
			c.killCard();
	}

	@Override
	public String getAdress() {
		// TODO Auto-generated method stub
		return null;
	}

}
