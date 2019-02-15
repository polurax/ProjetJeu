package metier.vivant;

import java.awt.Color;

import metier.Monde;
import metier.Monstre;
import metier.Position;
import metier.Taille;

public class Slime extends Monstre{

	public Slime(Position position, Monde contenant) {
		super(Color.GREEN, position, new Taille(10, 10), false, contenant, 10, true);
	}
	
}
