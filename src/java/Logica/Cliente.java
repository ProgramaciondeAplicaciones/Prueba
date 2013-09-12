/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Logica.Datatypes.DataFecha;
import Persistencia.conectar;
import Logica.Datatypes.DataP;
import Logica.Datatypes.dataCliente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicole
 */
public class Cliente extends Perfil{
        conectar cc =new conectar();
public ArrayList Compras;
     

public Cliente(String ni,String co,String no,String ap,DataFecha fe,String im){
         nick = ni;
         correo = co;
         nombre = no;
         apellido = ap;
         
         fechaNac = fe;
         imagen = im;

     }
        public Cliente(){
         nick = "";
         correo = "";
         nombre = "";
         apellido = "";
       
         fechaNac = new DataFecha();
         imagen = "";

     }
        
        public DataP GetDataP(){
         DataP dp =new DataP(nick);
        
         return dp;
     } 
        
        
     public dataCliente obtenerData(){
    dataCliente datac = new dataCliente(nombre,nick,apellido, correo, imagen,fechaNac,edad);
    return datac;
}
       @Override
    public boolean existeN(String ni) {
      conectar cc=new conectar();
      boolean r=true;
         try {
             if(cc.existeNickCliente(ni)){
                 r=true;
             }
             else
                 r=false;
             
         } catch (SQLException ex) {
             Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
         }
      return r;
     }
    
     
     
     @Override
           public boolean existeC(String co) {
      conectar cc=new conectar();
      boolean r=true;
         try {
             if(cc.existeCorreoCliente(co)){
                 r=true;
             }
             else
                 r=false;
             
         } catch (SQLException ex) {
             Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
         }
      return r;
     }
     
     
     
  public void addCliente(){
         conectar cc=new conectar();
         cc.addPerfil(this.nick,this.correo,this.nombre,this.apellido,this.fechaNac.getFecha(),this.imagen,"Cliente",null);
     }
  
    ////////////////////   F U N C I O N E S   C O M P R A R   J U E G O  ////////////////////
  
  
  public void crearCompra(DataFecha f, Juego j){
      Compra c=new Compra(f,j,this);
      
      //add a la base de datos
      conectar cc=new conectar();
      cc.addCompra(c);
      
      
      
      
      
      
  }

}
