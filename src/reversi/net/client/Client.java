package reversi.net.client;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
    private Socket s;
    private BufferedReader in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException
    {
        Socket s = new Socket("localhost", 57300);
        Client c = new Client(s);
        Scanner sc = new Scanner(System.in);

        System.out.println(c.readLine());

        c.println(sc.nextLine());

        new Thread(new Lecteur(c)).start();

        while (true)
            c.println(sc.nextLine());
    }

    public Client(Socket s) throws IOException
    {
        this.s = s;
        this.in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        this.out= new PrintWriter(s.getOutputStream(), true);
    }

    public void println(String text)
    {
        out.println(text);
    }

    public String readLine() throws IOException
    {
        return in.readLine();
    }

    private static class Lecteur implements Runnable
    {
        private Client c;

        Lecteur(Client c)
        {
            this.c = c;
        }

        public void run()
        {
            while (true)
            {
                try
                {
                    execute(c.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }

        private void execute(String s)
        {
            System.out.println(s);
        }
    }
}
