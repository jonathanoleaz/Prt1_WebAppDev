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
        <title>Formulario de alumnos</title>
    </head>
    <body>
        <fieldset>
            <legend>Datos</legend>
            <form name="alumnoForm" id="alumnoForm"
                  method="post" action="AlumnoServlet?accion=guardar">
                <table>
                    <tr>
                        <th>ID:  </th>
                        <td><input type="number" name="txtID" 
                                   value="<c:out value="${alumno.noboleta}"/>"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Nombre: </th>
                        <td><input type="text" name="txtNombre"
                                   value="<c:out value="${alumno.nombre}"/>"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Ap.Paterno: </th>
                        <td><input type="text" name="txtPaterno"
                                   value="<c:out value="${alumno.paterno}"/>"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Ap.Materno: </th>
                        <td><input type="text" name="txtMaterno"
                                   value="<c:out value="${alumno.materno}"/>"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Domicilio: </th>
                        <td><input type="text" name="txtDomicilio"
                                   value="<c:out value="${alumno.domicilio}"/>"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Email: </th>
                        <td>
                            <input type="text" name="txtEmail"
                                   value="<c:out value="${alumno.email}"/>"/>
                        </td>

                        <th>ID carrera: </th>
                        <td>
                            <select name="txtCarrera">
                                <c:forEach var="carreras" items="${listaCarreras}">
                                    <option value="${carreras.idcarrera}">${carreras.nombrecarrera}</option>
                                </c:forEach>
                            </select>
                            <input type="number" name="txtCarrera"
                                   value="<c:out value="${alumno.carreraIdcarrera}"/>"/>
                        </td>
                        <th>ID usuario creado: </th>
                        <td>
                            <input type="number" name="txtUsuario"
                                   value="<c:out value="${alumno.usuarioIdusuario}"/>"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Aceptar </th>
                        <td colspan="2">
                            <input type="submit" name="cmdEnviar" value="enviar"/>
                        </td>
                    </tr>
                </table>
            </form>
        </fieldset>
        <a href="AlumnoServlet?accion=lista">Listado</a>
    </body>
</html>
