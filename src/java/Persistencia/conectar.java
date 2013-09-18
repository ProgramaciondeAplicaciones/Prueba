/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Categoria;
import Logica.Cliente;
import Logica.Comentario;
import Logica.Compra;
import Logica.ControladorJuego;
import Logica.ControladorPerfil;
import Presentacion.AltaJuego2;
import Presentacion.AltaJuego;
import javax.swing.*;
//  DARIO
import Logica.Datatypes.DataFecha;
import Logica.Datatypes.Money;
import Logica.Desarrollador;
import Logica.Juego;
import Presentacion.AltaCategoria;
import Presentacion.AltaPerfil;
import Presentacion.ComprarJuego3;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.org.mozilla.javascript.internal.ast.ForInLoop;






/**
 *
 * @author Nicole
 */

public class conectar {
Connection conect = null;
//DARIO
ControladorPerfil cont2= ControladorPerfil.getInstance();
ControladorJuego cont1= ControladorJuego.getInstance();
DataFecha fe=new DataFecha();
//TERMINA DARIO

   public Connection conectar()
    {
      try {
             
           //Cargamos el Driver MySQL
           Class.forName("org.gjt.mm.mysql.Driver");
           conect = DriverManager.getConnection("jdbc:mysql://localhost/progaplimarket","root","");
           //JOptionPane.showMessageDialog(null,"Conectado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error "+e);
        }
        return conect;
     
}
public void addPerfil(String nic,String co,String no ,String ap,String fe,String img,String tipo,String url){
    String sql="INSERT INTO perfiles (Nick,Correo,Nombre,Apellido,FechaNacimiento,Imagen,Tipo,webURL) VALUES (?,?,?,?,?,?,?,?)";
        try {
            Connection cn = this.conectar();
            PreparedStatement pst= cn.prepareStatement(sql);
            pst.setString(1,nic);//asigno en el signo de interrogacion numero uno la variable nom
            pst.setString(2,co);
            pst.setString(3,no);
            pst.setString(4,ap);
            pst.setString(5,fe);
            pst.setString(6,img);
            pst.setString(7,tipo);
            pst.setString(8,url);
            int n=pst.executeUpdate();//guarda en n la cantidad de datos que se guardo
           
            if (n>0){
                JOptionPane.showMessageDialog(null, "Registro guardado con exito");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AltaPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public   boolean existeNickCliente (String ni) throws SQLException {
        String sql = "SELECT * FROM perfiles WHERE perfiles.Nick = '"+ni+"' AND perfiles.Tipo='Cliente'";
        Connection cn = this.conectar();
        Statement  st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql); 
      
       if(rs.next()){
         return true;  
       }   
       else{
           return false;
       }
          
      }
    public boolean existeCorreoCliente(String co)throws SQLException {
        String sql = "SELECT * FROM perfiles WHERE perfiles.Correo = '"+co+"' AND perfiles.Tipo='Cliente'";
        Connection cn = this.conectar();
        Statement  st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql); 
      
       if(rs.next()){
         return true;  
       }   
       else{
           return false;
       }
    }

public   boolean existeNickDesarrollador(String ni) throws SQLException {
        String sql = "SELECT * FROM perfiles WHERE perfiles.Nick = '"+ni+"' AND perfiles.Tipo='Desarrollador'";
        Connection cn = this.conectar();
        Statement  st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql); 
      
       if(rs.next()){
         return true;  
       }   
       else{
           return false;
       }
          
      }
    public boolean existeCorreoDesarrollador(String co) throws SQLException {
        String sql = "SELECT * FROM perfiles WHERE perfiles.Correo = '"+co+"' AND perfiles.Tipo='Desarrollador'";
        Connection cn = this.conectar();
        Statement  st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql); 
      
