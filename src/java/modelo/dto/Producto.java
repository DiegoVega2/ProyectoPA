/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dto;

import java.util.Objects;

/**
 *Clase Producto para almacenar los datos de un Producto que estan a la venta
 * @author DieguilloPillo
 */
public class Producto {
   private int id,stock;
   private String nombres,estado;
   double precio;

    /**
     *Constructor parámetrico que permite crear un Objeto de la Producto con valores
     * @param id representa el id del Producto, almacenado o para almacenar en una base de datos
     * @param nombres representa el nombre del producto
     * @param precio representa el precio individual del producto
     * @param stock representa la cantidad de productos disponibles
     * @param estado representa el estado actual del producto
     */
    public Producto(int id, String nombres, Double precio, int stock, String estado) {
        this.id = id;
        this.nombres = nombres;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
    }

    /**
     *Constructor parámetrico que permite crear un Objeto de la Producto sin valores
     */
    public Producto() {
        this.id = 0;
        this.nombres = "";
        this.precio =0;
        this.stock = 0;
        this.estado = "";
    } 

    /**
     *Método que retorna el valor del atributo id
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     *Metodo que modifica  el contenido del atributo id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *Método que retorna el valor del atributo nombres
     * @return String
     */
    public String getNombres() {
        return nombres;
    }

    /**
     *Metodo que modifica  el contenido del atributo nombres
     * @param nombres
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     *Método que retorna el valor del atributo precio
     * @return double
     */
    public double getPrecio() {
        return precio;
    }

    /**
     *Metodo que modifica  el contenido del atributo precio
     * @param precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     *Método que retorna el valor del atributo stock
     * @return int
     */
    public int getStock() {
        return stock;
    }

    /**
     *Metodo que modifica  el contenido del atributo stock
     * @param stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     *Método que retorna el valor del atributo estado
     * @return String
     */
    public String getEstado() {
        return estado;
    }

    /**
     *Metodo que modifica  el contenido del atributo estado
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }


    /**
     *Método que retorna el contenido de la clase Producto con sus respectivos atributos
     * @return String
     */
    @Override
    public String toString() {
        return "Producto: " + "id=" + id + ", nombres=" + nombres + ", precio=" + precio + ", stock=" + stock + ", estado=" + estado ;
    }
   
}
