package reversi.net.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Gestionnaire implements Runnable
{
    private Socket socket;

    private BufferedReader in;
    private PrintWriter out;

    public Gestionnaire(Socket s) throws IOException
    {
        this.socket = s;

        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream());
    }


    public void run()
    {
        System.out.println("[GEST] Exécution du gestionnaire sur connexion entrante");

        // out.println("Bonjour! Quel est votre nom?");

        try
        {
            String s = in.readLine();

            System.out.println("[GEST] Nouvelle connexion: " + s);

            out.println("Bienvenue " + s);

            socket.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
