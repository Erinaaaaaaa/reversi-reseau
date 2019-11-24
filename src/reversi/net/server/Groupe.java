package reversi.net.server;

public class Groupe implements Runnable
{
    private Gestionnaire[] gestionnaires;

    public Groupe(Gestionnaire... gestionnaires)
    {
        this.gestionnaires = gestionnaires;

        broacast("Groupe de " + gestionnaires.length + " gestionnaires!");
    }

    public void broacast(String text)
    {
        for (Gestionnaire g : gestionnaires)
        {
            if (g.connecte())
                g.println(text);
        }
    }

    public void run()
    {
        while (true)
        {
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            broacast("Oof");
        }
    }
}
