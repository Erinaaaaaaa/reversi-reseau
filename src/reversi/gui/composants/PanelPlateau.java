package reversi.gui;

import reversi.gui.composants.RoundedButton;
import reversi.metier.Joueur;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PanelPlateau extends JPanel implements ActionListener {

    private IControleur ctrl;
    private JButton[][] tabBouton;

    public PanelPlateau(IControleur c)
    {
        this.ctrl = c;

        this.setLayout(new GridLayout(this.ctrl.getLargeurPlateau(), this.ctrl.getHauteurPlateau()));
        this.tabBouton = new JButton[this.ctrl.getLargeurPlateau()][this.ctrl.getHauteurPlateau()];

        for(int x=0; x<tabBouton.length; x++)
        {
            for(int y=0;y<tabBouton[x].length;y++)
            {

                JButton btn = new RoundedButton(16);

                tabBouton[y][x] = btn;
                tabBouton[y][x].setPreferredSize(new Dimension(600/this.ctrl.getHauteurPlateau(),600/this.ctrl.getHauteurPlateau()));
                this.add(this.tabBouton[y][x]);
                this.tabBouton[y][x].addActionListener(this);

            }
        }

        this.maj();
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
                if(this.ctrl.peutJouer(x,y))
                {
                    tabBouton[y][x].setBackground(new Color(161,247,255));
                }
                else
                {
                    tabBouton[y][x].setBackground(new Color(230,253,255));
                }

                Joueur jTmp = this.ctrl.getJoueur(this.ctrl.getCasePlateau(x,y));

                if(jTmp != null)
                {
                    tabBouton[y][x].setBackground(jTmp.getColor());
                }
            }
        }

        if(this.ctrl.bloquee())
        {
            Joueur[] classement = this.ctrl.getClassement();

            StringBuilder sb = new StringBuilder();
            sb.append("Classement final");

            for (int i = 0; i < classement.length; i++)
            {
                Joueur j = classement[i];
                sb.append("\n#").append(i+1).append(": ").append(j.getNom())
                .append(" avec ").append(ctrl.getScoreJoueur(j)).append(" points");
            }

            //ImageIcon img = new ImageIcon("images/information.png");
            JOptionPane.showMessageDialog(null, sb.toString(), "Resultat", JOptionPane.INFORMATION_MESSAGE);

        }
    }
}
