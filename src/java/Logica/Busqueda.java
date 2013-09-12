/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.conectar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Nicole
 */
public class Busqueda {
    
  conectar cc=new conectar();
 
  
  
  public DefaultComboBoxModel getLista(String cadenaEscrita) throws SQLException{
      
     DefaultComboBoxModel modelo= new DefaultComboBoxModel();
     modelo=cc.getPerfilesComboBox(cadenaEscrita);
     return modelo;
        
      
  }
  
   public DefaultComboBoxModel getListaClientes(String cadenaEscrita) throws SQLException{
      
     DefaultComboBoxModel modelo= new DefaultComboBoxModel();
     modelo=cc.getClientesComboBox(cadenaEscrita);
     return modelo;
        
  }
   
   public DefaultComboBoxModel getListaDesarrolladores (String cadenaEscrita) throws SQLException{
      
     DefaultComboBoxModel modelo= new DefaultComboBoxModel();
     modelo=cc.getDesarrolladoresComboBox(cadenaEscrita);
     return modelo;
        
  }
   
//   
// public String[] buscar(String nombre){
//     String[] datos=new String [8];
//    try {
//        
//        String sql="SELECT * FROM perfiles WHERE Nick='"+nombre+"'";
//        Connection cn=cc.conexion();
//        Statement  st = cn.createStatement();
//        ResultSet rs = st.executeQuery(sql);
//        while (rs.next()){
//            for (int i=0;i<datos.length;i++){
//                datos[i]=rs.getString(i+1);
//            }
//        }
//    } catch (SQLException ex) {
//        return null;
//    }
//    return datos;
//    
//     
// }
}
