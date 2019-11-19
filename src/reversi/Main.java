package reversi;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Joueur[] joueurs = {
                new Joueur("Jeremiidesu"),
                new Joueur("Kyugamii"),
                new Joueur("S4ltyLH"),
                new Joueur("breadman")
        };

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
