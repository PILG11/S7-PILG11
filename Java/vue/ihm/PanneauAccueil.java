package Java.vue.ihm;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;

import Java.controleur.actions.ActionChangerPanneau;

public class PanneauAccueil extends JPanel{

    public static final int LARGEUR_PAR_DEFAUT = 500;
	public static final int HAUTEUR_PAR_DEFAUT = 300;
	public static final Color COULEUR_FOND_PAR_DEFAUT = Color.WHITE;

    private MainJFrame mainJFrame;

    public PanneauAccueil(MainJFrame mainJFrame){
        this.mainJFrame = mainJFrame;
        super.setPreferredSize(new Dimension(LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT));
		super.setBackground(COULEUR_FOND_PAR_DEFAUT);
        this.initButton();
    }

    private void initButton(){
        JButton buttonReservations = new JButton(new ActionChangerPanneau(this.mainJFrame, "Reservations", "reservation"));
        buttonReservations.setText("Reservations");
        this.add(buttonReservations);

        JButton buttonActualites = new JButton(new ActionChangerPanneau(this.mainJFrame, "Actualites", "actualite"));
        buttonActualites.setText("Actualites");
        this.add(buttonActualites);

        JButton buttonQuestions = new JButton(new ActionChangerPanneau(this.mainJFrame, "Questions", "question"));
        buttonQuestions.setText("Questions");
        this.add(buttonQuestions);

        JButton buttonInventaire = new JButton();
        buttonInventaire.setText("Inventaire");
        this.add(buttonInventaire);
    }

}