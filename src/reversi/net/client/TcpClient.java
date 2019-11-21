package reversi.net.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient
{
    private Socket socket;

    private BufferedReader in;
    private PrintWriter out;

    public TcpClient() throws IOException
    {
        socket = new Socket("localhost", 57300);

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream());
    }

    private void writeLine(String s)
    {
        out.println(s);
    }

    private boolean vivant()
    {
        return !socket.isInputShutdown();
    }

    public String readLine() throws IOException
    {
        return in.readLine();
    }

    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        TcpClient client = new TcpClient();

        // System.out.println(client.readLine());

        client.writeLine(sc.nextLine());

        System.out.println(client.readLine());
    }


}
