package Java.vue.ihm;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import Java.controleur.actions.ActionChangerPanneau;

public class PanneauActualites extends JPanel{

    private MainJFrame mainJFrame;

    public PanneauActualites(MainJFrame mainJFrame){
        super.setBackground(Color.blue);
        this.mainJFrame = mainJFrame;
        JButton buttonRetour = new JButton(new ActionChangerPanneau(this.mainJFrame, "Retour", "accueil"));
        buttonRetour.setText("Retour");
        this.add(buttonRetour);
    }
    
}
