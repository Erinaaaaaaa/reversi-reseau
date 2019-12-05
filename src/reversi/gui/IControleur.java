package reversi.gui;

import reversi.metier.Joueur;

public interface IControleur
{
    int  getLargeurPlateau();
    int  getHauteurPlateau();
    char getCasePlateau(int x, int y);
    String getNomJoueur(int i);

    int    getNombreJoueurs();
    int    getScoreJoueur(int i);
    int    getScoreJoueur(Joueur j);
    Joueur getJoueurCourant();
    Joueur getJoueur(int i);
    Joueur getJoueur(char c);
    Joueur[] getClassement();

    boolean peutJouer();
    boolean peutJouer(int x, int y);
    void jouer(int x, int y);
    boolean bloquee();

    void envoyerMessage(String message);
    String getMessagesChat();

    void majIHM();
}