package reversi;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Plateau plateau = Plateau.creer();
        Scanner s = new Scanner(System.in);

        char[] joueurs = {'N', 'B'};

        int joueur = 0;

        while (true)
        {
            afficher(plateau);
            System.out.println("TOUR DU JOUEUR '" + joueurs[joueur] + "'");
            System.out.println("Est-ce que ce joueur peut jouer?: " + plateau.peutJouer(joueurs[joueur]));

            if (!plateau.peutJouer(joueurs[joueur]))
            {
                joueur++;
                if (joueur >= joueurs.length) joueur = 0;
                break;
            }

            System.out.print("x (début à 0) = "); int x = s.nextInt();
            System.out.print("y (début à 0) = "); int y = s.nextInt();

            boolean result = plateau.jouer(joueurs[joueur], x, y);

            System.out.println("Succès du tour: " + result);

            if (result)
            {
                joueur++;
                if (joueur >= joueurs.length) joueur = 0;
            }
        }
        System.out.println("Joueur " + joueurs[joueur] + " gagne!");
    }

    private static void afficher(Plateau p)
    {
        System.out.println("---------------");
        System.out.println(p);
        System.out.println("---------------");
    }
}
