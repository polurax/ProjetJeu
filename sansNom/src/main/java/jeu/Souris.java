package jeu;

import java.awt.Point;
import metier.Position;
import metier.Vecteur;

public final class Souris {
	private Souris() {
	};

	private static Position getMousePosition() {
		Point point = Jeu.fenetre.getMousePosition(true);
		if (point == null) {
			return new Position(0, 0);
		} else {
			return new Position(point.getX(), point.getY());
		}
	}

	public static Vecteur getVecteur() {
		Position p = getMousePosition();
		double x = getPositionX(p);
		double y = getPositionY(p);
		return new Vecteur(x/(Math.abs(x)+Math.abs(y)), y/(Math.abs(x)+Math.abs(y)));
	}

	private static double getPositionX(Position position) {
		return position.getX() - Constante.TAILLE_FENETRE_LARGEUR / 2 - 8;
	}

	private static double getPositionY(Position position) {
		return position.getY() - Constante.TAILLE_FENETRE_HAUTEUR / 2 - 30;
	}
}
