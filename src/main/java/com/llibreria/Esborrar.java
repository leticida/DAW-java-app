package com.llibreria;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Esborrar per eliminar llibres de la base de dades.
 * 
 * URL Mapejada: /Esborrar
 * 
 * @author Leticia Campos
 */
@WebServlet("/Esborrar")
public class Esborrar extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Mètode doGet per eliminar un llibre per ID.
     *
     * @param request Petició HTTP
     * @param response Resposta HTTP
     * @throws ServletException si ocorre un error de servlet
     * @throws IOException si ocorre un error d'entrada/sortida
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try (Connection connexio = Connexio.obtenirConnexio();
             PreparedStatement ps = connexio.prepareStatement(
                     "DELETE FROM llibres WHERE id=?")) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("Consulta");
    }
}
