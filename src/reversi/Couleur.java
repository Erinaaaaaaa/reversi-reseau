package reversi;

public enum Couleur
{
    NOIR  ("Noir"),
    BLANC ("Blanc"),
    ROUGE ("Rouge"),
    ORANGE("Orange"),
    JAUNE ("Jaune"),
    VERT  ("Vert"),
    BLEU  ("Bleu"),
    VIOLET("Violet");

    private String couleur;

    Couleur(String couleur)
    {
        this.couleur = couleur;
    }

    public String getCouleur()
    {
        return couleur;
    }
}
