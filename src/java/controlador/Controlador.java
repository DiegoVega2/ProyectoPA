/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import config.GenerarSerie;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.dao.ClienteDAO;
import modelo.dao.EmpleadoDAO;
import modelo.dao.ProductoDAO;
import modelo.dao.VentaDAO;
import modelo.dto.Cliente;
import modelo.dto.Empleado;
import modelo.dto.Fecha;
import modelo.dto.Producto;
import modelo.dto.Venta;

/**
 *Clase controlador para controlar la logica del paquete modelo y los procesos realizados en un sitioweb de SistemaVentas
 * @author DieguilloPillo
 */
public class Controlador extends HttpServlet {
     private Empleado objEm= new Empleado();
     private EmpleadoDAO objEmDAO=new EmpleadoDAO();
     private Cliente objC = new Cliente();
     private ClienteDAO objCDAO = new ClienteDAO();
     private Producto objP = new Producto();
     private ProductoDAO objPDAO = new ProductoDAO();
     private Venta objV = new Venta();    
     private VentaDAO objVDAO = new VentaDAO();
     private List<Venta> lista= new ArrayList<>();
     private int item,cod,cant;
     private String descripcion;
     private double precio, subtotal;
     private double totalapagar=0;  
     private int ide,idc,idp,atendio;
     String numeroserie;
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
        HttpSession session= request.getSession();
        Empleado emple = (Empleado)session.getAttribute("usuario");
        if(emple==null){
            System.out.println("No ha Iniciado Sesion");
        }else{
            String menu=request.getParameter("menu");
        String accion=request.getParameter("accion");
        String idempleado1=request.getParameter("idempleado1");
        if((idempleado1!=null)&& (idempleado1!="0")){
          atendio=Integer.parseInt(idempleado1);
        }
        if(menu.equals("Principal")){
                request.getRequestDispatcher("Principal.jsp").forward(request, response);          
        }
        if(menu.equals("Empleado")){
            lista.clear();
            totalapagar=0;
            switch(accion){
                case "Listar":
                    List lista = objEmDAO.listar();
                    request.setAttribute("empleados", lista);
                    break; 
                case "Agregar":
                    String dni=request.getParameter("txtDni");
                    String nom=request.getParameter("txtNombres");
                    String tel=request.getParameter("txtTel");
                    String est=request.getParameter("txtEstado");
                    String user=request.getParameter("txtUsuario");
                    objEm.setDni(dni);
                    objEm.setNombre(nom);
                    objEm.setTelefono(tel);
                    objEm.setEstado(est);
                    objEm.setUser(user);
                    objEmDAO.agregar(objEm);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1=request.getParameter("txtDni");
                    String nom1=request.getParameter("txtNombres");
                    String tel1=request.getParameter("txtTel");
                    String est1=request.getParameter("txtEstado");
                    String user1=request.getParameter("txtUsuario");
                    objEm.setDni(dni1);
                    objEm.setNombre(nom1);
                    objEm.setTelefono(tel1);
                    objEm.setEstado(est1);
                    objEm.setUser(user1);
                    objEm.setId(ide);
                    objEmDAO.actualizar(objEm);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide=Integer.parseInt(request.getParameter("id"));
                    Empleado e= objEmDAO.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    ide=Integer.parseInt(request.getParameter("id"));
                    objEmDAO.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);                   
                    break;
            }
           request.getRequestDispatcher("Empleado.jsp").forward(request, response);        
        }
        
