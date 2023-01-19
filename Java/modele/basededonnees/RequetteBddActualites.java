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
            String sql = "INSERT INTO `actualites`(`nom`, `description`, `premièreImage`, `secondeImage`, `troisiemeImage`, `quatriemeImage`,`date`) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement stmt = dbConnection.getConnection().prepareStatement(sql);
            stmt.setString(1, this.actionValiderActu.getPanneauActualites().getTitle());
            stmt.setString(2, this.actionValiderActu.getPanneauActualites().getDescription());
            stmt.setString(3, this.actionValiderActu.getPanneauActualites().getPathImage1());
            stmt.setString(4, this.actionValiderActu.getPanneauActualites().getPathImage2());
            stmt.setString(5, this.actionValiderActu.getPanneauActualites().getPathImage3());
            stmt.setString(6, this.actionValiderActu.getPanneauActualites().getPathImage4());
            stmt.setDate(7, this.actionValiderActu.getDate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
    }
}
