package reversi.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class PanelChat extends JPanel implements ActionListener {

        IControleur ctrl;
        JTextField affichage;
        JTextField ecrire;

        public PanelChat(IControleur c){
            this.ctrl = c;

            this.setLayout(new BorderLayout());


            // TODO: donner une grande hauteur à l'affichage (classe Dimension)
            this.affichage = new JTextField("");
            this.affichage.setEnabled(false);
            this.affichage.setHorizontalAlignment(JTextField.LEFT);


            this.ecrire = new JTextField("");

            this.affichage.addActionListener(this);
            this.ecrire.addActionListener(this);

            this.add(this.affichage);
            this.add(this.ecrire,"South");




        }

        public void actionPerformed(ActionEvent e)
        {
            String ecriture = this.ecrire.getText();
            this.ecrire.setText("");
            this.affichage.setText(ecriture + "\n");

        }
}
