<%-- 
    Document   : ListaCategorias
    Created on : 6/03/2019, 01:40:24 PM
    Author     : jonat
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <c:forEach var="alumnos" items="${lista}">
                <tr>
                    <td><c:out value="${alumnos.noboleta}"/></td>
                    <td><c:out value="${alumnos.nombre}"/></td>
                    <td><c:out value="${alumnos.materno}"/></td>
                    <td><c:out value="${alumnos.paterno}"/></td>
                    <td><c:out value="${alumnos.domicilio}"/></td>
                    <td><c:out value="${alumnos.email}"/></td>
                    <td><c:out value="${alumnos.usuarioIdusuario}"/></td>
                    <td><c:out value="${alumnos.carreraIdcarrera}"/></td>
                    
                    <td><a href="AlumnoServlet?accion=eliminar&id=${alumnos.noboleta} ">Eliminar</a></td>
                    <td><a href="AlumnoServlet?accion=actualizar&id=${alumnos.noboleta} ">Actualizar</a></td>
                </tr>
            </c:forEach>
<a href="registrar.jsp">Nueva carrera</a>
        </table>
    </body>
</html>
