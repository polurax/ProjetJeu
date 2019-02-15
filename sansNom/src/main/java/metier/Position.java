package metier;

import java.awt.MouseInfo;
import java.awt.Point;
import metier.statique.Bords;

public class Position {

	private double x;
	private double y;

	public Position(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}
	
	public int getIntX() {
		return (int)(Math.round(this.getX()));
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}
	
	public int getIntY() {
		return (int)(Math.round(this.getY()));
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public void versGauche(double distance) {
		this.x-=distance;
	}
	public void versDroite(double distance) {
		this.x+=distance;
	}
	public void versHaut(double distance) {
		this.y-=distance;
	}
	public void versBas(double distance) {
		this.y+=distance;
	}
	public void deplace(Vecteur vecteur) {
		this.versDroite(vecteur.getX());
		this.versBas(vecteur.getY());
	}

	@Override
	public boolean equals(Object p2) {
		if(this.x==((Position) p2).getX() && this.y==((Position) p2).getY()) {
			return true;
		}
		return false;
	}
	
	public static boolean enDessousDe(Entite entite1,Entite entite2) {
		return Bords.getBordBas(entite2) < Bords.getBordHaut(entite1);
	}

	public static boolean auDessusDe(Entite entite1,Entite entite2) {
		return Bords.getBordHaut(entite2) > Bords.getBordBas(entite1);
	}

	public static boolean aDroiteDe(Entite entite1,Entite entite2) {
		return Bords.getBordGauche(entite1) > Bords.getBordDroit(entite2);
	}

	public static boolean aGaucheDe(Entite entite1,Entite entite2) {
		return Bords.getBordDroit(entite1) < Bords.getBordGauche(entite2);
	}
}
