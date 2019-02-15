package metier.statique;

import java.util.Random;

import metier.Joueur;
import metier.Monstre;
import metier.Position;
import metier.Vecteur;
import metier.Vivant;

public final class Deplacement {
	
	private Deplacement() {
	}
	
	public static void deplacementDe(Joueur joueur, Vecteur vecteur) {
		if(vecteur.getX()>0) {
			deplaceADroite(joueur,Math.abs(vecteur.getX()));
		}else if(vecteur.getX()<0) {
			deplaceAGauche(joueur,Math.abs(vecteur.getX()));
		}
		if(vecteur.getY()>0) {
			deplaceEnBas(joueur,Math.abs(vecteur.getY()));
		}else if(vecteur.getY()<0) {
			deplaceEnHaut(joueur,Math.abs(vecteur.getY()));
		}
		joueur.setOrientation(vecteur.getOrientation());
	}
	public static void deplaceAGauche(Vivant vivant, double distance) {
		if (vivant.getDecompteDeplacement() == 0) {
			if (!Colision.colisionDecorGauche(vivant)) {
				vivant.getPosition().versGauche(distance);
			}
		}
		decompteDeplacement(vivant);
	}

	public static void deplaceADroite(Vivant vivant, double distance) {
		if (vivant.getDecompteDeplacement() == 0) {
			if (!Colision.colisionDecorDroite(vivant)) {
				vivant.getPosition().versDroite(distance);
			}
		}
		decompteDeplacement(vivant);
	}

	public static void deplaceEnHaut(Vivant vivant, double distance) {
		if (vivant.getDecompteDeplacement() == 0) {
			if (!Colision.colisionDecorHaut(vivant)) {
				vivant.getPosition().versHaut(distance);
			}
		}
		decompteDeplacement(vivant);
	}

	public static void deplaceEnBas(Vivant vivant, double distance) {
		if (vivant.getDecompteDeplacement() == 0) {
			if (!Colision.colisionDecorBas(vivant)) {
				vivant.getPosition().versBas(distance);
			}
		}
		decompteDeplacement(vivant);
	}
	public static void deplaceAGauche(Vivant vivant) {
		if (vivant.getDecompteDeplacement() == 0) {
			if (!Colision.colisionDecorGauche(vivant)) {
				vivant.getPosition().versGauche(1);
				vivant.setOrientation('G');
			}
		}
		decompteDeplacement(vivant);
	}

	public static void deplaceADroite(Vivant vivant) {
		if (vivant.getDecompteDeplacement() == 0) {
			if (!Colision.colisionDecorDroite(vivant)) {
				vivant.getPosition().versDroite(1);
				vivant.setOrientation('D');
			}
		}
		decompteDeplacement(vivant);
	}

	public static void deplaceEnHaut(Vivant vivant) {
		if (vivant.getDecompteDeplacement() == 0) {
			if (!Colision.colisionDecorHaut(vivant)) {
				vivant.getPosition().versHaut(1);
				vivant.setOrientation('H');
			}
		}
		decompteDeplacement(vivant);
	}

	public static void deplaceEnBas(Vivant vivant) {
		if (vivant.getDecompteDeplacement() == 0) {
			if (!Colision.colisionDecorBas(vivant)) {
				vivant.getPosition().versBas(1);
				vivant.setOrientation('B');
			}
		}
		decompteDeplacement(vivant);
	}

	public static void decompteDeplacement(Vivant vivant) {
		if (vivant.getDecompteDeplacement() > vivant.getVitesse()) {
			vivant.setDecompteDeplacement(vivant.getDecompteDeplacement() - vivant.getVitesse());
		} else {
			if (vivant.getDecompteDeplacement() <= vivant.getVitesse() && vivant.getDecompteDeplacement() > 0) {
				vivant.setDecompteDeplacement(0);
			} else {
				vivant.setDecompteDeplacement(vivant.getDecompteDeplacementMax());
			}
		}
	}

	public static void deplacementDe(Monstre monstre) {
		if (monstre.getDecompteDeplacement() != 0) {
			Deplacement.decompteDeplacement(monstre);
		} else {
			if (monstre.getDeplacementPrevu().isEmpty()) {
				if (!monstre.isPassif()) {
					if (joueurVu(monstre)) {
						deplaceVersJoueur(monstre);
					} else {
						promenade(monstre);
					}
				} else {
					promenade(monstre);
				}

			} else {
				seDeplace(monstre);
			}
		}
	}

	private static void seDeplace(Monstre monstre) {
		switch (monstre.getDeplacementPrevu().remove().charValue()) {
		case 'H':
			Deplacement.deplaceEnHaut(monstre);
			break;
		case 'B':
			Deplacement.deplaceEnBas(monstre);
			break;
		case 'G':
			Deplacement.deplaceAGauche(monstre);
			break;
		default:
			Deplacement.deplaceADroite(monstre);
		}
	}

	private static void deplaceVersJoueur(Monstre monstre) {
		Joueur j = monstre.getContenant().getJoueur();
		if (Position.aGaucheDe(monstre, j)) {
			ajoutDeplacementPrevu(monstre, 'D', monstre.getLongueurDeplacementAttaque());
		}
		if (Position.aDroiteDe(monstre, j)) {
			ajoutDeplacementPrevu(monstre, 'G', monstre.getLongueurDeplacementAttaque());
		}
		if (Position.enDessousDe(monstre, j)) {
			ajoutDeplacementPrevu(monstre, 'H', monstre.getLongueurDeplacementAttaque());
		}
		if (Position.auDessusDe(monstre, j)) {
			ajoutDeplacementPrevu(monstre, 'B', monstre.getLongueurDeplacementAttaque());
		}
	}

	public static boolean joueurVu(Monstre monstre) {
		Joueur j = monstre.getContenant().getJoueur();
		int distance = (int) Math.sqrt(Math.pow((double) (monstre.getPosition().getX() - j.getPosition().getX()), 2)
				+ Math.pow((double) (monstre.getPosition().getY() - j.getPosition().getY()), 2));
		if (monstre.getDistanceVuJoueurMax() > distance) {
			return true;
		} else {
			return false;
		}
	}

	private static void promenade(Monstre monstre) {
		/*
		 * if (monstre.getDecomptePausePromenade() == 0) { char[] direction = { 'H',
		 * 'B', 'G', 'D' }; Random rand = new Random();
		 * ajoutDeplacementPrevu(monstre,direction[rand.nextInt(4)],
		 * monstre.getLongueurDeplacementPromenade()); }
		 * decomptePausePromenade(monstre);
		 */
		if (monstre.getDecomptePausePromenade() == 0) {
			char[] direction = { 'H', 'B', 'G', 'D' };
			Random rand = new Random();
			ajoutDeplacementPrevu(monstre, direction[rand.nextInt(4)], Aleatoire.gaussSimulation(0, monstre.getLongueurDeplacementPromenade()*2));
		}
		decomptePausePromenade(monstre);
	}

	private static void ajoutDeplacementPrevu(Monstre monstre, char c, int nb) {
		for (int i = 0; i < nb; i++) {
			monstre.getDeplacementPrevu().add(new Character(c));
		}
	}

	private static void decomptePausePromenade(Monstre monstre) {
		if (monstre.getDecomptePausePromenade() > 0) {
			monstre.setDecomptePausePromenade(monstre.getDecomptePausePromenade() - 1);
		} else {
			monstre.setDecomptePausePromenade(Aleatoire.gaussSimulation(0, monstre.getDecomptePausePromenadeMax()*2));
		}
	}

}
