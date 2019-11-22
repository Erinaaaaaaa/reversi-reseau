package reversi.net.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client
{
    public static void main(String[] args) throws IOException
    {
        Socket s = new Socket("localhost", 57300);

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        while (s.isConnected())
        {
            System.out.print((char)(in.read()));
        }
    }
}
