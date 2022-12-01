package config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *Clase Conexion utilizada para realizar la conexión haciauna base de datos
 * @author DieguilloPillo
 */
public class Conexion{
    private Connection con;
    private String url="jdbc:mysql://localhost:3306/bd_ventas";
    private String user="root";
    private String pass="";

    /**
     *Metodo usado para conectar la base de datos con el programa realizado
     * @return
     */
    public Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("Eroor: "+e.getMessage());
        }
        return con;
    }
    public Connection cerrarConexion(){
        return this.con=null;
    }
}