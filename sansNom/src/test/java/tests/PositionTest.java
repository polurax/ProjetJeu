package tests;
import static org.junit.Assert.*;
import org.junit.*;
import metier.*;

public class PositionTest {
	private Position position;
	
	@Before
	public void init() {
		position=new Position(20, 30);
	}
	
	@Test
	public void setXTest() {
		position.setX(40);
		assertEquals(40, position.getX(),0);
	}
	
	@Test
	public void setYTest() {
		position.setY(40);
		assertEquals(40, position.getY(),0);
	}
	
	@Test
	public void versHautTest() {
		position.versHaut(20);
		assertEquals(10, position.getY(),0);
	}
	
	@Test
	public void versBasTest() {
		position.versBas(20);
		assertEquals(50, position.getY(),0);
	}
	
	@Test
	public void versGaucheTest() {
		position.versGauche(20);
		assertEquals(0, position.getX(),0);
	}
	
	@Test
	public void versDroiteTest() {
		position.versDroite(20);
		assertEquals(40, position.getX(),0);
	}
}
