package reversi;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Plateau plateau = Plateau.creer();
        Scanner s = new Scanner(System.in);

        while (true)
        {
            afficher(plateau);
            System.out.print("couleur = "); char c = s.nextLine().charAt(0);

            System.out.println("Peut jouer: " + plateau.peutJouer(c));
        }
    }

    private static void afficher(Plateau p)
    {
        System.out.println("---------------");
        System.out.println(p);
        System.out.println("---------------");
    }
}