       if(rs.next()){
         return true;  
       }   
       else{
           return false;
       }
    }

 public   boolean existeNick (String ni) throws SQLException {
        String sql = "SELECT * FROM perfiles WHERE perfiles.Nick = '"+ni+"'";
        Connection cn = this.conectar();
        Statement  st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql); 
      
       if(rs.next()){
         return true;  
       }   
       else{
           return false;
       }
          
      }

    
    /*************YO*********************/
    
	public List ListaCategorias()
    {
        Connection cn = this.conectar();
        Statement  st = null;
    try {
        st = cn.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
    }
        ResultSet res;
        List Lista = new ArrayList();
        try {
            res = st.executeQuery("select Nombre from categorias");
            while(res.next())
            {    
              //  infoCat categoria = new infoCat ("Hola Gastón");
                
                Lista.add(res.getObject(1));
            }
            return Lista;
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    public void altaJuego(String Nom,int id,double tam ,String desc,Money prec,String ni){
    String sql="INSERT INTO juegos (Nombre,Id,Tamanio,Descripcion,Precio,Nick) VALUES (?,?,?,?,?,?)";
        try {
            Connection cn = this.conectar();
            PreparedStatement pst= cn.prepareStatement(sql);
            pst.setString(1,Nom);//asigno en el signo de interrogacion numero uno la variable nom
           pst.setInt(2,id);
            pst.setDouble(3,tam);
            pst.setString(4,desc);
            pst.setDouble(5,prec.getcantidad());
            pst.setString(6,ni);
         
            int e=pst.executeUpdate();//guarda en n la cantidad de datos que se guardo
           
//            if (e>0){
//                JOptionPane.showMessageDialog(null, "Registro guardado con exito");
//                
//            }
        } catch (SQLException ex) {
            Logger.getLogger(AltaJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
}  
	
	
    public void AgregarCategoriaAJuego(String nom, String nomCa) throws SQLException{
     String sql1 ="SELECT Id FROM juegos WHERE Nombre = '"+nom+"'" ;
        Connection cn = this.conectar();
        Statement  st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql1); 
        while(rs.next())
            {              
                String id = rs.getObject(1).toString();
                int ide = Integer.parseInt(id);
                
              //  Lista.add(res.getObject(1));
                    
        String sql="INSERT INTO tiene (IdJuego, NombreCategoria) VALUES (?,?)";
        try {
//            Connection cn = this.conectar();
//             Statement  st = null;
             st = cn.createStatement();
                                  
            PreparedStatement pst= cn.prepareStatement(sql);
            pst.setInt(1,ide);//asigno en el signo de interrogacion numero uno la variable idJue
            pst.setString(2, nomCa);
            int n=pst.executeUpdate();//guarda en n la cantidad de datos que se guardo
           int pru = 0;
            if (n>0){
               // JOptionPane.showMessageDialog(null, "Registro guardado con exito");
                pru =1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AltaJuego2.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
        
    }
    public LinkedList cargarDesarrolladoresCompletos() throws SQLException{
         
        
        LinkedList lDesarrollador= new LinkedList();
                
        Connection cn = this.conectar();
        String sql = "SELECT * FROM perfiles WHERE Tipo='Desarrollador'";
        Statement  st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            Desarrollador des= new Desarrollador();
            des.setNick((String)rs.getObject(1));
            des.setCorreo((String)rs.getObject(2));
            des.setNombre((String)rs.getObject(3));
            des.setApellido((String)rs.getObject(4));
            DataFecha df=new DataFecha();
            DataFecha dfa=new DataFecha();
            dfa=df.getFecha(rs.getString(5));
            
            des.setFechaNac(df);
            des.setImagen((String)rs.getObject(6));
            des.setWebURL((String)rs.getObject(8));
            
            
            //agrego un nuevo desarrollador a la lista
            lDesarrollador.add(des);
        }
        return lDesarrollador;
           
    }
    
    
    
    
    
    public List ListarDesarrolladores() throws SQLException
    {
         List Lista = new ArrayList();
        Connection cn = this.conectar();
        Statement  st = cn.createStatement();
        String sql="select Nick from perfiles where Tipo = 'Desarrollador' ";
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next())
            {    
                String s=null;
                s=(String)rs.getObject(1);
                Lista.add(s);
            }
        return Lista;
            
       
    }
    
    
//     public List ListaCategorias() throws SQLException
//    {
//         List Lista = new ArrayList();
//        Connection cn = this.conectar();
//        Statement  st = cn.createStatement();
//        String sql="select Nombre from categorias";
//        ResultSet rs = st.executeQuery(sql);
//        
//        while(rs.next())
//            {    
//                String s=null;
//                s=(String)rs.getObject(1);
//                Lista.add(s);
//            }
//        return Lista;
//            
//       
//    }
    
    
    
 
//    public List ListaCategorias()
//    {
//        Connection cn = this.conectar();
//        Statement  st = null;
//    try {
//        st = cn.createStatement();
//    } catch (SQLException ex) {
//        Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
//    }
//        ResultSet res;
//        List Lista = new ArrayList();
//        try {
//            res = st.executeQuery("select Nombre from categorias");
//            while(res.next())
//            {    
//                
//                Lista.add(res.getObject(1));
//            }
//            return Lista;
//            
//        } catch (SQLException ex) {
//            System.out.println(ex.toString());
//            return null;
//        }
//    }
    
//    public void altaJuego(String Nom,int id,double tam ,String desc,Money prec,String ni){
//    String sql="INSERT INTO juegos (Nombre,Id,Tamanio,Descripcion,Precio,Nick) VALUES (?,?,?,?,?,?)";
//        try {
//            Connection cn = this.conectar();
//            PreparedStatement pst= cn.prepareStatement(sql);
//            pst.setString(1,Nom);//asigno en el signo de interrogacion numero uno la variable nom
//           pst.setInt(2,id);
//            pst.setDouble(3,tam);
//            pst.setString(4,desc);
//            pst.setDouble(5,prec.getcantidad());
//            pst.setString(6,ni);
//         
//            int e=pst.executeUpdate();//guarda en n la cantidad de datos que se guardo
//           
//            if (e>0){
//                JOptionPane.showMessageDialog(null, "Registro guardado con exito");
//                
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(AltaJuego.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//        
        
    public int idJuego(String Nombre) throws SQLException{
        String sql1 ="SELECT Id FROM juegos WHERE Nombre = '"+Nombre+"'" ;
        Connection cn = this.conectar();
        Statement  st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql1); 
        int ide=0;
        while(rs.next())
            {              
                String id;
            id = rs.getObject(1).toString();
                ide = Integer.parseInt(id);
            }
    return ide;
    }    
    
    
//    
//    /*******************************DARIO****************************************************/
    public ArrayList GetDes(){
     
   Connection cn = this.conectar();
        Statement  st = null;
        String ni;
        String co ;
        String nom;
        String ap;
       DataFecha fecha;
        String im;
  String web;
    try {
        st = cn.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
    }
        ResultSet res;
        
        
        
        try {
            ArrayList lista = new ArrayList();
        
            res = st.executeQuery("select * from perfiles");

            while(res.next())
            {                
                 
                    ni =res.getString(1);
                     co =res.getString(2);
                      nom =res.getString(3);
                       ap =res.getString(4);
                      
                       fecha=new DataFecha();
                       fecha =getFecha(res.getString(5));
                       
                         im=res.getString(6);
                         if("Desarrollador".equals(res.getString(7))){
                          web =res.getString(8);
                          
                           Desarrollador des = new Desarrollador(ni,co,nom,ap,fecha,im,web);
                           lista.add(des);
                                  
//                           cont2.setDesarrollador(des);
                }
//                         else{
//                             
//                       Cliente cli = new Cliente(ni,co,nom,ap,fecha,im);
//                   cont2.setCliente(cli);
//                         }
//                
//          
                
            }
           
            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
           
        }  
    return null;
 }
 public ArrayList GetCliente(){
     
   Connection cn = this.conectar();
        Statement  st = null;
        String ni;
        String co ;
        String nom;
        String ap;
       DataFecha fecha;
        String im;
  
    try {
        st = cn.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
    }
        ResultSet res;
        
        
        
        try {
            ArrayList lista = new ArrayList();
        
            res = st.executeQuery("select * from perfiles ORDER BY nick ");

            while(res.next())
            {                
                 
                    ni =res.getString(1);
                     co =res.getString(2);
                      nom =res.getString(3);
                       ap =res.getString(4);
                      
                       fecha=new DataFecha();
                       fecha =getFecha(res.getString(5));
                         im=res.getString(6);
                         
                         if("Cliente".equals(res.getString(7))){
                        
//                          JOptionPane.showMessageDialog(null, dp.fechaNacim.getAnio(),"Error",JOptionPane.ERROR_MESSAGE);
                            
                             Cliente cli = new Cliente(ni,co,nom,ap,fecha,im);
                            
//                   cont2.setCliente(cli);
                           lista.add(cli);
                                  
//                           cont2.setDesarrollador(des);
                }
//                         else{
//                  
//                         }          
                
            }
           
            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
           
        }  
    return null;
 }
 
 
  public List ListaCategoria()
    {
      Connection cn = this.conectar();
        Statement  st = null;
        String nom;
    try {
        st = cn.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
    }
        ResultSet res;
        
        try {
            ArrayList lista = new ArrayList();
        
            res = st.executeQuery("select * from categorias");

            while(res.next())
            {                
                 nom =res.getString(1);
                            
                       Categoria cat = new Categoria(nom);
//                   
                           lista.add(cat);
               
            }
           
            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
           
        }  
    return null;
    }
      
     public List ListaJuegosCat(String cate)
    {
      Connection cn = this.conectar();
        Statement  st = null;
        String nom;
    try {
        st = cn.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
    }
        ResultSet res;
      
        try {
            ArrayList lista = new ArrayList();
        
            res = st.executeQuery("select juegos.* from tiene,juegos where NombreCategoria='"+cate+"'and tiene.IdJuego = juegos.Id");
                    
//            
            
           
        int id;
        String des;
        String nomd;
        String core;
        String ap;
        String fe;
        String im;
       
        String web;
        DataFecha fecha= new DataFecha();
        double tam;
        String nick;
        Money pre=new Money();
        int p;
            
            
            
            /////////////////////
           while(res.next())
            {                
                 nom =res.getString(1);
                  id =res.getInt(2);
                  tam =res.getDouble(3);
                  des=res.getString(4);
                  p=res.getInt(5);
                 
                  pre.setcantidad(p);
                  pre.settipo('d');
                  nick=res.getString(6);
                  
                  
//                    ResultSet res2;
                   ///////////////////////////
//                    res2 = st.executeQuery("select * from perfiles where Nick = '"+nick+"'");
//                  while(res2.next()){
//                   
//                   core= res2.getString(2);
//                   nomd =res2.getString(3);
//                  ap=res2.getString(4);
//                  fecha =getFecha(res2.getString(5));
//                  im=res2.getString(6);
//                  web=res2.getString(8);
//                 Desarrollador desa= new Desarrollador(nick,core,nomd,ap,fecha,im,web);
//                  
//                      }
                   
                  Desarrollador desa = new Desarrollador();
                  List v= null;
                      Juego ju = new Juego(nom,pre,des,tam,id,desa,v,v,v);
                     
                           lista.add(ju);
               
            }
           
            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
           
        }  
    return null;
    }
     
    public Juego GetJuegoCompleto(String n){
        Connection cn = this.conectar();
        Statement  st = null;
        
    try {
        st = cn.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
    }
        ResultSet res;
      
        try {
            
            List listacategorias = new LinkedList();
            List listaComentarios = new LinkedList();
            List listaCompras = new LinkedList();
           
        
            res = st.executeQuery("select * from juegos where Nombre ='"+n+"'");
        int id;
        String des;
        String nomd;
        String core;
        String ap;
        String fe;
        String im;
      
        String web;
        
        double tam;
        String nick;
        Money pre=new Money();
        int p;
            
           
            pre.settipo('d');
            /////////////////////
           while(res.next())
            {                
                 
                  id =res.getInt(2);
                  tam =res.getDouble(3);
                  des=res.getString(4);
                  p=res.getInt(5);
                 
                  pre.setcantidad(p);
                  
                  nick=res.getString(6);
                  
                
                  
                   
             Desarrollador desa = new Desarrollador();
             desa.setNick(nick);
                  
             listacategorias= this.getCategoriasConJuego(n);  
             
             listaComentarios=this.ObtenerComentariosDeUnJuego(id);
             
             listaCompras =this.ObtenerLasCompras(id);
             Juego ju = new Juego(n,pre,des,tam,id,desa,listacategorias,listaComentarios,listaCompras);
                        
               return ju;
            }
           
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
           
        }  
    return null;
        
        
    }
    
    
    public List getCategoriasConJuego(String ju){
        
    
      Connection cn = this.conectar();
        Statement  st = null;
        
    try {
        st = cn.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
    }
        ResultSet res;
      
        try {
            ArrayList lista = new ArrayList();
        
            res = st.executeQuery("select tiene.NombreCategoria from tiene,juegos where juegos.Nombre='"+ju+"'and tiene.IdJuego = juegos.Id");
       
        String nom;
     
            
            /////////////////////
           while(res.next())
            {                
                 nom =res.getString(1);
                 
                  
                
//                      }
                   
                  
                  Categoria cat = new Categoria(nom);
                           lista.add(cat);
               
            }
           
            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
           
        }  
    return null;
    }
    
    
    
     
        
        
     
    public List ObtenerLasCompras(int idju){
       Connection cn = this.conectar();
       ArrayList lista = new ArrayList();
        Statement  st = null;
        
    try {
        st = cn.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
    }
        ResultSet res;
      
        try {
           
        
            res = st.executeQuery("select * from compra where IdJuego='"+idju+"'");
       
        
            /////////////////////
           while(res.next())
            {  
                String nk=null;
                DataFecha df=new DataFecha();
        
                 nk =res.getString(1);
                
                df=this.getFecha(res.getString(3));
                 
//                      }fecha juego cliente
                   Cliente cli=new Cliente();
                   cli=cont2.findC(nk);
                   
                   Juego ju=new Juego();
                  ControladorJuego c1=ControladorJuego.getInstance();
                   ju=c1.findUnJuego(idju);
                  
                  if(ju==null || cli==null){
                      JOptionPane.showMessageDialog (null, "en obtener las compras esta mal");
                  }
                  Compra com = new Compra(df,ju,cli);
                  
                           lista.add(com);
               
            }
           
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
           
        }  
//    return null;
    return lista;
        
    }
    
     public List ObtenerComentariosDeUnJuego(int idju){  
      Connection cn = this.conectar();
        Statement  st = null;
        
    try {
        st = cn.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
    }
        ResultSet res;
      
        try {
            ArrayList lista = new ArrayList();
          List respuestas =  new LinkedList();
           
            res = st.executeQuery("select * from comentarios,juegos where IdJuego='"+idju+"' and IdJuego=juegos.Id");
           
       String nk;
       String text ;
       int id;
       DataFecha df=new DataFecha();
       
            /////////////////////
           while(res.next())
            {  
                
           id= res.getInt(1);
           text= res.getString(3);
           
          df=this.getFecha(res.getString(4));
           nk=res.getString(2);
      
          //DataFecha f, int i, String t, Cliente cli,List res)
          Cliente cli=cont2.findC(nk);
          
          respuestas=this.RespuestaComentarios(id);
          
          Comentario com =new Comentario(df,id,text,cli,respuestas);
          
          lista.add(com);  
            }
           
            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
           
        }  
    return null;
    
        
    }
     
      public List RespuestaComentarios(int idCom){  
      Connection cn = this.conectar();
        Statement  st = null;
        
    try {
        st = cn.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
    }
        ResultSet res;
      
        try {
            ArrayList lista = new ArrayList();
          ArrayList respuestas = new ArrayList();
            res = st.executeQuery("select * from comentarios_anidados where IdResp='"+idCom+"'");
       String nk;
       String text ;
       int id;
       DataFecha df=new DataFecha();
            /////////////////////
           while(res.next())
            {  
           id= res.getInt(1);
           text= res.getString(3);
          df=this.getFecha(res.getString(4));
           nk= res.getString(2);
           respuestas=null;
     
   
          Cliente cli=cont2.findC(nk);
         
          Comentario com =new Comentario(df,id,text,cli,respuestas);
          
                           lista.add(com);
               
            }
           
            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
           
        }  
    return null;
    
        
    }
    
    
    public void altaCategoria(String nombre){
    String sql="INSERT INTO categorias (Nombre) VALUES (?)";
           try {
                Connection cn = this.conectar();
            PreparedStatement pst= cn.prepareStatement(sql);
            pst.setString(1,nombre);//asigno en el signo de interrogacion numero uno la variable nom
            
              int n=pst.executeUpdate();//guarda en n la cantidad de datos que se guardo
           
            if (n>0){
                JOptionPane.showMessageDialog(null, "Registro guardado con exito");
                
            }
             } catch (SQLException ex) {
            Logger.getLogger(AltaCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }

}
    public   boolean existeCategoria (String ca) throws SQLException{
        String sql = "SELECT * FROM categorias WHERE Nombre = '"+ca+"'";
        Connection cn = this.conectar();
        Statement  st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
      
       if(rs.next()){
         return true;  
       }   
       else{
           return false;
       }
          
      }
   
      //        void mostrar(){
//         try {
//           
//           
//            Connection cn = cc.conectar();
//            String sql = "SELECT Nick FROM perfiles";
//            Statement  st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            
//            DefaultListModel modell=new DefaultListModel();
//            l_perfiles.setModel(modell);
//           
//            while(rs.next()){
//                modell.addElement(rs.getString("Nick"));
//            }
//            l_perfiles.setModel(modell);
//             } catch (SQLException ex) {
//            Logger.getLogger(ConsultaPerfil.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

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
     /****************************NICOLE*****************************************/
     
      ////////////////////   F U N C I O N E S   C O M P R A R   J U E G O  ////////////////////

    public List cargarJuegos() throws SQLException{
       
        List lJuegos= new ArrayList();
        List lCategorias= new ArrayList();
        
              
        
        Connection cn = this.conectar();
        String sql = "SELECT * FROM juegos";
        Statement  st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            Juego ju=new Juego();
            ju.setNombre((String)rs.getObject(1));
            int id=rs.getInt(2);
            ju.setId(id);
            ju.setTamanio(rs.getDouble(3));
            ju.setDescripcion((String)rs.getObject(4));
            Double d=rs.getDouble(5);
            Money m=new Money();
            m.setcantidad(d);
            ju.setPrecio(m);
            Desarrollador des = new Desarrollador();
            des.setNick((String)rs.getObject(6));
            ju.setDesarrollador(des);
            //obtengo la lista de categorias
            
            Connection co = this.conectar();
            String sq = "SELECT NombreCategoria FROM tiene WHERE IdJuego='"+id+"'";
            Statement  sta = co.createStatement();
            ResultSet res = sta.executeQuery(sql);
            while (res.next()){
                lCategorias.add(res.getObject(1));
            }
            //JOptionPane.showMessageDialog(null, ju.getNombre());
            ju.setCategorias(lCategorias);
            //agrego un juego a la lista
            lJuegos.add(ju);
            
            
            
//            Iterator it=lJuegos.iterator();
//            JOptionPane.showMessageDialog(null, "desde aca");
//            while (it.hasNext()){
//                Juego j=(Juego)it.next();
//                JOptionPane.showMessageDialog(null, j.getNombre());
//            }
//            JOptionPane.showMessageDialog(null, "fin");
            
            
        }
        return lJuegos;
        
        
    }
    
     public ArrayList cargarClientes() throws SQLException{
         
        
        ArrayList lClientes= new ArrayList();
                
        Connection cn = this.conectar();
        String sql = "SELECT * FROM perfiles WHERE Tipo='Cliente'";
        Statement  st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            Cliente cli= new Cliente();
            cli.setNick((String)rs.getObject(1));
            cli.setCorreo((String)rs.getObject(2));
            cli.setNombre((String)rs.getObject(3));
            cli.setApellido((String)rs.getObject(4));
            DataFecha df=new DataFecha();
            DataFecha dfa;
            df=getFecha(rs.getString(5));
            
            cli.setFechaNac(df);
            cli.setImagen((String)rs.getObject(6));
            
            
            //agrego un nuevo cliente a la lista
            lClientes.add(cli);
        }
        return lClientes;
           
    }
    
     
    public void addCompra(Compra c){
    try {
        String sql="INSERT INTO compra (Nick, IdJuego, Fecha) VALUES (?,?,?)";
        Connection cn=this.conectar();
        PreparedStatement pst= cn.prepareStatement(sql);
        pst.setString(1,c.getNickCliente());
        pst.setInt(2, c.getIdJuego());
        pst.setString(3,c.getFecha());
        
        pst.executeUpdate();
       
        
        
    } catch (SQLException ex) {
        Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
    }     
        
    } 
     
  
     
 
    private StringTokenizer StringTokenizer(String f, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public  DefaultComboBoxModel getClientesComboBox(String cadenaEscrita) throws SQLException{
         DefaultComboBoxModel modelo= new DefaultComboBoxModel();
      String sql="SELECT Nick FROM perfiles WHERE Tipo='Cliente' AND Nick LIKE '"+cadenaEscrita+"%';";
      
      Connection cn = this.conectar();
       Statement  st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql); 
        
        while(rs.next()){
            modelo.addElement(rs.getString("Nick"));
        }
            return modelo;
           
    }
 
    
    public  DefaultComboBoxModel getPerfilesComboBox(String cadenaEscrita) throws SQLException{
         DefaultComboBoxModel modelo= new DefaultComboBoxModel();
      String sql="SELECT Nick FROM perfiles WHERE Nick LIKE '"+cadenaEscrita+"%';";
      
      Connection cn = this.conectar();
       Statement  st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql); 
        
        while(rs.next()){
            modelo.addElement(rs.getString("Nick"));
        }
            return modelo;
           
    }
     public  DefaultComboBoxModel getDesarrolladoresComboBox(String cadenaEscrita) throws SQLException{
         DefaultComboBoxModel modelo= new DefaultComboBoxModel();
      String sql="SELECT Nick FROM perfiles WHERE Tipo='Desarrollador' AND Nick LIKE '"+cadenaEscrita+"%';";
      
      Connection cn = this.conectar();
       Statement  st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql); 
        
        while(rs.next()){
            modelo.addElement(rs.getString("Nick"));
        }
            return modelo;
           
    }
        
}

  

    
    
    
