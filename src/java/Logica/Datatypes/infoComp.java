/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Datatypes;

/**
 *
 * @author Nicole
 */
public class infoComp {
    private String nick;
    private DataFecha fecha;
    private dataJuego juego;
    
   public infoComp(){
        nick="";
        fecha=new DataFecha();
        juego=new dataJuego();
    }
    
   public infoComp(String n, DataFecha df,dataJuego dj){
        nick=n;
        fecha=df;
        juego=dj;
    }
   
   public String getNick(){
       return nick;
   }
   public DataFecha getFecha(){
       return fecha;
   }
   public dataJuego getJuego(){
       return juego;
   }
   
   
   
   
}
