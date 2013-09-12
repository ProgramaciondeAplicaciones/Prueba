/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Nicole
 */
import java.util.*;
/**
 *
 * @author dc
 */
public class Categoria {
private String nombre;
private List listaJuego;

public Categoria(String no){
   nombre = no;
}
  public Categoria() {
        nombre=" ";
        
    }

public String getNombre(){
    return nombre;
}

public void setNombre(String no){
    nombre = no;
}        

}