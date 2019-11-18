package reversi.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelInfo extends JPanel implements ActionListener {

    Controleur ctrl;
    JPanel infoJoueur;

    public PanelInfo(Controleur c){

        this.ctrl = c;

        this.setLayout(new BorderLayout());

        this.infoJoueur = new JPanel();
        this.infoJoueur.setLayout(new GridLayout(4,1));

        this.infoJoueur.add(new JLabel(this.ctrl.getNomJoueur(1)));
        this.infoJoueur.add(new JLabel("BONJOUR JE SUIS LE VOMIT"));
        this.infoJoueur.add(new JLabel(this.ctrl.getNomJoueur(2)));
        this.infoJoueur.add(new JLabel("BONJOUR JE SUIS UNE PATATE"));

        this.add(this.infoJoueur, "North");


    }

    public void actionPerformed(ActionEvent e) {


    }


}
