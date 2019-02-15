package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import metier.Taille;

public class TailleTest {

	private Taille taille;
	
	@Before
	public void init() {
		taille=new Taille(20, 30);
	}
	
	@Test
	public void setLargeurTest() {
		taille.setLargeur(40);
		assertEquals(40, taille.getLargeur());
	}
	
	@Test
	public void setHauteurTest() {
		taille.setHauteur(40);
		assertEquals(40, taille.getHauteur());
	}

}
