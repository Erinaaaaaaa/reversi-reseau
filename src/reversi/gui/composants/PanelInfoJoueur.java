package reversi.gui.composants;

import reversi.gui.IControleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelInfoJoueur extends JPanel implements ActionListener {

    IControleur ctrl;

    private JLabel lblJoueur;
    private JLabel lblScore;

    private final Font NORMAL = new Font("Dialog", Font.PLAIN, 20);
    private final Font GRAS = new Font("Dialog", Font.BOLD, 25);

    private int numJoueur;

    public PanelInfoJoueur(IControleur c, int numJoueur){

        this.ctrl = c;
        this.numJoueur = numJoueur;

        this.setLayout(new GridLayout(2,1,5,0));

        //On applique un effet sur le joueur courant
        if(this.ctrl.getJoueurCourant().equals(this.ctrl.getJoueur(numJoueur)) )
        {
            lblJoueur = new JLabel(this.ctrl.getNomJoueur(numJoueur));
            lblJoueur.setFont(this.GRAS);
            lblJoueur.setForeground(this.ctrl.getJoueur(numJoueur).getColor());
            // lblText.setToolTipText(this.ctrl.getNomJoueur(numJoueur));
            this.add(lblJoueur);

        }
        else //Sinon c'est pas en gras
        {
            lblJoueur = new JLabel(this.ctrl.getNomJoueur(numJoueur));
            lblJoueur.setFont(NORMAL);
            lblJoueur.setForeground(this.ctrl.getJoueur(numJoueur).getColor());
            this.add(lblJoueur);
        }

        lblScore = new JLabel("Score : " + this.ctrl.getScoreJoueur(numJoueur));
        lblScore.setFont(NORMAL);

        this.add(lblScore);


    }

    public void actionPerformed(ActionEvent e){

    }

    public void setScore(int score)
    {
        this.lblScore.setText("Score: " + score);
    }


    public int getNumJoueur() {
        return numJoueur;
    }

    public void setGras(boolean b) {
        if (b)
            this.lblJoueur.setFont(GRAS);
        else
            this.lblJoueur.setFont(NORMAL);

    }
}
