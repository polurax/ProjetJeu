package metier.statique;

import java.util.ArrayList;

import metier.Decor;
import metier.Entite;
import metier.Vivant;

public class Colision {

	private Colision() {}

	public static boolean colisionGauche(Vivant v, Entite e) {
		if (v.getEstDur() || e.getEstDur()) {
			if (Bords.getBordDroit(e)+1 == Bords.getBordGauche(v) && ((hautAuCentre(v, e)
					|| basAuCentre(v, e) || hautAuCentre(e, v) || basAuCentre(e, v)))) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static boolean colisionDecorGauche(Vivant v) {
		ArrayList<Decor> decorListe = v.getContenant().getDecorListe();
		boolean trouve = false;
		int i = 0;
		while (!trouve && decorListe.size() > i) {
			if (colisionGauche(v, decorListe.get(i))) {
				trouve = true;
			}
			i++;
		}
		return trouve;
	}

	public static boolean colisionDroite(Vivant v, Entite e) {
		if (v.getEstDur() || e.getEstDur()) {
			if (Bords.getBordDroit(v)+1 == Bords.getBordGauche(e) && (hautAuCentre(v, e)
					|| basAuCentre(v, e) || hautAuCentre(e, v) || basAuCentre(e, v))) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static boolean colisionDecorDroite(Vivant v) {
		ArrayList<Decor> decorListe = v.getContenant().getDecorListe();
		boolean trouve = false;
		int i = 0;
		while (!trouve && decorListe.size() > i) {
			if (colisionDroite(v, decorListe.get(i))) {
				trouve = true;
			}
			i++;
		}
		return trouve;
	}

	public static boolean colisionHaut(Vivant v, Entite e) {
		if (v.getEstDur() || e.getEstDur()) {
			if (Bords.getBordHaut(v)-1 == Bords.getBordBas(e) && (gaucheAuCentre(v, e)
					|| droiteAuCentre(v, e) || gaucheAuCentre(e, v) || droiteAuCentre(e, v))) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static boolean colisionDecorHaut(Vivant v) {
		ArrayList<Decor> decorListe = v.getContenant().getDecorListe();
		boolean trouve = false;
		int i = 0;
		while (!trouve && decorListe.size() > i) {
			if (colisionHaut(v, decorListe.get(i))) {
				trouve = true;
			}
			i++;
		}
		return trouve;
	}

	public static boolean colisionBas(Vivant v, Entite e) {
		if (v.getEstDur() || e.getEstDur()) {
			if (Bords.getBordBas(v)+1 == Bords.getBordHaut(e) && (gaucheAuCentre(v, e)
					|| droiteAuCentre(v, e) || gaucheAuCentre(e, v) || droiteAuCentre(e, v))) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static boolean colisionDecorBas(Vivant v) {
		ArrayList<Decor> entiteListe = v.getContenant().getDecorListe();
		boolean trouve = false;
		int i = 0;
		while (!trouve && entiteListe.size() > i) {
			if (colisionBas(v, entiteListe.get(i))) {
				trouve = true;
			}
			i++;
		}
		return trouve;
	}

	private static boolean gaucheAuCentre(Entite e1, Entite e2) {
		if (Bords.getBordGauche(e1) >= Bords.getBordGauche(e2)
				&& Bords.getBordGauche(e1) <= Bords.getBordDroit(e2)) {
			return true;
		} else {
			return false;
		}

	}

	private static boolean droiteAuCentre(Entite e1, Entite e2) {
		if (Bords.getBordDroit(e1) >= Bords.getBordDroit(e2)
				&& Bords.getBordDroit(e1) <= Bords.getBordGauche(e2)) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean hautAuCentre(Entite e1, Entite e2) {
		if (Bords.getBordHaut(e1) >= Bords.getBordHaut(e2)
				&& Bords.getBordHaut(e1) <= Bords.getBordBas(e2)) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean basAuCentre(Entite e1, Entite e2) {
		if (Bords.getBordBas(e1) >= Bords.getBordBas(e2)
				&& Bords.getBordBas(e1) <= Bords.getBordHaut(e2)) {
			return true;
		} else {
			return false;
		}
	}
}
