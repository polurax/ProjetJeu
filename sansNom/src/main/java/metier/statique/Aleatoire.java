package metier.statique;

import java.util.Random;

public final class Aleatoire {
	private Aleatoire() {}
	
	public static int gaussSimulation(int min, int max) {
		Random rand=new Random();

		return (int)((rand.nextGaussian()/4*(max-min))+max); 
	}
}
