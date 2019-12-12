package reversi.net.client;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
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

        this.in = new BufferedReader(new InputStreamReader(s.getInputStream(), StandardCharsets.UTF_8));
        this.out = new PrintWriter(new OutputStreamWriter(s.getOutputStream(), StandardCharsets.UTF_8), true);
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
