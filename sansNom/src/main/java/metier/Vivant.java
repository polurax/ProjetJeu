package metier;

import java.awt.Color;

public abstract class Vivant extends Entite {
	
	protected int decomptePauseAttaque;
	protected int decomptePauseAttaqueMax;
	private final int portee = 5;
	protected int vies;
	private int vieMax;
	protected char orientation;
	private int vitesse;
	protected int decompteDeplacement;
	private final int decompteDeplacementMax = 200;
	protected boolean peutBouger;
	protected Arme arme;

	public Vivant(Color couleur, Position position, Taille taille, boolean estDur, Monde contenant, int vies,
			int vitesse, Arme arme, int decomptePauseAttaqueMax) {
		super(couleur, position, taille, estDur, contenant);
		this.vies = vies;
		this.vieMax = vies;
		this.vitesse=vitesse;
		this.decompteDeplacement = 0;
		orientation = 'B';
		this.peutBouger = true;
		this.decomptePauseAttaque = 0;
		this.decomptePauseAttaqueMax=decomptePauseAttaqueMax;
		this.arme=arme;
		
	}

	public abstract void meurt();

	public void perdVies(int dommage) {
		vies-=dommage;
		if (vies <= 0) {
			this.meurt();
		}
	}
	
	public abstract void attaque();
	
	public void decomptePauseAttaque() {
		if (this.getDecomptePauseAttaque() > 0) {
			this.setDecomptePauseAttaque(this.getDecomptePauseAttaque() - 1);
		} else {
			this.setDecomptePauseAttaque(this.getDecomptePauseAttaqueMax());
		}
	}

	public void setDecompteDeplacement(int decompteDeplacement) {
		this.decompteDeplacement = decompteDeplacement;
	}

	public int getVieMax() {
		return vieMax;
	}

	public char getOrientation() {
		return orientation;
	}

	public void setOrientation(char orientation) {
		this.orientation = orientation;
	}

	public int getVies() {
		return vies;
	}

	public int getDecompteDeplacement() {
		return decompteDeplacement;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public int getDecompteDeplacementMax() {
		return decompteDeplacementMax;
	}

	public int getPortee() {
		return portee;
	}

	public int getDecomptePauseAttaque() {
		return decomptePauseAttaque;
	}

	public Arme getArme() {
		return arme;
	}

	public void setArme(Arme arme) {
		this.arme = arme;
	}
	
	public void setDecomptePauseAttaque(int decomptePauseAttaque) {
		this.decomptePauseAttaque = decomptePauseAttaque;
	}

	public int getDecomptePauseAttaqueMax() {
		return decomptePauseAttaqueMax;
	}
}
