package jeu;

import java.util.ArrayList;

import metier.Joueur;
import metier.Monstre;
import metier.Projectile;
import metier.arme.ArmeDistance;
import metier.statique.Deplacement;

public class Sequence {
	private Jeu jeu;

	public Sequence(Jeu jeu) {
		this.jeu = jeu;
	}

	public void up() {
		// joueur
		Joueur joueur = Jeu.monde.getJoueur();
		Commande commande = jeu.getControleur().getCommande();
		Deplacement.decompteDeplacement(joueur);

		if (commande.getAvance()) {
			Deplacement.deplacementDe(joueur, Souris.getVecteur());
		}
		
		
		if (commande.getAttaque()) {
			joueur.attaque();
			commande.setAttaque(false);
		}
		if (joueur.getDecomptePauseAttaque() > 0) {
			joueur.decomptePauseAttaque();
		}

		// monstres
		ArrayList<Monstre> monstres = Jeu.monde.getMonstreListe();
		for (Monstre monstre : monstres) {
			Deplacement.deplacementDe(monstre);
			monstre.attaque();
			monstre.getArme().decompteRecharge();
		}

		ArrayList<Projectile> projectiles = Jeu.monde.getProjectileListe();
		for (Projectile projectile : projectiles) {
			projectile.deplace();
		}
	}
}
