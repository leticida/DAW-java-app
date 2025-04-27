<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestió de llibres</title>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">

    <h1 class="mb-4">Gestió de llibres</h1>

    <!-- Formulari per afegir nou llibre -->
    <h2>Afegir nou llibre</h2>
    <form action="Afegir" method="post" class="mb-5">
        <div class="mb-3">
            <label for="titol" class="form-label">Títol</label>
            <input type="text" class="form-control" name="titol" required>
        </div>
        <div class="mb-3">
            <label for="isbn" class="form-label">ISBN</label>
            <input type="text" class="form-control" name="isbn" required>
        </div>
        <div class="mb-3">
            <label for="any_publicacio" class="form-label">Any de publicació</label>
            <input type="number" class="form-control" name="any_publicacio" required>
        </div>
        <div class="mb-3">
            <label for="id_editorial" class="form-label">ID Editorial</label>
            <input type="number" class="form-control" name="id_editorial" required>
        </div>
        <button type="submit" class="btn btn-primary">Afegir llibre</button>
    </form>

    <!-- Llistat de llibres -->
    <h2>Llibres disponibles</h2>

    <ul class="list-group">
        <%
            ArrayList<HashMap<String, String>> llibres = (ArrayList<HashMap<String, String>>) request.getAttribute("llibres");
            if (llibres != null) {
                for (HashMap<String, String> llibre : llibres) {
        %>
            <li class="list-group-item d-flex justify-content-between align-items-center">
                <span><%= llibre.get("id") %> - <%= llibre.get("titol") %> (ISBN: <%= llibre.get("isbn") %>)</span>
                <span>
                    <a href="Esborrar?id=<%= llibre.get("id") %>" class="btn btn-danger btn-sm">Eliminar</a>
                </span>
            </li>
        <%
                }
            } else {
        %>
            <li class="list-group-item">No hi ha llibres disponibles.</li>
        <%
            }
        %>
    </ul>

</body>
</html>