         if(menu.equals("Clientes")){
             lista.clear();
             totalapagar=0;
                switch(accion){
                case "Listar":
                    List listaclientes = objCDAO.listar();
                    request.setAttribute("listaclientes", listaclientes);
                    System.out.println("hola: "+listaclientes.toString());
                    break; 
                case "Agregar":
                    String dni=request.getParameter("txtDni");
                    String nom=request.getParameter("txtNombres");
                    String dir=request.getParameter("txtDir");
                    String est=request.getParameter("txtEstado");
                    objC.setDni(dni);
                    objC.setNombres(nom);
                    objC.setDireccion(dir);
                    objC.setEstado(est);
                    objCDAO.agregar(objC);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                String dni1=request.getParameter("txtDni");
                    String nom1=request.getParameter("txtNombres");
                    String dir1=request.getParameter("txtDir");
                    String est1=request.getParameter("txtEstado");
                    objC.setDni(dni1);
                    objC.setNombres(nom1);
                    objC.setDireccion(dir1);
                    objC.setEstado(est1);
                    objC.setId(idc);
                    objCDAO.actualizar(objC);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                 break;
                case "Editar":
                    idc=Integer.parseInt(request.getParameter("id"));
                    Cliente c= objCDAO.listarId(idc);
                    request.setAttribute("cliente", c);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                  idc=Integer.parseInt(request.getParameter("id"));
                    objCDAO.delete(idc);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);    
                    break;
                default:
                    request.getRequestDispatcher("Clientes.jsp").forward(request, response); 
            }
           request.getRequestDispatcher("Clientes.jsp").forward(request, response);        
        }
          if(menu.equals("Producto")){
              lista.clear();
              totalapagar=0;
                switch(accion){
                case "Listar":
                    List listaproductos = objPDAO.listar();
                    request.setAttribute("listaproductos", listaproductos);
                    System.out.println("hola: "+listaproductos.toString());
                    break; 
                case "Agregar":
                    String nom=request.getParameter("txtNombres");
                    double precio=Double.parseDouble(request.getParameter("txtPrecio"));
                    int stock=Integer.parseInt(request.getParameter("txtStock"));
                    String est=request.getParameter("txtEstado");
                    objP.setNombres(nom);
                    objP.setStock(stock);
                    objP.setPrecio(precio);
                    objP.setEstado(est);
                    objPDAO.agregar(objP);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nom1=request.getParameter("txtNombres");
                    int stock1=Integer.parseInt(request.getParameter("txtStock"));
                    String est1=request.getParameter("txtEstado");
                    double precio1 = Double.parseDouble(request.getParameter("txtStock"));
                    objP.setNombres(nom1);
                    objP.setStock(stock1);
                    objP.setEstado(est1);
                    objP.setPrecio(precio1);
                    objP.setId(idp);
                    objPDAO.actualizar(objP);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idp=Integer.parseInt(request.getParameter("id"));
                    Producto p= objPDAO.listarId(idp);
                    request.setAttribute("producto", p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Delete":
                    idp=Integer.parseInt(request.getParameter("id"));
                    objPDAO.delete(idp);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
            }
           request.getRequestDispatcher("Producto.jsp").forward(request, response);        
        }
           if(menu.equals("RegistrarVenta")){
               switch(accion){
                case "BuscarCliente":
                    String dni=request.getParameter("codigocliente");
                    totalapagar=0;
                    objC.setDni(dni);
                    objC= objCDAO.buscar(dni);
                    request.setAttribute("objC",objC);
                    numeroserie=objVDAO.generarSerie();
                   if(numeroserie==null){
                       numeroserie="00000001";                      
                   }else{
                       int incrementar=Integer.parseInt(numeroserie);
                       GenerarSerie gs = new GenerarSerie();
                       numeroserie=gs.NumeroSerie(incrementar);
                   }
                   request.setAttribute("nserie", numeroserie);
                    break; 
                case "BuscarProducto":
                    int id=Integer.parseInt(request.getParameter("codigoproducto"));
                    objP=objPDAO.listarId(id);
                    request.setAttribute("objC",objC);
                    request.setAttribute("producto", objP);//mandar objeto a jsp
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalpagar", totalapagar);
                    request.setAttribute("nserie", numeroserie);
                    break; 
                case "Agregar":
                    request.setAttribute("objC",objC);
                    request.setAttribute("nserie", numeroserie);
                    item=item+1;
                    cod=objP.getId();
                    descripcion=request.getParameter("nomproducto");
                    precio=Double.parseDouble(request.getParameter("precio"));
                    cant=Integer.parseInt(request.getParameter("cant"));
                    subtotal=precio*cant;
                    objV= new Venta();
                    objV.setItem(item);
                    objV.setIdProducto(cod);
                    objV.setDescripcionp(descripcion);
                    objV.setPrecio(precio);
                    objV.setCantidad(cant);
                    objV.setSubtotal(subtotal);
                    lista.add(objV);
                    totalapagar=0;
                    for (int i = 0; i <lista.size(); i++) {                       
                        totalapagar=totalapagar+lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalpagar", totalapagar);
                    request.setAttribute("lista", lista);
                    break;
                case "GenerarVenta":
                    //Actualziación del Stock
                    for (int i = 0; i < lista.size(); i++) {
                        Producto objP = new Producto();
                        int cantidad =lista.get(i).getCantidad(); 
                        int idproducto= lista.get(i).getIdProducto();
                        ProductoDAO objPDAO = new ProductoDAO();
                        objP=objPDAO.buscar(idproducto);
                        int stockactual= (objP.getStock()-cantidad);
                        objPDAO.actualizarStock(idproducto, stockactual);
                    }
                    //guardar venta
                    objV.setIdcliente(objC.getId());
                    objV.setIdempleado(atendio);
                    objV.setNumserie(numeroserie);
                    objV.setFecha(new Fecha().toString());
                    totalapagar=0;
                    for (int i = 0; i <lista.size(); i++) {                       
                        totalapagar=totalapagar+lista.get(i).getSubtotal();
                    }
                    objV.setMonto(totalapagar);
                    objV.setEstado("1");
                    objVDAO.guardarVenta(objV);
                    //guardar detalle ventas
                    System.out.println("ya genere la venta");
                    int idv=Integer.parseInt(objVDAO.idVentas());
                    
                    for (int i = 0; i < lista.size(); i++) {
                        System.out.println("entre al ciclo generarventa");
                        System.out.println("lista: "+lista.get(i).toString());
                        objV=new Venta();
                        objV=lista.get(i);
                        objV.setId(idv);
//                        objV.setIdProducto(lista.get(i).getIdProducto());
//                        objV.setCantidad(lista.get(i).getCantidad());
//                        objV.setPrecio(lista.get(i).getPrecio());
                        System.out.println("VENTA JEJE:"+objV.toString());
                        objVDAO.guardarDetalleventas(objV);
                    }
                    lista.clear();
                    totalapagar=0;
                    item=0;
                    break;
                case "Cancelar":
                    objV=new Venta();
                    lista.clear();
                    totalapagar=0;
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                    break;
                case "Editar":
                    System.out.println("entre a editar");
                    idv=Integer.parseInt(request.getParameter("id"));
                    int cantidad=4; 
                    lista=objVDAO.actualizar(idv, cantidad, lista);
                    totalapagar=0;
                    for (int i = 0; i <lista.size(); i++) {                       
                        totalapagar=totalapagar+lista.get(i).getSubtotal();
                    }
                    request.setAttribute("objC",objC);
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("totalpagar", totalapagar);
                    request.setAttribute("lista", lista);
                    break;
                case "Eliminar":
                    idv=Integer.parseInt(request.getParameter("id"));
                    lista=objVDAO.eliminar(idv, lista);
                    totalapagar=0;
                    for (int i = 0; i <lista.size(); i++) {                       
                        totalapagar=totalapagar+lista.get(i).getSubtotal();
                    }
                    request.setAttribute("objC",objC);
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("totalpagar", totalapagar);
                    request.setAttribute("lista", lista);
                    break;
                default:
//                   numeroserie=objVDAO.generarSerie();
//                   if(numeroserie==null){
//                       numeroserie="00000001";                      
//                   }else{
//                       int incrementar=Integer.parseInt(numeroserie);
//                       GenerarSerie gs = new GenerarSerie();
//                       numeroserie=gs.NumeroSerie(incrementar);
//                   }
//                   request.setAttribute("nserie", numeroserie);
              request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);        
            }
           request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);        
        }  
        }       
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
