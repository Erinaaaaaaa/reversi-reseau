package reversi;

import java.util.ArrayList;
import java.util.Arrays;

public class Partie
{
    private Plateau plateau;
    private ArrayList<Joueur> alJoueurs;

    private int joueurCourant;

    public Partie(ArrayList<Joueur> joueurs)
    {
        this((Joueur[])(joueurs.toArray()));
    }

    public Partie(Joueur[] joueurs)
    {
        this.plateau = Plateau.creer();
        this.alJoueurs = new ArrayList<>();
        this.alJoueurs.addAll(Arrays.asList(joueurs));

        this.joueurCourant = 0;
    }

    private void changerJoueur()
    {
        joueurCourant++;

        if (joueurCourant >= alJoueurs.size())
            joueurCourant = 0;
    }

    public Joueur getJoueurCourant() { return this.alJoueurs.get(this.joueurCourant); }

    public int getNbJoueurs() { return this.alJoueurs.size(); }

    /**
     *
     * @param x Position horizontale, base 0
     * @param y Position verticale, base 0
     * @return Vrai si le coup était valide, faux sinon
     */
    public boolean jouer(int x, int y)
    {
        return false;
    }

    public boolean peutJouer()
    {
        return true;
    }
}
