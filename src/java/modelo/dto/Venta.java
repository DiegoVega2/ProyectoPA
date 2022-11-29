/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dto;

import java.util.Objects;

/**
 * Clase Venta para guardar los datos relacionados con la venta de productos
 * @author DieguilloPillo
 */
public class Venta {
    private int id,item,idcliente,idempleado,cantidad,idProducto;
    private String numserie,descripcionp,fecha,estado;
    private double precio,subtotal,monto;

    /**
     * Este es el contructor parámetrico para crear un Objeto de la clase Venta con valores
     * @param id representa el id de la clase ventas, sea jerarquizada y almacenada en una base de datos
     * @param item representa el numero de items que fueron vendidos
     * @param idcliente representa el id de un Cliente almacenado en una base de datos
     * @param idempleado representa el id de un Empleado almacenado en una base de datos
     * @param numserie  representa el número de serie de una factura-representa el numero de venta
     * @param descripcionp representa el nombre del articulo vendido
     * @param fecha  representa la fecha en la que se realizo la venta
     * @param cantidad representa la cantidad de productos vendidos
     * @param estado representa el estado actual del producto
     * @param precio representa el precio de un producto
     * @param subtotal representa el subtotal de una venta
     * @param monto representa el valor total de una venta
     * @param idProducto representa el id de un Producto almacenado en una abse de datos
     */
    public Venta(int id, int item, int idcliente, int idempleado, String numserie, String descripcionp, String fecha, int cantidad, String estado, double precio, double subtotal, double monto,int idProducto) {
        this.id = id;
        this.item = item;
        this.idcliente = idcliente;
        this.idempleado = idempleado;
        this.numserie = numserie;
        this.descripcionp = descripcionp;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.estado = estado;
        this.precio = precio;
        this.subtotal = subtotal;
        this.monto = monto;
        this.idProducto= idProducto;
    }

    /**
     *Constructor básico para crear un Objeto de la clase Venta sin valores
     */
    public Venta() {
        this.id = 0;
        this.item = 0;
        this.idcliente = 0;
        this.idempleado = 0;
        this.numserie = "";
        this.descripcionp = "";
        this.fecha = "";
        this.cantidad = 0;
        this.estado = "";
        this.precio = 0;
        this.subtotal = 0;
        this.monto = 0;
        this.idProducto= 0;
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
     *Método que retorna el valor de los item de la venta
     * @return int
     */
    public int getItem() {
        return item;
    }

    /**
     *Metodo que modifica  el contenido del atributo item
     * @param item
     */
    public void setItem(int item) {
        this.item = item;
    }

    /**
     *Método que retorna el valor del atributo idcliente
     * @return int
     */
    public int getIdcliente() {
        return idcliente;
    }

    /**
     *Metodo que modifica  el contenido del atributo idcliente
     * @param idcliente
     */
    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    /**
     *Método que retorna el valor del atributo idempleado
     * @return int
     */
    public int getIdempleado() {
        return idempleado;
    }

    /**
     *Metodo que modifica  el contenido del atributo idempleado
     * @param idempleado
     */
    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    /**
     *Método que retorna el valor del atributo numserie
     * @return String
     */
    public String getNumserie() {
        return numserie;
    }

    /**
     *Metodo que modifica  el contenido del atributo numserie
     * @param numserie
     */
    public void setNumserie(String numserie) {
        this.numserie = numserie;
    }

    /**
     *Método que retorna el valor del atributo descripcionp
     * @return String
     */
    public String getDescripcionp() {
        return descripcionp;
    }

    /**
     *Metodo que modifica  el contenido del atributo descripcionp
     * @param descripcionp
     */
    public void setDescripcionp(String descripcionp) {
        this.descripcionp = descripcionp;
    }

    /**
     *Método que retorna el valor del atributo fecha
     * @return String
     */
    public String getFecha() {
        return fecha;
    }

    /**
     *Metodo que modifica  el contenido del atributo fecha
     * @param fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
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
     *Método que retorna el valor del atributo subtotal
     * @return double
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     *Metodo que modifica  el contenido del atributo subtotal
     * @param subtotal
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     *Método que retorna el valor del atributo monto
     * @return double
     */
    public double getMonto() {
        return monto;
    }

    /**
     *Método que retorna el valor del atributo cantidad
     * @return int
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     *Metodo que modifica  el contenido del atributo cantidad
     * @param cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     *Método que retorna el valor del atributo idProducto
     * @return int
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     *Metodo que modifica  el contenido del atributo idProducto
     * @param idProducto
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    /**
     *Metodo que modifica  el contenido del atributo monto
     * @param monto
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     *Método que retorna el contenido de la clase Venta con sus respectivos atributos
     * @return String
     */
    @Override
    public String toString() {
        return "Venta" + "id=" + id + ", item=" + item + ", idcliente=" +
                idcliente + ", idempleado=" + idempleado + ", numserie=" + numserie + 
                ", descripcionp=" + descripcionp + ", fecha=" + fecha + 
                ", cantidad=" + cantidad + ", estado=" + estado + 
                ", precio=" + precio + ", subtotal=" + subtotal + 
                ", monto=" + monto;
    }
    
}
