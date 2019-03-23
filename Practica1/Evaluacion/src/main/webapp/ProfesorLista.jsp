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
        <meta charset="ISO-8859-1"> 
        <title>Lista de profesores</title>
    </head>
    <body>
        Lista de profesores
        <table>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Paterno</th>
                <th>Materno</th>
                <th>Paterno</th>
                <th>Domicilio</th>
                <th>Email</th>
                <th>Usuario</th>
                <th>Carrera</th>
                <th>E</th>
                <th>E</th>
            </tr>
            <c:forEach var="profesores" items="${lista}">
                <tr>
                    <td><c:out value="${profesores.noboleta}"/></td>
                    <td><c:out value="${profesores.nombre}"/></td>
                    <td><c:out value="${profesores.materno}"/></td>
                    <td><c:out value="${profesores.paterno}"/></td>
                    <td><c:out value="${profesores.domicilio}"/></td>
                    <td><c:out value="${profesores.email}"/></td>
                    <td><c:out value="${profesores.usuarioIdusuario}"/></td>
                    <td><c:out value="${profesores.carreraIdcarrera}"/></td>
                    
                    <td><a href="AlumnoServlet?accion=eliminar&id=${profesores.noboleta}&alOrProf=profesor ">Eliminar</a></td>
                    <td><a href="AlumnoServlet?accion=actualizar&id=${profesores.noboleta}&alOrProf=profesor">Actualizar</a></td>
                </tr>
            </c:forEach>
<a href="registrar.jsp">Nueva carrera</a>
        </table>
    </body>
</html>
