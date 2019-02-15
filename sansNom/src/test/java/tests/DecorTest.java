package tests;

import java.awt.Color;

import org.junit.Before;

import metier.Decor;
import metier.Entite;
import metier.Position;
import metier.Taille;
@SuppressWarnings("unused")
public class DecorTest {
	
	private Decor decor;
	
	@Before
	public void init() {
		decor = new Decor(Color.black,new Position(10, 30),new Taille(20,10),false,null);
	}
	
}
