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
        <title>Lista de materias</title>
    </head>
    <body>
        <table>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Descripción</th>
                <th>Carrera</th>
                <th>E</th>
                <th>E</th>
            </tr>
            <c:forEach var="materias" items="${lista}">
                <tr>
                    <td><c:out value="${materias.idmateria}"/></td>
                    <td><c:out value="${materias.nombremateria}"/></td>
                    <td><c:out value="${materias.descripcion}"/></td>
                    <td><c:out value="${materias.carreraIdcarrera}"/></td>
                    <td><a href="MateriaServlet?accion=eliminar&id=${materias.idmateria} ">Eliminar</a></td>
                    <td><a href="MateriaServlet?accion=actualizar&id=${materias.idmateria} ">Actualizar</a></td>
                </tr>
            </c:forEach>

        </table>
        <a href="LlenarCarrerasMateria">Nueva carrera</a>
    </body>
</html>
