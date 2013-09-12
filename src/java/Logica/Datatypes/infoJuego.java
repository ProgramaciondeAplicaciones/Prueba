/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Datatypes;
import java.util.*;

/**
 *
 * @author Nicole
 */
public class infoJuego {
       public String nombre;
    public String des;
    public double tamanio;
    public String nickD;
    public List Categorias;
    public List Clientes;
    public List Comentarios;
    
 
    public infoJuego(){
        nombre="";
        des="";
        tamanio=0;
        nickD="";
        Categorias= new LinkedList();
        Clientes =new LinkedList();
        Comentarios = new LinkedList();
        
    }
    public infoJuego(String n,String de,double tam,String nick,List cat,List cli,List com){
        nombre =n;
        des= de;
        tamanio=tam;
        nickD= nick;
        Categorias =cat;
        Clientes = cli;
        Comentarios =com;
        
        
        
    }
    public List obtenerLasRespuestasComentario(int i){
         Iterator it=Comentarios.iterator();
 List resp = new LinkedList();
   while(it.hasNext()){
    InfoComent c=(InfoComent)it.next();
    if(c.getid()==i){
        resp.add(c);
    }
    
         
   }
   return resp;
    }
    
    
       public String getNombre(){
        return nombre;
    }
    public String getDescrip(){
        return des;
    }
    public double getTamanio(){
        return tamanio;
    }
    public String getNick(){
        return nickD;
    }
    public List getCategorias(){
        return Categorias;
    }
    public List getComentarios(){
        return Comentarios;
    }
    public List getClientes(){
        return Clientes;
    }
  
    
    
    
}
