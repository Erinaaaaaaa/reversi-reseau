package reversi.metier;

import java.awt.Color;

public enum Couleur
{
    NOIR  (Color.BLACK  ),
    BLANC (Color.WHITE  ),
    ROUGE (Color.RED    ),
    ORANGE(Color.ORANGE ),
    JAUNE (Color.YELLOW ),
    VERT  (Color.GREEN  ),
    BLEU  (Color.BLUE   ),
    ROSE  (Color.MAGENTA);

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
