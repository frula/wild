package interfaz;

import negocio.Cliente;

public class FormCliente extends javax.swing.JDialog {

    public FormCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btbuscar = new javax.swing.JButton();
        txbuscar = new javax.swing.JTextField();
        lbdni = new javax.swing.JLabel();
        txdni = new javax.swing.JTextField();
        lbnombre = new javax.swing.JLabel();
        txnombre = new javax.swing.JTextField();
        lbdir = new javax.swing.JLabel();
        lbtel = new javax.swing.JLabel();
        txdir = new javax.swing.JTextField();
        txtel = new javax.swing.JTextField();
        btsalir = new javax.swing.JButton();
        btagregar = new javax.swing.JButton();
        btbloquear = new javax.swing.JButton();
        btmod = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablacli = new javax.swing.JTable();
        checkhab = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setName("panel"); // NOI18N

        jLabel1.setFont(new java.awt.Font("MV Boli", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cliente");

        //jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/verde-usuario-icono-8942-32.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(jLabel1))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btbuscar.setText("Buscar");
        btbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbuscarActionPerformed(evt);
            }
        });

        txbuscar.setText("Ingrese DNI");
        txbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txbuscarActionPerformed(evt);
            }
        });

        lbdni.setText("DNI:");

        txdni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txdniActionPerformed(evt);
            }
        });

        lbnombre.setText("Nombre:");

        txnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txnombreActionPerformed(evt);
            }
        });

        lbdir.setText("Direccion:");

        lbtel.setText("Telefono:");

        txdir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txdirActionPerformed(evt);
            }
        });

        txtel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtelActionPerformed(evt);
            }
        });

        btsalir.setText("Salir");
        btsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsalirActionPerformed(evt);
            }
        });

        //btagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user-add-icone-8041-32.png"))); // NOI18N
        btagregar.setText("Agregar");
        btagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btagregarActionPerformed(evt);
            }
        });

        //btbloquear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/remove-user-icone-9632-32.png"))); // NOI18N
        btbloquear.setText("Bloquear");
        btbloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbloquearActionPerformed(evt);
            }
        });

        //btmod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vcard-edit-icone-8358-32.png"))); // NOI18N
        btmod.setText("Modificar");
        btmod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmodActionPerformed(evt);
            }
        });

        tablacli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablacli);

        checkhab.setText("Habilitado");
        checkhab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkhabActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkhab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btbuscar)
                .addGap(8, 8, 8))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btagregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btbloquear))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbdni)
                            .addComponent(lbnombre)
                            .addComponent(lbdir)
                            .addComponent(lbtel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txdir)
                            .addComponent(txdni)
                            .addComponent(txnombre)
                            .addComponent(txtel, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btmod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btbuscar)
                        .addComponent(txbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(checkhab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbdni)
                            .addComponent(txdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbnombre)
                            .addComponent(txnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txdir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbdir))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbtel)
                            .addComponent(txtel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 96, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btagregar)
                    .addComponent(btbloquear)
                    .addComponent(btmod)
                    .addComponent(btsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("panel");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txbuscarActionPerformed
    }//GEN-LAST:event_txbuscarActionPerformed

    private void txdniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txdniActionPerformed
    }//GEN-LAST:event_txdniActionPerformed

    private void txtelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtelActionPerformed
    }//GEN-LAST:event_txtelActionPerformed

    private void btsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsalirActionPerformed
        dispose();        
    }//GEN-LAST:event_btsalirActionPerformed

    private void btagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btagregarActionPerformed
        int es;
        if(checkhab.isSelected()){
           es=0; 
        }
        else{
            es=1;
        }
        System.out.println("SOY Hab"+es);
        int dni=Integer.parseInt(txdni.getText());
        int tel=Integer.parseInt(txtel.getText());
        Cliente.AgregarCliente(txnombre.getText(),dni,txdir.getText(),tel,es);
    }//GEN-LAST:event_btagregarActionPerformed

    private void btbloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbloquearActionPerformed
    }//GEN-LAST:event_btbloquearActionPerformed

    private void btmodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmodActionPerformed
    }//GEN-LAST:event_btmodActionPerformed

    private void txnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txnombreActionPerformed
    }//GEN-LAST:event_txnombreActionPerformed

    private void txdirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txdirActionPerformed
    }//GEN-LAST:event_txdirActionPerformed

    private void checkhabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkhabActionPerformed
    }//GEN-LAST:event_checkhabActionPerformed

    private void btbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbuscarActionPerformed
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
            java.util.logging.Logger.getLogger(FormCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormCliente dialog = new FormCliente(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btmod;
    private javax.swing.JButton btsalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox checkhab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbdir;
    private javax.swing.JLabel lbdni;
    private javax.swing.JLabel lbnombre;
    private javax.swing.JLabel lbtel;
    private javax.swing.JTable tablacli;
    private javax.swing.JTextField txbuscar;
    private javax.swing.JTextField txdir;
    private javax.swing.JTextField txdni;
    private javax.swing.JTextField txnombre;
    private javax.swing.JTextField txtel;
    // End of variables declaration//GEN-END:variables
}
