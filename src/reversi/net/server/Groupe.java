package reversi.net.server;

import reversi.metier.Joueur;
import reversi.metier.Partie;

import java.io.IOException;

public class Groupe implements Runnable
{
    private Gestionnaire[] gestionnaires;

    private Joueur[] joueurs;
    private Partie partie;

    public Groupe(Gestionnaire... gestionnaires)
    {
        this.gestionnaires = gestionnaires;
        this.joueurs = new Joueur[gestionnaires.length];
    }

    public void run()
    {
        try
        {
            preparerJoueurs();
            preparerPartie();
            envoyerInfosPartie();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void envoyerInfosPartie()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("11");

        for (Joueur j : joueurs)
        {
            sb.append(":")
                    .append(j.getNom())
                    .append(";")
                    .append(j.getJeton());
        }

        broadcast(sb.toString());
    }

    private void preparerPartie()
    {
        this.partie = new Partie(this.joueurs);
    }

    public void broadcast(String text)
    {
        for (Gestionnaire g : gestionnaires)
            g.println(text);
    }

    // GESTION DES APPELS

    private void preparerJoueurs() throws IOException
    {
        for (int i = 0; i < gestionnaires.length; i++)
        {
            Gestionnaire g = gestionnaires[i];
            joueurs[i] = new Joueur(g.readLine());
        }
    }
}
