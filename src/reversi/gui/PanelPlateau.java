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

        for(int cpt1=0; cpt1<tabBouton.length; cpt1++)
        {
            for(int cpt2=0;cpt2<tabBouton[cpt1].length;cpt2++)
            {
                char f = ctrl.getCasePlateau(cpt2, cpt1);
                JButton btn;

                if (f != '\0')
                    btn = new JButton("" + f);
                else
                    btn = new JButton(" ");

                tabBouton[cpt1][cpt2] = btn;
                tabBouton[cpt1][cpt2].setPreferredSize(new Dimension(600/this.ctrl.getHauteurPlateau(),600/this.ctrl.getHauteurPlateau()));
                this.add(this.tabBouton[cpt1][cpt2]);
                this.tabBouton[cpt1][cpt2].addActionListener(this);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {

        System.out.println(((JButton) e.getSource()).getText());
    }


}
