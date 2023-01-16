package java.modele.basededonnees;

import java.sql.*;

public class RequeteBdd {

    private ConnectionBdd dbConnection;

    public RequeteBdd() {
        dbConnection = new ConnectionBdd();
    }

    public void verifyConnection() {
        dbConnection.openConnection();
        try {
            DatabaseMetaData meta = dbConnection.getConnection().getMetaData();
            System.out.println("Connexion établie avec la base de données : " + meta.getURL());
            System.out.println("Driver utilisé : " + meta.getDriverName());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
    }
    
}
