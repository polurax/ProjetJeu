package metier;

import java.awt.Color;

public abstract class Entite {

	protected Color couleur;
	protected Position position;
	protected Taille taille;
	protected boolean estDur;
	protected Monde contenant;

	public Entite(Color couleur, Position position, Taille taille, boolean estDur, Monde contenant) {
		this.couleur = couleur;
		this.position = position;
		this.taille = taille;
		this.estDur = estDur;
		this.contenant = contenant;
	}

	public void setContenant(Monde contenant) {
		this.contenant = contenant;
	}

	public boolean getEstDur() {
		return estDur;
	}

	public Color getCouleur() {
		return couleur;
	}

	public Monde getContenant() {
		return contenant;
	}

	public Position getPosition() {
		return position;
	}

	public Taille getTaille() {
		return taille;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

}
