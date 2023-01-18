package Java.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import Java.vue.ihm.MainJFrame;
import Java.vue.ihm.PanneauActualites;

public class ActionChoisirImage extends AbstractAction{

    private PanneauActualites panneauActualites;

    public ActionChoisirImage(PanneauActualites panneauActualites){
        super("ValidationActu");
        this.panneauActualites = panneauActualites;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser("Importer");
		FileNameExtensionFilter filtre = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png");
		fileChooser.addChoosableFileFilter(filtre);
		int choose = fileChooser.showOpenDialog(this.panneauActualites);
		
		if(choose == JFileChooser.APPROVE_OPTION) {
			String path  = fileChooser.getSelectedFile().getAbsolutePath();
			///this.panneauActualites.setPathCourant(path);
		}
    }
    
}
