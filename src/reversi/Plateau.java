package reversi;

public class Plateau
{
    private int largeur;
    private int hauteur;
    // tabJetons[hauteur][largeur]
    private char[][] tabJetons;
    private Joueur j1;
    private Joueur j2;

    private Plateau(int largeur, int hauteur)
    {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.tabJetons = new char[hauteur][largeur];
        this.j1 = new Joueur('N', "Joueur1");
        this.j2 = new Joueur('B', "Joueur2");

        this.tabJetons[hauteur/2-1][largeur/2-1] = 'N';
        this.tabJetons[hauteur/2  ][largeur/2  ] = 'N';

        this.tabJetons[hauteur/2  ][largeur/2-1] = 'B';
        this.tabJetons[hauteur/2-1][largeur/2  ] = 'B';
    }

    public static Plateau creer()
    {
        return creer(8);
    }

    public static Plateau creer(int cote)
    {
        return creer(cote, cote);
    }

    public static Plateau creer(int largeur, int hauteur)
    {
        if (largeur %2 != 0 || largeur < 4)
            return null;

        if (hauteur %2 != 0 || hauteur < 4)
            return null;

        return new Plateau(largeur, hauteur);
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

        valide |= ligneDansCetteDirection(jeton, x, y, 0, -1);  // Nord
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

        if (steps <= 1)
            return false;

        return true;
    }

    public boolean placer(char jeton, int x, int y)
    {
        // Placement invalide
        if (jeton != 'B' && jeton != 'N')
            return false;

        // Placement hors-limite
        if ((x < 0 || x >= largeur) || (y < 0 || y >= hauteur))
            return false;

        // Emplacement non vide
        if (this.tabJetons[y][x] != '\0')
            return false;

        // TODO: Application des règles

        this.tabJetons[y][x] = jeton;
        return true;
    }

    public String getNomJoueur(int i)
    {
        if(i==1)return this.j1.getNom();
        if(i==2)return this.j2.getNom();

        return "Indefini";
    }

    public char getCase(int x, int y)
    {
        return tabJetons[y][x];
    }

    public int getScoreJoueur(int joueur)
    {
        if(joueur == 1)return this.j1.getScore(this);
        if(joueur == 2)return this.j2.getScore(this);

        return 0;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        for (char[] row : tabJetons)
        {
            for (char slot : row)
            {
                if (slot == '\0') sb.append('x');
                else sb.append(slot);
                sb.append(' ');
            }
            sb.append('\n');
        }

        return sb.deleteCharAt(sb.length()-1).toString();
    }
}
