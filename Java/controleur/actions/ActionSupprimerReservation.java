package Java.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import Java.modele.basededonnees.RequeteBddReservation;
import Java.vue.ihm.MainJFrame;

public class ActionSupprimerReservation extends AbstractAction{

    private MainJFrame mainJFrame;
    private String nouveauPanneau;
    private int idReservation;

    public ActionSupprimerReservation(MainJFrame mainJFrame, int idReservation, String nouveauPanneau){
        this.mainJFrame = mainJFrame;
        this.nouveauPanneau = nouveauPanneau;
        this.idReservation = idReservation;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        RequeteBddReservation requeteBddReservation = new RequeteBddReservation();

        int result = JOptionPane.showConfirmDialog(null, "Etes-vous sur de vouloir supprimer la réservation?", "Confirmation", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            requeteBddReservation.supprimerReservation(idReservation);
            this.mainJFrame.setContentPane(this.nouveauPanneau);
        } 

    }
    
}
