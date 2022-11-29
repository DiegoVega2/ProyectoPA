package modelo.dto;

import java.util.Calendar;

/**
 * Clase Fecha utilizada para el manejo de las 
 * fechas de nacimioento, ingreso y actual
 * @author Diego Vega
 * @author Kevin Silva
 * @version 5.0
 */
public class Fecha {
        private int aa,mm,dd;

    /**
     *Constructor Parametrico permite crear una instancia u objeto a partir de los siguientes parametros
     * @param dd hace referencia al dia de la fecha
     * @param mm hace referencia al mes de la fecha
     * @param aa hace referencia al año de la fecha
     */

    /**
     *Constructor basico permite crear una instancia u objeto a partir de valores nulos
     */
    public Fecha() {
        Calendar fecha= Calendar.getInstance();
        this.aa = fecha.get(Calendar.YEAR); //Traemos el año
        this.mm = fecha.get(Calendar.MONTH);//Traemos el mes
        this.dd = fecha.get(Calendar.DAY_OF_MONTH);//Traemos el dia
    }
 
    /**
     *Metodo que retorna el contenido del 
     * atributo aa(año de la fecha) en formato integer
     * @return int
     */
    public int getAa() {
        return aa;
    }

    /**
     *Metodo que modifica  el contenido del atributo aa
     * (año de la fecha) a partir de un parametro de tipo integer
     * @param aa
     */
    public void setAa(int aa) {
        this.aa = aa;
    }

    /**
     *Metodo que retorna el contenido del 
     * atributo mm(mes de la fecha) en formato integer
     * @return int
     */
    public int getMm() {
        return mm;
    }

    /**
     *Metodo que modifica  el contenido del atributo mm
     * (mes de la fecha) a partir de un parametro de tipo integer
     * @param mm
     */
    public void setMm(int mm) {
        this.mm = mm;
    }

    /**
     *Metodo que retorna el contenido del 
     * atributo dd(dia de la fecha) en formato integer
     * @return int
     */
    public int getDd() {
        return dd;
    }

    /**
     *Metodo que modifica  el contenido del atributo dd
     * (dia de la fecha) a partir de un parametro de tipo integer
     * @param dd
     */
    public void setDd(int dd) {
        this.dd = dd;
    } 

    /**
     *Metodo que retorna el contenido de la fecha(dd,mm,aa) en formato texto
     * @return String
     */
    @Override
    public String toString() {
        return  dd + "/" + mm + "/" + aa ;
    }
}

