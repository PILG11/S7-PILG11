package Java.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import Java.modele.basededonnees.RequeteBddReservation;
import Java.vue.ihm.MainJFrame;

public class ActionSupprimerReservation extends AbstractAction{

    private MainJFrame mainJFrame;
    private String nouveauPanneau;
    private int idClient;

    public ActionSupprimerReservation(MainJFrame mainJFrame, int idClient, String nouveauPanneau){
        this.mainJFrame = mainJFrame;
        this.nouveauPanneau = nouveauPanneau;
        this.idClient = idClient;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        RequeteBddReservation requeteBddReservation = new RequeteBddReservation();

        int result = JOptionPane.showConfirmDialog(null, "Etes-vous sur de vouloir supprimer la réservation?", "Confirmation", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            requeteBddReservation.supprimerReservation(idClient);
            this.mainJFrame.setContentPane(this.nouveauPanneau);
        } 

    }
    
}
