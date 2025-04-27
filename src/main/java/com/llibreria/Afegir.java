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
 * Servlet Afegir per inserir nous llibres a la base de dades.
 * 
 * URL Mapejada: /Afegir
 * 
 * @author Leticia Campos
 */
@WebServlet("/Afegir")
public class Afegir extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Mètode doPost per inserir un nou llibre.
     *
     * @param request Petició HTTP
     * @param response Resposta HTTP
     * @throws ServletException si ocorre un error de servlet
     * @throws IOException si ocorre un error d'entrada/sortida
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titol = request.getParameter("titol");
        String isbn = request.getParameter("isbn");
        int any = Integer.parseInt(request.getParameter("any_publicacio"));
        int editorial = Integer.parseInt(request.getParameter("id_editorial"));

        try (Connection connexio = Connexio.obtenirConnexio();
             PreparedStatement ps = connexio.prepareStatement(
                     "INSERT INTO llibres (titol, isbn, any_publicacio, id_editorial) VALUES (?, ?, ?, ?)")) {

            ps.setString(1, titol);
            ps.setString(2, isbn);
            ps.setInt(3, any);
            ps.setInt(4, editorial);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("Consulta");
    }
}

