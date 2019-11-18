package reversi;

public class Joueur
{
    char couleur;
    String nom;

    public Joueur(char c, String nom)
    {
        this.couleur = c;
        this.nom = nom;
    }

    public char getCouleur()
    {
        return couleur;
    }

    public String getNom()
    {
        return nom;
    }

    public int getScore(Plateau p)
    {
        int score = 0;

        for(int cpt1=0; cpt1<p.getHauteur(); cpt1++)
            for(int cpt2=0; cpt2<p.getLargeur(); cpt2++)
                if(p.getCase(cpt1,cpt2)==this.couleur) score++;


        return score;
    }
}
