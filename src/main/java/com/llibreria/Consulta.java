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


@WebServlet("/Consulta")
public class Consulta extends HttpServlet {

    private static final long serialVersionUID = 1L;

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
