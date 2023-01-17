package Java.modele.baseDeDonnees;

import java.sql.*;

public class RequeteBdd {

    public static void main(String[] args) {
        RequeteBdd service = new RequeteBdd();
        service.verifyConnection();
    }

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
