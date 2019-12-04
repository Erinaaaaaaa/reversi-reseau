package reversi.gui.composants;

import reversi.gui.ControleurLocal;
import reversi.gui.IControleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelInfo extends JPanel implements ActionListener {

    IControleur ctrl;
    JPanel infoJoueurs;
    JPanel pChat;
    PanelInfoJoueur[] pInfoJoueurs;

    public PanelInfo(IControleur c){

        this.ctrl = c;

        this.setLayout(new BorderLayout());

        this.pInfoJoueurs = new PanelInfoJoueur[this.ctrl.getNombreJoueurs()];
        this.infoJoueurs = new JPanel();
        this.infoJoueurs.setLayout(new GridLayout(4,1,0,15));

        // if (!(this.ctrl instanceof ControleurLocal))
        {
            this.pChat = new PanelChat(ctrl);
            this.add(this.pChat, BorderLayout.CENTER);
        }

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
