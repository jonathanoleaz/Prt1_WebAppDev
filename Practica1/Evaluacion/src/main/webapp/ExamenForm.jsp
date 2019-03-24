<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Profesor</title>
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
                                <h2 class="subtitle has-text-white has-text-weight-bold">SISTEMA PARA LA EVALUACI脫N</h2>
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
                                        <!----------------------------------------Links de las p谩ginas------------------------------------------------->
                                        <li><a href="inicioProfesor.html">Inicio</a></li>
                                        <li class="is-active"><a href="ExamenForm.html">Crear Examen</a></li>
                                        <li><a href="verGrafica.html">Ver Estad韘ticas</a></li>
                                        <li><a href="#">Ayuda</a></li>
                                        <!----------------------------------------Links de las p谩ginas------------------------------------------------->
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
                        Creaci髇 de cuestionario para la evaluaci髇
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
                                    <li class="tablinks is-active" onclick="openTab(event, 'Titulo')"><a style="text-decoration-color:white; color: #909497;">T铆tulo</a></li>
                                    <li class="tablinks" onclick="openTab(event, 'Pregunta1')"><a style="text-decoration-color:white; color: #909497;">Pregunta 1</a></li>
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
                                          action="ExamenServlet?accion=guardar">
                                        <!----------------------------------T脥TULO------------------------------------------------------------------------------->
                                        <div class="field tabcontent tabcontent2" id="Titulo">
                                            <div class="control">
                                                <input class="input is-medium is-link" type="text" placeholder="T韙ulo del cuestionario" type="text" name="txtNombre">
                                                Materia: <select name="txtMateria">
                                                    <c:forEach var="materias" items="${listaMaterias}">
                                                        <option value="${materias.idmateria}">${materias.nombremateria}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <!----------------------------------PREGUNTA 1------------------------------------------------------------------------------->
                                        <div class="tabcontent" id="Pregunta1">
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-medium is-link" type="text" placeholder="Pregunta 1" name="txtDescripPreg1">
                                                </div>
                                            </div>
                                            <div class="field ">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opci贸n 1" name="txtOp1Preg1">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opci贸n 2" name="txtOp2Preg1">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opci贸n 3" name="txtOp3Preg1">
                                                </div>
                                            </div>


                                            <select name="txtOpCorrPreg1">
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                            </select>
                                        </div>

                                        <!----------------------------------PREGUNTA 2------------------------------------------------------------------------------->
                                        <div class="tabcontent" id="Pregunta2">
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-medium is-link" type="text" placeholder="Pregunta 2" name="txtDescripPreg2">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opci贸n 1" name="txtOp1Preg2">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opci贸n 2" name="txtOp2Preg2">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opci贸n 3" name="txtOp3Preg2">
                                                </div>
                                            </div>
                                            <select name="txtOpCorrPreg2">
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                            </select>
                                        </div>

                                        <!----------------------------------PREGUNTA 3------------------------------------------------------------------------------->
                                        <div class="tabcontent" id="Pregunta3">
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-medium is-link" type="text" placeholder="Pregunta 3" name="txtDescripPreg3">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opci贸n 1" name="txtOp1Preg3">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opci贸n 2" name="txtOp2Preg3">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opci贸n 3" name="txtOp3Preg3">
                                                </div>
                                            </div>
                                            <select name="txtOpCorrPreg3">
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                            </select>
                                        </div>

                                        <!----------------------------------PREGUNTA 4------------------------------------------------------------------------------->
                                        <div class="tabcontent" id="Pregunta4">
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-medium is-link" type="text" placeholder="Pregunta 4" name="txtDescripPreg4">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opci贸n 1" name="txtOp1Preg4">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opci贸n 2" name="txtOp2Preg4">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opci贸n 3" name="txtOp3Preg4">
                                                </div>
                                            </div>
                                            <select name="txtOpCorrPreg4">
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                            </select>
                                        </div>

                                        <!----------------------------------PREGUNTA 5------------------------------------------------------------------------------->
                                        <div class="tabcontent" id="Pregunta5">
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-medium is-link" type="text" placeholder="Pregunta 5" name="txtDescripPreg5">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opci贸n 1" name="txtOp1Preg5">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opci贸n 2" name="txtOp2Preg5">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opci贸n 3" name="txtOp3Preg5">
                                                </div>
                                            </div>
                                            <select name="txtOpCorrPreg5">
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                            </select>
                                        </div>

                                        <!----------------------------------PREGUNTA 6------------------------------------------------------------------------------->
                                        <div class="tabcontent" id="Pregunta6">
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-medium is-link" type="text" placeholder="Pregunta 6" name="txtDescripPreg6">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opci贸n 1" name="txtOp1Preg6">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opci贸n 2" name="txtOp2Preg6">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opci贸n 3" name="txtOp3Preg6">
                                                </div>
                                            </div>
                                            <select name="txtOpCorrPreg6">
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                            </select>
                                        </div>

                                        <!----------------------------------PREGUNTA 7------------------------------------------------------------------------------->
                                        <div class="tabcontent" id="Pregunta7">
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-medium is-link" type="text" placeholder="Pregunta 7" name="txtDescripPreg7">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opci贸n 1" name="txtOp1Preg7">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opci贸n 2" name="txtOp2Preg7">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opci贸n 3" name="txtOp3Preg7">
                                                </div>
                                            </div>
                                            <select name="txtOpCorrPreg7">
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                            </select>
                                        </div>

                                        <!----------------------------------PREGUNTA 8------------------------------------------------------------------------------->
                                        <div class="tabcontent" id="Pregunta8">
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-medium is-link" type="text" placeholder="Pregunta 8" name="txtDescripPreg8">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opci贸n 1" name="txtOp1Preg8">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opci贸n 2" name="txtOp2Preg8">
                                                </div>
                                            </div>
                                            <div class="field">
                                                <div class="control">
                                                    <input class="input is-short is-link" type="text" placeholder="Opci贸n 3" name="txtOp3Preg8">
                                                </div>
                                            </div>
                                            <select name="txtOpCorrPreg8">
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                            </select>
                                            <br>
                                            <!----------------------------------BOT覰---------------------------------------->
                                            <div class="field">
                                                <input type="submit" class="button is-block is-link is-large is-fullwidth" value="Crear Examen">
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
                            <li><a href="https://www.gob.mx/sep">Secretar韆 de Educaci髇 P鷅lica</a></li>
                            <li><a href="https://www.asociacionmexicanadepedagogia.com/about">Asociaci髇 Mexicana de Pedagog韆</a></li>            
                            <li><a href="http://inicio.ifai.org.mx/SitePages/ifai.aspx">Instituto Nacional de Transparencia, Acceso a la Informaci贸n y Protecci贸n de Datos Personales</a></li>
                        </ul>
                    </div>
                    <div class="column is-3">
                    </div>
                    <div class="column is-4">
                        <h2><strong>Contacto</strong></h2>
                        <ul>
                            <li>Mesa de ayuda: dudas e informaci髇 gobmx@funcionpublica.gob.mx</li>
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
