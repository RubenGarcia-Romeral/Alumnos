/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alumno;
import Modelo.Utilidades;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class AlumnosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private String rutaFichero;
    private ArrayList<Alumno> DAW_a = null;
    private ArrayList<Alumno> DAW_b = null;
    private ArrayList<String> grupos = null;
    
    
    
    
    public void init(ServletConfig config) throws ServletException {
        DAW_a = new ArrayList<Alumno>();
        DAW_b = new ArrayList<Alumno>();
        grupos = new ArrayList<String>();
        rutaFichero = config.getServletContext().getRealPath("").concat(File.separator).concat("ficheros");
        grupos.add("2daw_a");
        grupos.add("2daw_b");
        try {
            
            
            DAW_a = Utilidades.getProductos(rutaFichero.concat(File.separator).concat("2daw_a.txt"));
            DAW_b = Utilidades.getProductos(rutaFichero.concat(File.separator).concat("2daw_b.txt"));
        } catch (IOException ex) {
            
            
            Logger.getLogger(AlumnosServlet.class.getName()).log(Level.SEVERE, null, ex);
            
            
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
        
        
        String grupoSeleccionado;
        
            if(request.getParameter("grupo")!=null)grupoSeleccionado=request.getParameter("grupo");
                else grupoSeleccionado=grupos.get(0);
        
        
            if(grupoSeleccionado.equals("2daw_a"))request.setAttribute("daw_a2", DAW_a);
                else request.setAttribute("daw_b2", DAW_b);
            
            
        request.setAttribute("grupos",grupos);
        request.setAttribute("grupo", grupoSeleccionado);
        request.getRequestDispatcher("vista/Alumnos.jsp").forward(request, response);
        
        
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
        
        
        ArrayList<Alumno> seleccionados = new ArrayList<Alumno>();
        String grupoSeleccionado=request.getParameter("grupo");
        Alumno a=null;
        
        
        
        switch(grupoSeleccionado){
            case "2daw_a":
                for(Alumno al: DAW_a){
                    
                    
                    if(request.getParameter(String.valueOf(al.getId()))!=null){
                        a = new Alumno(al.getId(),al.getNombre(),al.getApellidos(),al.getEmail());
                        seleccionados.add(a);
                    }
                }
                
                
                break;
            case "2daw_b":
                
                
                for(Alumno al: DAW_b){
                    
                    if(request.getParameter(String.valueOf(al.getId()))!=null){
                        a = new Alumno(al.getId(),al.getNombre(),al.getApellidos(),al.getEmail());
                        
                        seleccionados.add(a);
                        
                    }
                    
                }
                break;
        }
        
        
        request.setAttribute("grupo", grupoSeleccionado);
        request.setAttribute("seleccionados", seleccionados);
        request.getRequestDispatcher("vista/mensajeAlumnos.jsp").forward(request, response);
        
        
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
