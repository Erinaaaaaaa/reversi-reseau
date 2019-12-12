package reversi.metier;

import java.awt.Color;

public enum Couleur
{
    NOIR  (Color.DARK_GRAY),
    VERT  (new Color(101, 193, 81)    ),
    ROUGE (new Color(255, 58, 51)      ),
    BLEU(new Color(85, 189, 255)     );

    private Color couleur;

    Couleur(Color couleur)
    {
        this.couleur = couleur;
    }

    public Color getCouleur()
    {
        return couleur;
    }
}
