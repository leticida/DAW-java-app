package com.llibreria;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Consulta per obtenir dades de la base de dades 'llibres'.
 * Realitza una consulta a la taula llibres i envia els resultats al JSP.
 * 
 * URL Mapejada: /Consulta
 * 
 * @author Leticia Campos
 */
@WebServlet("/Consulta")
public class Consulta extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Mètode doGet que obté els llibres de la base de dades
     * i els passa com atribut a llibreria.jsp.
     * 
     * @param request Petició HTTP
     * @param response Resposta HTTP
     * @throws ServletException si ocorre un error de servlet
     * @throws IOException si ocorre un error d'entrada/sortida
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<String> llibres = new ArrayList<>();

        try (Connection connexio = Connexio.obtenirConnexio();
             Statement stmt = connexio.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT titol FROM llibres")) {

            while (rs.next()) {
                llibres.add(rs.getString("titol"));
            }
            request.setAttribute("llibres", llibres);
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("llibreria.jsp");
        dispatcher.forward(request, response);
    }
}

