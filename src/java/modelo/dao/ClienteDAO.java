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
import modelo.dto.Cliente;
import modelo.dto.Empleado;

/**
 *Clase ClienteDAO usada para aplicar la CRUD desde el programa a la BD
 * y en la tabla decleinte
 * @author DieguilloPillo
 */
public class ClienteDAO {
    private Conexion cn= new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String respuesta="";
    
    /**
     *Metodo que permite consultar los registros que se 
     * encuentran en la base de datos, mas especificamente en la tabla cliente
     * con ayuda de la clase Conexion,
     * que recibe un id y por medio de este busca un registro con ese id en la BD,
     * si existe retorna el objeto con los parametros de ese registro, sino retorna null
     * @param dni
     * @return Cliente
     */
    public Cliente buscar(String dni){
        Cliente c = new Cliente();
        String sql="select * from cliente where Dni="+dni;
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
               c.setId(rs.getInt(1));
               c.setDni(rs.getString(2));
               c.setNombres(rs.getString(3));              
               c.setDireccion(rs.getString(4));
               c.setEstado(rs.getString(5));
            }
            System.out.println("Cliente encontrado de manera exitosa");
        } catch (Exception e) {
            System.out.println("Error buscando Cliente"+e.getMessage());
        }
        return c;
    }
    //CRUD

    /**
     *Método que devuelve una lista con todos los registros de la tabla cliente con ayuda de la clase Conexion
     * @return List
     */
    public List listar(){
      String sql="select * from cliente";  
      List<Cliente> lista = new ArrayList<>();
      try{
         con=cn.conexion();
         ps=con.prepareStatement(sql);
         rs=ps.executeQuery();//ejecutar consulta
         while(rs.next()){
             Cliente objC = new Cliente();
             objC.setId(rs.getInt(1));
             objC.setDni(rs.getString(2));
             objC.setNombres(rs.getString(3));
             objC.setDireccion(rs.getString(4));
             objC.setEstado(rs.getString(5));
             lista.add(objC);
         }
      }catch(SQLException ex){
          System.out.println("Error listando Cliente: "+ex.getMessage()); 
      }
      return lista;
    }
    
    /**
     *Metodo que permite insertar registros en la BD, mas 
     * especificamente en la tabla cliente con ayuda de la clase Conexion, y retorna una respuesta acerca de si pudo agregar o no el registro a la tabla empelado dentro de la bd,
     * los registros que agrega son los parámetros del Cliente cl enviado
     * @param cl
     * @return String
     */
    public String agregar(Cliente cl){
        String sql="insert into cliente(Dni, Nombres, Direccion, Estado)values(?,?,?,?)";
        try {
           con=cn.conexion();
           ps=con.prepareStatement(sql);
           ps.setString(1, cl.getDni());
           ps.setString(2, cl.getNombres());
           ps.setString(3, cl.getDireccion());
           ps.setString(4, cl.getEstado());
           ps.executeUpdate();
           respuesta="Registro exitoso de Cliente...";
        } catch (SQLException e) {
          System.out.println("Error agregando Cliente: "+e.getMessage());
          respuesta="Error agregando Cliente: "+e.getMessage();
        }
       return respuesta;
    }

    /**
     *Método que sirve para listar un Cliente, recibe un id, busca un registro con este id en la tabla cliente y si lo encuentra retorna un objeto Cliente
     * con los valores respectivos, sino lo encuentra retorna nulo
     * @param id
     * @return Cliente
     */
    public Cliente listarId(int id){
        Cliente objC = new Cliente();
        String sql="select * from cliente where IdCliente="+id;
        try {
          con=cn.conexion();
          ps=con.prepareStatement(sql);
          rs=ps.executeQuery();
          while(rs.next()){
              objC.setId(rs.getInt(1));
             objC.setDni(rs.getString(2));
             objC.setNombres(rs.getString(3));
             objC.setDireccion(rs.getString(4));
             objC.setEstado(rs.getString(5));
          }
            System.out.println("Liste Bien Cliente :3");    
        }catch (SQLException e){ 
           System.out.println("Error listando Cliente: "+e.getMessage());
        }
        return objC;
    }
    
    /**
     *Método que recibe un objeto Cliente, para actualizar sus datos en la base de datos, especificamente en la tabla cliente
     * @param cl
     * @return String
     */
    public String actualizar(Cliente cl){
       String sql="update cliente set Dni=?, Nombres=?, Direccion=?, Estado=? where IdCliente=?";
        try {
           con=cn.conexion();
           ps=con.prepareStatement(sql);
           ps.setString(1, cl.getDni());
           ps.setString(2, cl.getNombres());
           ps.setString(3, cl.getDireccion());
           ps.setString(4, cl.getEstado());
           ps.setInt(5, cl.getId());
           ps.executeUpdate();
           respuesta="Actualización de Cliente exitosa...";
        } catch (SQLException e) {
          System.out.println("Error actualizando Cliente: "+e.getMessage());
          respuesta="Error actu Cliente: "+e.getMessage();
        }
       return respuesta;  
    }

    /**
     *Metodo que elimina el Cliente especifico en la BD que tenga asignado el valor del parámetro id, mas especificamente
     * de la tabla cliente con ayuda de la clase Conexion
     * @param id
     */
    public void delete(int id){
        String sql="delete from cliente where IdCliente="+id;
        try {
           con=cn.conexion();
           ps=con.prepareStatement(sql);
           ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error eliminado Cliente: "+e.getMessage());
        }
    }
}
