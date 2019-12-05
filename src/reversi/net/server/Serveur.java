package reversi.net.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Serveur implements Runnable
{
    public static void main(String[] args) throws IOException
    {
        new Thread(new Serveur()).start();
    }

    private ServerSocket ss;

    private ArrayList<Gestionnaire> alGestAttente;

    public Serveur() throws IOException
    {
        this.ss = new ServerSocket(57300);

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
                if (alGestAttente.size() == 2)
                {
                    Gestionnaire[] gests = new Gestionnaire[]
                            {
                                    alGestAttente.get(0),
                                    alGestAttente.get(1)
                            };

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
