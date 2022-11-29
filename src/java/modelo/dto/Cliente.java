/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dto;

import java.util.Objects;

/**
 *Clase Producto para almacenar los datos de un Cliente que realizan el proceso de compra
 * @author DieguilloPillo
 */
public class Cliente {
  private int id;
  private String dni, nombres, direccion, estado;

    /**
     * Contructor parámetrico para crear un objeto de la clase Empleado
     * @param id representa el id del Cliente, almacenado o para almacenar en una base de datos
     * @param dni representa el dni del cliente
     * @param nombres representa los nombres de un cliente registrado
     * @param direccion representa la dirección de un cliente
     * @param estado representa el estado de un cliente
     */
    public Cliente(int id, String dni, String nombres, String direccion, String estado) {
        this.id = id;
        this.dni = dni;
        this.nombres = nombres;
        this.direccion = direccion;
        this.estado = estado;
    }

    /**
     *Constructor parámetrico que permite crear un Objeto de la Cliente sin valores
     */
    public Cliente() {
        this.id = 0;
        this.dni = "";
        this.nombres = "";
        this.direccion = "";
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
     *Método que retorna el valor del atributo direccion
     * @return String
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *Metodo que modifica  el contenido del atributo direccion
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
     *Método que retorna el contenido de la clase Cliente con sus respectivos atributos
     * @return String
     */
    @Override
    public String toString() {
        return "Cliente" + "id=" + id + ", dni=" + dni + ", nombres=" + nombres + ", direccion=" + direccion + ", estado=" + estado ;
    }
  
}
