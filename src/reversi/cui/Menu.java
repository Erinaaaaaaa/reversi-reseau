package reversi.cui;

import java.util.Scanner;

public class Menu
{
    private static Scanner sc = new Scanner(System.in);

    public String getTexte(String message)
    { return getTexte(message, false); }

    public String getTexte(String message, boolean newLine)
    {
        System.out.print(message);
        return sc.nextLine();
    }
}
