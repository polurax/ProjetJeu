package metier;

import java.awt.Color;

public class Projectile extends Entite{

	private Vecteur vecteur;
	private int decompteDeplacement;
	private int decompteDeplacementMax=200;
	private int vitesse;
	
	public Projectile(Position position, Vecteur vecteur, int vitesse) {
		super(Color.cyan,position,new Taille(2, 2),true, null);
		this.vecteur=vecteur;
		this.vitesse=vitesse;
		this.decompteDeplacement=0;
	}
	
	public void decompteDeplacement() {
		if (decompteDeplacement > 0) {
			decompteDeplacement-=vitesse;
			if(decompteDeplacement<0) {
				decompteDeplacement=0;
			}
		} else {
			decompteDeplacement=decompteDeplacementMax;
		}
	}
	
	public void deplace() {
		if(decompteDeplacement==0) {
			position.deplace(vecteur);
		}
		decompteDeplacement();
	}

	public Position getPosition() {
		return position;
	}

	public Vecteur getVecteur() {
		return vecteur;
	}

	public Color getCouleur() {
		return couleur;
	}

	public Taille getTaille() {
		return taille;
	}
}
