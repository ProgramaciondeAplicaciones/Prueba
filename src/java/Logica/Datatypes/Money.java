/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Datatypes;

/**
 *
 * @author Nicole
 */
public class Money {
   private double cantidad;
   private char tipo;
   private int op;
   private double numero =0;
   private double coti;

   public Money() {
    cantidad =0 ;
    tipo = '0';
    }


public Money(double cantidad, char tipo ) {
    this.cantidad = cantidad;
    this.tipo = tipo;
}



 public void setcantidad(double a){
    cantidad = a;
}
public void settipo (char b){
    tipo = b;
}

public double getcantidad(){
    return cantidad;
}

public char gettipo (){
    return tipo;
}


public double  cotizacion = 19.25;

public void ImprimirMoney (Money m){
    System.out.println( m.tipo +" "+m.cantidad);

       }

//CONVERTIR
public Money convertir (Money laux){


    if (tipo == 'd'){
        laux.cantidad = cantidad * cotizacion;
        laux.tipo = 'u';
    }else{
       laux.cantidad = cantidad / cotizacion;
        laux.tipo = 'd';
    }
    return laux;
}
}



