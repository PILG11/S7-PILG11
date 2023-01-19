package Java.controleur.actions;

import java.awt.event.ActionEvent;
import java.sql.Date;
import java.time.LocalDate;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import Java.modele.basededonnees.RequetteBddActualites;
import Java.vue.ihm.MainJFrame;
import Java.vue.ihm.PanneauActualites;

public class ActionValiderActu extends AbstractAction{

    private MainJFrame mainJFrame;
    private PanneauActualites panneauActualites;
    public PanneauActualites getPanneauActualites() {
        return panneauActualites;
    }

    private String titre;
    private String description;
    private String premiereImage;
    private Date date;

    public ActionValiderActu(MainJFrame mainJFrame, PanneauActualites panneauActualites){
        super("ValidationActu");
        this.mainJFrame = mainJFrame;
        this.panneauActualites = panneauActualites;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.getValues();
        
        if(this.titre.length() == 0){
            JOptionPane.showMessageDialog(null, "Erreur : Entrez un titre", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(this.description.length() == 0){
            JOptionPane.showMessageDialog(null, "Erreur : Entrez une description", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }  
        if(this.premiereImage == null){
            JOptionPane.showMessageDialog(null, "Erreur : Sélectionner au minimum l'image 1", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }  

        this.requetePublicationActu();
        this.resetPanneau();
    }
    
    private void getValues(){
        titre = this.panneauActualites.getTitle();
        description = this.panneauActualites.getDescription();
        premiereImage = this.panneauActualites.getPathImage1();
        setDate();
    }

    private void requetePublicationActu(){
        RequetteBddActualites requetteBddActualites = new RequetteBddActualites();
        requetteBddActualites.publierActu(this);
    }

    private void resetPanneau(){
        this.mainJFrame.setContentPane("actualites");
    }

    private void setDate(){
        LocalDate localDate = LocalDate.now();
        String dateJour = localDate.toString();
        date = Date.valueOf(dateJour);
    }

    public Date getDate(){
        return this.date;
    }
}
