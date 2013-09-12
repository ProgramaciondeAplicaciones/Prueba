/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Datatypes;


/**
 *
 * @author Nicole
 */

public abstract class dataPerfil {
    public String nombre;
    public String nick;
    public String apellido;
    public String correo;
    public String imagen;
    public DataFecha fechaNacim;
    public int edad;
            
      
    public abstract String DameTipo();
   
      public dataPerfil(){
        nombre=null;
        nick=null;
        apellido=null;
        correo=null;
        imagen=null;
        fechaNacim=new DataFecha();
        edad=0;
    }
}
