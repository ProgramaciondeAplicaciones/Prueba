/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Logica.Datatypes.DataFecha;

/**
 *
 * @author dc
 */
public class Compra {
    private DataFecha fecha;
    private Juego juego;
    private Cliente cliente;
    
    
    public Compra(){
        fecha=new DataFecha();
        juego=new Juego();
        cliente=new Cliente();
    }
     public Compra(DataFecha df, Juego j, Cliente c){
        fecha=df;
        juego=j;
        cliente=c;
    }
    
public String getFecha(){
    String s=fecha.getFecha();
    return s;
   
}

public int getIdJuego(){
    int i=juego.getId();
    return i;
}

public String getNickCliente(){
    String n=cliente.getNick();
    return n;
}
    
}
