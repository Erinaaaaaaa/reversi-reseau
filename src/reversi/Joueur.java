package reversi;

public class Joueur
{
    int couleur;
    String nom;

    public Joueur(int c, String nom)
    {
        this.couleur = c;
        this.nom = nom;
    }

    public int getCouleur()
    {
        return couleur;
    }

    public String getNom()
    {
        return nom;
    }
}
