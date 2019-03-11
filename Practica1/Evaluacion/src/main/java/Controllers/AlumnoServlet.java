package Controllers;

import DAOs.*;
import java.io.IOException;
import java.util.Arrays;
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
public class AlumnoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        System.out.println("nada");
        String action = request.getParameter("accion");
        System.out.println(action);
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
            Logger.getLogger(AlumnoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AlumnoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            AlumnoDAOImpl dao = new AlumnoDAOImpl();
            System.out.println("dd:"+Arrays.toString(dao.selectAll().toArray()));
            request.setAttribute("lista", dao.selectAll());
            RequestDispatcher vista = request.getRequestDispatcher("AlumnoLista.jsp");
            vista.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AlumnoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        almacenar(request, response);
        RequestDispatcher vista = request.getRequestDispatcher("AlumnoForm.jsp");
        vista.forward(request, response);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        AlumnoDAOImpl dao = new AlumnoDAOImpl();
        Alumno c = new Alumno();
        String id = request.getParameter("idcarrera");
        c.setIdcarrera(Integer.parseInt(id));
        c = dao.getByPrimaryKey(c.getIdcarrera());
        dao.delete(c);
        listado(request, response);

    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        AlumnoDAOImpl dao = new AlumnoDAOImpl();
        Alumno c = new Alumno();
        String id = request.getParameter("id");
        System.out.println("id:"+id);
        c.setNoboleta(Integer.parseInt(id));
        c = dao.getByPrimaryKey(c.getNoboleta());
        System.out.println(c.toString());
        request.setAttribute("alumno", c);
        
        //almacenarArticulo(request, response);
        RequestDispatcher vista = request.getRequestDispatcher("AlumnoForm.jsp");
        vista.forward(request, response);

    }

    private void almacenar(HttpServletRequest request, HttpServletResponse response){
        System.out.println("Guardando carrera");
        Alumno c = new Alumno();
        AlumnoDAOImpl d = new AlumnoDAOImpl();
        if (request.getParameter("txtID") == null || request.getParameter("txtID").isEmpty()) {
            
            try {
                System.out.println("se crea");
//                c.setIdcarrera(Integer.parseInt(request.getParameter("txtID")));
                c.setNombre(request.getParameter("txtNombre"));
                c.setMaterno(request.getParameter("txtMaterno"));
                c.setPaterno(request.getParameter("txtPaterno"));
                c.setDomicilio(request.getParameter("txtDomicilio"));
                c.setEmail(request.getParameter("txtEmail"));
                
                c.setUsuarioIdusuario(Integer.parseInt(request.getParameter("txtUsuario")));
                c.setCarreraIdcarrera(Integer.parseInt(request.getParameter("txtCarrera")));
                
                
                d.insert(c);
                listado(request, response);
            } catch (Exception ex) {
                try {
                    ex.printStackTrace();
                    response.sendRedirect("Error.html");
                } catch (IOException ex1) {
                    Logger.getLogger(AlumnoServlet.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        } else {
            try {
                System.out.println("se actualiza");
                
                c.setNoboleta(Integer.parseInt(request.getParameter("txtID")));
                c.setNombre(request.getParameter("txtNombre"));
                c.setMaterno(request.getParameter("txtMaterno"));
                c.setPaterno(request.getParameter("txtPaterno"));
                c.setDomicilio(request.getParameter("txtDomicilio"));
                c.setEmail(request.getParameter("txtEmail"));
                
                c.setUsuarioIdusuario(Integer.parseInt(request.getParameter("txtUsuario")));
                c.setCarreraIdcarrera(Integer.parseInt(request.getParameter("txtCarrera")));
                
                d.update(c);
                listado(request, response);
                
            } catch (Exception ex) {
                try {
                    ex.printStackTrace();
                    response.sendRedirect("Error.html");
                } catch (IOException ex1) {
                    Logger.getLogger(AlumnoServlet.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
    }

}
