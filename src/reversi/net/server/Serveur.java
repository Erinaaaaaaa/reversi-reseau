package reversi.net.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Serveur
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        new Serveur().run();
        while (true)
        {
            Thread.sleep(500);
        }
    }

    private ServerSocket ss;

    private ArrayList<Gestionnaire> alGest;
    private ArrayList<Thread> alThread;

    public Serveur() throws IOException
    {
        this.ss = new ServerSocket(57300);

        this.alGest = new ArrayList<>();
        this.alThread = new ArrayList<>();
    }

    public void run() throws IOException
    {
        System.out.println("Ecoute...");
        while (true)
        {
            Socket s = ss.accept();
            System.out.println("Connexion acceptée");
            Gestionnaire g = new Gestionnaire(s, this);
            if (alGest.size() == 2)
            {

            }
        }
    }

    public void broadcast(String text)
    {
        for (Gestionnaire g : alGest)
        {
            g.println(text);
        }
    }
}
