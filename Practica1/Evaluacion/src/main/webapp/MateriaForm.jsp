<%-- 
    Document   : CategoriaJSP
    Created on : 6/03/2019, 10:39:14 AM
    Author     : jonat
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de materias</title>
    </head>
    <body>
        <fieldset>
            <legend>Datos</legend>
            <form name="alumnoForm" id="alumnoForm"
                  method="post" action="MateriaServlet?accion=guardar">
                <table>
                    <tr>
                        <th>ID:  </th>
                        <td><input type="number" name="id" readonly="readonly" 
                                   value="<c:out value="${materia.idmateria}"/>"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Nombre: </th>
                        <td><input type="text" name="txtNombre"
                                   value="<c:out value="${materia.nombremateria}"/>"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Descripción: </th>
                        <td><input type="text" name="txtDescripcion"
                                   value="<c:out value="${materia.descripcion}"/>"/>
                        </td>
                    </tr>                    
                    <th>Carrera: </th>
                    <td>
                        <select name="txtCarrera">
                            <c:forEach var="carreras" items="${listaCarreras}">
                                <option value="${carreras.idcarrera}">${carreras.nombrecarrera}</option>
                            </c:forEach>
                        </select>
                        
                    </td>
                    
                    <tr>
                        <th>Aceptar </th>
                        <td colspan="2">
                            <input type="submit" name="cmdEnviar" value="enviar"/>
                        </td>
                    </tr>
                </table>
            </form>
        </fieldset>
        <a href="MateriaServlet?accion=lista">Listado</a>
    </body>
</html>
