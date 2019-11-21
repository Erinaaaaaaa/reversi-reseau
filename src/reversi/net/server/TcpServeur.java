package reversi.net.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class TcpServeur
{
    private ServerSocket ss;

    private ArrayList<Gestionnaire> piscine;

    public TcpServeur() throws IOException
    {
        ss = new ServerSocket(57300);
        piscine = new ArrayList<>();
    }

    public void run() throws IOException
    {
        while (true)
        {
            Socket s = ss.accept();
            Gestionnaire gest = new Gestionnaire(s);
            piscine.add(gest);
            new Thread(gest).start();
            System.out.println("[SERV] Nouveau client connecté et ajouté à la piscine");
        }
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);

        new TcpServeur().run();

        String texte = "";

        while (!(texte = sc.nextLine()).equals("exit"))
        {}
    }
}
