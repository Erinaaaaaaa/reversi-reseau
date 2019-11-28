package reversi.net.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Gestionnaire implements Runnable
{
    private Socket s;
    private Serveur serv;
    private Groupe grp;

    private String nom;

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
        try
        {
            out.println("Tu tapel coman");
            nom = in.readLine();
            serv.broadcast("<" + nom + " a rejoint la discussion>");

            while (true)
            {
                String input = in.readLine();

                if (input == null)
                {
                    s.close();
                    serv.broadcast("<" + nom + " a quitté la discussion>");
                    return;
                }

                serv.broadcast("[" + nom + "] " + input);
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void println(String text)
    {
        out.println(text);
    }

    public Groupe getGrp()
    {
        return grp;
    }

    public void setGrp(Groupe grp)
    {
        this.grp = grp;
    }
}
