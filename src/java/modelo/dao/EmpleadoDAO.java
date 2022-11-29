/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.Empleado;

/**
 *Clase EmpleadoDAO usada para aplicar la CRUD desde el programa a la BD
 * y en la tabla de empleado
 * @author DieguilloPillo
 */
public class EmpleadoDAO {
    private Conexion cn= new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String respuesta="";

    /**
     *Método usado para validar si el usuario ingresado esta almacenado en la base de datos, en donde recibe los aprametros del usuario y contraseña, y si encuuentra un registro
     * en la base de datos que tenga estos datos exactamente, retorna un Objeto Empleado con los valores de la fila respectiva, en la tabla empleado
     * @param user
     * @param dni
     * @return
     */
    public Empleado validar(String user, String dni){
        Empleado objEm= new Empleado();
        String sql="select * from empleado where User=? and Dni=?";
        try {
            con=cn.conexion();
            System.out.println("Con: "+con);
            ps=con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs=ps.executeQuery();
            while(rs.next()){
              System.out.println("holaa: "+rs.getInt("IdEmpleado"));
              objEm.setId(rs.getInt("IdEmpleado"));
               objEm.setUser(rs.getString("User"));
               objEm.setDni(rs.getString("Dni"));
               objEm.setNombre(rs.getString("Nombres"));          
            }
        } catch (Exception e) {
            System.out.println("Error validando: "+e.getMessage());
        }
        System.out.println(objEm.toString());
        return objEm;
    }
    
    
    //CRUD

    /**
     *Método que devuelve una lista con todos los registros de la tabla empleado con ayuda de la clase Conexion
     * @return List
     */
    public List listar(){
      String sql="select * from empleado";  
      List<Empleado> lista = new ArrayList<>();
      try{
         con=cn.conexion();
         ps=con.prepareStatement(sql);
         rs=ps.executeQuery();//ejecutar consulta
         while(rs.next()){
             Empleado objEm = new Empleado();
             objEm.setId(rs.getInt(1));
             objEm.setDni(rs.getString(2));
             objEm.setNombre(rs.getString(3));
             objEm.setTelefono(rs.getString(4));
             objEm.setEstado(rs.getString(5));
             objEm.setUser(rs.getString(6));
             lista.add(objEm);
         }
      }catch(SQLException ex){
          System.out.println("Error listando Empleado: "+ex.getMessage()); 
      }
      return lista;
    }
    
    /**
    *Metodo que permite insertar registros en la BD, mas 
     * especificamente en la tabla empleado con ayuda de la clase Conexion, y retorna una respuesta acerca de si pudo agregar o no el registro a la tabla empelado dentro de la bd.
     * los registros que agrega son los parámetros del Empleado em enviado
     * @param em
     * @return Srting
     */
    public String agregar(Empleado em){
        String sql="insert into empleado(Dni, Nombres, Telefono, Estado, User)values(?,?,?,?,?)";
        try {
           con=cn.conexion();
           ps=con.prepareStatement(sql);
           ps.setString(1, em.getDni());
           ps.setString(2, em.getNombre());
           ps.setString(3, em.getTelefono());
           ps.setString(4, em.getEstado());
           ps.setString(5, em.getUser());
           ps.executeUpdate();
           respuesta="Registro exitoso...";
        } catch (SQLException e) {
          System.out.println("Error agregando Empleado: "+e.getMessage());
          respuesta="Error agregando Empleado: "+e.getMessage();
        }
       return respuesta;
    }

    /**
     *Método que sirve para listar un Empleado, recibe un id, busca un registro con este id en la tabla empleado y si lo encuentra retorna un objeto Empleado
     * con los valores respectivos, sino lo encuentra retorna nulo
     * @param id
     * @return Empleado
     */
    public Empleado listarId(int id){
        Empleado objEm=new Empleado();
        String sql="select * from empleado where IdEmpleado="+id;
        try {
          con=cn.conexion();
          ps=con.prepareStatement(sql);
          rs=ps.executeQuery();
          while(rs.next()){
             objEm.setId(rs.getInt(1));
             objEm.setDni(rs.getString(2));
             objEm.setNombre(rs.getString(3));
             objEm.setTelefono(rs.getString(4));
             objEm.setEstado(rs.getString(5));
             objEm.setUser(rs.getString(6)); 
          }
            System.out.println("Liste Bien Empleado :3");    
        }catch (SQLException e){ 
           System.out.println("Error listando Empleado: "+e.getMessage());
        }
        return objEm;
    }
    
    /**
     *Método que recibe un objeto Empleado, para actualizar sus datos en la base de datos, especificamente en la tabla empleado
     * @param em
     * @return String
     */
    public String actualizar(Empleado em){
       String sql="update empleado set Dni=?, Nombres=?, Telefono=?, Estado=?, User=? where IdEmpleado=?";
        try {
           con=cn.conexion();
           ps=con.prepareStatement(sql);
           ps.setString(1, em.getDni());
           ps.setString(2, em.getNombre());
           ps.setString(3, em.getTelefono());
           ps.setString(4, em.getEstado());
           ps.setString(5, em.getUser());
           ps.setInt(6, em.getId());
           ps.executeUpdate();
           respuesta="Actualización exitosa Empleado...";
        } catch (SQLException e) {
          System.out.println("Error actualizando Empleado: "+e.getMessage());
          respuesta="Error actu Empleado: "+e.getMessage();
        }
       return respuesta;  
    }

    /**
     *Metodo que elimina el Empleado especifico en la BD que tenga asignado el valor del parámetro id, mas especificamente
     * de la tabla empleado con ayuda de la clase Conexion
     * @param id
     */
    public void delete(int id){
        String sql="delete from empleado where IdEmpleado="+id;
        try {
           con=cn.conexion();
           ps=con.prepareStatement(sql);
           ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error eliminando Empleado: "+e.getMessage());
        }
    }
}
