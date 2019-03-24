package Controllers;

import DAOs.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jonat
 */
public class ExamenServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        
        CarreraDAOImpl daoCarr = new CarreraDAOImpl();
        Carrera carr = new Carrera();
        request.setAttribute("listaCarreras", daoCarr.selectAll());
        
        System.out.println("nada");
        String action = request.getParameter("accion");
        System.out.println(action);
        String id = request.getParameter("id");
        System.out.println("id:" + id);
        
        if (action.equals("lista")) {
            System.out.println("nananana");
            listado(request, response);
        } else {
            if (action.equals("nueva")) {
                agregar(request, response);
            } else {
                if (action.equals("eliminar")) {
                    eliminar(request, response);
                } else {
                    if (action.equals("actualizar")) {
                        actualizar(request, response);
                    } else if (action.equals("guardar")) {
                        almacenar(request, response);
                    }
                }
            }
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ExamenServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ExamenServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
/**/
    private void listado(HttpServletRequest request, HttpServletResponse response) {
        try {
            System.out.println("nada");
            ExamenDAOImpl dao = new ExamenDAOImpl();
            System.out.println("dd:" + Arrays.toString(dao.selectAll().toArray()));
            request.setAttribute("lista", dao.selectAll());
            RequestDispatcher vista = request.getRequestDispatcher("ExamenLista.jsp");
            vista.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ExamenServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void agregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        almacenar(request, response);
        
        MateriaDAOImpl daoCarr = new MateriaDAOImpl();
        
        request.setAttribute("listaMaterias", daoCarr.selectAll());
        
        RequestDispatcher vista = request.getRequestDispatcher("ExamenForm.jsp");
        vista.forward(request, response);
    }
    
    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ExamenDAOImpl dao = new ExamenDAOImpl();
        Examen c = new Examen();
        String id = request.getParameter("id");
        c.setIdexamen(Integer.parseInt(id));
        c = dao.getByPrimaryKey(c.getIdexamen());
        dao.delete(c);
        listado(request, response);
        
    }
    
    private void actualizar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ExamenDAOImpl dao = new ExamenDAOImpl();
        Examen c = new Examen();
        String id = request.getParameter("idExamen");
        System.out.println("id:" + id);
        c.setIdexamen(Integer.parseInt(id));
        c = dao.getByPrimaryKey(c.getIdexamen());
        System.out.println(c.toString());
        request.setAttribute("examen", c);
        
        PreguntaDAOImpl daoPreg = new PreguntaDAOImpl();
        List preguntas = new ArrayList();
        preguntas = daoPreg.getByExamenIdexamen(c.getIdexamen());
        System.out.println(Arrays.toString(preguntas.toArray()));
        Pregunta preg;
        for (int i = 0; i < preguntas.size(); i++) {
            preg = (Pregunta) preguntas.get(i);
            request.setAttribute("preg" + i, preg);
        }

        //almacenarArticulo(request, response);
        RequestDispatcher vista = request.getRequestDispatcher("Examen.jsp");
        vista.forward(request, response);
        
    }
    
    private void almacenar(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Guardando carrera");
        Examen c = new Examen();
        ExamenDAOImpl d = new ExamenDAOImpl();
        
        Pregunta preg = new Pregunta();
        PreguntaDAOImpl pregDao = new PreguntaDAOImpl();
        if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
            try {
                System.out.println("se crea");
//                c.setIdcarrera(Integer.parseInt(request.getParameter("txtID")));
                c.setDescripcion(request.getParameter("txtNombre"));
                c.setNombreexamen(request.getParameter("txtNombre"));
                c.setMateriaIdmateria(new MateriaDAOImpl().getByPrimaryKey(Integer.parseInt(request.getParameter("txtMateria"))).getIdmateria());
                
                java.util.Date date1 = new java.util.Date();
                java.sql.Date date2 = new java.sql.Date(date1.getTime());
                c.setFecha(date2);
                System.out.println("fecha: " + date2);
//c.setCarreraIdcarrera(new CarreraDAOImpl().getByPrimaryKey(Integer.parseInt(request.getParameter("txtCarrera"))).getIdcarrera());
                d.insert(c);
                
                c = (Examen) d.getByDescripcion(request.getParameter("txtNombre")).get(0);

                /*------->> Pregunta 1*/
                preg.setDescripcion(request.getParameter("txtDescripPreg1"));
                preg.setOpcion1(request.getParameter("txtOp1Preg1"));
                preg.setOpcion2(request.getParameter("txtOp2Preg1"));
                preg.setOpcion3(request.getParameter("txtOp3Preg1"));
                preg.setOpcioncorrecta(request.getParameter("txtOpCorrPreg1"));
                preg.setExamenIdexamen(c.getIdexamen());
                preg.setNombremateria("");
                
                pregDao.insert(preg);

                /*------->> Pregunta 2*/
                preg.setDescripcion(request.getParameter("txtDescripPreg2"));
                preg.setOpcion1(request.getParameter("txtOp1Preg2"));
                preg.setOpcion2(request.getParameter("txtOp2Preg2"));
                preg.setOpcion3(request.getParameter("txtOp3Preg2"));
                preg.setOpcioncorrecta(request.getParameter("txtOpCorrPreg2"));
                preg.setExamenIdexamen(c.getIdexamen());
                
                pregDao.insert(preg);

                /*------->> Pregunta 3*/
                preg.setDescripcion(request.getParameter("txtDescripPreg3"));
                preg.setOpcion1(request.getParameter("txtOp1Preg3"));
                preg.setOpcion2(request.getParameter("txtOp2Preg3"));
                preg.setOpcion3(request.getParameter("txtOp3Preg3"));
                preg.setOpcioncorrecta(request.getParameter("txtOpCorrPreg3"));
                preg.setExamenIdexamen(c.getIdexamen());
                
                pregDao.insert(preg);

                /*------->> Pregunta 4*/
                preg.setDescripcion(request.getParameter("txtDescripPreg4"));
                preg.setOpcion1(request.getParameter("txtOp1Preg4"));
                preg.setOpcion2(request.getParameter("txtOp2Preg4"));
                preg.setOpcion3(request.getParameter("txtOp3Preg4"));
                preg.setOpcioncorrecta(request.getParameter("txtOpCorrPreg4"));
                preg.setExamenIdexamen(c.getIdexamen());
                
                pregDao.insert(preg);

                /*------->> Pregunta 5*/
                preg.setDescripcion(request.getParameter("txtDescripPreg5"));
                preg.setOpcion1(request.getParameter("txtOp1Preg5"));
                preg.setOpcion2(request.getParameter("txtOp2Preg5"));
                preg.setOpcion3(request.getParameter("txtOp3Preg5"));
                preg.setOpcioncorrecta(request.getParameter("txtOpCorrPreg5"));
                preg.setExamenIdexamen(c.getIdexamen());
                preg.setNombremateria("");
                
                pregDao.insert(preg);

                /*------->> Pregunta 6*/
                preg.setDescripcion(request.getParameter("txtDescripPreg6"));
                preg.setOpcion1(request.getParameter("txtOp1Preg6"));
                preg.setOpcion2(request.getParameter("txtOp2Preg6"));
                preg.setOpcion3(request.getParameter("txtOp3Preg6"));
                preg.setOpcioncorrecta(request.getParameter("txtOpCorrPreg6"));
                preg.setExamenIdexamen(c.getIdexamen());
                
                pregDao.insert(preg);

                /*------->> Pregunta 7*/
                preg.setDescripcion(request.getParameter("txtDescripPreg7"));
                preg.setOpcion1(request.getParameter("txtOp1Preg7"));
                preg.setOpcion2(request.getParameter("txtOp2Preg7"));
                preg.setOpcion3(request.getParameter("txtOp3Preg7"));
                preg.setOpcioncorrecta(request.getParameter("txtOpCorrPreg7"));
                preg.setExamenIdexamen(c.getIdexamen());
                
                pregDao.insert(preg);

                /*------->> Pregunta 8*/
                preg.setDescripcion(request.getParameter("txtDescripPreg8"));
                preg.setOpcion1(request.getParameter("txtOp1Preg8"));
                preg.setOpcion2(request.getParameter("txtOp2Preg8"));
                preg.setOpcion3(request.getParameter("txtOp3Preg8"));
                preg.setOpcioncorrecta(request.getParameter("txtOpCorrPreg8"));
                preg.setExamenIdexamen(c.getIdexamen());
                
                pregDao.insert(preg);
                
                listado(request, response);
            } catch (Exception ex) {
                try {
                    ex.printStackTrace();
                    response.sendRedirect("Error.html");
                } catch (IOException ex1) {
                    Logger.getLogger(ExamenServlet.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        } else {
            try {
                System.out.println("se califica el examen");
                int puntos = 0;
                
                String idExamen = request.getParameter("id");
                
                ExamenDAOImpl exDao = new ExamenDAOImpl();
                Examen ex = exDao.getByPrimaryKey(Integer.parseInt(idExamen));
                
                MateriaDAOImpl matDao=new MateriaDAOImpl();
                Materia mat=new Materia();
                mat=matDao.getByPrimaryKey(ex.getMateriaIdmateria());
                
                ResultadoexamenDAOImpl resExamenDao = new ResultadoexamenDAOImpl();
                Resultadoexamen resExamen = new Resultadoexamen();
                
                resExamen.setAlumnoNoboleta(1005);
                
                java.util.Date date1 = new java.util.Date();
                java.sql.Date date2 = new java.sql.Date(date1.getTime());
                resExamen.setFecha(date2.toString());
                resExamen.setCalificacion(0);
                resExamen.setMateriaIdmateria(mat.getIdmateria());
                resExamen.setAlumnoNoboleta(1005);
                resExamenDao.insert(resExamen);
                
                List resExamenFoundList = resExamenDao.selectAll();
                
                resExamen = (Resultadoexamen) resExamenFoundList.get(resExamenFoundList.size() - 1);
                
                RespuestaDAOImpl respDao = new RespuestaDAOImpl();
                Respuesta resp = new Respuesta();
                
                for (int i = 0; i < 8; i++) {
                    resp.setOpcionelegida(Integer.parseInt(request.getParameter("res" + (i + 1))));
                    resp.setPreguntaIdpregunta(pregDao.getByPrimaryKey(Integer.parseInt(request.getParameter("id" + i))).getIdpregunta());
                    resp.setResultadoexamenIdresultado(resExamen.getIdresultado());
                    respDao.insert(resp);

                    /*Calificación de la respuesta*/
                    Pregunta pr = pregDao.getByPrimaryKey(resp.getPreguntaIdpregunta());
                    String respuesta = resp.getOpcionelegida().toString();
                    String respuestaCorrecta = pr.getOpcioncorrecta();
                    if (respuesta.equals(respuestaCorrecta)) {
                        puntos++;
                    }
                }
                
                resExamen.setCalificacion(puntos);
                
                resExamenDao.update(resExamen);

                //c.setIdmateria(Integer.parseInt(request.getParameter("id")));
                //c.setDescripcion(request.getParameter("txtDescripcion"));
                //c.setNombremateria(request.getParameter("txtNombre"));
                //c.setCarreraIdcarrera(new CarreraDAOImpl().getByPrimaryKey(Integer.parseInt(request.getParameter("txtCarrera"))).getIdcarrera());
                //d.update(c);
                listado(request, response);
                
            } catch (Exception ex) {
                try {
                    ex.printStackTrace();
                    response.sendRedirect("Error.html");
                } catch (IOException ex1) {
                    Logger.getLogger(ExamenServlet.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
    }
}
