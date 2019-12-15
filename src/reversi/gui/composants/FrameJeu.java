package reversi.gui.composants;

import reversi.gui.IControleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class FrameJeu extends JFrame {

    private PanelPlateau pPlateau;
    private PanelInfo pInfo;
    private IControleur ctrl;

    public FrameJeu(IControleur c){

        if (c.getNomJoueurLocal() != null)
            this.setTitle("Reversi - " + c.getNomJoueurLocal());
        else
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

        this.addWindowFocusListener(new WindowFocusListener()
        {
            @Override
            public void windowGainedFocus(WindowEvent windowEvent)
            {
                if (!ctrl.bloquee())
                    repaint();
            }

            @Override
            public void windowLostFocus(WindowEvent windowEvent)
            {

            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public void majIHM() {
        this.pInfo.maj();
        this.pPlateau.maj();
    }
}
