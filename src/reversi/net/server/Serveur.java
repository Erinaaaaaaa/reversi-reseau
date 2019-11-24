package reversi.net.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Serveur
{
    private ServerSocket ss;

    private ArrayList<Gestionnaire> pool;

    public Serveur()
    {
        pool = new ArrayList<>();

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
                pool.add(g);
                new Thread(g).start();
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
