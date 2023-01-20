package Java.vue.ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Java.controleur.actions.ActionChangerPanneau;
import Java.controleur.actions.ActionSupprimerReservation;
import Java.controleur.actions.ActionValiderReservation;
import Java.modele.basededonnees.RequeteBddReservation;

public class PanneauReservation extends JPanel{

    private MainJFrame mainJFrame;

    // id / evenement / valide / dateDebut / duree / chambres / salles / client
    List<String> listId;
    List<String> listEvent;
    List<Integer> listValide;
    List<String> listDateDebut;
    List<String> listDuree;
    List<String> listChambres;
    List<String> listSalles;
    List<String> listClientNom;
    List<String> listClientPrenom;
    List<Integer> listClientId;
    List<String> listClientInformtionEmail;
    List<String> listClientInformtionNumero;
    
    int nombreDemandeReservation;
    
    JLabel titre = new JLabel("Réservations demandées : ");
    JLabel titre2 = new JLabel("Réservations confirmées : ");


    public PanneauReservation(MainJFrame mainJFrame){

        this.mainJFrame = mainJFrame;

        GridLayout grid = new GridLayout(7,1);
        this.setLayout(grid);
        super.setBackground(Color.gray);
        super.setPreferredSize(new Dimension(600,500));

        this.initListe();

        this.add(this.titre);
        this.initTitreListe();
        this.afficherdemandes();

        this.add(this.titre2);
        this.initTitreListe();
        this.afficherconfirmation();

        this.initBouton();

    }

    private void afficherdemandes(){

    // id / evenement / valide / dateDebut / duree / chambres / salles / client

        for(int i = 0; i < this.nombreDemandeReservation; i++){

            if(this.listValide.get(i) == 0){

                RequeteBddReservation requeteBddReservation = new RequeteBddReservation();
                this.listClientInformtionEmail = requeteBddReservation.informationClientEmail(listClientId.get(i));
                this.listClientInformtionNumero = requeteBddReservation.informationClientNumero(listClientId.get(i));

                JPanel ligne = new JPanel();
                ligne.setLayout(new GridLayout(1, 9));
    
                JLabel evenement = new JLabel(this.listEvent.get(i));
                JLabel valide;
                if(this.listValide.get(i) == 0){
                    valide = new JLabel("Non validé");
                }
                else{
                    valide = new JLabel("Validé");
                }                JLabel dateDebut = new JLabel(this.listDateDebut.get(i));
                JLabel duree = new JLabel(this.listDuree.get(i));
                JLabel chambres = new JLabel(this.listChambres.get(i));
                JLabel salles = new JLabel(this.listSalles.get(i));
                JLabel clientNomPrenom = new JLabel(this.listClientNom.get(i) + " " + this.listClientPrenom.get(i));
                JLabel email = new JLabel(this.listClientInformtionEmail.get(0));
                JLabel numero = new JLabel(this.listClientInformtionNumero.get(0));
    
                JButton valider = new JButton(new ActionValiderReservation(this.mainJFrame, this.listClientId.get(i), "reservations"));
                valider.setText("Valider");
                valider.setBackground(Color.green);
    
                JButton supprimer = new JButton(new ActionSupprimerReservation(this.mainJFrame, this.listClientId.get(i), "reservations"));
                supprimer.setText("Supprimer");
                supprimer.setBackground(Color.red);
    
                // JButton contacter = new JButton(new ActionChangerPanneau(this.mainJFrame, "Contacter", "contacterClient", this.listClient.get(i)));
                // contacter.setText("Contacter");
    
                ligne.add(evenement);
                ligne.add(valide);
                ligne.add(dateDebut);
                ligne.add(duree);
                ligne.add(chambres);
                ligne.add(salles);
                ligne.add(clientNomPrenom);
                ligne.add(email);
                ligne.add(numero);

                ligne.add(valider);
                ligne.add(supprimer);
    
                this.add(ligne);

            }
        }
    }

