package reversi.net.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Serveur
{
    private ServerSocket ss;

    private ArrayList<Gestionnaire> poolGestionnaire;
    private ArrayList<Groupe> poolGroupe;

    public Serveur()
    {
        poolGestionnaire = new ArrayList<>();
        poolGroupe = new ArrayList<>();

        try
        {
            ss = new ServerSocket(57300);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void run()
    {
        try
        {
            while (true)
            {
                Socket s = ss.accept();
                System.out.println("[SERV] Nouvelle connexion!");
                Gestionnaire g = new Gestionnaire(s);
                poolGestionnaire.add(g);
                new Thread(g).start();

                if (poolGestionnaire.size() == 4)
                {
                    Groupe grp = new Groupe(poolGestionnaire.get(0),
                            poolGestionnaire.get(1),
                            poolGestionnaire.get(2),
                            poolGestionnaire.get(3));

                    poolGroupe.add(grp);

                    new Thread(grp).start();
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        Serveur s = new Serveur();
        s.run();

        while (true)
        {
            Thread.sleep(500);
        }
    }
}
