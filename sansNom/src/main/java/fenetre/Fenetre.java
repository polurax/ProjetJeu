package fenetre;

import java.awt.Dimension;

import javax.swing.JFrame;

import jeu.Constante;
import jeu.Controleur;
import jeu.Jeu;

@SuppressWarnings("serial")
public class Fenetre extends JFrame {
	private ContenuFenetre contenu;

	public Fenetre(Controleur controleur) {
		this.contenu = new ContenuFenetre(this);
		this.addKeyListener(controleur);
		this.setPreferredSize(new Dimension(Constante.TAILLE_FENETRE_LARGEUR, Constante.TAILLE_FENETRE_HAUTEUR));
		this.setTitle("Jeu sans nom");
		this.setSize(Constante.TAILLE_FENETRE_LARGEUR + 16, Constante.TAILLE_FENETRE_HAUTEUR + 39);
		this.setContentPane(contenu);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}


	public ContenuFenetre getContenu() {
		return contenu;
	}

}
