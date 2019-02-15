package metier;

import java.awt.Color;
import java.util.ArrayDeque;

public class Monstre extends Vivant {

	private final int distanceVuJoueurMax = 100;
	private final int distanceApprocheMin = 3;
	private ArrayDeque<Character> deplacementPrevu;
	private final int longueurDeplacementPromenade = 5;
	private final int longueurDeplacementAttaque = 1;
	private final int decomptePausePromenadeMax = 2000;
	private int decomptePausePromenade;
	private boolean passif;

	public Monstre(Color couleur, Position position, Taille taille, boolean estDur, Monde contenant, int vies,
			boolean passif) {
		super(couleur, position, taille, estDur, contenant, vies, 30, new Poing(), 500);
		this.setDeplacementPrevu(new ArrayDeque<Character>());
		this.passif = passif;
		this.decomptePausePromenade = 0;
	}

	public void meurt() {
		contenant.getMonstreListe().remove(this);
	}

	public void attaque() {
		if (!this.isPassif()) {
			if (this.getDecomptePauseAttaque() == 0) {
				this.getArme().utilise(this);
			}
			decomptePauseAttaque();
		}
	}

	public int getDecomptePausePromenade() {
		return decomptePausePromenade;
	}

	public void setDecomptePausePromenade(int decomptePausePromenade) {
		this.decomptePausePromenade = decomptePausePromenade;
	}

	public ArrayDeque<Character> getDeplacementPrevu() {
		return deplacementPrevu;
	}

	public void setDeplacementPrevu(ArrayDeque<Character> deplacementPrevu) {
		this.deplacementPrevu = deplacementPrevu;
	}

	public int getDecomptePausePromenadeMax() {
		return decomptePausePromenadeMax;
	}

	public boolean isPassif() {
		return passif;
	}

	public void setPassif(boolean passif) {
		this.passif = passif;
	}

	public int getDecomptePauseAttaque() {
		return decomptePauseAttaque;
	}

	public int getDistanceVuJoueurMax() {
		return distanceVuJoueurMax;
	}

	public int getDistanceApprocheMin() {
		return distanceApprocheMin;
	}

	public int getLongueurDeplacementPromenade() {
		return longueurDeplacementPromenade;
	}

	public int getLongueurDeplacementAttaque() {
		return longueurDeplacementAttaque;
	}

}
