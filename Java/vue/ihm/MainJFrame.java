package Java.vue.ihm;

import javax.swing.JFrame;

public class MainJFrame extends JFrame{

    PanneauAccueil panneauAccueil = new PanneauAccueil(this);
    PanneauReservation panneauReservation;
    PanneauQuestions panneauQuestions = new PanneauQuestions(this);
    PanneauActualites panneauActualites; 
    PanneauManageActualites panneauManageActualites;
    PanneauContacterClient panneauContacterClient;

    public MainJFrame(){
        this.setContentPane("accueil");
    }

    public void setContentPane(String nomPanneau){
        switch (nomPanneau){
            case "accueil":
                this.setTitle("Gestion Site Gite - Accueil");
                this.setContentPane(this.panneauAccueil);
                break;
            case "reservations":
                this.setTitle("Gestion Site Gite - Reservations");
                this.panneauReservation = new PanneauReservation(this);
                this.setContentPane(this.panneauReservation);
                break;
            case "questions":
                this.setTitle("Gestion Site Gite - Questions");
                this.setContentPane(this.panneauQuestions);
                break;
            case "actualites":
                this.setTitle("Gestion Site Gite - Actualites");
                this.panneauActualites = new PanneauActualites(this);
                this.setContentPane(this.panneauActualites);
                break;
            case "manageActualites":
                this.setTitle("Gestion Site Gite - Manage Actualites");
                this.panneauManageActualites = new PanneauManageActualites(this);
                this.setContentPane(this.panneauManageActualites);
                break;
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
    }

    public void setContentPane(String nomPanneau, int index){

        switch(nomPanneau){
            case "contacterClient":
            this.setTitle("Gestion Site Gîte - Contacter Client");
            this.panneauContacterClient = new PanneauContacterClient(this, index);
            this.setContentPane(panneauContacterClient);
        }

    }
    
}
