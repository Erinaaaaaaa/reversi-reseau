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
            int tmp = i+1;
            this.joueurs[i] = new Joueur("Joueur" + tmp);
        }

        this.partie = new Partie(this.joueurs);

        this.IHM = new FrameJeu(this);
    }



    public int  getLargeurPlateau(){return this.partie.getPlateau()[0].length;}
    public int  getHauteurPlateau(){return this.partie.getPlateau().length;}
    public char getCasePlateau(int x, int y)
    {
        return this.partie.getPlateau()[y][x];
    }

    public String getNomJoueur(int i){return this.partie.getJoueurs()[i].getNom() ;}
    public int    getNombreJoueurs(){return this.partie.getJoueurs().length;}
    public int    getScoreJoueur(int i){
       return this.partie.getScore(this.partie.getJoueurs()[i]);
    }
    public Joueur getJoueurCourant(){return this.partie.getJoueurCourant();}
    public Joueur getJoueur(int i){return this.partie.getJoueurs()[i];}

    public void   joueurSuivant() { this.partie.joueurSuivant();
        System.out.println(this.getJoueurCourant().getNom());}


    public boolean peutJouer(){return this.partie.peutJouer();}
    public boolean jouer(int x, int y){return this.partie.jouer(x,y);}

    public void majIHM() {
        IHM.majIHM();
    }



    public static void main(String[] args) throws Exception {
        new Controleur();
    }


}