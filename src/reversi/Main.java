package reversi;

import reversi.metier.Joueur;
import reversi.metier.Partie;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre de joueurs (2 ou 4): ");
        int nbJ = -1;

        while (nbJ != 2 && nbJ != 4)
        {
            nbJ = sc.nextInt();
        }

        ArrayList<Joueur> joueurs = new ArrayList<>();

        joueurs.add(new Joueur("Joueur 1"));
        joueurs.add(new Joueur("Joueur 2"));

        if (nbJ == 4)
        {
            joueurs.add(new Joueur("Joueur 3"));
            joueurs.add(new Joueur("Joueur 4"));
        }

        Partie p = new Partie(joueurs);

        while (!p.bloquee())
        {
            System.out.println(p);

            boolean peutJouer = p.peutJouer();

            Joueur j = p.getJoueurCourant();

            System.out.println("Joueur actuel: " + j.getNom() + " (" + j.getJeton() + ")");
            System.out.println("Le joueur actuel peut jouer: " + peutJouer);

            if (!peutJouer)
            {
                p.joueurSuivant();
                continue;
            }

            System.out.print("Position X (base 0): "); int x = sc.nextInt();
            System.out.print("Position Y (base 0): "); int y = sc.nextInt();

            boolean result = p.jouer(x, y);

            System.out.println("Résultat du coup: " + result);
        }

        System.out.println(p);
    }
}
