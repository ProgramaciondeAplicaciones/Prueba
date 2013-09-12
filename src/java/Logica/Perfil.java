/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Logica.Datatypes.DataFecha;

/**
 *
 * @author Nicole
 */
abstract class Perfil {
     public String nick;
     public String correo;
     public String nombre;
     public String apellido;
     public int edad;
     public DataFecha fechaNac;
     public String imagen;
       
     public Perfil(){
        nombre="o";
        nick="o";
        apellido="o";
        correo="o";
        imagen="o";
        fechaNac=new DataFecha();
    }


     public String getNick(){
         return nick;
     }
     public String getCorreo(){
         return correo;
     }
     public String getNombre(){
         return nombre;
     }
     public String getApellido(){
         return apellido;
     }
     public int getEdad(){
         return edad;
     }
     public DataFecha getFechaNac(){
         return fechaNac;
     }
     public String getImagen(){
         return imagen;
     }
     public void setNick(String ni){
         nick = ni;
     }
     public void setCorreo(String co){
         correo = co;
     }
     public void setNombre(String no){
         nombre = no;
     }
     public void setApellido(String ap){
         apellido = ap;
     }
     public void setEdad(int ed){
         edad = ed;
     }
     public void setFechaNac(DataFecha fe){
         fechaNac = fe;
     }
     public void setImagen(String im){
         imagen = im;
     }

     
     abstract boolean existeN(String ni);
     abstract boolean existeC(String co);
}
