package fenetre;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import jeu.Constante;
import jeu.Jeu;
import metier.Decor;
import metier.Entite;
import metier.Joueur;
import metier.Monstre;
import metier.Position;
import metier.Projectile;
import metier.statique.Bords;

@SuppressWarnings("serial")
public class ContenuFenetre extends JPanel {
	private final Fenetre CONTENANT;

	public ContenuFenetre(Fenetre contenant) {
		this.CONTENANT = contenant;
	}

	public void paintComponent(Graphics g) {
		Joueur joueur=Jeu.monde.getJoueur();
		ArrayList<Decor> decors=Jeu.monde.getDecorListe();
		ArrayList<Monstre> monstres=Jeu.monde.getMonstreListe();
		ArrayList<Projectile> projectiles=Jeu.monde.getProjectileListe();

		dessineFond(g, joueur.getPosition());
		
		dessineDecors(g, decors);
		
		dessineVivant(g, monstres);
		
		dessineBarreVieMontre(g, monstres);

		dessineJoueur(g, joueur);
		
		dessineProjectile(g, projectiles);

		dessineBarreVieJoueur(g, joueur);
		
	}

	private void dessineBarreVieJoueur(Graphics g, Joueur joueur) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, 150, 20);
		g.setColor(Color.RED);
		g.fillRect(0, 0, joueur.getVies() * 150
				/ joueur.getVieMax(), 20);
	}

	private void dessineJoueur(Graphics g, Joueur joueur) {
		g.setColor(joueur.getCouleur());
		g.fillRect(Constante.TAILLE_FENETRE_LARGEUR / 2 - Constante.TAILLE_JOUEUR_LARGEUR / 2,
				Constante.TAILLE_FENETRE_HAUTEUR / 2 - Constante.TAILLE_JOUEUR_HAUTEUR / 2,
				joueur.getTaille().getLargeur(),
				joueur.getTaille().getHauteur());
		g.setColor(Color.BLACK);
		switch (joueur.getOrientation()) {
		case 'H':
			g.fillRect(Constante.TAILLE_FENETRE_LARGEUR / 2 - 2,
					Constante.TAILLE_FENETRE_HAUTEUR / 2 - Constante.TAILLE_JOUEUR_HAUTEUR / 2, 4, 2);
			break;
		case 'B':
			g.fillRect(Constante.TAILLE_FENETRE_LARGEUR / 2 - 2,
					Constante.TAILLE_FENETRE_HAUTEUR / 2 + Constante.TAILLE_JOUEUR_HAUTEUR / 2 - 2, 4, 2);
			break;
		case 'G':
			g.fillRect(Constante.TAILLE_FENETRE_LARGEUR / 2 - Constante.TAILLE_JOUEUR_LARGEUR / 2,
					Constante.TAILLE_FENETRE_HAUTEUR / 2 - 2, 2, 4);
			break;
		case 'D':
			g.fillRect(Constante.TAILLE_FENETRE_LARGEUR / 2 + Constante.TAILLE_JOUEUR_LARGEUR / 2 - 2,
					Constante.TAILLE_FENETRE_HAUTEUR / 2 - 2, 2, 4);
			break;
		}
	}

	private void dessineBarreVieMontre(Graphics g, ArrayList<Monstre> monstres) {
		for (Monstre monstre : monstres) {
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(this.getPositionPlacementX(monstre),
					this.getPositionPlacementY(monstre) - 5, 20, 2);
			g.setColor(Color.RED);
			g.fillRect(this.getPositionPlacementX(monstre),
					this.getPositionPlacementY(monstre) - 5,
					monstre.getVies() * 20
							/ monstre.getVieMax(),
					2);
		}
	}

	private void dessineVivant(Graphics g, ArrayList<Monstre> monstres) {
		for (Monstre monstre : monstres) {
			g.setColor(monstre.getCouleur());
			g.fillRect(this.getPositionPlacementX(monstre),
					this.getPositionPlacementY(monstre),
					monstre.getTaille().getLargeur(),
					monstre.getTaille().getHauteur());
		}
	}

	private void dessineDecors(Graphics g, ArrayList<Decor> decors) {
		for (Decor decor : decors) {
			g.setColor(decor.getCouleur());
			g.fillRect(this.getPositionPlacementX(decor),
					this.getPositionPlacementY(decor),
					decor.getTaille().getLargeur(),
					decor.getTaille().getHauteur());
		}
	}
	
	private void dessineProjectile(Graphics g, ArrayList<Projectile> projectiles) {
		for (Projectile projectile : projectiles) {
			g.setColor(projectile.getCouleur());
			g.fillRect(this.getPositionPlacementX(projectile),
					this.getPositionPlacementY(projectile),
					projectile.getTaille().getLargeur(),
					projectile.getTaille().getHauteur());
		}
	}
	
	private void dessineFond(Graphics g, Position positionJoueur) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, Constante.TAILLE_FENETRE_LARGEUR, Constante.TAILLE_FENETRE_HAUTEUR);
		BufferedImage image;
		try {
			image = ImageIO.read(new File(".\\src\\textures\\caseFond.png"));
			g.setColor(Color.BLACK);
			int x=1-Constante.TAILLE_CASES_SOL;
			int y;
			while(x<Constante.TAILLE_FENETRE_LARGEUR+Constante.TAILLE_CASES_SOL) {
				y=1-Constante.TAILLE_CASES_SOL;
				while(y<Constante.TAILLE_FENETRE_HAUTEUR+Constante.TAILLE_CASES_SOL) {
					g.drawImage(image, x - positionJoueur.getIntX()% Constante.TAILLE_CASES_SOL, y - positionJoueur.getIntY() % Constante.TAILLE_CASES_SOL, Constante.TAILLE_CASES_SOL, Constante.TAILLE_CASES_SOL,null);
					y+=Constante.TAILLE_CASES_SOL;
				}
				x+=Constante.TAILLE_CASES_SOL;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private int getPositionPlacementX(Entite entite) {
		return Bords.getBordGauche(entite) + Constante.TAILLE_FENETRE_LARGEUR / 2
				- Jeu.monde.getJoueur().getPosition().getIntX();
	}

	private int getPositionPlacementY(Entite entite) {
		return Bords.getBordHaut(entite) + Constante.TAILLE_FENETRE_HAUTEUR / 2
				- Jeu.monde.getJoueur().getPosition().getIntY();
	}
}
