package Java.modele.basededonnees;

import java.sql.*;

import Java.controleur.actions.ActionValiderActu;

public class RequetteBddActualites {

    private ConnectionBdd dbConnection;
    private ActionValiderActu actionValiderActu;
    
    public RequetteBddActualites(ActionValiderActu actionValiderActu){
        this.dbConnection = new ConnectionBdd();
        this.actionValiderActu = actionValiderActu;
        this.publierActu();
    }

    private void publierActu(){
        dbConnection.openConnection();
        try {
            String sql = "INSERT INTO `actualites`(`nom`, `description`, `premièreImage`, `secondeImage`, `troisiemeImage`, `quatriemeImage`,`date`) VALUES (?,?,?,?,?,?,NULL)";
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(sql);
            stmt.setString(1, this.actionValiderActu.getTitre());
            stmt.setString(2, this.actionValiderActu.getDescription());
            stmt.setString(3, this.actionValiderActu.getPremiereImage());
            stmt.setString(4, this.actionValiderActu.getSecondeImage());
            stmt.setString(5, this.actionValiderActu.getTroisiemeImage());
            stmt.setString(6, this.actionValiderActu.getQuatriemeImage());
            stmt.executeUpdate();
            System.out.println("L'actualité a été ajoutée avec succès!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
    }
}
