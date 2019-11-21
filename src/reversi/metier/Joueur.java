package reversi.metier;

public class Joueur
{
    private String  nom;

    // Ces attributs sont définis à la création de partie
    private char    jeton;
    private Couleur couleur;

    public Joueur(String nom)
    {
        this.nom = nom;
    }

    public String getNom() { return this.nom; }

    public char getJeton() { return this.jeton; }
    public Couleur getCouleur() { return this.couleur; }

    public void setJeton(char jeton) { this.jeton = jeton;}
    public void setCouleur(Couleur couleur) { this.couleur = couleur; }

}
