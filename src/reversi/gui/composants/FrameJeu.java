package reversi.gui.composants;

import reversi.gui.IControleur;

import javax.swing.*;
import java.awt.*;

public class FrameJeu extends JFrame {

    private PanelPlateau pPlateau;
    private PanelInfo pInfo;
    private IControleur ctrl;

    public FrameJeu(IControleur c){



        this.setTitle("Reversi");
        this.setLocation(50,50);
        this.setSize(900,600);
        this.setResizable(false);

        this.setLayout(new BorderLayout(5, 5));

        this.ctrl = c;

        /*----------------------------*/
        /*PANEL DE GAUCHE AVEC PLATEAU*/
        /*----------------------------*/

        this.pPlateau = new PanelPlateau(this.ctrl);
        this.add(this.pPlateau,"West");

        this.pInfo = new PanelInfo(this.ctrl);
        this.add(this.pInfo);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public void majIHM() {
        this.pInfo.maj();
        this.pPlateau.maj();
    }
}
