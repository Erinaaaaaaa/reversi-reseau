package reversi.gui.composants;

import reversi.gui.IControleur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class PanelChat extends JPanel implements ActionListener {

        IControleur ctrl;

        JScrollPane pane;

        JTextArea affichage;
        JTextField input;

        private String message;

        public PanelChat(IControleur c){
            this.ctrl = c;

            this.setLayout(new BorderLayout());

            this.message = "";



            this.affichage = new JTextArea("");
            this.affichage.setEnabled(false);
            this.affichage.setColumns(20);
            this.affichage.setRows(5);
            this.affichage.setLineWrap(true);
            this.affichage.setWrapStyleWord(true);
            this.affichage.setDisabledTextColor(Color.BLACK);

            this.pane = new JScrollPane(this.affichage);


            this.input = new JTextField("");

            this.input.addActionListener(this);

            this.add(this.pane);
            this.add(this.input,"South");




        }

        public void setText(String str){this.message = str;}

        public void actionPerformed(ActionEvent e)
        {
            String message = this.input.getText();
            if (message.trim().equals("")) return;

            this.ctrl.envoyerMessage(message);
            this.input.setText("");

            this.affichage.setText(this.ctrl.getMessagesChat());
        }

    public void majChat()
    {
        this.affichage.setText(this.ctrl.getMessagesChat());
    }
}
