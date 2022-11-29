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
import modelo.dto.Producto;

/**
  *Clase ProductoDAO usada para aplicar la CRUD desde el programa a la BD
 * y en la tabla de producto
 * @author DieguilloPillo
 */
public class ProductoDAO {
    private Conexion cn= new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private String respuesta="";
    
    /**
     *Metodo que permite consultar los registros que se 
     * encuentran en la base de datos, mas especificamente en la tabla producto
     * con ayuda de la clase Conexion,
     * que recibe un id y por medio de este busca un registro con ese id en la BD,
     * si existe retorna el objeto con los parametros de ese registro, sino retorna null
     * @param id
     * @return Producto
     */
    public Producto buscar(int id){
         Producto objP = new Producto();
         String sql="select * from producto where IdProducto="+id;
         try {
             con=cn.conexion();
             ps=con.prepareStatement(sql);
             rs=ps.executeQuery();
             while(rs.next()){
             objP.setId(rs.getInt(1));
             objP.setNombres(rs.getString(2));
             objP.setPrecio(rs.getDouble(3));
             objP.setStock(rs.getInt(4));
             objP.setEstado(rs.getString(5));
         }
         } catch (Exception e) {
             respuesta="Error en buscar Producto"+e.getMessage();
             System.out.println(respuesta);
         }
         return objP;
     }
     
    /**
      *Metodo que actualiza los registros de stock en la BD, mas especificamente
     * de la tabla producto con ayuda de la clase conexion, que recibe un id para la busqueda del producto y actualiza el stock en el caso de una venta
     * @param id
     * @param stock
     * @return String
     */
    public String actualizarStock(int id, int stock){
         String sql="update producto set Stock=? where IdProducto=?";
         try {
             con=cn.conexion();
             ps=con.prepareStatement(sql);
             ps.setInt(1, stock);
             ps.setInt(2, id);
             ps.executeUpdate();
         } catch (Exception e) {
             respuesta="Error actualizando stock producto"+e.getMessage();
             System.out.println(respuesta);
         }
         return respuesta;
     }
     
     
    //CRUD

    /**
     *Método que devuelve una lista con todos los registros de la tabla producto con ayuda de la clase Conexion
     * @return List
     */
    public List listar(){
      String sql="select * from producto";  
      List<Producto> lista = new ArrayList<>();
      try{
         con=cn.conexion();
         ps=con.prepareStatement(sql);
         rs=ps.executeQuery();//ejecutar consulta
         while(rs.next()){
             Producto objP = new Producto();
             objP.setId(rs.getInt(1));
             objP.setNombres(rs.getString(2));
             objP.setPrecio(rs.getDouble(3));
             objP.setStock(rs.getInt(4));
             objP.setEstado(rs.getString(5));
             lista.add(objP);
         }
      }catch(SQLException ex){
          System.out.println("Error listando Producto: "+ex.getMessage()); 
      }
      return lista;
    }
    
    /**
     *Metodo que permite insertar registros en la BD, mas 
     * especificamente en la tabla producto con ayuda de la clase Conexion
     * @param pr
     * @return String
     */
    public String agregar(Producto pr){
        String sql="insert into producto(Nombres, Precio, Stock, Estado)values(?,?,?,?)";
        try {
           con=cn.conexion();
           ps=con.prepareStatement(sql);
           ps.setString(1, pr.getNombres());
           ps.setDouble(2, pr.getPrecio());
           ps.setInt(3, pr.getStock());
           ps.setString(4, pr.getEstado());
           ps.executeUpdate();
           respuesta="Registro exitoso de Producto...";
        } catch (SQLException e) {
          System.out.println("Error agregando Producto: "+e.getMessage());
          respuesta="Error agregando Producto: "+e.getMessage();
        }
       return respuesta;
    }

    /**
     *Método que sirve para listar un Producto, recibe un id, busca un registro con este id en la tabla producto y si lo encuentra retorna un objeto Producto 
     * con los valores respectivos, sino lo encuentra retorna nulo
     * @param id
     * @return Producto
     */
    public Producto listarId(int id){
        Producto objP = new Producto();
        String sql="select * from producto where IdProducto="+id;
        try {
          con=cn.conexion();
          ps=con.prepareStatement(sql);
          rs=ps.executeQuery();
          while(rs.next()){
              objP.setId(rs.getInt(1));
             objP.setNombres(rs.getString(2));
             objP.setPrecio(rs.getDouble(3));
             objP.setStock(rs.getInt(4));
             objP.setEstado(rs.getString(5));
          }
            System.out.println("Liste Bien Producto :3");    
        }catch (SQLException e){ 
           System.out.println("Error listando Producto: "+e.getMessage());
        }
        return objP;
    }
    
    /**
     *Método que recibe un objeto Producto, para actualizar sus datos en la base de datos, especificamente en la tabla producto
     * @param pr
     * @return String
     */
    public String actualizar(Producto pr){
       String sql="update producto set Nombres=?, Precio=?, Stock=?, Estado=? where IdProducto=?";
        try {
           con=cn.conexion();
           ps=con.prepareStatement(sql);
           ps.setString(1, pr.getNombres());
           ps.setDouble(2, pr.getPrecio());
           ps.setInt(3, pr.getStock());
           ps.setString(4, pr.getEstado());
           ps.setInt(5, pr.getId());
           ps.executeUpdate();
           respuesta="Actualización de Producto exitosa...";
        } catch (SQLException e) {
          System.out.println("Error actualizando Producto: "+e.getMessage());
          respuesta="Error actu Producto: "+e.getMessage();
        }
       return respuesta;  
    }

    /**
     *Metodo que elimina el Producto especifico en la BD que tenga asignado el valor del parámetro id, mas especificamente
     * de la tabla producto con ayuda de la clase Conexion
     * @param id
     */
    public void delete(int id){
        String sql="delete from producto where IdProducto="+id;
        try {
           con=cn.conexion();
           ps=con.prepareStatement(sql);
           ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error eliminado Producto: "+e.getMessage());
        }
    }
}
