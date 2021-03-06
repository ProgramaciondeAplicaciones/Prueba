/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.ControladorJuego;
import Logica.ControladorPerfil;
import Logica.Datatypes.dataJuego;
import Logica.Juego;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicole
 */
public class ComprarJuego extends javax.swing.JFrame {
DefaultComboBoxModel modelo = new DefaultComboBoxModel();
DefaultListModel modell=new DefaultListModel();
  

    /**
     * Creates new form ComprarJuego
     */
    public ComprarJuego() {
        initComponents();
         setLocationRelativeTo(null);
    try {
        cargarNickJuegos();
        precio.setVisible(false);
        
    } catch (SQLException ex) {
        Logger.getLogger(ComprarJuego.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b_mostrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        l_perfiles = new javax.swing.JList();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        l_juegos1 = new javax.swing.JList();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        l_juegos = new javax.swing.JList();
        precio = new javax.swing.JLabel();
        e_precio = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        b_mostrar.setText("Mostrar");
        b_mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_mostrarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Perfiles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 51)));

        jScrollPane2.setViewportView(l_perfiles);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Juegos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 51)));

        l_juegos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_juegos1MouseClicked(evt);
            }
        });
        l_juegos1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                l_juegos1KeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(l_juegos1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton2.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(745, 453));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("Comprar Juego");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 11, 259, 48);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripcion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 51, 102))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(0, 0, 105));

        descripcion.setEditable(false);
        descripcion.setColumns(20);
        descripcion.setRows(5);
        jScrollPane3.setViewportView(descripcion);
        descripcion.setLineWrap(true);
        descripcion.setWrapStyleWord(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(293, 115, 411, 178);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Juegos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(0, 51, 102))); // NOI18N

        l_juegos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_juegosMouseClicked(evt);
            }
        });
        l_juegos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                l_juegosKeyTyped(evt);
            }
        });
        jScrollPane5.setViewportView(l_juegos);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(30, 70, 203, 340);

        precio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        precio.setForeground(new java.awt.Color(0, 51, 105));
        precio.setText("Precio: U$S");
        getContentPane().add(precio);
        precio.setBounds(310, 330, 80, 20);

        e_precio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        e_precio.setForeground(new java.awt.Color(0, 51, 102));
        getContentPane().add(e_precio);
        e_precio.setBounds(390, 330, 72, 20);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 102));
        jButton1.setText("Comprar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(500, 370, 90, 30);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 51, 102));
        jButton3.setText("Cancelar");
        jButton3.setPreferredSize(new java.awt.Dimension(90, 30));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(610, 370, 90, 30);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, -10, 990, 470);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_mostrarActionPerformed

    }//GEN-LAST:event_b_mostrarActionPerformed

    private void l_juegos1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_juegos1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_l_juegos1MouseClicked

    private void l_juegos1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_l_juegos1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_l_juegos1KeyTyped

    private void l_juegosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_juegosMouseClicked
    try {
        String v=(String)l_juegos.getSelectedValue();
        ControladorJuego c1=ControladorJuego.getInstance();
        Iterator it=c1.listarJuegos().iterator();
        int fin=0;
        String devolver=null;
        double devolver2=1;
        while(it.hasNext()&&fin==0){
            dataJuego dj=(dataJuego)it.next();
            if(v.equals(dj.getNombre())){
                devolver=dj.getDescripcion();
                devolver2=dj.getPrecio().getcantidad();
                fin=2;
            }
            
        }
        
        DefaultListModel modell=new DefaultListModel();
        modell.addElement(devolver);
        descripcion.setText(devolver);
        
        e_precio.setText(Double.toString(devolver2));
        precio.setVisible(true);
        
        
        
    } catch (SQLException ex) {
        Logger.getLogger(ComprarJuego.class.getName()).log(Level.SEVERE, null, ex);
    }
       
    }//GEN-LAST:event_l_juegosMouseClicked

    private void l_juegosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_l_juegosKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_l_juegosKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     ControladorJuego c1=ControladorJuego.getInstance();
     c1.SeleccionJ((String)l_juegos.getSelectedValue());
     this.setVisible(false);
     ComprarJuego2 view = new ComprarJuego2();
     view.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         this.setVisible(false);
      Inicio view;
        view = new Inicio();
      view.setVisible(true); 
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(ComprarJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComprarJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComprarJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComprarJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ComprarJuego().setVisible(true);
            }
        });
    }
    public void cargarNickJuegos() throws SQLException{
        Iterator it;
        ControladorJuego cont1=ControladorJuego.getInstance();
        it = cont1.listarJuegos().iterator();
 while (it.hasNext()){
      dataJuego dj = (dataJuego)it.next();
      //JOptionPane.showMessageDialog(null, dj.getNombre());
      modelo.addElement(dj.getNombre());
      
      }
 l_juegos.setModel(modelo);
        
 
        
        
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_mostrar;
    private javax.swing.JTextArea descripcion;
    private javax.swing.JLabel e_precio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList l_juegos;
    private javax.swing.JList l_juegos1;
    private javax.swing.JList l_perfiles;
    private javax.swing.JLabel precio;
    // End of variables declaration//GEN-END:variables
}
