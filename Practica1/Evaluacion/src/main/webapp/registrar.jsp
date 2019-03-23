<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="ISO-8859-1"> 
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Sistema de EvaluaciÃ³n</title>
        <link rel="shortcut icon" href="images/maletin.png" type="image/x-icon">
        <!--Style-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
        <link rel="stylesheet" type="text/css" href="login.css">
        <!-- Bulma Version 0.7.4-->
        <link rel="stylesheet" href="https://unpkg.com/bulma@0.7.4/css/bulma.min.css" />
        <!--Script-->
        <script type="text/javascript" src="js/main.js"></script>

        <style type="text/css">
            html,
            body {
                font-family: 'Open Sans';
            }
            img {
                padding: 5px;
            }
        </style>
    </head>

    <body>
        <section class="hero is-dark is-short is-bold">
            <section class="hero is-dark is-short is-bold">
                <div class="hero-head">
                    <nav class="navbar is-dark">
                        <div class="container">
                            <div class="navbar-brand">
                                <a class="navbar-item" href="index.html">
                                    <h2 class="subtitle has-text-white has-text-weight-bold">SISTEMA PARA LA EVALUACIÓN</h2>
                                </a>
                                <span class="navbar-burger burger" data-target="navbarMenu">
                                    <span></span>
                                    <span></span>
                                    <span></span>
                                </span>
                            </div>
                            <div id="navbarMenu" class="navbar-menu">
                                <div class="navbar-end">
                                    <div class="tabs is-right">
                                        <ul>
                                            <!----------------------------------------Links de las pÃ¡ginas------------------------------------------------->
                                            <li><a href="index.html">Inicio</a></li>
                                            <li class="is-active"><a href="login.html">Iniciar Sesión</a></li>
                                            <li><a href="registrar.html">Registrarse</a></li>
                                            <!----------------------------------------Links de las pÃ¡ginas------------------------------------------------->
                                        </ul>
                                    </div>
                                    </div>
                                </div>
                            </div>
                    </nav>
                </div>
            </section>
            <div class="hero-body" style="background: #EFEFBB;
                 background: -webkit-linear-gradient(to right, #D4D3DD, #EFEFBB);
                 background: linear-gradient(to right, #D4D3DD, #EFEFBB);">
                <div class="container has-text-centered" style="height: 540px;">
                    <div class="columns">
                        <div class="column is-4 is-offset-4">
                            <h3 class="title has-text-dark">Registro de usuario</h3>
                            <p class="subtitle has-text-grey">Por favor ingrese sus datos.</p>
                            <div class="box">
                                <figure class="avatar">
                                    <img src="images/equipo.png">
                                </figure>
                                <!----------------------------------------------------------------------------------------------------------------------------->                        
                                <form method="POST" name="alumnoForm" id="alumnoForm"
                  method="post" action="AlumnoServlet?accion=guardar">
                                    <div class="field">
                                        <div class="control">
                                            <!----------------------Boleta------------------------------------------------------->
                                            <input class="input is-medium is-link" placeholder="Boleta" name="txtID" type="number"
                                                   value="<c:out value="${alumno.noboleta}"/>">
                                        </div>
                                    </div>

                                    <div class="field">
                                        <div class="control">
                                            <!----------------------Nombre(s)------------------------------------------------------->
                                            <input class="input is-medium is-link" placeholder="Nombre(s)" type="text" name="txtNombre"
                                                   value="<c:out value="${alumno.nombre}"/>" >
                                        </div>
                                    </div>

                                    <div class="field">
                                        <div class="control">
                                            <!----------------------Paterno------------------------------------------------------->
                                            <input class="input is-medium is-link" placeholder="Apellido Paterno" type="text" name="txtPaterno"
                                                   value="<c:out value="${alumno.paterno}"/>">
                                        </div>
                                    </div>

                                    <div class="field">
                                        <div class="control">
                                            <!----------------------Materno------------------------------------------------------->
                                            <input class="input is-medium is-link" placeholder="Apellido Materno" type="text" name="txtMaterno"
                                                   value="<c:out value="${alumno.paterno}"/>">
                                        </div>
                                    </div>

                                    <div class="field">
                                        <div class="control">
                                            <!----------------------Domicilio------------------------------------------------------->
                                            <input class="input is-medium is-link" placeholder="Domicilio" name="txtDomicilio"
                                                   value="<c:out value="${alumno.domicilio}"/>">
                                        </div>
                                    </div>

                                    <div class="field">
                                        <div class="control">
                                            <!----------------------Domicilio------------------------------------------------------->
                                            <input class="input is-medium is-link" type="text" name="txtEmail"
                                                   value="<c:out value="${alumno.email}"/>"/>
                                        </div>
                                    </div>

                                    <div class="field">
                                        <div class="control" >
                                            <div class="select is-medium is-link is-fullwidth">
                                                <!----------------------Tipo Usuario----------------------------------------------->
                                                <select name="alOrProf">
                                                    <option value="profesor">Profesor</option>
                                                    <option >Alumno</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="field">
                                        <div class="control">
                                            <div class="select is-medium is-link is-fullwidth">
                                                <!----------------------Carreras------------------------------------------------------>
                                                <select name="txtCarrera">
                                                    <c:forEach var="carreras" items="${listaCarreras}">
                                                        <option value="${carreras.idcarrera}">${carreras.nombrecarrera}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                        <input class="button is-block is-link is-large is-fullwidth" type="submit" name="cmdEnviar" value="enviar">
                                </form>
                                        <a href="AlumnoServlet?accion=lista">Listado de alumnos</a>
                                        <a href="AlumnoServlet?accion=lista&alOrProf=profesor">Listado de profesores</a>
                                <!----------------------------------------------------------------------------------------------------------------------------->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="hero-foot">
            </div>
        </section>
        <section class="section" style="background: #EFEFBB;
                 background: -webkit-linear-gradient(to right, #D4D3DD, #EFEFBB);
                 background: linear-gradient(to right, #D4D3DD, #EFEFBB);">
        </section>
        <section class="section" style="background: #EFEFBB;
                 background: -webkit-linear-gradient(to right, #D4D3DD, #EFEFBB);
                 background: linear-gradient(to right, #D4D3DD, #EFEFBB);">
        </section>
        <section class="section" style="background: #EFEFBB;
                 background: -webkit-linear-gradient(to right, #D4D3DD, #EFEFBB);
                 background: linear-gradient(to right, #D4D3DD, #EFEFBB);">
        </section>
        <script src="js/bulma.js"></script>
    </body>

</html>
