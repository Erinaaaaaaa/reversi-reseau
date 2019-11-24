package reversi.net.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args) throws IOException
    {
        Socket s = new Socket("localhost", 57300);
        Scanner sc = new Scanner(System.in);

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        System.out.println(in.readLine());

        out.println(sc.nextLine());

        new Thread(new Lecteur(in)).start();

        while (true)
            out.println(sc.nextLine());
    }

    private static class Lecteur implements Runnable
    {
        private BufferedReader in;

        Lecteur(BufferedReader br)
        {
            this.in = br;
        }

        public void run()
        {
            while (true)
            {
                try
                {
                    execute(in.readLine());
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
