<%-- 
    Document   : ListaCategorias
    Created on : 6/03/2019, 01:40:24 PM
    Author     : jonat
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de categorías</title>
    </head>
    <body>
        <table>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Descripción</th>
                <th>E</th>
                <th>E</th>
            </tr>
            <c:forEach var="carreras" items="${lista}">
                <tr>
                    <td><c:out value="${carreras.idcarrera}"/></td>
                    <td><c:out value="${carreras.nombrecarrera}"/></td>
                    <td><c:out value="${carreras.descripcion}"/></td>
                    <td><a href="CarreraServlet?accion=eliminar&id=${carreras.idcarrera} ">Eliminar</a></td>
                    <td><a href="CarreraServlet?accion=actualizar&id=${carreras.idcarrera} ">Actualizar</a></td>
                </tr>
            </c:forEach>

        </table>
        <a href="CarreraForm.jsp">Nueva carrera</a>
    </body>
</html>