    private void afficherconfirmation(){

        for(int i = 0; i < this.nombreDemandeReservation; i++){

            if(this.listValide.get(i) == 1){

                RequeteBddReservation requeteBddReservation = new RequeteBddReservation();
                this.listClientInformtionEmail = requeteBddReservation.informationClientEmail(listClientId.get(i));
                this.listClientInformtionNumero = requeteBddReservation.informationClientNumero(listClientId.get(i));

                JPanel ligne = new JPanel();
                ligne.setLayout(new GridLayout(1, 8));
    
                JLabel evenement = new JLabel(this.listEvent.get(i));

                JLabel valide;
                if(this.listValide.get(i) == 0){
                    valide = new JLabel("Non validé");
                }
                else{
                    valide = new JLabel("Validé");
                }
                JLabel dateDebut = new JLabel(this.listDateDebut.get(i));
                JLabel duree = new JLabel(this.listDuree.get(i) + " jours");
                JLabel chambres = new JLabel(this.listChambres.get(i));
                JLabel salles = new JLabel(this.listSalles.get(i));
                JLabel clientNomPrenom = new JLabel(this.listClientNom.get(i) + " " + this.listClientPrenom.get(i));
                JLabel email = new JLabel(this.listClientInformtionEmail.get(0));
                JLabel numero = new JLabel(this.listClientInformtionNumero.get(0));

                JLabel trou = new JLabel("");
                JLabel trou1 = new JLabel("");

    
                // JButton contacter = new JButton(new ActionChangerPanneau(this.mainJFrame, "Contacter", "contacterClient", this.listClient.get(i)));
                // contacter.setText("Contacter");
    
                ligne.add(evenement);
                ligne.add(valide);
                ligne.add(dateDebut);
                ligne.add(duree);
                ligne.add(chambres);
                ligne.add(salles);
                ligne.add(clientNomPrenom);
                ligne.add(email);
                ligne.add(numero);

                ligne.add(trou);
                ligne.add(trou1);
    
                this.add(ligne);

            }
        }
    }

    private void initTitreListe(){

        JPanel ligne = new JPanel();
        ligne.setLayout(new GridLayout(1, 8));
        ligne.setBackground(new Color(210,210,210));

        JLabel evenement = new JLabel("Evenement");
        JLabel valide = new JLabel("valide");
        JLabel dateDebut = new JLabel("Date de debut");
        JLabel duree = new JLabel("duree");
        JLabel chambres = new JLabel("chambres");
        JLabel salles = new JLabel("salles");
        JLabel client = new JLabel("client");
        JLabel email = new JLabel("email");
        JLabel numero = new JLabel("numero");
        JLabel trou = new JLabel("");
        JLabel trou1 = new JLabel("");

        ligne.add(evenement);
        ligne.add(valide);
        ligne.add(dateDebut);
        ligne.add(duree);
        ligne.add(chambres);
        ligne.add(salles);
        ligne.add(client);
        ligne.add(email);
        ligne.add(numero);

        ligne.add(trou);
        ligne.add(trou1);

        this.add(ligne);

    }

    private void initListe(){

            // id / evenement / valide / dateDebut / duree / chambres / salles / client
        RequeteBddReservation requeteBddReservation = new RequeteBddReservation();

        this.nombreDemandeReservation = requeteBddReservation.nombreDemandeReservation();

        this.listId = requeteBddReservation.RecupererReservationId();
        this.listEvent = requeteBddReservation.RecupererReservationEvenement();
        this.listValide = requeteBddReservation.RecupererReservationValide();
        this.listDateDebut = requeteBddReservation.RecupererReservationDateDebut();
        this.listDuree = requeteBddReservation.RecupererReservationDuree();
        this.listChambres = requeteBddReservation.RecupererReservationChambres();
        this.listSalles = requeteBddReservation.RecupererReservationSalles();
        this.listClientNom = requeteBddReservation.RecupererReservationClientNom();
        this.listClientPrenom = requeteBddReservation.RecupererReservationClientPrenom();
        this.listClientId = requeteBddReservation.RecupererReservationClientId();

    }

    private void initBouton(){

        JButton buttonRetour = new JButton(new ActionChangerPanneau(this.mainJFrame, "Retour", "accueil"));
        buttonRetour.setText("Retour");

        this.add(buttonRetour);

    }
}
