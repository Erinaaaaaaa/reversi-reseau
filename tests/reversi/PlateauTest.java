package reversi;

import org.junit.jupiter.api.*;
import reversi.metier.Joueur;
import reversi.metier.Plateau;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest
{
    private static Plateau plateau;

    @BeforeAll
    static void setUp()
    {
        ArrayList<Joueur> al = new ArrayList<>();
        al.add(new Joueur("Joueur 1"));
        al.add(new Joueur("Joueur 2"));

        al.get(0).setJeton('A');
        al.get(1).setJeton('B');

        plateau = Plateau.creer(al);
    }

    @AfterAll
    static void tearDown()
    {
        plateau = null;
    }

    @Test
    void peutJouerTest()
    {
        assertTrue (plateau.peutJouer('A'));
        assertTrue (plateau.peutJouer('B'));
        assertFalse(plateau.peutJouer('C'));
        assertFalse(plateau.peutJouer('D'));
        assertFalse(plateau.peutJouer('E'));
        assertFalse(plateau.peutJouer('F'));
        assertFalse(plateau.peutJouer('G'));
        assertFalse(plateau.peutJouer('H'));
        assertFalse(plateau.peutJouer('I'));
        assertFalse(plateau.peutJouer('J'));
        assertFalse(plateau.peutJouer('K'));
        assertFalse(plateau.peutJouer('L'));
        assertFalse(plateau.peutJouer('M'));
        assertFalse(plateau.peutJouer('N'));
        assertFalse(plateau.peutJouer('O'));
        assertFalse(plateau.peutJouer('P'));
        assertFalse(plateau.peutJouer('Q'));
        assertFalse(plateau.peutJouer('R'));
        assertFalse(plateau.peutJouer('S'));
        assertFalse(plateau.peutJouer('T'));
        assertFalse(plateau.peutJouer('U'));
        assertFalse(plateau.peutJouer('V'));
        assertFalse(plateau.peutJouer('W'));
        assertFalse(plateau.peutJouer('X'));
        assertFalse(plateau.peutJouer('Y'));
        assertFalse(plateau.peutJouer('Z'));
    }

    @Test
    void creerNbJoueursTest()
    {
        ArrayList<Joueur> joueurs = new ArrayList<>();

        joueurs.add(new Joueur("Joueur 1"));
        Plateau p0 = Plateau.creer(8, 8, joueurs);

        joueurs.add(new Joueur("Joueur 2"));
        Plateau p1 = Plateau.creer(8, 8, joueurs);

        joueurs.add(new Joueur("Joueur 3"));
        Plateau p2 = Plateau.creer(8, 8, joueurs);

        joueurs.add(new Joueur("Joueur 4"));
        Plateau p3 = Plateau.creer(8, 8, joueurs);

        joueurs.add(new Joueur("Joueur 5"));
        Plateau p4 = Plateau.creer(8, 8, joueurs);

        joueurs.add(new Joueur("Joueur 6"));
        Plateau p5 = Plateau.creer(8, 8, joueurs);

        joueurs.add(new Joueur("Joueur 7"));
        Plateau p6 = Plateau.creer(8, 8, joueurs);

        assertNull(p0);
        assertNotNull(p1);
        assertNull(p2);
        assertNotNull(p3);
        assertNull(p4);
        assertNull(p5);
        assertNull(p6);
    }

    @Test
    void creerNbParamTest()
    {
        ArrayList<Joueur> al = new ArrayList<>();
        al.add(new Joueur("j1"));
        al.add(new Joueur("j2"));

        Plateau p1 = Plateau.creer(al);
        Plateau p2 = Plateau.creer(8, al);
        Plateau p3 = Plateau.creer(8, 16, al);

        // P1
        assertNotNull(p1);
        assertEquals(8,p1.getLargeur());
        assertEquals(8,p1.getHauteur());

        // P2
        assertNotNull(p2);
        assertEquals(8,p2.getLargeur());
        assertEquals(8,p2.getHauteur());

        // P3
        assertNotNull(p3);
        assertEquals(8,p3.getLargeur());
        assertEquals(16,p3.getHauteur());
    }
}