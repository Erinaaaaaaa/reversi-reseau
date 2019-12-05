package reversi.gui;

import reversi.gui.composants.FrameJeu;
import reversi.metier.Joueur;
import reversi.metier.Partie;
import reversi.net.client.Client;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class ControleurReseau implements IControleur
{
    private String nom;

    private FrameJeu ihm;
    private Partie p;

    private Client c;

    public ControleurReseau() throws IOException, InterruptedException
    {
        // Demande de l'adresse
        String[] addr = JOptionPane.showInputDialog(
                null,
                "Adresse du serveur?",
                "Reversi",
                JOptionPane.QUESTION_MESSAGE).split(":", 2);

        String host = "localhost";
        int port = 57300;

        if (addr.length >= 1 && !addr[0].trim().equals(""))
            host = addr[0];

        if (addr.length >= 2)
            port = Integer.parseInt(addr[1]);

        System.out.println("Serveur: " + host + ":" + port);

        // Demande du nom
        String nom = JOptionPane.showInputDialog(null, "Quel est votre nom?", "Reversi", JOptionPane.QUESTION_MESSAGE);

        if (nom != null && !nom.trim().equals(""))
            this.nom = nom;
        else
        {
            System.err.println("Aucun nom choisi, fermeture du programme.");
            System.exit(1);
        }

        this.c = new Client("localhost", 57300);
        c.println(this.nom);
        run();

        GestionnaireIhm tmpIhm = new GestionnaireIhm(this);
        new Thread(tmpIhm).start();
        this.ihm = tmpIhm.getIhm();

        System.out.println();
    }

    private void run() throws IOException, InterruptedException
    {
        System.out.println("Entree dans la boucle de lecture");
        while (true)
        {
            String txt = c.readLine();
            System.out.println("[CMD] " + txt);

            String[] cmd = txt.split(":");

            // GESTION COMMANDES
            switch (cmd[0])
            {
                // INITIALISATION DE PARTIE
                case "11":
                {
                    ArrayList<Joueur> js = new ArrayList<>();

                    for (int i = 1; i < cmd.length; i++)
                    {
                        String[] obj = cmd[i].split(";");
                        Joueur j = new Joueur(obj[0]);
                        j.setJeton(obj[1].charAt(0));
                        js.add(j);
                    }

                    this.p = new Partie(js);

                    GestionnaireIhm tmpIhm = new GestionnaireIhm(this);
                    new Thread(tmpIhm).start();

                    Thread.sleep(1000);

                    this.ihm = tmpIhm.getIhm();
                    break;
                }
                // JOUER
                case "21":
                {
                    int x = Integer.parseInt(cmd[1]);
                    int y = Integer.parseInt(cmd[2]);
                    this.p.jouer(x, y);
                    this.majIHM();
                    break;
                }
            }
        }
    }

    @Override
    public int getLargeurPlateau()
    {
        return this.p.getPlateau()[0].length;
    }

    @Override
    public int getHauteurPlateau()
    {
        return this.p.getPlateau().length;
    }

    @Override
    public char getCasePlateau(int x, int y)
    {
        return this.p.getPlateau()[y][x];
    }

    @Override
    public String getNomJoueur(int i)
    {
        return this.p.getJoueurs()[i].getNom();
    }

    @Override
    public int getNombreJoueurs()
    {
        return this.p.getJoueurs().length;
    }

    @Override
    public int getScoreJoueur(int i)
    {
        return getScoreJoueur(getJoueur(i));
    }

    @Override
    public int getScoreJoueur(Joueur j)
    {
        return this.p.getScore(j);
    }

    @Override
    public Joueur getJoueurCourant()
    {
        return this.p.getJoueurCourant();
    }

    @Override
    public Joueur getJoueur(int i)
    {
        return this.p.getJoueurs()[i];
    }

    @Override
    public Joueur getJoueur(char c)
    {
        return this.p.getJoueur(c);
    }

    @Override
    public Joueur[] getClassement()
    {
        return this.p.getClassement();
    }

    @Override
    public boolean peutJouer()
    {
        return this.p.peutJouer();
    }

    @Override
    public boolean peutJouer(int x, int y)
    {
        return this.p.peutJouer(x,y);
    }

    @Override
    public boolean bloquee()
    {
        return this.p.bloquee();
    }

    @Override
    public void jouer(int x, int y)
    {
        c.println("21:" + x + ":" + y);
    }




    @Override
    public void envoyerMessage(String message)
    {
        System.out.println("Message: " + message);
    }

    @Override
    public String getMessagesChat()
    {
        return "null";
    }

    @Override
    public void majIHM()
    {
        this.ihm.majIHM();
    }

    public static void main(String[] args) throws IOException, InterruptedException
    {
        new ControleurReseau();
    }
}

class GestionnaireIhm implements Runnable
{
    private IControleur c;
    private FrameJeu ihm;

    public GestionnaireIhm(IControleur c)
    {
        this.c = c;
    }

    public FrameJeu getIhm()
    {
        return this.ihm;
    }

    public void run()
    {
        this.ihm = new FrameJeu(this.c);
    }
}