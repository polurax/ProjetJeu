package metier.vivant;

import java.awt.Color;

import metier.Monde;
import metier.Monstre;
import metier.Position;
import metier.Taille;

public class GrosSlime extends Monstre{

	public GrosSlime(Position position, Monde contenant) {
		super(Color.GREEN, position, new Taille(15, 15), false, contenant, 10, false);
	}
	
}
