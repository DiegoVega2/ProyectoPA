/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.dao.EmpleadoDAO;
import modelo.dto.Empleado;

/**
 *Validar es un servlet usado apra validar la sesión de un Empleado
 * @author DieguilloPillo
 */
public class Validar extends HttpServlet {
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *Este método sirve apra recibir peticiones de un usuario y una respuesta por parte del servidor de aplicaciones
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          String accion = request.getParameter("accion");
        switch (accion) {
            case "Ingresar":
                String u = request.getParameter("txtuser");
                String p = request.getParameter("txtpass");
                Empleado dto = new Empleado();
                dto.setUser(u);
                dto.setDni(p);
                EmpleadoDAO dao= new EmpleadoDAO();
                dto=dao.valSesion(dto);
                if(dto!=null){ //si hay sesion
                     System.out.println("ok entro a sesion");
                    HttpSession session = request.getSession();
                    session.setAttribute("usuario", dto);
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);//redireccionar
                }else{
                     System.out.println("NO Pailas a sesion");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                
                break;
            case "Salir":
                System.out.println("entre a cerrar la sesion1");
                 HttpSession session = request.getSession();
                 request.setAttribute("usuario", null);
                 session.invalidate();
                 request.getRequestDispatcher("Principal.jsp").forward(request, response);//redireccionar
                break;
        }
        
        
//        String accion=request.getParameter("accion");//nombre del botón
//        if(accion.equalsIgnoreCase("Ingresar")){//validar si se hizo clic en el boton
//            String user=request.getParameter("txtuser");
//            String pass=request.getParameter("txtpass");
//            objEm=objEmDAO.validar(user, pass);
//            if(objEm.getUser()!=""){
//                request.setAttribute("usuario", objEm);
//             request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);//redireccionar al controlador
//            }else{
//                request.getRequestDispatcher("index.jsp").forward(request, response);
//            }
//        }else{
//        request.getRequestDispatcher("index.jsp").forward(request, response);//redirecciona a la misma página
//
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *Método usado para el envio de datos de un formulario por medio del método get que llama al método processrequest para procesar la petición del usuario
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
     *Método usado para el envio de datos de un formulario por medio del método post que llama al método processrequest para procesar la petición del usuario
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                processRequest(request, response);

//        String accion=request.getParameter("accion");//nombre del botón
//        if(accion.equalsIgnoreCase("Ingresar")){//validar si se hizo clic en el boton
//            String user=request.getParameter("txtuser");
//            String pass=request.getParameter("txtpass");
//            objEm=objEmDAO.validar(user, pass);
//            if(objEm.getUser()!=""){
//                request.setAttribute("usuario", objEm);
//             request.getRequestDispatcher("Controlador?accion=Principal").forward(request, response);//redireccionar al controlador
//            }else{
//                request.getRequestDispatcher("index.jsp").forward(request, response);
//            }
//        }else{
//        request.getRequestDispatcher("index.jsp").forward(request, response);//redirecciona a la misma página
//
//        }
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
