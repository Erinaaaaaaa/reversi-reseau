package reversi.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelInfoJoueur extends JPanel implements ActionListener {

    Controleur ctrl;

    public PanelInfoJoueur(Controleur c, int numJoueur){

        this.ctrl = c;

        this.setLayout(new GridLayout(2,1,5,0));
        this.add(new JLabel(this.ctrl.getNomJoueur(numJoueur)));
        this.add(new JLabel("Score : " + this.ctrl.getScoreJoueur(numJoueur)));
    }

    public void actionPerformed(ActionEvent e){

    }

}
