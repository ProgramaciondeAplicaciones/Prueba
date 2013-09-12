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
public class InfoComent {
    private int id;
    private String texto;
    private String nomcli;
    private String Fecha;
    private List respuesta;
    
    public InfoComent (int i, String t, String n, String f, List l){
        id=i;
        texto=t;
        nomcli=n;
        Fecha=f;
        respuesta=l;
    }
    public InfoComent (){
        id=0;
        texto="o";
        nomcli="o";
        Fecha= "";
        respuesta= new LinkedList();
    }
    public void setRespuesta(InfoComent com){
        respuesta.add(com);
    }
    public int getid(){
        return id;
        
    }
    public String getTexto(){
        return texto;
        
    }
    public String getnombreCliente(){
        return nomcli;
        
    }
    public String getfecha(){
        return Fecha;
        
    }
    public List getRespuestas(){
        return respuesta;
        
    }
}