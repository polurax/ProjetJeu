package tests;

import static org.junit.Assert.*;
import org.junit.*;
import metier.*;
import metier.statique.Deplacement;
import metier.vivant.*;
@SuppressWarnings("deprecation")
public class MonstreTest {
	private Monstre monstre;
	private Joueur joueur;
	private Monstre monstrePassif;

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
	public void joueurVuTest() {
		joueur.getPosition().versBas(monstre.getDistanceVuJoueurMax() - 1);
		assertEquals(true, Deplacement.joueurVu(monstre));

		joueur.getPosition().versBas(1);
		assertEquals(false, Deplacement.joueurVu(monstre));

		joueur.getPosition().setY(monstre.getPosition().getY() - monstre.getDistanceVuJoueurMax() + 1);
		assertEquals(true, Deplacement.joueurVu(monstre));

		joueur.getPosition().versHaut(1);
		assertEquals(false, Deplacement.joueurVu(monstre));

		joueur.getPosition().setY(10);
		joueur.getPosition().setX(monstre.getPosition().getX() - monstre.getDistanceVuJoueurMax() + 1);
		assertEquals(true, Deplacement.joueurVu(monstre));

		joueur.getPosition().versGauche(1);
		assertEquals(false, Deplacement.joueurVu(monstre));

		joueur.getPosition().setX(monstre.getPosition().getX() + monstre.getDistanceVuJoueurMax() - 1);
		assertEquals(true, Deplacement.joueurVu(monstre));

		joueur.getPosition().versDroite(1);
		assertEquals(false, Deplacement.joueurVu(monstre));

		joueur.getPosition().versGauche(1);
		joueur.getPosition().versGauche(10);
		joueur.getPosition().versHaut(10);
		assertEquals(true, Deplacement.joueurVu(monstre));
	}

	
	@Test
	public void raprocheJoueurEnBas() {
		joueur.getPosition().versBas(40);
		Position p = new Position(monstre.getPosition().getX(), monstre.getPosition().getY());
		assertEquals(true, monstre.getPosition().equals(p));
		assertEquals(true, Deplacement.joueurVu(monstre));
		Deplacement.deplacementDe(monstre);
		Deplacement.deplacementDe(monstre);
		assertEquals(p.getY() + 1, monstre.getPosition().getY(),0);
	}

	@Test
	public void raprocheJoueurEnHaut() {
		joueur.getPosition().versHaut(40);
		Position p = new Position(monstre.getPosition().getX(), monstre.getPosition().getY());
		assertEquals(true, monstre.getPosition().equals(p));
		assertEquals(true, Deplacement.joueurVu(monstre));
		Deplacement.deplacementDe(monstre);
		Deplacement.deplacementDe(monstre);
		assertEquals(p.getY() - 1, monstre.getPosition().getY(),0);
	}

	@Test
	public void raprocheJoueurAGauche() {
		joueur.getPosition().versGauche(40);
		Position p = new Position(monstre.getPosition().getX(), monstre.getPosition().getY());
		assertEquals(true, monstre.getPosition().equals(p));
		assertEquals(true, Deplacement.joueurVu(monstre));
		Deplacement.deplacementDe(monstre);
		Deplacement.deplacementDe(monstre);
		assertEquals(p.getX() - 1, monstre.getPosition().getX(),0);
	}

	@Test
	public void raprocheJoueurADroite() {
		joueur.getPosition().versDroite(40);
		Position p = new Position(monstre.getPosition().getX(), monstre.getPosition().getY());
		assertEquals(true, monstre.getPosition().equals(p));
		assertEquals(true, Deplacement.joueurVu(monstre));
		Deplacement.deplacementDe(monstre);
		Deplacement.deplacementDe(monstre);
		assertEquals(p.getX() + 1, monstre.getPosition().getX(),0);
	}

	@Test
	public void raprocheJoueurEnDiagonale() {
		joueur.getPosition().versDroite(40);
		joueur.getPosition().versBas(40);
		Position p = new Position(monstre.getPosition().getX(), monstre.getPosition().getY());
		assertEquals(true, monstre.getPosition().equals(p));
		assertEquals(true, Deplacement.joueurVu(monstre));
		Deplacement.deplacementDe(monstre);
		Deplacement.deplacementDe(monstre);
		monstre.setDecompteDeplacement(0);
		Deplacement.deplacementDe(monstre);
		assertEquals(p.getX() + 1,monstre.getPosition().getX(),0);
		assertEquals(p.getY() + 1,monstre.getPosition().getY(),0);
	}

	@Test
	public void promenadeActifTest() {
		joueur.getPosition().versDroite(1000);
		Position p = new Position(monstre.getPosition().getX(), monstre.getPosition().getY());
		assertEquals(true, monstre.getPosition().equals(p));
		monstre.setDecomptePausePromenade(0);
		Deplacement.deplacementDe(monstre);
		Deplacement.deplacementDe(monstre);
		assertEquals(false, monstre.getPosition().equals(p));
		p=monstre.getPosition();
		Deplacement.deplacementDe(monstre);
		assertEquals(true, monstre.getPosition().equals(p));
	}

	@Test
	public void promenadePassifTest() {
		joueur.getPosition().versDroite(1000);
		Position p = new Position(monstrePassif.getPosition().getX(), monstrePassif.getPosition().getY());
		assertEquals(true, monstrePassif.getPosition().equals(p));
		monstrePassif.setDecomptePausePromenade(0);
		Deplacement.deplacementDe(monstrePassif);
		Deplacement.deplacementDe(monstrePassif);
		assertEquals(false, monstrePassif.getPosition().equals(p));
		p=monstrePassif.getPosition();
		Deplacement.deplacementDe(monstrePassif);
		assertEquals(true, monstrePassif.getPosition().equals(p));
	}

	@Test
	public void attendTest() {
		joueur.getPosition().versDroite(1000);
		Position p = new Position(monstre.getPosition().getX(), monstre.getPosition().getY());
		assertEquals(true, monstre.getPosition().equals(p));
		monstre.setDecomptePausePromenade(2);
		Deplacement.deplacementDe(monstre);
		assertEquals(true, monstre.getPosition().equals(p));
	}
}
