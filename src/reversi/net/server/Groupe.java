package reversi.net.server;

public class Groupe
{
    private Gestionnaire[] gestionnaires;

    public Groupe(Gestionnaire... gestionnaires)
    {
        this.gestionnaires = gestionnaires;
    }
}
