<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Alumno</title>
        <link rel="shortcut icon" href="images/maletin.png" type="image/x-icon">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
        <!-- Bulma Version 0.7.4-->
        <link rel="stylesheet" href="https://unpkg.com/bulma@0.7.4/css/bulma.min.css" />
        <link rel="stylesheet" type="text/css" href="css/hero.css">
        <link rel="stylesheet" href="https://unpkg.com/bulma-modal-fx/dist/css/modal-fx.min.css" />
        <style type="text/css">
            .tabcontent {
                display: none;
            }
            .tabcontent2 {
                display: block;
            }
        </style>
    </head>
    <body>
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
                                        <!----------------------------------------Links de las páginas------------------------------------------------->
                                        <li><a href="inicioAlumno.html">Inicio</a></li>
                                        <li><a href="hacerExamen.html">Realizar Examen</a></li>
                                        <li class="is-active"><a href="verCalificaciones.html">Ver Mis Calificaciones</a></li>
                                        <li><a href="#">Ayuda</a></li>
                                        <!----------------------------------------Links de las páginas------------------------------------------------->
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
            <div class="hero-body" >
                <div class="container has-text-centered">
                    <h1 class="title">
                        Calificaciones Obtenidas
                    </h1>
                </div>
            </div>
        </section>        
        <section class="container">
            <div class="sandbox">
                <div class="tile is-ancestor">
                    <div class="tile is-parent is-full is-shady">
                        <article class="tile is-child notification is-white">
                            <table class="table is-fullwidth">
                                <thead>
                                    <tr>
                                        <!----------------------------------CABECERA DE LA TALBA----------------------------------------------------------->
                                        <th>ID</th>
                                        <th>MATERIA</th>
                                        <th>FECHA</th>
                                        <th>CALIFICACI�N</th>
                                        <!----------------------------------------------------------------------------------------------------------------->
                                    </tr>
                                </thead>
                                <tbody>
                                    <!----------------------------------CONTENIDO DE LA TALBA----------------------------------------------------------->
                                    <c:forEach var="resultado" items="${listaResultados}">
                                        <tr>
                                            <td><c:out value="${resultado.idresultado}"/></td>
                                            <td><c:out value="${resultado.materiaIdmateria}"/></td>
                                            <td><c:out value="${resultado.fecha}"/></td>
                                            <td><c:out value="${resultado.calificacion}"/></td>
                                            
                                        </tr>
                                    </c:forEach>
                                    <!----------------------------------------------------------------------------------------------------------------->
                                </tbody>
                            </table>  
                        </article>
                    </div>
                </div>
            </div>
        </section>
        <footer class="footer is-short">
            <div class="container">
                <div class="columns">
                    <div class="column is-3 is-offset-2">
                        <h2><strong>Enlaces</strong></h2>
                        <ul>
                            <li><a href="https://www.gob.mx/sep">Secretaría de Educación Pública</a></li>
                            <li><a href="https://www.asociacionmexicanadepedagogia.com/about">Asociación Mexicana de Pedagogía</a></li>            
                            <li><a href="http://inicio.ifai.org.mx/SitePages/ifai.aspx">Instituto Nacional de Transparencia, Acceso a la Información y Protección de Datos Personales</a></li>
                        </ul>
                    </div>
                    <div class="column is-3">
                    </div>
                    <div class="column is-4">
                        <h2><strong>Contacto</strong></h2>
                        <ul>
                            <li>Mesa de ayuda: dudas e información gobmx@funcionpublica.gob.mx</li>
                            <li>Contactanos: 55 55 55 55 55</li>
                            <li><a href="https://github.com/luisfig">Git Hub</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <script src="js/bulma.js"></script>
        </footer>
        <script></script>
    </body>
</html>
