package metier.arme;

import java.util.ConcurrentModificationException;

import metier.Arme;
import metier.Joueur;
import metier.Monstre;
import metier.Position;
import metier.Vivant;
import metier.statique.Bords;

public abstract class ArmeCorps extends Arme {

	public ArmeCorps(int dommage, int decompteRecharge) {
		super(dommage, decompteRecharge);
	}

	private static boolean peutFrapper(Vivant attaquant, Vivant victime) {
		int distance;
		int distanceY;
		int distanceX;
		if (Position.enDessousDe(attaquant, victime)) {
			distanceY = Bords.getBordHaut(attaquant) - Bords.getBordBas(victime);
		} else if (Position.auDessusDe(attaquant, victime)) {
			distanceY = Bords.getBordHaut(victime) - Bords.getBordBas(attaquant);
		} else {
			distanceY = 0;
		}
		if (Position.aDroiteDe(attaquant, victime)) {
			distanceX = Bords.getBordDroit(victime) - Bords.getBordGauche(attaquant);
		} else if (Position.aGaucheDe(attaquant, victime)) {
			distanceX = Bords.getBordDroit(attaquant) - Bords.getBordGauche(victime);
		} else {
			distanceX = 0;
		}
		distance = (int) Math.sqrt(Math.pow((double) distanceY, 2) + Math.pow((double) distanceX, 2));
		if (distance < victime.getPortee()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void utilise(Joueur attaquant) {
		try {
			for (Monstre monstre : attaquant.getContenant().getMonstreListe()) {
				if (peutFrapper(attaquant, monstre)) {
					monstre.perdVies(dommage);
				}
			}
		}catch(ConcurrentModificationException e) {
			
		}

	}

	@Override
	public void utilise(Monstre attaquant) {
		Joueur joueur = attaquant.getContenant().getJoueur();
		if (peutFrapper(attaquant, joueur)) {
			joueur.perdVies(dommage);
		}
	}

	public int getDommage() {
		return dommage;
	}

	public void setDommage(int dommage) {
		this.dommage = dommage;
	}

}
