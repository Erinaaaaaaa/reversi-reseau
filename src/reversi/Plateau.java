package reversi;

public class Plateau
{
    private int tailleHorizontale;
    private int tailleVerticale;
    private Jeton[][] tabJetons;

    public Plateau(int x, int y)
    {
        this.tailleHorizontale = x;
        this.tailleVerticale = y;
        this.tabJetons = new Jeton[x][y];
    }

    public int getTailleHorizontale()
    {
        return tailleHorizontale;
    }

    public int getTailleVerticale()
    {
        return tailleVerticale;
    }
}
