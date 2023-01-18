package Java.vue.ihm;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import Java.controleur.actions.ActionChangerPanneau;

public class PanneauReservation extends JPanel{

    private MainJFrame mainJFrame;

    public PanneauReservation(MainJFrame mainJFrame){
        super.setBackground(Color.red);
        this.mainJFrame = mainJFrame;
        JButton buttonRetour = new JButton(new ActionChangerPanneau(this.mainJFrame, "Retour", "accueil"));
        buttonRetour.setText("Retour");
        this.add(buttonRetour);
    }

}
