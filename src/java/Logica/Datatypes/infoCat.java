/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Datatypes;

/**
 *
 * @author Nicole
 */
public class infoCat {
    private String nombre;
    
    public infoCat(String n){
        nombre=n;
    }
    public String getNombre(){
    return nombre;
}
    
      public infoCat(){
        nombre="";
    }
public void setNombre(String no){
    nombre = no;
}       
    
    
}
