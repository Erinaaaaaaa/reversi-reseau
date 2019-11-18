package reversi;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest
{
    private Plateau plateau;

    @BeforeEach
    void setUp()
    {
        plateau = Plateau.creer();
    }

    @AfterEach
    void tearDown()
    {
        plateau = null;
    }

    @Test
    void peutJouerTest()
    {
        assertFalse(plateau.peutJouer('A'));
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
        assertTrue (plateau.peutJouer('N'));
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
}