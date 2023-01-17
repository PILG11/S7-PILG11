package Java.vue.ihm;

import javax.swing.JFrame;

public class MainJFrame extends JFrame{

    PanneauAccueil panneauAccueil = new PanneauAccueil(this);
    PanneauReservation panneauReservation = new PanneauReservation(this);
    PanneauQuestions panneauQuestions = new PanneauQuestions(this);
    PanneauActualites panneauActualites = new PanneauActualites(this); 

    public MainJFrame(){
        this.setContentPane("accueil");
    }

    public void setContentPane(String nomPanneau){
        switch (nomPanneau){
            case "accueil":
                this.setContentPane(this.panneauAccueil);
                break;
            case "reservations":
                this.setContentPane(this.panneauReservation);
                break;
            case "questions":
                this.setContentPane(this.panneauQuestions);
                break;
            case "actualites":
                this.setContentPane(this.panneauActualites);
                break;
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
    }
    
}
