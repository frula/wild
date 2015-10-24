/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import datos.Pizzeria;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import negocio.MateriaPrima;

public class FormMatPrima extends javax.swing.JDialog {
    ArrayList <MateriaPrima> materiasprimas = Pizzeria.devuelveMateriaPrima();
    
    public FormMatPrima(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        limpiar();
        bloquear();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btsalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txcat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txmatprima = new javax.swing.JTextField();
        btagregar = new javax.swing.JButton();
        btbloquear = new javax.swing.JButton();
        btmodificar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txidmatp = new javax.swing.JTextField();
        chhab = new javax.swing.JCheckBox();
        btnuevo = new javax.swing.JButton();
        btbuscar = new javax.swing.JButton();
        txbuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btsalir.setText("Salir");
        btsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsalirActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(28, 76, 70));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Rod", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Materia prima");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Categoria:");

        txcat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txcatActionPerformed(evt);
            }
        });
        txcat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txcatKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txcatKeyTyped(evt);
            }
        });

        jLabel3.setText("Materia Prima:");

        txmatprima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txmatprimaActionPerformed(evt);
            }
        });
        txmatprima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txmatprimaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txmatprimaKeyTyped(evt);
            }
        });

        btagregar.setText("Agregar");
        btagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btagregarActionPerformed(evt);
            }
        });

        btbloquear.setText("Bloquear/\nDesbloquear");
        btbloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbloquearActionPerformed(evt);
            }
        });

        btmodificar.setText("Modificar");
        btmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmodificarActionPerformed(evt);
            }
        });

        jLabel4.setText("ID M. Prima");

        txidmatp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txidmatpActionPerformed(evt);
            }
        });
        txidmatp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txidmatpKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txidmatpKeyTyped(evt);
            }
        });

        chhab.setText("Habilitado");

        btnuevo.setText("Nuevo");
        btnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnuevoActionPerformed(evt);
            }
        });

        btbuscar.setText("Buscar");
        btbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbuscarActionPerformed(evt);
            }
        });

        txbuscar.setText("Ingrese nombre de Materia Prima");
        txbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txbuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chhab)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btagregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btbloquear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btmodificar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txidmatp, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txcat, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txmatprima, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btsalir, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btbuscar))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btbuscar)
                    .addComponent(txbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(chhab)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txidmatp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txcat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txmatprima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btmodificar)
                    .addComponent(btbloquear)
                    .addComponent(btagregar)
                    .addComponent(btnuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btsalir))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void limpiar (){
       txidmatp.setText("");
       txcat.setText("");
       txmatprima.setText("");
    }
    
    void bloquear(){
       txidmatp.setEnabled(false);
       txcat.setEnabled(false);
       txmatprima.setEnabled(false);
       
       btnuevo.setEnabled(true);
       btagregar.setEnabled(false);
       btbloquear.setEnabled(false);
       btmodificar.setEnabled(false);
       chhab.setEnabled(false);
    }
    
       void desbloquear(){
       txidmatp.setEnabled(false);
       txcat.setEnabled(true);
       txmatprima.setEnabled(true);
        
       
       btnuevo.setEnabled(true);
       btagregar.setEnabled(false);
       btbloquear.setEnabled(false);
       btmodificar.setEnabled(false);
       chhab.setEnabled(false);
    }
       void desbloquearGuardar(){
        boolean desbloqueo=true;
        int id=Integer.parseInt(txidmatp.getText());
        if(txidmatp.getText().equals("")||id<=materiasprimas.size()){
            desbloqueo=false;}
        else if(txcat.getText().equals("")){
            desbloqueo=false;}
        else if(txmatprima.getText().equals("")){
            desbloqueo=false;}
        else{
            desbloqueo=true;}
        btagregar.setEnabled(desbloqueo);
        }
       
       void desbloquearBloMod(){
         btmodificar.setEnabled(true);
         btbloquear.setEnabled(true);
       }
       
       void desbloquearBloqHab(int es){
         if(es==0){chhab.setSelected(true);}
         else if(es==1){chhab.setSelected(false);}
       }
    
    private void btagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btagregarActionPerformed
        //0=EstaMarcado 1=NOestaMarcado
        int es;
        if(chhab.isSelected()){
           es=0; 
        }
        else{
            es=1;
        }
        String nombre=txmatprima.getText().toUpperCase();
        int id=Integer.parseInt(txidmatp.getText());
        String cat=txcat.getText();
        Pizzeria.agregarmatprima(nombre,cat,es);
        bloquear();
    }//GEN-LAST:event_btagregarActionPerformed

    private void btbloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbloquearActionPerformed
        int id=Integer.parseInt(txidmatp.getText());
        int es;
        if(chhab.isSelected()){
           es=1; 
        }
        else{
            es=0;
        }
        Pizzeria.bloquarDesbloquearMatprima(id, es);
        desbloquearBloqHab(es);
    }//GEN-LAST:event_btbloquearActionPerformed

    private void btmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmodificarActionPerformed
        String nombre=txmatprima.getText().toUpperCase();
        int id=Integer.parseInt(txidmatp.getText());
        int cat=Integer.parseInt(txcat.getText());
        Pizzeria.modificarmatprima(id, nombre,cat);        
    }//GEN-LAST:event_btmodificarActionPerformed

    private void txidmatpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txidmatpActionPerformed
        if(txidmatp.getText().equals("")){
            txidmatp.requestFocus();
        }
        else{
            txidmatp.transferFocus(); 
        }
    }//GEN-LAST:event_txidmatpActionPerformed

    private void txcatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txcatActionPerformed
        if(txcat.getText().equals("")){
            txcat.requestFocus();
        }
        else{
            txcat.transferFocus(); 
        }
    }//GEN-LAST:event_txcatActionPerformed

    private void txmatprimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txmatprimaActionPerformed
        if(txmatprima.getText().equals("")){
            txmatprima.requestFocus();
        }
        else{
            txmatprima.transferFocus(); 
        } 
    }//GEN-LAST:event_txmatprimaActionPerformed

    private void btsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsalirActionPerformed
        dispose();  
    }//GEN-LAST:event_btsalirActionPerformed

    private void btnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnuevoActionPerformed
        chhab.setSelected(true);
        limpiar();
        desbloquear();
        String setid=Integer.toString(materiasprimas.size()+1);
        txidmatp.setText(setid);
        txidmatp.requestFocus();
    }//GEN-LAST:event_btnuevoActionPerformed

    private void txidmatpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txidmatpKeyTyped
        desbloquearGuardar();
    }//GEN-LAST:event_txidmatpKeyTyped

    private void txcatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txcatKeyTyped
        desbloquearGuardar();
    }//GEN-LAST:event_txcatKeyTyped

    private void txmatprimaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txmatprimaKeyTyped
        desbloquearGuardar();
    }//GEN-LAST:event_txmatprimaKeyTyped

    private void txidmatpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txidmatpKeyReleased
        if(!txidmatp.getText().matches("[0-9--]*")){
            JOptionPane.showMessageDialog(null, "Solo valores numéricos","Advertencia",JOptionPane.ERROR_MESSAGE);
            txidmatp.setText("");
        }
        //desbloquearGuarMod();
    }//GEN-LAST:event_txidmatpKeyReleased

    private void txcatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txcatKeyReleased
        if(!txcat.getText().matches("[0-9--]*")){
            JOptionPane.showMessageDialog(null, "Solo valores numéricos","Advertencia",JOptionPane.ERROR_MESSAGE);
            txcat.setText("");
            
        }
        desbloquearGuardar();
    }//GEN-LAST:event_txcatKeyReleased

    private void txmatprimaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txmatprimaKeyReleased
        /*char c = evt.getKeyChar();
        String aux = txmatprima.getText();
        txmatprima.setText("");
        if(!aux.isEmpty()){
            aux=aux.substring(0,aux.length()-1);
        System.out.println(aux.length()-1);
        aux+=String.valueOf(c).toUpperCase();
        txmatprima.setText(aux);}*/
        desbloquearGuardar();
    }//GEN-LAST:event_txmatprimaKeyReleased

    private void txbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txbuscarActionPerformed
        btbuscar.requestFocus();
    }//GEN-LAST:event_txbuscarActionPerformed

    private void btbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbuscarActionPerformed
        boolean existe=false;
        for(int i=0;i<materiasprimas.size();i++){
           String nombre=txbuscar.getText().toUpperCase();
        if(nombre.equals(materiasprimas.get(i).getnombre())){
            String id=Integer.toString(materiasprimas.get(i).getidmp());
            txidmatp.setText(id);
            txmatprima.setText(materiasprimas.get(i).getnombre());
            String cat=materiasprimas.get(i).getcategoria();
            txcat.setText(cat); 
            if(materiasprimas.get(i).gethabilitado()==0){
            chhab.setSelected(true);
            }
            else if (materiasprimas.get(i).gethabilitado()==1){
            chhab.setSelected(false);         
            }
            
            existe=true;
            btagregar.setEnabled(false);
            desbloquear();
            desbloquearBloMod();
        }
        else if(existe==false && i==materiasprimas.size()-1){
            txbuscar.setText("");
            txbuscar.requestFocus();
            JOptionPane.showMessageDialog(null,"No se encontro ningun registro");
        }       
        }
    }//GEN-LAST:event_btbuscarActionPerformed

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
            java.util.logging.Logger.getLogger(FormMatPrima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMatPrima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMatPrima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMatPrima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormMatPrima dialog = new FormMatPrima(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btagregar;
    private javax.swing.JButton btbloquear;
    private javax.swing.JButton btbuscar;
    private javax.swing.JButton btmodificar;
    private javax.swing.JButton btnuevo;
    private javax.swing.JButton btsalir;
    private javax.swing.JCheckBox chhab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txbuscar;
    private javax.swing.JTextField txcat;
    private javax.swing.JTextField txidmatp;
    private javax.swing.JTextField txmatprima;
    // End of variables declaration//GEN-END:variables
}
