package reversi.gui;

import reversi.metier.Joueur;
import reversi.metier.Partie;
import reversi.metier.Plateau;

import javax.swing.*;

public class Controleur{

    private Partie   partie;
    private FrameJeu IHM;
    private Joueur[] joueurs;

    private int joueur;

    public Controleur()
    {

        // Appel popup nb joueurs
        Choix[] choixNbJoueur = {
                new Choix(2, "2 joueurs"),
                new Choix(4, "4 joueurs")
        };

        int nbJoueursChoisi = ((Choix)(JOptionPane.showInputDialog(null,
                "Veuillez indiquer le nombre de joueurs !",
                "Une partie va commencer !",
                JOptionPane.QUESTION_MESSAGE,
                null,
                choixNbJoueur,
                choixNbJoueur[0]))).getNb();
        JOptionPane.showMessageDialog(null, "Vous avez choisi " + nbJoueursChoisi + " joueurs", "", JOptionPane.INFORMATION_MESSAGE);



        //TODO: appel popup noms joueurs

        this.joueurs = new Joueur[nbJoueursChoisi];

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
    public Joueur getJoueur(char c){return this.partie.getJoueur(c);}

    public Joueur[] getClassement(){return this.partie.getClassement();}

    public void   joueurSuivant() { this.partie.joueurSuivant();
        System.out.println(this.getJoueurCourant().getNom());}


    public boolean peutJouer(){return this.partie.peutJouer();}
    public boolean peutJouer(int x, int y){return this.partie.peutJouer(x,y);}
    public boolean jouer(int x, int y){return this.partie.jouer(x,y);}

    public boolean bloquee(){return this.partie.bloquee();}

    public void majIHM() {
        IHM.majIHM();
    }



    public static void main(String[] args) throws Exception {
        new Controleur();
    }


}