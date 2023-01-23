package Java.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import Java.modele.basededonnees.RequeteBddReservation;
import Java.vue.ihm.MainJFrame;

public class ActionValiderReservation extends AbstractAction{

    private MainJFrame mainJFrame;
    private String nouveauPanneau;
    private int idReservation;

    public ActionValiderReservation(MainJFrame mainJFrame, int idReservation, String nouveauPanneau){
        this.mainJFrame = mainJFrame;
        this.nouveauPanneau = nouveauPanneau;
        this.idReservation = idReservation;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        RequeteBddReservation requeteBddReservation = new RequeteBddReservation();

        requeteBddReservation.validerReservation(this.idReservation);

        this.mainJFrame.setContentPane(this.nouveauPanneau);
    }
    
}
