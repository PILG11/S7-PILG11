package Java.vue.ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Java.controleur.actions.ActionChangerPanneau;
import Java.controleur.actions.ActionEnvoyerMessageClient;
import Java.modele.basededonnees.RequeteBddReservation;

public class PanneauContacterClient extends JPanel{
    
    private MainJFrame mainJFrame;
    private int indexClient;
    
    JLabel titre_message;
    JTextField message;
    List<String> informationDuClient;

    public PanneauContacterClient(MainJFrame mainJFrame, int indexClient){

        this.mainJFrame = mainJFrame;
        this.indexClient = indexClient;

        GridLayout grid = new GridLayout(2,2);
        this.setLayout(grid);
        super.setBackground(Color.gray);
        super.setPreferredSize(new Dimension(600,500));

        this.informationClient();

        this.initComponent();
        this.initComponentInformationClient();
        this.initBoutonEnvoyer();

        JButton buttonRetour = new JButton(new ActionChangerPanneau(this.mainJFrame, "Retour", "accueil"));
        buttonRetour.setText("Retour");

        this.add(buttonRetour);

    }

    public String getMessage(){
        return this.message.getText();
    }

    private void initComponent(){

        titre_message = new JLabel("Message : ");
        message = new JTextField();

        this.add(titre_message);
        this.add(message);

    }

    private void initComponentInformationClient(){

        String information = " Informations du Client : \n";

        for(int i = 0; i < this.informationDuClient.size(); i++){
            if(i == this.informationDuClient.size() - 1){
                information += informationDuClient.get(i);
            }
            else{
                information += informationDuClient.get(i) + ", ";
            }
        }

        JLabel informationClient = new JLabel(information);
        this.add(informationClient);

    }

    private void initBoutonEnvoyer(){

        JButton envoyer = new JButton(new ActionEnvoyerMessageClient(this.informationDuClient.get(3),  this.getMessage()));
        envoyer.setText("Envoyer");
        
        this.add(envoyer);
        
    }

    private void informationClient(){

        RequeteBddReservation requeteBddReservation = new RequeteBddReservation();

    }
}
