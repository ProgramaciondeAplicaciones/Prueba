/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.conectar;
import Logica.Datatypes.DataFecha;
import Logica.Datatypes.DataP;
import Logica.Datatypes.dataCliente;
import Logica.Datatypes.dataDes;
import Logica.Datatypes.dataDesarrollador;
import Logica.Datatypes.dataPerfil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Nicole
 */

 public class ControladorPerfil {
    private List Desarrolladores;
    Desarrollador DesSelec; 
    private ArrayList Clientes;
   conectar cc= new conectar();
    Connection cn = cc.conexion();
    public String tipo=null;
    
    private String nickAux,correoAux,imagenAux;
    private String noImagen="http://refugioantiaereo.com/wp-content/uploads/2008/07/no-imagen-wordpress.gif";
    private ControladorPerfil(){
        Desarrolladores= new LinkedList();
       Desarrollador DesSelec; 
       Clientes= new ArrayList();
        nickAux="";
        correoAux="";
    }
    
    private static ControladorPerfil instance = new ControladorPerfil();
    
    public void setImagen(String img){
        imagenAux=img;
    }
     public String getImagen(){
        return imagenAux;
    }
     public void setNoImagen(){
         imagenAux=noImagen;
     }
    public static ControladorPerfil getInstance(){
        return instance;
    }
    
    int contID=0;
//    public List listarDes(){
//        List lista= new LinkedList();
//            return lista;
//    }
//    
    public void setNickAux(String n){
        nickAux=n;
    }
    public void setCorreoAux(String c){
        correoAux=c;
    }
    public String getNickAux(){
        return nickAux;
    }
     public String getCorreoAux(){
        return correoAux;
    }
    
     
     
///////////////////////////// F U N C I O N E S   C O N T R O L A D O R    2  ////////////////////////////// 

public List listarDes () throws SQLException{
    conectar cc =new conectar();
    List listaDes = new ArrayList();
    listaDes = cc.ListarDesarrolladores();
    List devolver=new ArrayList();
    
    
    Iterator it = listaDes.iterator();
    while (it.hasNext())
    {
      String niick;
      niick = (String) it.next();
      dataDes desarr = new dataDes(niick);
      devolver.add(desarr);
     }
    return devolver;
   } 
     
public void SelecDes(String nick){
      DesSelec=new Desarrollador();
      DesSelec.setNick(nick);
   
}     
     
public boolean altaPerfil(String ni,String co){
        Cliente c=new Cliente();
        Desarrollador d=new Desarrollador();
        boolean r;
        if(c.existeN(ni)||c.existeC(co)){
            r=true;
        }
        else{
            if(d.existeN(ni)||d.existeC(co)){
                r=true;
            }
            else{
                r=false;
                correoAux=co;
                nickAux=ni;
            }
        }
        return r;
     }    

public void datosPerfil (String nom , String ap, DataFecha fech,String img){
    
 if("Desarrollador".equals(tipo)) {
     this.datosPerfilD(nom, ap, fech, img);
 }
 else
     this.datosPerfilC(nom, ap, fech, img);
        
}
     
   
   
public void registrComp() throws SQLException{
    
    ControladorJuego control1= ControladorJuego.getInstance();
    
    //obtengo nick del desarrollador, fecha de la compra y el juego a comprar del controlador 1
    Juego j=control1.getJuegoSelec();
    String n=control1.getnickComprador();
    DataFecha f=control1.getFechaCompra();
   
//    if(cc.existeNickCliente(n)){
    
    
    //vacio y competo la lista de clientes
    
    Clientes=new ArrayList();
    Clientes=cc.cargarClientes();
   
    //busco en la lista de clientes el que tenga nick "n"
    Cliente clienteSelec=this.findC(n);
   // JOptionPane.showMessageDialog(null, clienteSelec.getNombre());
    clienteSelec.crearCompra(f,j);
    
//    }
//    else{
//        JOptionPane.showMessageDialog(null, "El nick ingresado no existe en el sistema");
//    }
}  
   
public List listarP (){
      
  this.Desarrolladores.clear();
  Clientes.clear();
  Desarrolladores= cc.GetDes();
  Clientes = cc.GetCliente();
    ArrayList listaP = new ArrayList();
     //listaP=(ArrayList)listaP.clone();
    
    Iterator it =Clientes.iterator();
 
    while(it.hasNext()){
         Cliente pAux=(Cliente)it.next();
         
         DataP dp= new DataP(pAux.nick);
         
         listaP.add(dp);
                
               
            }
    
   Iterator it2 =Desarrolladores.iterator();
 
    while(it2.hasNext()){
         Desarrollador pAux2=(Desarrollador)it2.next();
         
         DataP dp2= new DataP(pAux2.getNick());
                      listaP.add(dp2);
                
               
            }
    
    return listaP;
   
}     
   
public dataPerfil seleccionarP(String n){
       
  if(findC(n)!=null){
      Cliente c =findC(n);
     
     dataPerfil data = new dataCliente(c.nombre,c.nick,c.apellido,c.correo,c.imagen,c.fechaNac,c.edad);
     
         return data;    
             
  }
  else{
      Desarrollador d=findD(n);
     
        dataPerfil data;
      data = new dataDesarrollador(d.nombre,d.nick,d.apellido,d.correo,d.imagen,d.fechaNac,d.webURL,d.edad);
     return data;
  }
   
  }   
  
public  void IngresarURL (String webURL){
    DesSelec.setWebURL(webURL);
    DesSelec.addDesarrollador();
    
    
}
   
///////////////////////////// F U N C I O N E S     E X T R A S  ////////////////////////////// 
 

 public void datosPerfilC(String nom, String ap, DataFecha fech, String img){
        Cliente cli= new Cliente(nickAux,correoAux,nom,ap,fech,img);
        cli.addCliente();
    }
   public void datosPerfilD(String nom, String ap, DataFecha fech, String img){
         Desarrollador des= new Desarrollador(nickAux,correoAux,nom,ap,fech,img,null);
         this.DesSelec=des;
         
    }    




    
public Desarrollador GetDes() throws SQLException{
           Desarrolladores=new LinkedList();
           conectar cc=new conectar();
           Desarrolladores=cc.cargarDesarrolladoresCompletos();
           Desarrollador dd=new Desarrollador();
           dd=findD(DesSelec.getNick());
           return dd;
       }
       
       
   public Desarrollador findD(String n){
        
    Desarrollador des=new Desarrollador();
    Iterator it=Desarrolladores.iterator();
    int fin =0;
    while(it.hasNext()&& fin==0){
        Desarrollador dAux=(Desarrollador)it.next();
         if(dAux.getNick().equals(n)){
             des=dAux;
             des.setEdad(calcularEdad(des.getFechaNac()));
             fin=2;
           }
        
    }
      
 return des;   
    
}    
   
    @SuppressWarnings("empty-statement")
   public Cliente findC(String n){
  
    Cliente cli=new Cliente();
    Clientes.clear();
    Clientes=cc.GetCliente();
    
    Iterator it=Clientes.iterator();
    int fin =0;
    while(it.hasNext()&& fin==0){
        Cliente cAux=new Cliente();
        
        cAux=(Cliente)it.next();
        if(null==cAux.getImagen()){
            cAux.setImagen(noImagen);
        }
         if(cAux.getNick().equals(n)){
             
             cli=cAux;
             cli.setEdad(calcularEdad(cli.getFechaNac()));
             
             fin=2;
            
           }
      
    }
    if(fin!=2){
     
        return null;
    }else{
         return cli; 
    }
}
       

  
  
    public void setDesarrollador(  Desarrollador des){
      Desarrolladores.add(des);
    }
    public void setCliente(  Cliente client){
      Clientes.add(client);
    }
    
    
    public static int calcularEdad(DataFecha fechaNac) {
 
    Calendar fechaActual = Calendar.getInstance();
 
    // Cálculo de las diferencias.
    int anios = fechaActual.get(Calendar.YEAR) - fechaNac.getAnio();
    int meses = fechaActual.get(Calendar.MONTH) - fechaNac.getMes();
    int dias = fechaActual.get(Calendar.DAY_OF_MONTH) - fechaNac.getDia();
 
    // Hay que comprobar si el día de su cumpleaños es posterior
    // a la fecha actual, para restar 1 a la diferencia de años,
    // pues aún no ha sido su cumpleaños.</code>
 
    if(meses < 0 // Aún no es el mes de su cumpleaños
       || (meses==0 && dias < 0)) { // o es el mes pero no ha llegado el día.
 
        anios--;
    }
    return anios;
}
    
    
    
    
    
//    public int SelecDes(String n){
//       
//        int cont=0;
//        Iterator iterador=DataDesarrolladores.iterator();
//        boolean op=true; 
//        while(iterador.hasNext()){
//            Desarrollador com=(Desarrollador) iterador.next();
//            if(com.getNick().equals(n)){
//                op=true;
//                
//            }   
//        }
//           if(op==true){
//               cont++;
//               
//           }
//           return cont;
//        }
  
      
 
//    public List listarP(){
//    conectar cc =new conectar();
//    List listarPer = new ArrayList();
//    listarPer = cc.listarPerfiles();
//    return listarPer;
//    }
        
        
//    public ArrayList listarDes(){
//        ArrayList lista= new ArrayList();
//        return lista;
//    }
//     
//   
//   
   
   
   

    
//public int SelecDes(String n){
//       
//        int cont=0;
//        Iterator iterador=Desarrolladores.iterator();
//        boolean op=true; 
//        while(iterador.hasNext()){
//            Desarrollador com=(Desarrollador) iterador.next();
//            if(com.getNick().equals(n)){
//                op=true;
//                
//            }   
//        }
//           if(op==true){
//               cont++;
//               
//           }
//           return cont;
//        }
    
    

    
}
    
    
    
    
    
    
    
    
    
    
       
       
       
   
    

