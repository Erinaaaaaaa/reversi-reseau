package reversi.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelInfo extends JPanel implements ActionListener {

    Controleur ctrl;
    JPanel infoJoueurs;
    PanelInfoJoueur[] pInfoJoueurs;

    public PanelInfo(Controleur c){

        this.ctrl = c;

        this.setLayout(new BorderLayout());

        this.pInfoJoueurs = new PanelInfoJoueur[this.ctrl.getNombreJoueurs()];
        this.infoJoueurs = new JPanel();
        this.infoJoueurs.setLayout(new GridLayout(4,1,0,15));


        for(int i = 0; i < this.pInfoJoueurs.length; i++)
        {
            this.pInfoJoueurs[i] = new PanelInfoJoueur(this.ctrl, i);
            this.infoJoueurs.add(this.pInfoJoueurs[i]);
        }

        this.add(infoJoueurs, BorderLayout.NORTH);
    }

    public void actionPerformed(ActionEvent e) {


    }


    public void maj() {
        for (PanelInfoJoueur pij : pInfoJoueurs)
        {
            pij.setGras(
                    this.ctrl.getJoueurCourant().equals(
                            this.ctrl.getJoueur(pij.getNumJoueur())
                    )
            );
            pij.setScore(this.ctrl.getScoreJoueur(pij.getNumJoueur()));
        }
    }
}
