package Java.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import Java.modele.basededonnees.RequeteBddReservation;
import Java.vue.ihm.MainJFrame;

public class ActionValiderReservation extends AbstractAction{

    private MainJFrame mainJFrame;
    private String nouveauPanneau;
    private int idClient;

    public ActionValiderReservation(MainJFrame mainJFrame, int idClient, String nouveauPanneau){
        this.mainJFrame = mainJFrame;
        this.nouveauPanneau = nouveauPanneau;
        this.idClient = idClient;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        RequeteBddReservation requeteBddReservation = new RequeteBddReservation();

        requeteBddReservation.validerReservation(this.idClient);

        this.mainJFrame.setContentPane(this.nouveauPanneau);
    }
    
}
