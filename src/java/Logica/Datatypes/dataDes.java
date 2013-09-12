/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Datatypes;



/**
 *
 * @author Administrador
 */
public class dataDes {
     private String nick;
    
     public dataDes(String n){
         nick =n;
        }
     
     public dataDes(){
         nick ="";
        }
     
     public void setNick (String n){
         nick = n;
         }
     
      public String getNick (){
          return nick;
      }
    
    
}
