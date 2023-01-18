package Java.controleur.actions;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

import Java.vue.ihm.PanneauActualites;

public class ActionChoisirImage extends AbstractAction{

    private PanneauActualites panneauActualites;
    private JLabel imageChoisie;

    public ActionChoisirImage(PanneauActualites panneauActualites,JLabel imageChoisie){
        super("ValidationActu");
        this.panneauActualites = panneauActualites;
        this.imageChoisie = imageChoisie;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser("Importer");
        
        fileChooser.setCurrentDirectory(new File("C:\\Users\\erwan\\Desktop\\S7-PILG11"));

		FileNameExtensionFilter filtre = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png");
		fileChooser.addChoosableFileFilter(filtre);
        fileChooser.setFileFilter(filtre);

		int choose = fileChooser.showOpenDialog(this.panneauActualites);
		
		if(choose == JFileChooser.APPROVE_OPTION) {
			String path  = fileChooser.getSelectedFile().getAbsolutePath();
			this.panneauActualites.setPath(this.imageChoisie,path);
		}
    }
    
}
