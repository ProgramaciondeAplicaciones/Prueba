/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Datatypes;

import java.util.StringTokenizer;

/**
 *
 * @author Nicole
 */

public class DataFecha {
    private int dia;
    private int mes;
    private int anio;
    
    public DataFecha(int dia1, int mes1, int anio1){
        dia = dia1;
        mes = mes1;
        anio = anio1;
    }
     public DataFecha(){
        dia = 0;
        mes = 0;
        anio = 0;
    }
    
    public int getDia(){
        return dia;
    }
     public int getMes(){
        return mes;
    }
      public int getAnio(){
        return anio;
    }
      public void setDia(int d){
          dia= d;
      }
      public void setMes(int m){
          mes= m;
      }
      public void setAnio(int a){
          anio=a;
      }
      
      public String imprimirFecha(){
          String fechaS=dia+"/"+mes+"/"+anio;
          return fechaS;
      }
      public String getFecha(DataFecha f){
          String fechaS=anio+"-"+mes+"-"+dia;
          return fechaS;
      }
      
     

       @Override
      public boolean equals (Object obj){
          if ((obj instanceof DataFecha)){
              DataFecha objDate = (DataFecha)obj; 
              if(this.dia==objDate.dia && this.mes==objDate.mes && this.anio==objDate.anio ){
                  return true;
              }
              else
                  return false;
          }
          else
              return false;
        
      }
       
       
           public String getFecha(){
          String fechaS=this.anio+"-"+this.mes+"-"+this.dia;
          return fechaS;
      }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.dia;
        hash = 83 * hash + this.mes;
        hash = 83 * hash + this.anio;
        return hash;
    }

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


}
 
    
    
    
    
      
      
      
//      public String getFecha(){
//          String fechaS=this.anio+"-"+this.mes+"-"+this.dia;
//          return fechaS;
//      }
//       @Override
//      public boolean equals (Object obj){
//          if ((obj instanceof DataFecha)){
//              DataFecha objDate = (DataFecha)obj; 
//              if(this.dia==objDate.dia && this.mes==objDate.mes && this.anio==objDate.anio ){
//                  return true;
//              }
//              else
//                  return false;
//          }
//          else
//              return false;
//        
//      }
//
//    @Override
//    public int hashCode() {
//        int hash = 5;
//        hash = 83 * hash + this.dia;
//        hash = 83 * hash + this.mes;
//        hash = 83 * hash + this.anio;
//        return hash;
//    }
//      public DataFecha getFecha(String fecha){
//     
//     StringTokenizer token= new StringTokenizer (fecha,"-");
//   
//     String aaa=token.nextToken();
//     String mmm=token.nextToken();
//     String ddd=token.nextToken();
//     
//     int dd=Integer.parseInt(ddd);
//     int aa=Integer.parseInt(aaa);
//     int mm=Integer.parseInt(mmm);
//     
//     DataFecha fechaa = new DataFecha(dd,mm,aa);
//     
//     return fechaa;
//     
//     StringTokenizer token= new StringTokenizer (fecha,"-");
//   
//     String aaa=token.nextToken();
//     String mmm=token.nextToken();
//     String ddd=token.nextToken();
//     
//     int dd=Integer.parseInt(ddd);
//     int aa=Integer.parseInt(aaa);
//     int mm=Integer.parseInt(mmm);
//     
//     DataFecha fechaa = new DataFecha(dd,mm,aa);
//     
//     return fechaa;
//     
//     
//     
//     
// }
//}
//    private StringTokenizer StringTokenizer(String f, String string) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    

    
   
    

