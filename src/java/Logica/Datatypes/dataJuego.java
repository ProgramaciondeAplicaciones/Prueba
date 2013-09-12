/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Datatypes;

/**
 *
 * @author dc
 */
public class dataJuego{
    private String nombre;
    private String descripcion;
    private Money precio;
    
    public dataJuego(String n, String d, Money m){
        nombre=n;
        descripcion=d;
        precio=m;
    }
    public dataJuego(){
        nombre="";
        descripcion="";
        precio=new Money();
    }
    public String getNombre(){
        return nombre;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public Money getPrecio(){
        return precio;
    }
}
