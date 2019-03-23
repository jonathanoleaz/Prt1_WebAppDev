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
public class MateriaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        
        CarreraDAOImpl daoCarr = new CarreraDAOImpl();
        Carrera carr = new Carrera();
        request.setAttribute("listaCarreras", daoCarr.selectAll());
        
        
        System.out.println("nada");
        String action = request.getParameter("accion");
        System.out.println(action);
        String id = request.getParameter("id");
        System.out.println("id:"+id);
        
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
            Logger.getLogger(MateriaServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MateriaServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            MateriaDAOImpl dao = new MateriaDAOImpl();
            System.out.println("dd:"+Arrays.toString(dao.selectAll().toArray()));
            request.setAttribute("lista", dao.selectAll());
            RequestDispatcher vista = request.getRequestDispatcher("MateriaLista.jsp");
            vista.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(MateriaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        almacenar(request, response);
        CarreraDAOImpl daoCarr = new CarreraDAOImpl();
        Carrera carr = new Carrera();
        request.setAttribute("listaCarreras", daoCarr.selectAll());
        
        RequestDispatcher vista = request.getRequestDispatcher("MateriaForm.jsp");
        vista.forward(request, response);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MateriaDAOImpl dao = new MateriaDAOImpl();
        Materia c = new Materia();
        String id = request.getParameter("id");
        c.setIdmateria(Integer.parseInt(id));
        c = dao.getByPrimaryKey(c.getIdmateria());
        dao.delete(c);
        listado(request, response);

    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MateriaDAOImpl dao = new MateriaDAOImpl();
        Materia c = new Materia();
        String id = request.getParameter("id");
        System.out.println("id:"+id);
        c.setIdmateria(Integer.parseInt(id));
        c = dao.getByPrimaryKey(c.getIdmateria());
        System.out.println(c.toString());
        request.setAttribute("materia", c);
        
        //almacenarArticulo(request, response);
        RequestDispatcher vista = request.getRequestDispatcher("MateriaForm.jsp");
        vista.forward(request, response);

    }

    private void almacenar(HttpServletRequest request, HttpServletResponse response){
        System.out.println("Guardando carrera");
        Materia c = new Materia();
        MateriaDAOImpl d = new MateriaDAOImpl();
        if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {            
            try {
                System.out.println("se crea");
//                c.setIdcarrera(Integer.parseInt(request.getParameter("txtID")));
                c.setDescripcion(request.getParameter("txtDescripcion"));
                c.setNombremateria(request.getParameter("txtNombre"));
                c.setCarreraIdcarrera(new CarreraDAOImpl().getByPrimaryKey(Integer.parseInt(request.getParameter("txtCarrera"))).getIdcarrera());
                d.insert(c);
                listado(request, response);
            } catch (Exception ex) {
                try {
                    ex.printStackTrace();
                    response.sendRedirect("Error.html");
                } catch (IOException ex1) {
                    Logger.getLogger(MateriaServlet.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        } else {
            try {
                System.out.println("se actualiza");
                
                c.setIdmateria(Integer.parseInt(request.getParameter("id")));
                c.setDescripcion(request.getParameter("txtDescripcion"));
                c.setNombremateria(request.getParameter("txtNombre"));
                c.setCarreraIdcarrera(new CarreraDAOImpl().getByPrimaryKey(Integer.parseInt(request.getParameter("txtCarrera"))).getIdcarrera());
                
                d.update(c);
                listado(request, response);
                
            } catch (Exception ex) {
                try {
                    ex.printStackTrace();
                    response.sendRedirect("Error.html");
                } catch (IOException ex1) {
                    Logger.getLogger(MateriaServlet.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
    }
}
