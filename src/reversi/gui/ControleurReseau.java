package reversi.gui;

import reversi.metier.Joueur;

import javax.swing.*;

public class ControleurReseau implements IControleur
{
    private String nom;

    public ControleurReseau()
    {
        String nom = JOptionPane.showInputDialog(null, "Quel est votre nom?", "Reversi", JOptionPane.QUESTION_MESSAGE);

        if (nom != null && !nom.trim().equals(""))
            this.nom = nom;
        else
            System.out.println("No");
    }

    @Override
    public int getLargeurPlateau()
    {
        return 0;
    }

    @Override
    public int getHauteurPlateau()
    {
        return 0;
    }

    @Override
    public char getCasePlateau(int x, int y)
    {
        return 0;
    }

    @Override
    public String getNomJoueur(int i)
    {
        return null;
    }

    @Override
    public int getNombreJoueurs()
    {
        return 0;
    }

    @Override
    public int getScoreJoueur(int i)
    {
        return 0;
    }

    @Override
    public int getScoreJoueur(Joueur j)
    {
        return 0;
    }

    @Override
    public Joueur getJoueurCourant()
    {
        return null;
    }

    @Override
    public Joueur getJoueur(int i)
    {
        return null;
    }

    @Override
    public Joueur getJoueur(char c)
    {
        return null;
    }

    @Override
    public Joueur[] getClassement()
    {
        return new Joueur[0];
    }

    @Override
    public void joueurSuivant()
    {

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
        return false;
    }

    @Override
    public void majIHM()
    {

    }

    public static void main(String[] args)
    {
        new ControleurReseau();
    }
}
