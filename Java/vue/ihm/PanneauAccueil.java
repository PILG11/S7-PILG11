package java.vue.ihm;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.controleur.actions.ActionActualites;
import java.controleur.actions.ActionQuestions;
import java.controleur.actions.ActionReservations;

public class PanneauAccueil extends JPanel{

    public static final int LARGEUR_PAR_DEFAUT = 500;
	public static final int HAUTEUR_PAR_DEFAUT = 300;
	public static final Color COULEUR_FOND_PAR_DEFAUT = Color.WHITE;

    public PanneauAccueil(){
        super.setPreferredSize(new Dimension(LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT));
		super.setBackground(COULEUR_FOND_PAR_DEFAUT);
        this.initButton();
    }

    private void initButton(){
        JButton buttonReservations = new JButton(new ActionReservations());
        buttonReservations.setText("Reservations");
        this.add(buttonReservations);

        JButton buttonActualites = new JButton(new ActionActualites());
        buttonActualites.setText("Actualites");
        this.add(buttonActualites);

        JButton buttonQuestions = new JButton(new ActionQuestions());
        buttonQuestions.setText("Questions");
        this.add(buttonQuestions);

        JButton buttonInventaire = new JButton();
        buttonInventaire.setText("Inventaire");
        this.add(buttonInventaire);
    }

}