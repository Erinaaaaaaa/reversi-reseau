package reversi.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PanelPlateau extends JPanel implements ActionListener {

    private Controleur ctrl;
    private JButton[][] tabBouton;

    public PanelPlateau(Controleur c)
    {
        this.ctrl = c;

        this.setLayout(new GridLayout(this.ctrl.getLargeurPlateau(), this.ctrl.getHauteurPlateau()));
        this.tabBouton = new JButton[this.ctrl.getLargeurPlateau()][this.ctrl.getHauteurPlateau()];

        for(int x=0; x<tabBouton.length; x++)
        {
            for(int y=0;y<tabBouton[x].length;y++)
            {
                char f = ctrl.getCasePlateau(x, y);
                JButton btn;

                if (f != '\0')
                    btn = new JButton("" + f);
                else
                    btn = new JButton(" ");

                tabBouton[y][x] = btn;
                tabBouton[y][x].setPreferredSize(new Dimension(600/this.ctrl.getHauteurPlateau(),600/this.ctrl.getHauteurPlateau()));
                this.add(this.tabBouton[y][x]);
                this.tabBouton[y][x].addActionListener(this);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {

        System.out.println(((JButton) e.getSource()).getText());

        if(ctrl.peutJouer())
        {
            for(int y = 0; y<tabBouton.length; y++ ) {
                for (int x = 0; x < tabBouton[y].length; x++) {
                    if (this.tabBouton[y][x].equals(e.getSource())) {
                        this.ctrl.jouer(x, y);
                    }
                }
            }

        }


        this.ctrl.majIHM();

    }

    public void maj()
    {
        for(int y = 0; y<tabBouton.length; y++ ) {
            for (int x = 0; x < tabBouton[y].length; x++) {
                tabBouton[y][x].setText("" + this.ctrl.getCasePlateau(x,y));

                //  TODO: Colorier toute les cases des joueurs
            }
        }
    }
}
