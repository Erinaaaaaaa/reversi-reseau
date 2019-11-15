package reversi;

public class Partie
{
    private Plateau plateau;
    private Joueur joueur1, joueur2;

    public Partie(Plateau p, Joueur j1, Joueur j2)
    {
        this.plateau = p;
        this.joueur1 = j1;
        this.joueur2 = j2;
    }
}
