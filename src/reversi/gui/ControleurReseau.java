package reversi.gui;

import reversi.gui.composants.FrameJeu;
import reversi.metier.Couleur;
import reversi.metier.Joueur;
import reversi.net.client.Client;

import javax.swing.*;
import java.io.IOException;

public class ControleurReseau implements IControleur
{
    private String nom;

    private FrameJeu ihm;

    private Client c;

    // Attrs temporaires
    private Joueur[] joueurs = {
            new Joueur("sdfsdfs"),
            new Joueur("dfsdfsdf")
    };

    public ControleurReseau() throws IOException
    {
        // Init temporaire
        this.joueurs[0].setCouleur(Couleur.NOIR);
        this.joueurs[1].setCouleur(Couleur.VERT);

        // Demande du nom
        // String nom = JOptionPane.showInputDialog(null, "Quel est votre nom?", "Reversi", JOptionPane.QUESTION_MESSAGE);

        // if (nom != null && !nom.trim().equals(""))
        //     this.nom = nom;
        // else
        // {
        //     System.err.println("Aucun nom choisi, fermeture du programme.");
        //     System.exit(1);
        // }

        this.nom = "nword";

        this.c = new Client("localhost", 57300);
        c.println(this.nom);
        run();

        GestionnaireIhm tmpIhm = new GestionnaireIhm(this);
        new Thread(tmpIhm).start();
        this.ihm = tmpIhm.getIhm();

        System.out.println();
    }

    private void run() throws IOException
    {
        System.out.println("Entree dans run()");
        while (true)
        {
            String txt = c.readLine();
            System.out.println(txt);
        }
    }

    @Override
    public int getLargeurPlateau()
    {
        return 2;
    }

    @Override
    public int getHauteurPlateau()
    {
        return 2;
    }

    @Override
    public char getCasePlateau(int x, int y)
    {
        return 'A';
    }

    @Override
    public String getNomJoueur(int i)
    {
        return "null";
    }

    @Override
    public int getNombreJoueurs()
    {
        return 2;
    }

    @Override
    public int getScoreJoueur(int i)
    {
        return 2;
    }

    @Override
    public int getScoreJoueur(Joueur j)
    {
        return 3;
    }

    @Override
    public Joueur getJoueurCourant()
    {
        return joueurs[0];
    }

    @Override
    public Joueur getJoueur(int i)
    {
        return joueurs[i];
    }

    @Override
    public Joueur getJoueur(char c)
    {
        return joueurs[0];
    }

    @Override
    public Joueur[] getClassement()
    {
        return joueurs;
    }

    @Override
    public boolean peutJouer()
    {
        return false;
    }

    @Override
    public boolean peutJouer(int x, int y)
    {
        return false;
    }

    @Override
    public boolean jouer(int x, int y)
    {
        return false;
    }

    @Override
    public boolean bloquee()
    {
        return true;
    }

    @Override
    public void envoyerMessage(String message)
    {
        System.out.println("Message: " + message);
    }

    @Override
    public String getMessagesChat()
    {
        return "null";
    }

    @Override
    public void majIHM()
    {

    }

    public static void main(String[] args) throws IOException
    {
        new ControleurReseau();
    }
}

class GestionnaireIhm implements Runnable
{
    private IControleur c;
    private FrameJeu ihm;

    public GestionnaireIhm(IControleur c)
    {
        this.c = c;
    }

    public FrameJeu getIhm()
    {
        return this.ihm;
    }

    public void run()
    {
        this.ihm = new FrameJeu(this.c);
    }
}