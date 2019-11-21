package reversi.gui;

import reversi.metier.Joueur;
import reversi.metier.Partie;
import reversi.metier.Plateau;

public class Controleur{

    private Partie   partie;
    private FrameJeu IHM;
    private Joueur[] joueurs;

    private int joueur;

    public Controleur()
    {

        this.joueurs = new Joueur[4];

        //Initialisation des joueurs
        for(int i = 0; i<this.joueurs.length; i++)
        {
            this.joueurs[i] = new Joueur("Joueur" + i);
        }

        this.partie = new Partie(this.joueurs);

        this.IHM = new FrameJeu(this);
    }

    public String getNomJoueur(int i){return this.partie.getJoueurs()[i].getNom() ;}

    public int getNombreJoueurs(){return this.partie.getJoueurs().length;}

    public int getLargeurPlateau(){return this.partie.getPlateau()[0].length;}
    public int getHauteurPlateau(){return this.partie.getPlateau().length;}
    public char getCasePlateau(int x, int y)
    {
        return this.partie.getPlateau()[y][x];
    }
    public int getScoreJoueur(int i){
       return this.partie.getScore(this.partie.getJoueurs()[i]);
    }

    /*public boolean jouer(int x, int y)
    {
        // Appeler le jeu

        // Changement de joueur
        joueur = 3 - joueur;

        return true;
    }*/

    public static void main(String[] args) throws Exception {
        new Controleur();
    }
}