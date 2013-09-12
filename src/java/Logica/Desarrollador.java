/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Logica.Datatypes.DataFecha;
import Persistencia.conectar;
import Logica.Datatypes.dataDesarrollador;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicole
 */
public class Desarrollador extends Perfil {
    public String webURL;
     conectar cc =new conectar();


     public Desarrollador(String ni,String co,String no,String ap,DataFecha fe,String im,String we){
         nick = ni;
         correo = co;
         nombre = no;
         apellido = ap;
      
         fechaNac = fe;
         imagen = im;
         webURL = we;
     }
 public Desarrollador(){
         nick = "o";
         correo = "";
         nombre = "";
         apellido = "";
        
         fechaNac = new DataFecha();
         imagen = "";
         webURL = "";
     }
 
 public dataDesarrollador obtenerData(){
         dataDesarrollador data=new dataDesarrollador(nombre,nick,apellido,correo,imagen,fechaNac,webURL,edad);
         
         return data;
     }

     
     
     
     public String getWebURL(){
         return webURL;
     }
     public void setWebURL(String se){
         webURL=se;
     }
     
     
      @Override
      public boolean existeN(String ni) {
     
      boolean r=true;
        try {
            if(cc.existeNickDesarrollador(ni)){
                r=true;
            }
            else
                r=false;
        } catch (SQLException ex) {
            Logger.getLogger(Desarrollador.class.getName()).log(Level.SEVERE, null, ex);
        }
      return r;
     }
    
     @Override
 public boolean existeC(String co) {
     
     boolean r=true;
        try {
            if(cc.existeCorreoDesarrollador(co)){
               r=true;
            }
            else
               r=false;
        } catch (SQLException ex) {
            Logger.getLogger(Desarrollador.class.getName()).log(Level.SEVERE, null, ex);
        }
          return r;   
         } 
      
     
 public void addDesarrollador(){
        
         cc.addPerfil(this.nick,this.correo,this.nombre,this.apellido,this.fechaNac.getFecha(),this.imagen,"Desarrollador",this.webURL);
     }


}
