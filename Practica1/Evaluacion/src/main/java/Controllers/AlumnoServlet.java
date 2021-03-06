package Controllers;

import DAOs.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

public class AlumnoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        System.out.println("nada");
        String action = request.getParameter("accion");
        String alumnoOrProfesor = request.getParameter("alOrProf");
        if(alumnoOrProfesor!=null){
            if("Alumno".equals(alumnoOrProfesor)){
                alumnoOrProfesor=null;
            }
        }
        System.out.println("Alumno?="+alumnoOrProfesor);
        System.out.println(action);
        
        CarreraDAOImpl daoCarr = new CarreraDAOImpl();
        Carrera carr = new Carrera();
        request.setAttribute("listaCarreras", daoCarr.selectAll());
        
        
        if (alumnoOrProfesor==null) {
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
        } else if (alumnoOrProfesor.equals("profesor")) {
            if (action.equals("lista")) {
                System.out.println("nananana");
                listadoProfesor(request, response);
            } else {
                if (action.equals("nueva")) {
                    agregarProfesor(request, response);
                } else {
                    if (action.equals("eliminar")) {
                        eliminarProfesor(request, response);
                    } else {
                        if (action.equals("actualizar")) {
                            actualizarProfesor(request, response);
                        } else if (action.equals("guardar")) {
                            almacenarProfesor(request, response);
                        }
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
            System.out.println("dd:" + Arrays.toString(dao.selectAll().toArray()));
            request.setAttribute("lista", dao.selectAll());
            RequestDispatcher vista = request.getRequestDispatcher("AlumnoLista.jsp");
            vista.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AlumnoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        almacenar(request, response);
        RequestDispatcher vista = request.getRequestDispatcher("registrar.jsp");
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

        CarreraDAOImpl daoCarr = new CarreraDAOImpl();
        Carrera carr = new Carrera();

        request.setAttribute("listaCarreras", daoCarr.selectAll());

        String id = request.getParameter("id");
        System.out.println("id:" + id);
        c.setNoboleta(Integer.parseInt(id));
        c = dao.getByPrimaryKey(c.getNoboleta());
        System.out.println(c.toString());
        request.setAttribute("alumno", c);

        //almacenarArticulo(request, response);
        RequestDispatcher vista = request.getRequestDispatcher("registrar.jsp");
        vista.forward(request, response);

    }

    private void almacenar(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Guardando carrera");
        Alumno c = new Alumno();
        AlumnoDAOImpl d = new AlumnoDAOImpl();
        
        
        System.out.println(request.getParameter("txtID"));

        if (request.getParameter("txtID") == null || request.getParameter("txtID").isEmpty()) {

            try {
                System.out.println("se crea");
//                c.setIdcarrera(Integer.parseInt(request.getParameter("txtID")));
                c.setNombre(request.getParameter("txtNombre"));
                c.setMaterno(request.getParameter("txtMaterno"));
                c.setPaterno(request.getParameter("txtPaterno"));
                c.setDomicilio(request.getParameter("txtDomicilio"));
                c.setEmail(request.getParameter("txtEmail"));

                /*Usuario*/
                UsuarioDAOImpl usuarioDao=new UsuarioDAOImpl();
                Usuario usuario=new Usuario();
                usuario.setNombreUsuario(c.getNombre()+c.getPaterno()+c.getMaterno());
                usuario.setTipoUsuario(1);
                usuario.setPassword(BCrypt.hashpw(usuario.getNombreUsuario(), BCrypt.gensalt()));
                usuarioDao.insert(usuario);
                
                List foundUsers=usuarioDao.selectAll();
                usuario=(Usuario) foundUsers.get(foundUsers.size()-1);
                
                /*Usuario*/
                
                c.setUsuarioIdusuario(usuario.getIdusuario());
                //c.setUsuarioIdusuario(Integer.parseInt(request.getParameter("txtUsuario")));
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

                c.setUsuarioIdusuario(5);
                //c.setUsuarioIdusuario(Integer.parseInt(request.getParameter("txtUsuario")));
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

    private void listadoProfesor(HttpServletRequest request, HttpServletResponse response) {
        try {
            System.out.println("nada");
            ProfesorDAOImpl dao = new ProfesorDAOImpl();
            System.out.println("dd:" + Arrays.toString(dao.selectAll().toArray()));
            request.setAttribute("lista", dao.selectAll());
            RequestDispatcher vista = request.getRequestDispatcher("ProfesorLista.jsp");
            vista.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AlumnoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agregarProfesor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        almacenar(request, response);
        RequestDispatcher vista = request.getRequestDispatcher("registrar.jsp");
        vista.forward(request, response);
    }

    private void eliminarProfesor(HttpServletRequest request, HttpServletResponse response) {
        AlumnoDAOImpl dao = new AlumnoDAOImpl();
        Alumno c = new Alumno();
        String id = request.getParameter("idcarrera");
        c.setIdcarrera(Integer.parseInt(id));
        c = dao.getByPrimaryKey(c.getIdcarrera());
        dao.delete(c);
        listadoProfesor(request, response);
        
    }

    private void actualizarProfesor(HttpServletRequest request, HttpServletResponse response) throws DAOException, ServletException, IOException {
        ProfesorDAOImpl dao = new ProfesorDAOImpl();
        Profesor c = new Profesor();

        CarreraDAOImpl daoCarr = new CarreraDAOImpl();
        Carrera carr = new Carrera();

        request.setAttribute("listaCarreras", daoCarr.selectAll());

        String id = request.getParameter("id");
        System.out.println("id:" + id);
        c.setNoboleta(Integer.parseInt(id));
        c = dao.getByPrimaryKey(c.getNoboleta());
        System.out.println(c.toString());
        request.setAttribute("alumno", c);

        //almacenarArticulo(request, response);
        RequestDispatcher vista = request.getRequestDispatcher("registrar.jsp");
        vista.forward(request, response);
    }

    private void almacenarProfesor(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Guardando carrera");
        Profesor c = new Profesor();
        ProfesorDAOImpl d = new ProfesorDAOImpl();
        System.out.println(request.getParameter("txtID"));

        if (request.getParameter("txtID") == null || request.getParameter("txtID").isEmpty()) {

            try {
                System.out.println("se crea");
//                c.setIdcarrera(Integer.parseInt(request.getParameter("txtID")));
                c.setNombre(request.getParameter("txtNombre"));
                c.setMaterno(request.getParameter("txtMaterno"));
                c.setPaterno(request.getParameter("txtPaterno"));
                c.setDomicilio(request.getParameter("txtDomicilio"));
                c.setEmail(request.getParameter("txtEmail"));
                                                
                /*Usuario*/
                UsuarioDAOImpl usuarioDao=new UsuarioDAOImpl();
                Usuario usuario=new Usuario();
                usuario.setNombreUsuario(c.getNombre()+c.getPaterno()+c.getMaterno());
                usuario.setTipoUsuario(0);
                usuario.setPassword(BCrypt.hashpw(usuario.getNombreUsuario(), BCrypt.gensalt()));
                usuarioDao.insert(usuario);
                
                List foundUsers=usuarioDao.selectAll();
                usuario=(Usuario) foundUsers.get(foundUsers.size()-1);
                
                /*Usuario*/                
                
                c.setUsuarioIdusuario(usuario.getIdusuario());
                c.setCarreraIdcarrera(Integer.parseInt(request.getParameter("txtCarrera")));

                System.out.println("Prof to register: "+c.toString());
                d.insert(c);
                
                
                listadoProfesor(request, response);
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

                c.setUsuarioIdusuario(5);
                c.setCarreraIdcarrera(Integer.parseInt(request.getParameter("txtCarrera")));

                d.update(c);
                listadoProfesor(request, response);

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
