package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import metier.Joueur;
import metier.Monde;
import metier.Monstre;
import metier.Position;
import metier.arme.Epee;
import metier.vivant.GrosSlime;
import metier.vivant.Slime;

public class AttaqueTest {
	private Monstre monstre;
	private Monstre monstrePassif;
	private Joueur joueur;

	@Before
	public void init() {
		Monde monde = new Monde();
		monstre = new GrosSlime(new Position(10, 20), monde);
		monstrePassif = new Slime(new Position(10, 20), monde);
		monde.getMonstreListe().add(monstre);
		monstre.setContenant(monde);
		monde.setJoueur(new Joueur(monde, new Position(10, 20)));
		joueur = monde.getJoueur();
	}

	@Test
	public void attaqueActifCentre() {
		int vieJoueur = joueur.getVies();
		monstre.attaque();
		assertEquals(vieJoueur - 1, joueur.getVies());
	}

	@Test
	public void attaquePassif() {
		int vieJoueur = joueur.getVies();
		monstrePassif.attaque();
		assertEquals(vieJoueur, joueur.getVies());
	}

	@Test
	public void attaqueAGauche() {
		int vieJoueur = joueur.getVies();
		monstre.getPosition().versDroite(10);
		monstre.attaque();
		assertEquals(vieJoueur - 1, joueur.getVies());
	}

	@Test
	public void attaqueADroite() {
		int vieJoueur = joueur.getVies();
		monstre.getPosition().versGauche(10);
		monstre.attaque();
		assertEquals(vieJoueur - 1, joueur.getVies());
	}

	@Test
	public void attaqueEnHaut() {
		int vieJoueur = joueur.getVies();
		monstre.getPosition().versBas(10);
		monstre.attaque();
		assertEquals(vieJoueur - 1, joueur.getVies());
	}

	@Test
	public void attaqueEnBas() {
		int vieJoueur = joueur.getVies();
		monstre.getPosition().versHaut(10);
		monstre.attaque();
		assertEquals(vieJoueur - 1, joueur.getVies());
	}

	@Test
	public void attaqueAGaucheEnHaut() {
		int vieJoueur = joueur.getVies();
		monstre.getPosition().versDroite(10);
		monstre.getPosition().versBas(10);
		monstre.attaque();
		assertEquals(vieJoueur - 1, joueur.getVies());
	}

	@Test
	public void attaqueADroiteEnHaut() {
		int vieJoueur = joueur.getVies();
		monstre.getPosition().versGauche(10);
		monstre.getPosition().versBas(10);
		monstre.attaque();
		assertEquals(vieJoueur - 1, joueur.getVies());
	}

	@Test
	public void attaqueAGaucheEnBas() {
		int vieJoueur = joueur.getVies();
		monstre.getPosition().versDroite(10);
		monstre.getPosition().versHaut(10);
		monstre.attaque();
		assertEquals(vieJoueur - 1, joueur.getVies());
	}

	@Test
	public void attaqueADroiteEnBas() {
		int vieJoueur = joueur.getVies();
		monstre.getPosition().versGauche(10);
		monstre.getPosition().versHaut(10);
		monstre.attaque();
		assertEquals(vieJoueur - 1, joueur.getVies());
	}
	
	@Test
	public void attaqueEpeeAGaucheEnHaut() {
		int vieJoueur = joueur.getVies();
		monstre.getPosition().versDroite(10);
		monstre.getPosition().versBas(10);
		monstre.setArme(new Epee(2));
		monstre.attaque();
		assertEquals(vieJoueur - 2, joueur.getVies());
	}
}
