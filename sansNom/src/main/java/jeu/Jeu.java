package jeu;

import fenetre.Fenetre;

import metier.Monde;

public class Jeu {

	public static Fenetre fenetre;
	private Controleur controleur;
	public static Monde monde;

	public Jeu() {

		this.controleur = new Controleur();
		this.monde = new Monde(this);
		this.fenetre = new Fenetre(controleur);
		
	}

	public Controleur getControleur() {
		return controleur;
	}

}
