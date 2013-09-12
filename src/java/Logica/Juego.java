/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import Logica.Datatypes.InfoComent;
import Logica.Datatypes.Money;
import Logica.Datatypes.infoCat;
import Logica.Datatypes.infoCli;
import java.util.*;

/**
 *
 * @author Nicole
 */
public class Juego {
private String nombre;
private String descripcion;
private double tamanio;
private int id;
private Money precio;
private List listaCategorias;


private List Comentarios;
private Desarrollador des;
private List Compras;

public Juego(String no,Money pr,String de,double ta,int i,Desarrollador d,List cat,List comen,List Comp){
    nombre = no;
    descripcion = de;
    tamanio = ta;
    id = i;
    precio = pr;
    des = d;
    listaCategorias =cat;
   
    Comentarios=comen;
    Compras=Comp;
}

public Juego(){
    nombre = "";
    descripcion = "";
    tamanio = 0;
    id = 0;
    precio = new Money();
    des = new Desarrollador();
    listaCategorias =new LinkedList();
    
    Comentarios=new LinkedList();
    Compras=new LinkedList();
}

public Desarrollador getDesarrollador(){
    return des;
}



public String getNombre(){
    return nombre;
}
public Money getPrecio(){
    return precio;
}
public String getDescripcion(){
    return descripcion;
}
public double getTamanio(){
    return tamanio;
}
public int getId(){
    return id;
}
public void setNombre (String no){
    nombre = no ;
}
public void setDescripcion (String de){
    descripcion = de ;
}
public void setDesarrollador(Desarrollador d){
    des= d;
}
public void setTamanio (double ta){
    tamanio = ta ;
}
public void setId (int i){
   id = i ;
}
public void setPrecio(Money p){
   precio = p;
}
public String getNick(){
    return des.getNick();
} 

public List getCategorias(){
    return listaCategorias;
}
public List getCliente(){
    return listaCategorias;
}
        


public void setCategorias(List l){
    listaCategorias=l;
}
        
public List getComentarios(){
    return Comentarios;
}
public void addComentarios(Comentario com){
    Comentarios.add(com);
    
}


public List getInfoCat(){
 List categ=new LinkedList();
       
         Iterator it =listaCategorias.iterator();
         
    while(it.hasNext()){
        
         Categoria pAux=(Categoria)it.next();
         
        infoCat cli = new infoCat(pAux.getNombre());
        
categ.add(cli);
     
            }
   return categ;
}

public List getInfoCli(){
 List client=new LinkedList();
       
         Iterator it =Compras.iterator();
         
    while(it.hasNext()){
        
         Compra pAux=(Compra)it.next();
         
        infoCli cli = new infoCli(pAux.getNickCliente());
        
client.add(cli);
     
            }
   return client;
}


public List getInfoComent(){
     List icom=new LinkedList();
         String a = "";
         Iterator it =Comentarios.iterator();
         
    while(it.hasNext()){
        
         Comentario pAux=(Comentario)it.next();
         
      InfoComent  ic= new InfoComent(pAux.getId(),pAux.getTexto(),pAux.getNombreCliente(),pAux.getFecha().getFecha(),pAux.getInfoComentAnidados());
        
icom.add(ic);
     
            }
   return icom;
}
        


}




