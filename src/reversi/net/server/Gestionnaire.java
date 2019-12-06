package reversi.net.server;

import reversi.metier.Joueur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class Gestionnaire implements Runnable
{
    private Socket s;
    private Serveur serv;
    private Groupe grp;
    private Joueur joueur;

    private BufferedReader in;
    private PrintWriter out;

    public Gestionnaire(Socket s, Serveur serv) throws IOException
    {
        this.s = s;
        this.serv = serv;

        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        out = new PrintWriter(s.getOutputStream(), true);
    }

    public void run()
    {
        while (true)
        {
            try
            {
                String txt = readLine();

                if (txt == null)
                {
                    this.grp.broadcast("12:" + joueur.getNom());
                    System.err.println("Erreur de lecture serveur [" + this.joueur.getNom() + "]");
                    return;
                }

                System.out.print("[GEST");
                if (joueur != null) System.out.print("-" + joueur.getNom());
                System.out.println("-CMD] " + txt);

                String[] cmd = txt.split(":");

                // TODO: Interpréter le NPO comme fin de partie

                switch (cmd[0])
                {
                    // Commande de jeu
                    case "21":
                    {
                        if (this.grp.getJoueurCourant() == this.joueur)
                        {
                            int x = Integer.parseInt(cmd[1]);
                            int y = Integer.parseInt(cmd[2]);
                            if (this.grp.jouer(x, y))
                                this.grp.broadcast("21:" + x + ":" + y);
                        }
                        break;
                    }

                    // Commandes de chat
                    case "31":
                    {
                        String message = txt.split(":", 2)[1];
                        this.grp.addMessage(joueur, message);
                        break;
                    }
                }

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void println(String text)
    {
        out.println(text);
    }

    public String readLine() throws IOException
    {
        try
        {
            return in.readLine();
        } catch (SocketException e)
        {
            return null;
        }
    }

    public Groupe getGrp()
    {
        return grp;
    }

    public void setGrp(Groupe grp)
    {
        this.grp = grp;
    }

    public void setJoueur(Joueur j)
    {
        this.joueur = j;
    }

    public Joueur getJoueur()
    {
        return joueur;
    }
}
