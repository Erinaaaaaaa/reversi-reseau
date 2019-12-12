package reversi.net.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Serveur implements Runnable
{
    public static void main(String[] args) throws IOException
    {
        if (args.length == 1)
        {
            switch (args[0])
            {
                case "2":
                    new Thread(new Serveur(2)).start();
                    break;
                case "4":
                    new Thread(new Serveur(4)).start();
                    break;
                default:
                    System.err.println("Paramètre invalide");
                    break;
            }
        }
        else
        {
            new Thread(new Serveur(2)).start();
        }
    }

    private ServerSocket ss;
    private int nbPlayers;

    private ArrayList<Gestionnaire> alGestAttente;

    public Serveur(int nbPlayers) throws IOException
    {
        this.ss = new ServerSocket(9001);
        this.nbPlayers = nbPlayers;
        this.alGestAttente = new ArrayList<>();
    }

    public void run()
    {
        try
        {
            System.out.println("Ecoute...");
            while (true)
            {
                Socket s = ss.accept();
                System.out.println("Connexion acceptée");
                Gestionnaire g = new Gestionnaire(s, this);
                this.alGestAttente.add(g);
                if (alGestAttente.size() == nbPlayers)
                {
                    Gestionnaire[] gests = new Gestionnaire[nbPlayers];

                    for (int i = 0; i < nbPlayers; i++)
                        gests[i] = alGestAttente.get(i);

                    for (Gestionnaire tmp : gests)
                        alGestAttente.remove(tmp);

                    Groupe grp = new Groupe(gests);

                    new Thread(grp).start();
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void broadcast(String text)
    {
        for (Gestionnaire g : alGestAttente)
        {
            g.println(text);
        }
    }
}
