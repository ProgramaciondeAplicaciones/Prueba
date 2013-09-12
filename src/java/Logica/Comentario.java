/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import Logica.Datatypes.DataFecha;
import Logica.Datatypes.InfoComent;
import java.util.*;

/**
 *
 * @author Nicole
 */
public class Comentario {
    private DataFecha Fecha;
    private int id;
    private String Texto;
    private Cliente cliente;
    private List comentarios;

    public Comentario (DataFecha f, int i, String t, Cliente cli,List res){
        Fecha=f;
        id=i; 
        Texto=t;
        cliente=cli;
        comentarios=res;
        
        
     
    }
      public Comentario (){
        Fecha=new DataFecha();
        id=0; 
        Texto="";
        cliente=new Cliente();
        comentarios=new LinkedList();
        
     
    } 
    public int getId(){
        return id;
 
}
    public DataFecha getFecha(){
        return Fecha;
    }
    public String getTexto(){
        return Texto;
    }
    
    public String getNombreCliente(){
        return cliente.getNombre();
         
    }
    public List getComAnidados(){
        List listaCom=new LinkedList();
        
        Iterator iterador=comentarios.iterator();
        while(iterador.hasNext()){
            Comentario com=(Comentario) iterador.next();
            InfoComent data= new InfoComent(com.getId(),com.getTexto(),com.getNombreCliente(),com.getFecha().getFecha(),com.getComAnidados());
            listaCom.add(data);
        
        }
        
            
        return listaCom;
        
        }
    public List getInfoComentAnidados(){
        List listaCom=new LinkedList();
        List listavacia=new LinkedList();
        Iterator iterador=comentarios.iterator();
        while(iterador.hasNext()){
            Comentario com=(Comentario) iterador.next();
            InfoComent data= new InfoComent(com.getId(),com.getTexto(),com.getNombreCliente(),com.getFecha().getFecha(),listavacia);
            listaCom.add(data);
        
        }
        
            
        return listaCom;
        
        }
       
    }
    
   
    





