/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dto;

import java.util.Objects;

/**
 *Clase Producto para almacenar los datos de un Empleado que realizan el proceso de Venta
 * @author DieguilloPillo
 */
public class Empleado {
    private int id;
    private String dni,nombre,telefono,estado,user;

    /**
     * Contructor parámetrico para crear un objeto de la clase Empleado
     * @param id representa el id del Empleado, almacenado o para almacenar en una base de datos
     * @param dni representa la contraseña del usuario apra entrar al sistema
     * @param nombre representa el nombre del empleado
     * @param telefono representa el número de teléfono del empleado
     * @param estado representa el estado del producto
     * @param user representa el usuario elegido por el empleado
     */
    public Empleado(int id, String dni, String nombre, String telefono, String estado, String user) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.estado = estado;
        this.user = user;
    }

    /**
     *Constructor parámetrico que permite crear un Objeto de la Empleado sin valores
     */
    public Empleado() {
        this.id = 0;
        this.dni = "";
        this.nombre = "";
        this.telefono = "";
        this.estado = "";
        this.user = "";
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
     *Método que retorna el valor del atributo dni
     * @return String
     */
    public String getDni() {
        return dni;
    }

    /**
     *Metodo que modifica  el contenido del atributo dni
     * @param dni
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     *Método que retorna el valor del atributo nombre
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *Metodo que modifica  el contenido del atributo nombre
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *Método que retorna el valor del atributo telefono
     * @return String
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     *Metodo que modifica  el contenido del atributo id
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
     *Método que retorna el valor del atributo user
     * @return String
     */
    public String getUser() {
        return user;
    }

    /**
     *Metodo que modifica  el contenido del atributo user
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }

   

    /**
     *Método que retorna el contenido de la clase Empleado con sus respectivos atributos
     * @return String
     */
    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", estado=" + estado + ", user=" + user;
    }
    
}
