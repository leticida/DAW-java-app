package com.llibreria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe Connexio per establir connexions a la base de dades.
 * Conté les credencials i la lògica de connexió.
 * 
 * @author Leticia Campos
 */
public class Connexio {

    private static final String URL = "jdbc:mysql://IP_DEL_SERVIDOR:3307/llibres"; // Canvia IP_DEL_SERVIDOR
    private static final String USUARI = "root"; 
    private static final String CONTRASENYA = ""; 
    /**
     * Estableix i retorna una connexió a la base de dades.
     * 
     * @return Connexió activa a la base de dades.
     * @throws SQLException si ocorre un error de connexió.
     */
    public static Connection obtenirConnexio() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USUARI, CONTRASENYA);
        } catch (ClassNotFoundException e) {
            throw new SQLException("No s'ha trobat el driver JDBC.", e);
        }
    }
}
