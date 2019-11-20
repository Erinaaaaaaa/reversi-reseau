package reversi;

import java.util.ArrayList;
import java.util.Arrays;

public class Partie
{
    private Plateau plateau;
    private ArrayList<Joueur> alJoueurs;

    private int joueurCourant;

    private boolean pret = false;

    public Partie(ArrayList<Joueur> joueurs)
    {
        this((Joueur[])(joueurs.toArray()));
    }

    public Partie(Joueur[] joueurs)
    {
        this.alJoueurs = new ArrayList<>();
        this.alJoueurs.addAll(Arrays.asList(joueurs));

        this.joueurCourant = 0;

        this.initialiserJoueurs();

        this.plateau = Plateau.creer(alJoueurs);
    }

    private void initialiserJoueurs()
    {
        for (int i = 0; i < alJoueurs.size(); i++)
        {
            Joueur j = alJoueurs.get(i);
            j.setJeton((char)('A' + i));
            j.setCouleur(Couleur.values()[i]);
        }
    }

    public void joueurSuivant()
    {
        joueurCourant++;

        if (joueurCourant >= alJoueurs.size())
            joueurCourant = 0;
    }

    public Joueur getJoueurCourant() { return this.alJoueurs.get(this.joueurCourant); }

    public int getNbJoueurs() { return this.alJoueurs.size(); }

    public boolean jouer(int x, int y)
    {
        boolean result = plateau.jouer(this.getJoueurCourant().getJeton(), x, y);

        if (result) joueurSuivant();

        return result;
    }

    public boolean peutJouer()
    {
        return this.plateau.peutJouer(this.getJoueurCourant().getJeton());
    }

    public boolean bloquee()
    {
        for (Joueur j : alJoueurs)
        {
            if (plateau.peutJouer(j.getJeton()))
                return false;
        }
        return true;
    }

    public int getScore(Joueur j)
    {
        if (!alJoueurs.contains(j))
            return 0;

        return plateau.getScore(j.getJeton());
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append(this.plateau.toString());

        for (Joueur j : alJoueurs)
        {
            sb.append(String.format("\n%-20s (%c): %2d",
                    j.getNom(), j.getJeton(), getScore(j)));
        }

        return sb.toString();
    }
}
