/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.LinkedList;
import java.util.List;
import Persistencia.conectar;
import Logica.Datatypes.DataFecha;
import Logica.Datatypes.Money;
import Logica.Datatypes.dataJuego;
import Logica.Datatypes.infoCat;
import Logica.Datatypes.infoComp;
import Logica.Datatypes.infoJuego;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class ControladorJuego {
    
   ControladorPerfil cont2= ControladorPerfil.getInstance();
    private List Juegos;
    private List Categorias;
    private List listaCat;
    conectar cc= new conectar();
    Connection cn = cc.conectar();
    public List categoriasparaeljuego;
     Categoria catSelec ;
      Juego jug;
      
       
    
    private Juego juegoSelec;
    private DataFecha fechaCompra;
    private String nickComprador;
    private infoComp ic;
    
    public Juego getJuegoSelec(){
        return juegoSelec;
    }
    public DataFecha getFechaCompra(){
        return fechaCompra;
    }
    public String getnickComprador(){
        return nickComprador;
    }
    
    
    
   private ControladorJuego(){
        Juegos= new LinkedList();
        Categorias = new LinkedList();
        catSelec =new Categoria();
        listaCat = new LinkedList();
        categoriasparaeljuego=new LinkedList();
        jug=new Juego();
        
      }
   
   
    private static ControladorJuego instance = new ControladorJuego(); 
   
 public static ControladorJuego getInstance(){
        return instance;
       
    }  
   
///////////////////////////// F U N C I O N E S   C O N T R O L A D O R    1  //////////////////////////////     

 
public boolean ingresarCat(String a){
    try {
            if(cc.existeCategoria(a)==true){
                return true;
             
    }else{
              return false;
              
            } 
        } catch (SQLException ex) {
            Logger.getLogger(Presentacion.AltaCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

}
 
public void crearCategoria(String nombre){
       cc.altaCategoria(nombre);
  }
 
public List AltaJuego(String nom, double tamanio, Money precio, String descripcion) throws SQLException{
    Categorias.clear();
     // conectar cc=new conectar();
     ArrayList listaAux=new ArrayList();
     listaAux= (ArrayList) cc.ListaCategorias();
     Categorias=(ArrayList)listaAux.clone();
     listaAux.clear();
    
     Iterator it=Categorias.iterator();
     while(it.hasNext()){   
         String cAux=(String)it.next();
         infoCat ic= new infoCat (cAux);
         listaAux.add(ic);
      }
     
     return listaAux;
}
 
public void SeleccionarCat(String Nombre){
      catSelec=new Categoria();
     int fin=0;
     Iterator it=Categorias.iterator();
     while(it.hasNext() && fin==0){
         Categoria  cAux=(Categoria)it.next();
         if(cAux.getNombre().equals(Nombre)){
             catSelec=cAux;
             fin=2;
                                            }                        
                                    }          
}

public List listarCat (){
      
  Categorias.clear();
  
   Categorias= cc.ListaCategoria();
  
    ArrayList listac = new ArrayList();
    Iterator it =Categorias.iterator();
 
    while(it.hasNext()){
         Categoria pAux=(Categoria)it.next();
         
         infoCat cat= new infoCat(pAux.getNombre());
         
         listac.add(cat);
                
               
            }
    
 
    
    return listac;
   
}  

public List listarJuegos() throws SQLException{
     Juegos.clear();
     conectar cc=new conectar();
     List listaAux=new ArrayList();
     Juegos=cc.cargarJuegos();
     
    //Juegos tiene todos los juegos del sistema
     Iterator it=Juegos.iterator();
     
     while(it.hasNext()){
         Juego jAux=(Juego)it.next();
         //JOptionPane.showMessageDialog(null,jAux.getNombre());
         dataJuego dj= new dataJuego(jAux.getNombre(),jAux.getDescripcion(),jAux.getPrecio());
         //JOptionPane.showMessageDialog(null, dj.getNombre());
         listaAux.add(dj);
      }
     
     return listaAux;
     
        
 }

public void SeleccionJ(String j){
     juegoSelec=new Juego();
     int fin=0;
     Iterator it=Juegos.iterator();
     while(it.hasNext() && fin==0){
         Juego jAux=new Juego();
         jAux=(Juego)it.next();
         if(jAux.getNombre().equals(j)){
             juegoSelec=jAux;
             fin=2;
           }
      }
        
 } 

public void realizarCompra (String nickk,DataFecha fechaa){
     Juego j=juegoSelec;
     dataJuego dj=new dataJuego(j.getNombre(),j.getDescripcion(),j.getPrecio());
     fechaCompra=fechaa;
     nickComprador=nickk;
     ic =new infoComp(nickk,fechaa,dj);
          
 }


 
   
///////////////////////////// F U N C I O N E S   E X T R A S   //////////////////////////////    
 
 
 


public void CargarCategorias (List lista) throws SQLException 
        {
        listaCat.clear();
        listaCat = lista;
        }

public List VerCategoriasCargadas ()
{    
     Iterator it=listaCat.iterator();
     List listaAux = new ArrayList();
     while(it.hasNext()){
         infoCat cAux=(infoCat)it.next();
         listaAux.add(cAux);
                        }
          return listaAux;
}

     
public void RecordarDatosJuegos(String no,Money pr,String de,double ta,int i,Desarrollador des, List listaa, List listab,List listac)
{
    //List lista = new ArrayList();
    
    jug = new Juego(no, pr,de,ta,i,des,listaa,listab,listac);       
}

public Juego DevolverDatosJuegos()
{
        return jug;  
}





public Categoria GetCategoria ()
{
    return catSelec;
}



//Iterator it = listaa.iterator();
//        while (it.hasNext()){
//            String elemto = (String) it.next();
//            //JOptionPane.showMessageDialog(null, elemto);
//            try {
//                cc.AgregarCategoriaAJuego(nom, elemto);
//            } catch (SQLException ex) {
//                Logger.getLogger(AltaJuego.class.getName()).log(Level.SEVERE, null, ex);
//            }

// public List listarCategorias() throws SQLException{
//    conectar cc =new conectar();
//    List listaCat = new ArrayList();
//    listaCat = cc.ListarDesarrolladores();
//    List devolver=new ArrayList();
//    
//    
//    Iterator it = listaCat.iterator();
//    while (it.hasNext())
//    {
//        String nombre=null;
//        nombre = (String) it.next();
//        
//      infoCat cat = new infoCat(nombre);
//
//      devolver.add(cat);
//   
//     
//    }
//    return devolver;
//   } 


public void Categoriasparaeljuego(List listaa){
    categoriasparaeljuego.clear();
    categoriasparaeljuego = listaa;
}

public List VerCategoriasparaeljuego (){
     Iterator it=categoriasparaeljuego.iterator();
      List listaAux = new ArrayList();
     while(it.hasNext()){
         infoCat cAux=(infoCat)it.next();
         listaAux.add(cAux);
      }
          return listaAux;
}

public void registrarJ(Desarrollador des) throws SQLException{
  //conectar cc = new conectar();
    Juego jueg = this.DevolverDatosJuegos();
    cc.altaJuego(jueg.getNombre(),jueg.getId(), jueg.getTamanio(), jueg.getDescripcion(), jueg.getPrecio(), des.getNick());
    Iterator it = categoriasparaeljuego.iterator();
        while (it.hasNext()){
            String elemto = (String) it.next();
            //JOptionPane.showMessageDialog(null, elemto);
         cc.AgregarCategoriaAJuego(jueg.getNombre(), elemto);
     
    }
    
}





     public List seleccionarCat (String cate){
      
  Juegos.clear();
  
   Juegos= cc.ListaJuegosCat(cate);
  
    ArrayList listac = new ArrayList();
    Iterator it =Juegos.iterator();
 String d="";
 Money m=new Money();
    while(it.hasNext()){
         Juego pAux=(Juego)it.next();
         
         dataJuego data= new dataJuego(pAux.getNombre(),d,m);
         
         listac.add(data);
                             }
    return listac;
   
}  
     
   public infoJuego selectJuego(String j){
         jug=cc.GetJuegoCompleto(j);
        
         ArrayList listac = new ArrayList();
         List infosCli;
         List infoca;
         List coment;
         
         infoca = jug.getInfoCat();
         infosCli =jug.getInfoCli();
         
         coment = jug.getInfoComent();
         String a = "";
        
         
  
     infoJuego ij=new infoJuego(jug.getNombre(),jug.getDescripcion(),jug.getTamanio(),jug.getDesarrollador().getNick(),infoca,infosCli,coment);
         return ij;
         
     }
     public Juego findUnJuego(int id){
   
    Juego ju=new Juego();
    Iterator it=Juegos.iterator();
    

    int fin =0;
    while(it.hasNext()&& fin==0){
        Juego jAux=new Juego();
        jAux=(Juego)it.next();
         if(jAux.getId()==(id)){
             ju=jAux;
             fin=2;
            
           }
      
    }
    if(fin!=2){
        return null;
    }else{
         return ju; 
    }
}
    



    
   ////////////////////   F U N C I O N E S   C O M P R A R   J U E G O  ////////////////////
   
 

 

 
 
 
 
 
 //////////////////////   F U N C I O N E S    E X T R A S /////////////////////////////////

 public DataFecha getFecha(String fecha){
     
     StringTokenizer token= new StringTokenizer (fecha,"-");
   
     String aaa=token.nextToken();
     String mmm=token.nextToken();
     String ddd=token.nextToken();
     
     int dd=Integer.parseInt(ddd);
     int aa=Integer.parseInt(aaa);
     int mm=Integer.parseInt(mmm);
     DataFecha fechaa = new DataFecha(dd,mm,aa);
     
     return fechaa;
     
} 
 public infoComp getInfoComp (){
     return ic;
     
 }
 

 
  
  
//public List listarCategorias (){
//    conectar cc = new conectar();
//    List listcat = cc.ListaCategorias();
//    return listcat;
//}
  

 
  
  
}





