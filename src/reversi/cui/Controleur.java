package reversi.cui;

import reversi.net.client.Client;

import java.io.IOException;

class Controleur
{
    private Client c;

    Controleur() throws IOException
    {
        this.c = new Client("localhost", 57300);


    }

    private void execute(String command)
    {
        System.out.println(command);
    }

    private class Lecteur implements Runnable
    {
        private Client c;

        public Lecteur(Client c)
        {
            this.c = c;
        }

        public void run()
        {
            String input = "";
            while (true)
            {
                try
                {
                    input = c.readLine();

                    if (input == null)
                        return;

                    execute(input);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

}


