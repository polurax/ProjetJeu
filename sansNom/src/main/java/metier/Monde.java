package metier;

import java.awt.Color;
import java.util.ArrayList;

import jeu.Jeu;
import metier.vivant.GrosSlime;
import metier.vivant.Slime;

public class Monde {

	private Joueur joueur;
	private ArrayList<Decor> decorListe;
	private ArrayList<Monstre> monstreListe;
	private ArrayList<Projectile> projectileListe;
	private Jeu contenant;

	public Monde(Jeu contenant) {
		this.contenant = contenant;

		this.joueur = new Joueur(this, new Position(0, 0));

		decorListe = new ArrayList<Decor>();
		decorListe.add(new Decor(Color.YELLOW, new Position(14, -15), new Taille(6, 6), true, this));
		decorListe.add(new Decor(Color.CYAN, new Position(20, 15), new Taille(12, 12), true, this));

		monstreListe = new ArrayList<Monstre>();
		monstreListe.add(new Slime(new Position(-15, 20), this));
		monstreListe.add(new Slime(new Position(-10, -30), this));
		monstreListe.add(new GrosSlime(new Position(30, -20), this));
		
		projectileListe= new ArrayList<Projectile>();
	}

	public Monde() {
		decorListe = new ArrayList<Decor>();
		monstreListe = new ArrayList<Monstre>();
	}

	public ArrayList<Decor> getDecorListe() {
		return decorListe;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public ArrayList<Monstre> getMonstreListe() {
		return monstreListe;
	}

	public Jeu getContenant() {
		return contenant;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public ArrayList<Projectile> getProjectileListe() {
		return projectileListe;
	}

}
