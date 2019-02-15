package metier.arme;

import metier.*;

public abstract class ArmeDistance extends Arme {
	
	private int vitesse;

	public ArmeDistance(int dommage, int vitesse, int decompteRechergeMax) {
		super(dommage, decompteRechergeMax);
		this.vitesse = vitesse;
	}

	public void utilise(Monstre tireur) {
		if (decompteRecharge == 0) {
			tireur.getContenant().getProjectileListe()
					.add(new Projectile(new Position(tireur.getPosition().getX(), tireur.getPosition().getY()),
							new Vecteur(tireur.getOrientation()), vitesse));
		}
	}

	public void utilise(Joueur tireur) {
		if (decompteRecharge == 0) {
			tireur.getContenant().getProjectileListe()
					.add(new Projectile(new Position(tireur.getPosition().getX(), tireur.getPosition().getY()),
							new Vecteur(tireur.getOrientation()), vitesse));
		}
	}

}
