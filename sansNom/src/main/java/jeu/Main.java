package jeu;

public class Main {

	public static void main(String[] args) {
		Jeu jeu = new Jeu();
		Sequence sequence = new Sequence(jeu);
		while (true) {
			sequence.up();
			jeu.fenetre.getContenu().repaint();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
