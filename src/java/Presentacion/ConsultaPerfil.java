/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Busqueda;
import Logica.ControladorPerfil;
import Logica.Datatypes.DataFecha;
import Logica.Datatypes.DataP;
import Logica.Datatypes.dataPerfil;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Nicole
 */
public class ConsultaPerfil extends javax.swing.JFrame {
  
//DefaultComboBox modell = new DefaultComboBox();
    Busqueda busqueda=new Busqueda();
 DefaultComboBoxModel modell = new DefaultComboBoxModel();
ControladorPerfil cont2 = ControladorPerfil.getInstance();
// String paraImagen=null;
// ControladorPerfil cont2 = new ControladorPerfil();
    /**
     * Creates new form ConsultaPerfil
     */
    public ConsultaPerfil() {
        
      
        
       initComponents();
       CargarComboBox();  
       web.setVisible(false);
       panel.setVisible(false);
       
       //   setLocationRelativeTo(null);
       
       //super combo box
       
       c_perfiles.getEditor().getEditorComponent().addKeyListener(new KeyAdapter(){
       
           @Override
         public void  keyReleased(KeyEvent evt){
           
         String cadenaEscrita=c_perfiles.getEditor().getItem().toString();
         //limitar los eventos de las teclas usando el ACII 
         if(evt.getKeyCode()>=65 && evt.getKeyCode()<=90 || evt.getKeyCode()>=96 && evt.getKeyCode()<=105 || evt.getKeyCode()==8 ){
             try {            
                 c_perfiles.setModel(busqueda.getLista(cadenaEscrita));
                 if(c_perfiles.getItemCount()>0){
                     c_perfiles.showPopup();
                     if(evt.getKeyCode()!=8){
                         ((JTextComponent)c_perfiles.getEditor().getEditorComponent()).select(cadenaEscrita.length(),c_perfiles.getEditor().getItem().toString().length());
                         
                     }
                     else{
                         c_perfiles.getEditor().setItem(cadenaEscrita);
                     }
                 }
                 else{
                     c_perfiles.addItem(cadenaEscrita);
                 }
             } catch (SQLException ex) {
                 Logger.getLogger(ConsultaPerfil.class.getName()).log(Level.SEVERE, null, ex);
             }
             
             
             
         }
             
             
       }
         
         
           
       
       });
    }

public void CargarComboBox(){
    List al=cont2.listarP();
    Iterator it = al.iterator();
  
       while(it.hasNext()){  
            DataP a=(DataP)it.next();
                
               modell.addElement(a.getNick());
               
            }
            c_perfiles.setModel(modell); 

}
//public void buscar (String nombre)
//         {
//             
//             String datos[]=busqueda.buscar(nombre);
//             if(datos[0]!=null){
//                 
//             }
//         }         
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        b_mostrar = new javax.swing.JButton();
        c_perfiles = new javax.swing.JComboBox();
        salir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        mostrarurl = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        e_correo = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        e_apellido = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        as = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        foto = new javax.swing.JLabel();
        e_fechaN = new javax.swing.JLabel();
        e_nick = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        e_tipo = new javax.swing.JLabel();
        e_nombre = new javax.swing.JLabel();
        web = new javax.swing.JLabel();
        e_edad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(745, 453));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("Consulta de Perfil");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 0, 360, 48);

        b_mostrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        b_mostrar.setForeground(new java.awt.Color(0, 51, 102));
        b_mostrar.setText("Mostrar");
        b_mostrar.setMaximumSize(new java.awt.Dimension(745, 453));
        b_mostrar.setMinimumSize(new java.awt.Dimension(745, 453));
        b_mostrar.setPreferredSize(new java.awt.Dimension(745, 453));
        b_mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_mostrarActionPerformed(evt);
            }
        });
        getContentPane().add(b_mostrar);
        b_mostrar.setBounds(530, 60, 90, 30);

        c_perfiles.setEditable(true);
        c_perfiles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_perfilesMouseClicked(evt);
            }
        });
        c_perfiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_perfilesActionPerformed(evt);
            }
        });
        getContentPane().add(c_perfiles);
        c_perfiles.setBounds(260, 60, 242, 30);

        salir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        salir.setForeground(new java.awt.Color(0, 51, 102));
        salir.setText("Volver");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir);
        salir.setBounds(610, 370, 90, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 102));
        jLabel5.setText("Selecionar Perfil");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(130, 60, 130, 30);

        panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        mostrarurl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mostrarurl.setText("                                                    ");
        mostrarurl.setRequestFocusEnabled(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 102));
        jLabel12.setText("Nick");

        e_correo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        e_correo.setText("                                           ");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 102));
        jLabel14.setText("Correo");

        e_apellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        e_apellido.setText("                                                    ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 102));
        jLabel6.setText("Nombre");

        as.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        as.setForeground(new java.awt.Color(0, 51, 102));
        as.setText("Edad");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 102));
        jLabel10.setText("Fecha de Nacimiento");

        foto.setPreferredSize(new java.awt.Dimension(23, 23));

        e_fechaN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        e_fechaN.setText("                                 ");

        e_nick.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        e_nick.setText("                                      ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 102));
        jLabel9.setText("Apellido");

        e_tipo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        e_tipo.setForeground(new java.awt.Color(0, 51, 102));

        e_nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        e_nombre.setText("                                   ");

        web.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        web.setForeground(new java.awt.Color(0, 51, 102));
        web.setText("WebURL");

        e_edad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        e_edad.setPreferredSize(new java.awt.Dimension(25, 20));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(e_nick)
                            .addComponent(e_correo))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(e_fechaN, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(as)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e_edad, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelLayout.createSequentialGroup()
                            .addComponent(web, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(mostrarurl, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(e_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(e_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(e_nombre))
                        .addGap(26, 26, 26)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(e_apellido))
                        .addGap(27, 27, 27)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(e_fechaN, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(e_nick)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel14)))
                        .addGroup(panelLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(as, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(e_edad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(mostrarurl, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(web, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(e_correo)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panel);
        panel.setBounds(100, 110, 540, 250);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_mostrarActionPerformed
//       
      web.setVisible(false);
      mostrarurl.setVisible(false);
      String d= (String )c_perfiles.getSelectedItem();
      if(d==null){
           JOptionPane.showMessageDialog (null, "No hay perfil selecionado");
      }else{
          try {
              dataPerfil dp= cont2.seleccionarP(d);
              DataFecha f =dp.fechaNacim;
             e_nombre.setText(dp.nombre); 
             e_apellido.setText(dp.apellido);
             
             
             e_fechaN.setText(f.imprimirFecha());
             
             e_nick.setText(dp.nick);
             e_correo.setText(dp.correo);
             e_tipo.setText(dp.DameTipo());
         
            e_edad.setText(Integer.toString(dp.edad));
            if(dp.DameTipo().equals("Desarrollador")){
                e_tipo.setText("DESARROLLADOR");
                web.setVisible(true);
                mostrarurl.setVisible(true);
                mostrarurl.setText(cont2.findD(dp.nick).getWebURL());
           
            }
            else
                 e_tipo.setText("CLIENTE");
            
            ImageIcon imagen=new ImageIcon();
            if(dp.imagen.indexOf ("http://") == -1){
//            imagen = new ImageIcon(new URL (dp.imagen));
                imagen = new ImageIcon(dp.imagen);
            }
            else{
                 imagen = new ImageIcon(new URL (dp.imagen));
//                 imagen = new ImageIcon(dp.imagen);
//                 JOptionPane.showMessageDialog(this, dp.imagen);
            }
//             ImageIcon imagen = new ImageIcon(new URL("http://www.defiantdev.com/images/defiant_paint.jpg"));
             Icon icono = new ImageIcon (imagen.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(),Image.SCALE_DEFAULT));
             foto.setIcon(icono);
             this.repaint();
             //        foto.setBounds(60, 190, 130, 120);
              //foto.setIcon(new javax.swing.ImageIcon
                     //        foto.setBounds(60, 190, 130, 120);
      //        foto.setBounds(60, 190, 130, 120);
             panel.setVisible(true);
          } catch (MalformedURLException ex) {
              Logger.getLogger(ConsultaPerfil.class.getName()).log(Level.SEVERE, null, ex);
          }
        
      }
        
    }//GEN-LAST:event_b_mostrarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
           // TODO add your handling code here:
        this.setVisible(false);
      Inicio view;
        view = new Inicio();
      view.setVisible(true); 
    }//GEN-LAST:event_salirActionPerformed

    private void c_perfilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_perfilesActionPerformed
//String d = combo1.getComponents().toString();
//        dataPerfil dp= cont2.selecPerfil(d);
//        jLabel8.setText(dp.nombre); 
        
    }//GEN-LAST:event_c_perfilesActionPerformed

    private void c_perfilesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_perfilesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_c_perfilesMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultaPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConsultaPerfil().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel as;
    private javax.swing.JButton b_mostrar;
    private javax.swing.JComboBox c_perfiles;
    private javax.swing.JLabel e_apellido;
    private javax.swing.JLabel e_correo;
    private javax.swing.JLabel e_edad;
    private javax.swing.JLabel e_fechaN;
    private javax.swing.JLabel e_nick;
    private javax.swing.JLabel e_nombre;
    private javax.swing.JLabel e_tipo;
    private javax.swing.JLabel foto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel mostrarurl;
    private javax.swing.JPanel panel;
    private javax.swing.JButton salir;
    private javax.swing.JLabel web;
    // End of variables declaration//GEN-END:variables
}
