/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VisoresPDF;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAOs.Conexion;
import java.io.File;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletOutputStream;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author jonat
 */
public class CalificacionesTodas extends HttpServlet {

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
            throws ServletException, IOException {
        generarPDF(response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
    
    private void generarPDF(HttpServletResponse response){

        ServletOutputStream sos=null;
        try {
            Connection cn= Conexion.getConexion();
            sos = response.getOutputStream();
            System.out.println(getServletConfig().getServletContext().getRealPath(""));
            File archivo=new File(getServletConfig().getServletContext().getRealPath("/Reportes/TodasCalifs2.jasper"));
            byte[] bytes=null;
            bytes=JasperRunManager.runReportToPdf(archivo.getPath(), null, cn);
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            sos.write(bytes, 0, bytes.length);
            sos.flush();
            sos.close();
            
        }  catch (JRException ex) {
            Logger.getLogger(CalificacionesTodas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CalificacionesTodas.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        
    }

}
