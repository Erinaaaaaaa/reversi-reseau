package reversi.metier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Partie
{
    private Plateau plateau;
    private ArrayList<Joueur> alJoueurs;
    private HashMap<Character, Joueur> hmJetonJoueur;

    private int joueurCourant;

    public Partie(Joueur[] joueurs)
    {
        this(Arrays.asList(joueurs));
    }

    public Partie(List<Joueur> joueurs)
    {
        this.alJoueurs = new ArrayList<>(joueurs);
        this.hmJetonJoueur = new HashMap<>();

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
            this.hmJetonJoueur.put((char)('A' + i), j);
        }
    }

    public void joueurSuivant()
    {
        joueurCourant++;

        if (joueurCourant >= alJoueurs.size())
            joueurCourant = 0;
    }

    public Joueur getJoueurCourant() { return this.alJoueurs.get(this.joueurCourant); }

    public Joueur getJoueur(char jeton)
    {
        if (hmJetonJoueur.containsKey(jeton))
            return hmJetonJoueur.get(jeton);

        return null;
    }

    public Joueur[] getJoueurs()
    {
        Joueur[] js = new Joueur[this.alJoueurs.size()];
        this.alJoueurs.toArray(js);

        return js;
    }

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

    public char[][] getPlateau()
    {
        char[][] cases = new char[plateau.getHauteur()][plateau.getLargeur()];

        for (int y = 0; y < plateau.getHauteur(); y++)
            for (int x = 0; x < plateau.getLargeur(); x++)
                cases[y][x] = plateau.getCase(x,y);

        return cases;
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
