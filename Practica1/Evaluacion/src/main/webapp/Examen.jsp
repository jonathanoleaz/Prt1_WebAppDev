<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
                                    <!----------------------------------------Links de las páginas------------------------------------------------->
                                    <ul>
                                        <li><a href="inicioAlumno.html">Inicio</a></li>
                                        <li class="is-active"><a href="hacerExamen.html">Realizar Examen</a></li>
                                        <li><a href="verCalificaciones.html">Ver Mis Calificaciones</a></li>
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
                        Exámen
                    </h1>
                </div>
            </div>
        </section>        
        <section class="container">
            <div class="sandbox">
                <div class="tile is-ancestor">
                    <div class="tile is-parent is-full is-shady">
                        <article class="tile is-child notification is-white">
                            <div class="tabs is-centered">
                                <ul>
                                    <li class="tablinks is-active" onclick="openTab(event, 'Pregunta1')"><a style="text-decoration-color:white; color: #909497;">Pregunta 1</a></li>
                                    <li class="tablinks" onclick="openTab(event, 'Pregunta2')"><a style="text-decoration-color:white; color: #909497;">Pregunta 2</a></li>
                                    <li class="tablinks" onclick="openTab(event, 'Pregunta3')"><a style="text-decoration-color:white; color: #909497;">Pregunta 3</a></li>
                                    <li class="tablinks" onclick="openTab(event, 'Pregunta4')"><a style="text-decoration-color:white; color: #909497;">Pregunta 4</a></li>
                                    <li class="tablinks" onclick="openTab(event, 'Pregunta5')"><a style="text-decoration-color:white; color: #909497;">Pregunta 5</a></li>
                                    <li class="tablinks" onclick="openTab(event, 'Pregunta6')"><a style="text-decoration-color:white; color: #909497;">Pregunta 6</a></li>
                                    <li class="tablinks" onclick="openTab(event, 'Pregunta7')"><a style="text-decoration-color:white; color: #909497;">Pregunta 7</a></li>
                                    <li class="tablinks" onclick="openTab(event, 'Pregunta8')"><a style="text-decoration-color:white; color: #909497;">Pregunta 8</a></li>
                                </ul>
                            </div>
                            <div class="columns">
                                <div class="column"></div>
                                <div class="column is-half">

                                    <!----------------------------------FORMULARIO----------------------------------------------------------------------------------------->
                                    <form method="POST" name="examenForm" id="alumnoForm"
                                          action="ExamenServlet?accion=guardar&id=${examen.idexamen}">
                                        <input class="input is-medium is-link" type="text" placeholder="ID" name="id" readonly="readonly"
                                               value="<c:out value="${examen.idexamen}"/>">
                                        <!----------------------------------PREGUNTA 1------------------------------------------------------------------------------->
                                        <div class="tabcontent tabcontent2" id="Pregunta1">
                                            <input class="input is-medium is-link" type="text" placeholder="ID" name="id0" readonly="readonly"
                                               value="<c:out value="${preg0.idpregunta}"/>">
                                            
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-medium is-link" type="text" placeholder="Pregunta 1" name="pre1"
                                                           value="<c:out value="${preg0.descripcion}"/>">
                                                </div>
                                            </div>
                                            <div class="field ">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opción 1" name="pre1opc1"
                                                           value="<c:out value="${preg0.opcion1}"/>">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opción 2" name="pre1opc2"
                                                           value="<c:out value="${preg0.opcion2}"/>">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opción 3" name="pre1opc3"
                                                           value="<c:out value="${preg0.opcion3}"/>">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="number" min="1" max="3" name="res1" value="1">
                                                </div>
                                            </div>
                                        </div>

                                        <!----------------------------------PREGUNTA 2------------------------------------------------------------------------------->
                                        <div class="tabcontent" id="Pregunta2">
                                            <input class="input is-medium is-link" type="text" placeholder="ID" name="id1" readonly="readonly"
                                               value="<c:out value="${preg1.idpregunta}"/>">
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-medium is-link" type="text" placeholder="Pregunta 2" name="pre2"
                                                           value="<c:out value="${preg1.descripcion}"/>">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opción 1" name="pre2opc1"
                                                           value="<c:out value="${preg1.opcion1}"/>">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opción 2" name="pre2opc2"
                                                           value="<c:out value="${preg1.opcion2}"/>">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opción 3" name="pre2opc3"
                                                           value="<c:out value="${preg1.opcion3}"/>">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="number" min="1" max="3" name="res2">
                                                </div>
                                            </div>
                                        </div>

                                        <!----------------------------------PREGUNTA 3------------------------------------------------------------------------------->
                                        <div class="tabcontent" id="Pregunta3">
                                            <input class="input is-medium is-link" type="text" placeholder="ID" name="id2" readonly="readonly"
                                               value="<c:out value="${preg2.idpregunta}"/>">
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-medium is-link" type="text" placeholder="Pregunta 3" name="pre3"
                                                           value="<c:out value="${preg2.descripcion}"/>">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opción 1" name="pre3opc1"
                                                           value="<c:out value="${preg2.opcion1}"/>">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opción 2" name="pre3opc2"
                                                           value="<c:out value="${preg2.opcion2}"/>">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opción 3" name="pre3opc3"
                                                           value="<c:out value="${preg2.opcion3}"/>">
                                                </div>
                                            </div>
                                            <div class="control">
                                                <input class="input is-short is-link" type="number" min="1" max="3" name="res3">
                                            </div>
                                        </div>

                                        <!----------------------------------PREGUNTA 4------------------------------------------------------------------------------->
                                        <div class="tabcontent" id="Pregunta4">
                                            <input class="input is-medium is-link" type="text" placeholder="ID" name="id3" readonly="readonly"
                                               value="<c:out value="${preg3.idpregunta}"/>">
                                            
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-medium is-link" type="text" placeholder="Pregunta 4" name="pre4"
                                                           value="<c:out value="${preg3.descripcion}"/>">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opción 1" name="pre4opc1"
                                                           value="<c:out value="${preg3.opcion1}"/>">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opción 2" name="pre4opc2"
                                                           value="<c:out value="${preg3.opcion2}"/>">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opción 3" name="pre4opc3"
                                                           value="<c:out value="${preg3.opcion3}"/>">
                                                </div>
                                            </div>
                                            <div class="control">
                                                <input class="input is-short is-link" type="number" min="1" max="3" name="res4">
                                            </div>
                                        </div>

                                        <!----------------------------------PREGUNTA 5------------------------------------------------------------------------------->
                                        <div class="tabcontent" id="Pregunta5">
                                            <input class="input is-medium is-link" type="text" placeholder="ID" name="id4" readonly="readonly"
                                               value="<c:out value="${preg4.idpregunta}"/>">
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-medium is-link" type="text" placeholder="Pregunta 5" name="pre5"
                                                           value="<c:out value="${preg4.descripcion}"/>">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opción 1" name="pre5opc1"
                                                           value="<c:out value="${preg4.opcion1}"/>">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opción 2" name="pre5opc2"
                                                           value="<c:out value="${preg4.opcion2}"/>">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opción 3" name="pre5opc3"
                                                           value="<c:out value="${preg4.opcion3}"/>">
                                                </div>
                                            </div>
                                            <div class="control">
                                                <input class="input is-short is-link" type="number" min="1" max="3" name="res5">
                                            </div>
                                        </div>

                                        <!----------------------------------PREGUNTA 6------------------------------------------------------------------------------->
                                        <div class="tabcontent" id="Pregunta6">
                                            <input class="input is-medium is-link" type="text" placeholder="ID" name="id5" readonly="readonly"
                                               value="<c:out value="${preg5.idpregunta}"/>">
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-medium is-link" type="text" placeholder="Pregunta 6" name="pre6"
                                                           value="<c:out value="${preg5.descripcion}"/>">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opción 1" name="pre6opc1"
                                                           value="<c:out value="${preg5.opcion1}"/>">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opción 2" name="pre6opc2"
                                                           value="<c:out value="${preg5.opcion2}"/>">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opción 3" name="pre6opc3"
                                                           value="<c:out value="${preg5.opcion3}"/>">
                                                </div>
                                            </div>
                                            <div class="control">
                                                <input class="input is-short is-link" type="number" min="1" max="3" name="res6">
                                            </div>
                                        </div>

                                        <!----------------------------------PREGUNTA 7------------------------------------------------------------------------------->
                                        <div class="tabcontent" id="Pregunta7">
                                            <input class="input is-medium is-link" type="text" placeholder="ID" name="id6" readonly="readonly"
                                               value="<c:out value="${preg6.idpregunta}"/>">
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-medium is-link" type="text" placeholder="Pregunta 7" name="pre7"
                                                           value="<c:out value="${preg6.descripcion}"/>">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opción 1" name="pre7opc1"
                                                           value="<c:out value="${preg6.opcion1}"/>">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opción 2" name="pre7opc2" 
                                                           value="<c:out value="${preg6.opcion2}"/>">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opción 3" name="pre7opc3"
                                                           value="<c:out value="${preg6.opcion3}"/>">
                                                </div>
                                            </div>
                                            <div class="control">
                                                <input class="input is-short is-link" type="number" min="1" max="3" name="res7">
                                            </div>
                                        </div>

                                        <!----------------------------------PREGUNTA 8------------------------------------------------------------------------------->
                                        <div class="tabcontent" id="Pregunta8">
                                            <input class="input is-medium is-link" type="text" placeholder="ID" name="id7" readonly="readonly"
                                               value="<c:out value="${preg7.idpregunta}"/>">
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-medium is-link" type="text" placeholder="Pregunta 8" name="pre8"
                                                           value="<c:out value="${preg7.descripcion}"/>">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opción 1" name="pre8opc1"
                                                           value="<c:out value="${preg7.opcion1}"/>">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opción 2" name="pre8opc2"
                                                           value="<c:out value="${preg7.opcion2}"/>">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opción 3" name="pre8opc3"
                                                           value="<c:out value="${preg7.opcion3}"/>">
                                                </div>
                                            </div>
                                            <div class="control">
                                                <input class="input is-short is-link" type="number" min="1" max="3" name="res8">
                                            </div>
                                            <br>
                                            <!----------------------------------BOTÓN---------------------------------------->
                                            <div class="field">
                                                <input type="submit" class="button is-block is-link is-large is-fullwidth" value="Enviar Respuestas">
                                            </div>
                                        </div>
                                    </form>
                                    <!----------------------------------FORMULARIO----------------------------------------------------------------------------------------->
                                </div>
                                <div class="column"></div>
                            </div>
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
        <script>
                                        function openTab(evt, opc) {
                                            var i, tabcontent, tablinks;
                                            tabcontent = document.getElementsByClassName("tabcontent");
                                            for (i = 0; i < tabcontent.length; i++) {
                                                tabcontent[i].style.display = "none";
                                            }
                                            tablinks = document.getElementsByClassName("tablinks");
                                            for (i = 0; i < tablinks.length; i++) {
                                                tablinks[i].className = tablinks[i].className.replace(" is-active", "");
                                            }
                                            document.getElementById(opc).style.display = "block";
                                            evt.currentTarget.className += " is-active";
                                        }
        </script>
    </body>
</html>
