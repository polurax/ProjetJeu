package metier.statique;

import metier.Entite;

public final class Bords {
	private Bords() {};
	
	public static int getBordHaut(Entite e) {
		return e.getPosition().getIntY() - e.getTaille().getHauteur() / 2;
	}
	public static int getBordBas(Entite e) {
		return e.getPosition().getIntY() + e.getTaille().getHauteur() / 2;
	}
	public static int getBordGauche(Entite e) {
		return e.getPosition().getIntX() - e.getTaille().getLargeur() / 2;
	}
	public static int getBordDroit(Entite e) {
		return e.getPosition().getIntX() + e.getTaille().getLargeur() / 2;
	}
}
