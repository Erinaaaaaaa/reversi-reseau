package reversi;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Plateau plateau = new Plateau();
        Scanner s = new Scanner(System.in);

        while (true)
        {
            afficher(plateau);
            System.out.print("x = "); int x = s.nextInt();
            System.out.print("y = "); int y = s.nextInt();

            System.out.println("Placé: " + plateau.placer('B', x, y));
        }
    }

    private static void afficher(Plateau p)
    {
        System.out.println("---------------");
        System.out.println(p);
        System.out.println("---------------");
    }
}
