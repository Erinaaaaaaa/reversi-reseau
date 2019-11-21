package reversi.gui;

import javax.swing.*;

public class FrameJeu extends JFrame {

    private PanelPlateau pPlateau;
    private PanelInfo pInfo;
    private Controleur ctrl;

    public FrameJeu(Controleur c){



        this.setTitle("Reversi");
        this.setLocation(50,50);
        this.setSize(900,600);
        this.setResizable(false);

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
