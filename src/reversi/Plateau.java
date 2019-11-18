package reversi;

public class Plateau
{
    private int largeur;
    private int hauteur;
    // tabJetons[hauteur][largeur]
    private char[][] tabJetons;
    private Joueur j1;
    private Joueur j2;

    public Plateau() throws Exception
    {
        this(8);
    }

    public Plateau(int taille) throws Exception
    {
        this(taille, taille);
    }

    // TODO: Utiliser une Factory plutôt que d'utiliser une Exception
    public Plateau(int largeur, int hauteur) throws Exception
    {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.tabJetons = new char[hauteur][largeur];
        this.j1 = new Joueur('N', "Joueur1");
        this.j2 = new Joueur('B', "Joueur2");

        // TODO: réfléchir sur le comportement exact (exception ou +/- 1?)
        if (largeur % 2 != 0)
            throw new Exception("La largeur du plateau doit être paire");

        if (hauteur % 2 != 0)
            throw new Exception("La hauteur du plateau doit être paire");

        this.tabJetons[hauteur/2-1][largeur/2-1] = 'N';
        this.tabJetons[hauteur/2  ][largeur/2  ] = 'N';

        this.tabJetons[hauteur/2  ][largeur/2-1] = 'B';
        this.tabJetons[hauteur/2-1][largeur/2  ] = 'B';


    }

    public int getLargeur() { return this.largeur; }
    public int getHauteur() { return this.hauteur; }

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

        // TODO: vérification dans les 8 directions si le placement est valide ou non

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
