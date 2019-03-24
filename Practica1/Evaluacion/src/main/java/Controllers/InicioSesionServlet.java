package Controllers;

import DAOs.DAOException;
import DAOs.Usuario;
import DAOs.UsuarioDAOImpl;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author jonat
 */
public class InicioSesionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DAOException {
        HttpSession session = request.getSession(true);
        Usuario user = new Usuario();
        UsuarioDAOImpl userDao = new UsuarioDAOImpl();
        String mensajeMostrar = "Sesion NO iniciada";

        user = (Usuario) userDao.getByNombreUsuario(request.getParameter("usuario")).get(0);
        if (user.getNombreUsuario() == null) {
            System.out.println("Inicio de sesión falló");
            response.sendRedirect("login.html");
        }
        Boolean coincidencia;
        coincidencia = BCrypt.checkpw(request.getParameter("password"), user.getPassword());
        //coincidencia = UsuarioDAO.checkPass(request.getParameter("password"), user.getPassword());
        System.out.println(">>" + coincidencia);
        if (coincidencia) {
            mensajeMostrar = "Sesión iniciada";
            session.setAttribute("nombreUsuario", user.getNombreUsuario());
            session.setAttribute("idUsuario", user.getIdusuario());

            if (user.getTipoUsuario() == 0) {
                response.sendRedirect("inicioProfesor.html");
            } else {
                response.sendRedirect("inicioAlumno.html");
            }
        } else {
            response.sendRedirect("iniciarSesion");

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (DAOException ex) {
            Logger.getLogger(InicioSesionServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (DAOException ex) {
            Logger.getLogger(InicioSesionServlet.class.getName()).log(Level.SEVERE, null, ex);
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

}
