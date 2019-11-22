package reversi.gui;
import javax.swing.JOptionPane;

public class Choix
{
        public Choix(int nb, String text)
        {
            this.nb = nb;
            this.text = text;
        }

        private int nb;
        private String text;


        public int getNb()
        {
            return nb;
        }

        @Override
        public String toString()
        {
            return text;
        }
    }
