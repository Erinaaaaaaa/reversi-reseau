package reversi.net.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Gestionnaire
{
    private Socket s;
    private Serveur serv;
    private Groupe grp;

    private int loops = 0;

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

    public void println(String text)
    {
        out.println(text);
    }

    public String readLine() throws IOException
    { return in.readLine(); }

    public Groupe getGrp()
    {
        return grp;
    }

    public void setGrp(Groupe grp)
    {
        this.grp = grp;
    }
}
