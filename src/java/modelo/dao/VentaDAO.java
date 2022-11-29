/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.Venta;

/**
 *Clase VentaDAO usada para aplicar la CRUD desde el programa a la BD
 * y en la tabla de ventas y detalle_ventas
 * @author DieguilloPillo
 */
public class VentaDAO {
    private Connection con;
    private Conexion cn = new Conexion();
    private PreparedStatement ps;
    private ResultSet rs;
    private String respuesta;
    private List<Venta> lista = new ArrayList<>();

    /**
     *Método que retorna el máximo NumeroSerie almacenado en la base de datos
     * @return String
     */
    public String generarSerie(){
        String numeroserie="";
        String sql="select max(NumeroSerie) from ventas";
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                numeroserie=rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("Erron en generarSerie: "+e.getMessage());
        }
        return numeroserie;
    }

    /**
     *Método que retorna el máximo IdVentas almacenado en la base de datos
     * @return String
     */
    public String idVentas(){//captura o devuelve el max de idventas de la tabla ventas
        String idVenta="";
        String sql="select max(IdVentas) from ventas";
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                idVenta=rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("Error en idVentas: "+e.getMessage());
        }
        return idVenta;
    }

    /**
     *Método que recibe un Objeto de la clase Venta y retorna una respuesta acerca de si se realizo bien el proceso dentro del bloque Try-Catch
     * @param ve
     * @return String
     */
    public String guardarVenta(Venta ve){
        String sql="insert into ventas(IdCliente, IdEmpleado, NumeroSerie, FechaVentas, Monto, Estado)values(?,?,?,?,?,?)";
        try {
            con=cn.conexion();
            System.out.println(ve.toString());
            ps=con.prepareStatement(sql);
           ps.setInt(1, ve.getIdcliente());
           ps.setInt(2, ve.getIdempleado());
           ps.setString(3, ve.getNumserie());
           ps.setString(4, ve.getFecha());
           ps.setDouble(5, ve.getPrecio());
           ps.setString(6, ve.getEstado());
            ps.executeUpdate();
            respuesta="guardarVenta Exitosa";
            System.out.println("entre a guardar venta");
        } catch (Exception e) {
            respuesta="Error en guardarVenta: "+e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }

    /**
     *Método que recibe un Objeto de la clase Venta y retorna una respuesta acerca de si se realizo bien el proceso dentro del bloque Try-Catch
     * @param venta1
     * @return String
     */
    public String guardarDetalleventas(Venta venta1){
        String sql="insert into detalle_ventas(IdVentas, IdProducto, Cantidad, PrecioVenta)values(?,?,?,?)";
        try {
           con=cn.conexion();
           ps=con.prepareStatement(sql);
           ps.setInt(1, venta1.getId());
           ps.setInt(2, venta1.getIdProducto());
           ps.setInt(3, venta1.getCantidad());
           ps.setDouble(4, venta1.getPrecio());
           ps.executeUpdate();
            System.out.println("GENERE DETALLE VENTA");
        } catch (Exception e) {
            respuesta="Error en guardarDetalleVenta: "+e.getMessage();
            System.out.println(respuesta);
        }
        return respuesta;
    }
    /**
     *Método que recibe una lista de la clase venta y elimina el objeto venga que tenga el mismo id que el parámetro id enviado
     * @param id
     * @param lista1
     * @return List
     */
    public List<Venta> eliminar(int id, List<Venta> lista1){
        this.lista=lista1;
        for (int i = 0; i < lista.size(); i++) {
                        if(id==lista.get(i).getId()){
                            System.out.println("entre al if");
                          lista.remove(lista.get(i));
                        }
                    }
        return this.lista;
    }
    /**
     * Método para actualizar los datos de un Objeto Venta dentro de la lista
     * @param id
     * @param cantidad
     * @param lista2
     * @return 
     */
    public List<Venta> actualizar(int id,int cantidad, List<Venta> lista2){
        this.lista=lista2;
        for (int i = 0; i < lista.size(); i++) {
                        if(id==lista.get(i).getId()){
                            lista.get(i).setCantidad(cantidad);
                            lista.get(i).setSubtotal(cantidad*(lista.get(i).getPrecio()));
                            break;
                        }
                    }
        return this.lista;
    }
}
