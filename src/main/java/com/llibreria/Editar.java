
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
 * Servlet Editar per modificar llibres existents.
 * 
 * URL Mapejada: /Editar
 * 
 * @autor Leticia Campos
 */
@WebServlet("/Editar")
public class Editar extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Mètode doPost per actualitzar un llibre.
     *
     * @param request Petició HTTP
     * @param response Resposta HTTP
     * @throws ServletException si ocorre un error de servlet
     * @throws IOException si ocorre un error d'entrada/sortida
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String titol = request.getParameter("titol");
        String isbn = request.getParameter("isbn");
        int any = Integer.parseInt(request.getParameter("any_publicacio"));
        int editorial = Integer.parseInt(request.getParameter("id_editorial"));

        try (Connection connexio = Connexio.obtenirConnexio();
             PreparedStatement ps = connexio.prepareStatement(
                     "UPDATE llibres SET titol=?, isbn=?, any_publicacio=?, id_editorial=? WHERE id=?")) {

            ps.setString(1, titol);
            ps.setString(2, isbn);
            ps.setInt(3, any);
            ps.setInt(4, editorial);
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("Consulta");
    }
}

