package reversi.net.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Gestionnaire implements Runnable
{
    private Socket s;

    private BufferedReader in;
    private PrintWriter out;

    public Gestionnaire(Socket s) throws IOException
    {
        this.s = s;

        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        out = new PrintWriter(s.getOutputStream(), true);
    }

    public void run()
    {
        System.out.println("[GEST] Exécution du gestionnaire");
        try
        {
            out.println("Quel est votre nom?");
            String str = in.readLine();
            System.out.println("[GEST] Connexion identifiée: " + str);
            out.println("Bienvenue " + str);
            s.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("[GEST] Fin exécution du gestionnaire");
    }
}
