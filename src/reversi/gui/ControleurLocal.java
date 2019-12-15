package reversi.gui;

import reversi.gui.composants.FrameJeu;
import reversi.metier.Joueur;
import reversi.metier.Partie;

import javax.swing.*;

public class ControleurLocal implements IControleur
{

    private Partie   partie;
    private FrameJeu IHM;
    private Joueur[] joueurs;

    private int joueur;

    String messages = "";

    public ControleurLocal()
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

    @Override
    public String getNomJoueurLocal()
    {
        return null;
    }

    public int    getNombreJoueurs(){return this.partie.getJoueurs().length;}
    public int    getScoreJoueur(int i){
        return this.partie.getScore(this.partie.getJoueurs()[i]);
    }
    public int    getScoreJoueur(Joueur j){
        return this.partie.getScore(j);
    }
    public Joueur getJoueurCourant(){return this.partie.getJoueurCourant();}
    public Joueur getJoueur(int i){return this.partie.getJoueurs()[i];}
    public Joueur getJoueur(char c){return this.partie.getJoueur(c);}

    public Joueur[] getClassement(){return this.partie.getClassement();}


    public boolean peutJouer(){return this.partie.peutJouer();}
    public boolean peutJouer(int x, int y){return this.partie.peutJouer(x,y);}
    public void jouer(int x, int y){
        this.partie.jouer(x, y);
    }

    public boolean bloquee(){return this.partie.bloquee();}


    public void envoyerMessage(String message)
    {
        this.messages += "\n[Abruti] " + message;
    }

    public String getMessagesChat()
    {
        return this.messages;
    }

    public void majIHM() {
        IHM.majIHM();
    }



    public static void main(String[] args) throws Exception {
        new ControleurLocal();
    }


}