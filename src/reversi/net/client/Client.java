package reversi.net.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Client
{
    private Socket s;

    private BufferedReader in;
    private PrintWriter out;

    public Client(String host, int port) throws IOException
    {
        this(new Socket(host, port));
    }

    public Client(Socket s) throws IOException
    {
        this.s = s;

        this.in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        this.out = new PrintWriter(s.getOutputStream(), true);
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
        }
        catch (SocketException e)
        {
            System.err.println("Erreur de lecture client!!!!!!");
            return null;
        }
    }
}
