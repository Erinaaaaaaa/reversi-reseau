package reversi.metier;

import java.awt.Color;

public enum Couleur
{
    NOIR  (Color.DARK_GRAY),
    VERT  (Color.GREEN    ),
    ROUGE (Color.RED      ),
    ORANGE(Color.BLUE     );

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
