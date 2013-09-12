/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Datatypes;

/**
 *
 * @author dc
 */
public class infoCli {
    public String nombre;
    public infoCli(){
        nombre ="";
    }
    public infoCli(String nomb){
        nombre =nomb;
    }
    public void setNick(String n){
    nombre =n;
}
    
    public String getNombre(){
        return nombre;
    }
}
