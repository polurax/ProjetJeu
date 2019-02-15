package metier;

import java.awt.Color;
import jeu.Constante;
import metier.arme.*;

public class Joueur extends Vivant {

	public Joueur(Monde contenant, Position position) {
		super(Color.BLUE, position, new Taille(Constante.TAILLE_JOUEUR_LARGEUR, Constante.TAILLE_JOUEUR_HAUTEUR), false,
				contenant, Constante.VIE_JOUEUR, Constante.VITESSE_JOUEUR, new Arc()/*Poing()*/, 50);
	}

	public void meurt() {
		// a faire
	}

	public void attaque() {
		if (this.getDecomptePauseAttaque() == 0) {
			this.getArme().utilise(this);
			this.decomptePauseAttaque=this.decomptePauseAttaqueMax;
		}
	}
}
