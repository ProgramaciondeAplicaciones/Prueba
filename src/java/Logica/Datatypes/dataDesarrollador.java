/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Datatypes;
/**
 * 
 * @author Nicole
 */
public class dataDesarrollador extends dataPerfil {
    public String webURL;
   
 public dataDesarrollador(String n,String nk,String a, String c, String i, DataFecha fn, String w, int ed){
        nombre=n;
        nick=nk;
        apellido=a;
        correo=c;
        imagen=i;
        fechaNacim=fn;  
        webURL=w;
        edad=ed;
    }
  public dataDesarrollador(){
        nombre=null;
        nick=null;
        apellido=null;
        correo=null;
        imagen=null;
        fechaNacim=new DataFecha();  
        webURL=null;
        edad=0;

    }
 

public String DameTipo(){
         String c="Desarrollador";
         return c;
     }
    
   
    

  
   
    
}



