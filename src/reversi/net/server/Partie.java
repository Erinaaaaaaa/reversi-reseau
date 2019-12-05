package reversi.net.server;

import com.sun.org.apache.bcel.internal.generic.GETFIELD;
import reversi.metier.Couleur;
import reversi.metier.Joueur;

import java.io.IOException;

public class Partie implements Runnable
{
    private Gestionnaire[] gestionnaires;

    private Joueur[] joueurs;

    public Partie(Gestionnaire... gestionnaires)
    {
        this.gestionnaires = gestionnaires;
        this.joueurs = new Joueur[gestionnaires.length];
    }

    public void run()
    {
        try
        {
            preparerJoueurs();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void broadcast(String text)
    {
        for (Gestionnaire g : gestionnaires)
            g.println(text);
    }

    // GESTION DES APPELS

    private void preparerJoueurs() throws IOException
    {
        StringBuilder sb = new StringBuilder();
        sb.append("1");

        for (int i = 0; i < gestionnaires.length; i++)
        {
            Gestionnaire g = gestionnaires[i];
            joueurs[i] = new Joueur(g.readLine());
            joueurs[i].setJeton((char)('A' + i));
            sb.append(":").append(joueurs[i].getNom()).append(';').append((char)('A' + i));
        }

        broadcast(sb.toString());
    }
}
