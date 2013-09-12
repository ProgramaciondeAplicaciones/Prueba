/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Datatypes;

/**
 *
 * @author dc
 */
public class DataP {
     public String nick;
      public DataP(){
          nick ="o";
      }
      public DataP(String n){
          nick =n;
      }
      public String getNick(){
          return nick;
      }
      public void setNick(String n){
          nick = n;
      }
      
}
