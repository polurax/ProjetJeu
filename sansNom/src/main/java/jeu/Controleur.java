package jeu;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controleur extends KeyAdapter {

	private Commande commande;

	public Controleur() {
		this.commande = new Commande();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP)
			this.commande.setAvance(true);
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			this.commande.setAttaque(true);

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP)
			this.commande.setAvance(false);
	}

	public Commande getCommande() {
		return commande;
	}

}
