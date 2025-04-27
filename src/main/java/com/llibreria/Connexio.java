package com.llibreria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connexio {

    private static final String URL = "jdbc:mysql://IP_DEL_SERVIDOR:3306/llibres"; // Canvia IP_DEL_SERVIDOR
    private static final String USUARI = "nom_usuari"; // Canvia nom_usuari
    private static final String CONTRASENYA = "contrasenya"; // Canvia contrasenya


    public static Connection obtenirConnexio() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USUARI, CONTRASENYA);
        } catch (ClassNotFoundException e) {
            throw new SQLException("No s'ha trobat el driver JDBC.", e);
        }
    }
}
