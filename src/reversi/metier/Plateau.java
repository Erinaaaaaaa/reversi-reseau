package reversi.metier;

import java.util.ArrayList;

public class Plateau
{
    private int largeur;
    private int hauteur;
    // tabJetons[hauteur][largeur]
    private char[][] tabJetons;

    private Plateau(int largeur, int hauteur, ArrayList<Joueur> joueurs)
    {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.tabJetons = new char[hauteur][largeur];

        // TODO: Situations de départ

        switch (joueurs.size())
        {
            case 2:
            {
                this.tabJetons[hauteur/2-1][largeur/2-1] = joueurs.get(0).getJeton();
                this.tabJetons[hauteur/2-1][largeur/2  ] = joueurs.get(1).getJeton();
                this.tabJetons[hauteur/2  ][largeur/2-1] = joueurs.get(1).getJeton();
                this.tabJetons[hauteur/2  ][largeur/2  ] = joueurs.get(0).getJeton();
                break;
            }
            case 4:
            {
                int a = largeur/2;
                int b = hauteur/2;

                /*
                      a
                    C D
                  C A B D
                b B D C A
                    B A
                 */
                this.tabJetons[b-2][a-1] = joueurs.get(2).getJeton();
                this.tabJetons[b-2][a  ] = joueurs.get(3).getJeton();

                this.tabJetons[b-1][a-2] = joueurs.get(3).getJeton();
                this.tabJetons[b-1][a-1] = joueurs.get(0).getJeton();
                this.tabJetons[b-1][a  ] = joueurs.get(1).getJeton();
                this.tabJetons[b-1][a+1] = joueurs.get(2).getJeton();

                this.tabJetons[b  ][a-2] = joueurs.get(1).getJeton();
                this.tabJetons[b  ][a-1] = joueurs.get(3).getJeton();
                this.tabJetons[b  ][a  ] = joueurs.get(2).getJeton();
                this.tabJetons[b  ][a+1] = joueurs.get(0).getJeton();

                this.tabJetons[b+1][a-1] = joueurs.get(1).getJeton();
                this.tabJetons[b+1][a  ] = joueurs.get(0).getJeton();

                break;
            }
        }
    }

    public static Plateau creer(ArrayList<Joueur> joueurs)
    {
        switch (joueurs.size())
        {
            case 2: return creer(8, joueurs);
            case 3: return creer(10, joueurs);
            case 4: return creer(12, joueurs);
            default: return null;
        }

    }

    public static Plateau creer(int cote, ArrayList<Joueur> joueurs)
    {
        return creer(cote, cote, joueurs);
    }

    public static Plateau creer(int largeur, int hauteur, ArrayList<Joueur> joueurs)
    {
        if (largeur %2 != 0 || largeur < 4)
            return null;

        if (hauteur %2 != 0 || hauteur < 4)
            return null;

        if (joueurs.size() != 2 && joueurs.size() != 4)
            return null;

        return new Plateau(largeur, hauteur, joueurs);
    }

    public int getLargeur() { return this.largeur; }
    public int getHauteur() { return this.hauteur; }

    public boolean peutJouer(char jeton)
    {
        for (int i = 0; i < this.largeur; i++)
        for (int j = 0; j < this.hauteur; j++)
        {
            if (peutPlacer(jeton, i, j))
                return true;
        }
        return false;
    }

    // Méthode d'application des règles
    private boolean peutPlacer(char jeton, int x, int y)
    {
        if (this.tabJetons[y][x] != '\0')
            return false;

        // ordre des directions
        // N, NE, E, SE, S, SO, O, NO
        boolean valide = false;

        valide |= ligneDansCetteDirection(jeton, x, y,  0, -1);  // Nord
        valide |= ligneDansCetteDirection(jeton, x, y,  1, -1);  // Nord-est
        valide |= ligneDansCetteDirection(jeton, x, y,  1,  0);  // Est
        valide |= ligneDansCetteDirection(jeton, x, y,  1,  1);  // Sud-est
        valide |= ligneDansCetteDirection(jeton, x, y,  0,  1);  // Sud
        valide |= ligneDansCetteDirection(jeton, x, y, -1,  1);  // Sud-ouest
        valide |= ligneDansCetteDirection(jeton, x, y, -1,  0);  // Ouest
        valide |= ligneDansCetteDirection(jeton, x, y, -1, -1);  // Nord-ouest

        return valide;
    }

    private boolean ligneDansCetteDirection(char jeton, int x, int y, int deltaX, int deltaY)
    {
        int localX = x,
            localY = y;
        int steps = 0;

        while (localX >= 0 && localX < largeur && localY >= 0 && localY < hauteur)
        {
            localX += deltaX;
            localY += deltaY;
            steps++;

            if (localX < 0 || localX >= largeur || localY < 0 || localY >= hauteur)
                return false;

            char localJeton = tabJetons[localY][localX];

            if (localJeton == '\0')
                return false;

            if (localJeton == jeton)
                break;
        }

        return steps > 1;
    }

    public boolean jouer(char jeton, int x, int y)
    {
        // Placement hors-limite
        if ((x < 0 || x >= largeur) || (y < 0 || y >= hauteur))
            return false;

        // Emplacement non vide
        if (this.tabJetons[y][x] != '\0')
            return false;

        // Emplacement valide
        if (peutPlacer(jeton, x, y))
        {
            placer(jeton, x, y);
            return true;
        }

        return false;
    }

    private void placer(char jeton, int x, int y)
    {
        if (ligneDansCetteDirection(jeton, x, y,  0, -1))
            traiterLigne(jeton, x ,y,   0, -1);
        if (ligneDansCetteDirection(jeton, x, y,  1, -1))
            traiterLigne(jeton, x ,y,   1, -1);
        if (ligneDansCetteDirection(jeton, x, y,  1,  0))
            traiterLigne(jeton, x ,y,   1,  0);
        if (ligneDansCetteDirection(jeton, x, y,  1,  1))
            traiterLigne(jeton, x ,y,   1,  1);
        if (ligneDansCetteDirection(jeton, x, y,  0,  1))
            traiterLigne(jeton, x ,y,   0,  1);
        if (ligneDansCetteDirection(jeton, x, y, -1,  1))
            traiterLigne(jeton, x ,y,  -1,  1);
        if (ligneDansCetteDirection(jeton, x, y, -1,  0))
            traiterLigne(jeton, x ,y,  -1,  0);
        if (ligneDansCetteDirection(jeton, x, y, -1, -1))
            traiterLigne(jeton, x ,y,  -1, -1);
    }

    private void traiterLigne(char jeton, int x, int y, int deltaX, int deltaY)
    {
        int localX = x,
            localY = y;

        do
        {
            tabJetons[localY][localX] = jeton;
            localX+=deltaX;
            localY+=deltaY;
        } while (tabJetons[localY][localX] != jeton);
    }

    public char getCase(int x, int y)
    {
        return tabJetons[y][x];
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        for (char slot : tabJetons[0])
        {
            sb.append("+---");
        }
        sb.append("+\n");

        for (char[] row : tabJetons)
        {
            sb.append("|");
            for (char slot : row)
            {

                if (slot == '\0') sb.append("   |");
                else sb.append(" ").append(slot).append(" |");
            }
            sb.append("\n");

            for (char slot : row)
            {
                sb.append("+---");
            }
            sb.append("+\n");
        }

        return sb.deleteCharAt(sb.length()-1).toString();
    }

    public int getScore(char jeton)
    {
        int i = 0;

        for (char[] row : tabJetons)
            for (char slot : row)
                if (slot == jeton)
                    i++;

        return i;
    }
}