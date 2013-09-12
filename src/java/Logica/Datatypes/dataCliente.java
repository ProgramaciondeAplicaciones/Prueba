/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Datatypes;
/**
 *
 * @author Nicole
 */
public class dataCliente extends dataPerfil {
    
     public dataCliente(String n,String nk,String a, String c, String i, DataFecha fn,int ed){
        nombre=n;
        nick=nk;
        apellido=a;
        correo=c;
        imagen=i;
        fechaNacim=fn;  
        edad=ed;
  
        
    }
         
        public String DameTipo(){
         String c="Cliente";
         return c;
     }
}
