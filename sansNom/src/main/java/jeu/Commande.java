package jeu;

public class Commande {

	private boolean avance;
	private boolean attaque;

	public Commande() {
		this.avance = false;
		this.attaque = false;
	}

	public boolean getAvance() {
		return avance;
	}

	public void setAvance(boolean avance) {
		this.avance = avance;
	}

	public boolean getAttaque() {
		return attaque;
	}

	public void setAttaque(boolean attaque) {
		this.attaque = attaque;
	}

}
