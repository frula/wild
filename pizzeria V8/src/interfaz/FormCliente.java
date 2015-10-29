package interfaz;

import java.util.ArrayList;

import com.mxrck.autocompleter.TextAutoCompleter;

import datos.Pizzeria;
import negocio.Cliente;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FormCliente extends javax.swing.JDialog {
	
	ArrayList <Cliente> clientes= Pizzeria.devuelveClientes();
    int id=clientes.size()+1;
    
    public FormCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //inicio();
        
        /*final TextAutoCompleter busqueda = new TextAutoCompleter(txbuscar);
		for (int i = 0; i < Pizzeria.devuelveClientes().size(); i++) {

			busqueda.addItem(Pizzeria.devuelveClientes().get(i).getNombreCliente());
		}*/
		
    }
    
    /*void inicio(){
        checkhab.setEnabled(false);
        checkhab.setSelected(true);
        btagregar.setEnabled(false);
        btbloquear.setEnabled(false);
        btmod.setEnabled(false);
    }*/
    
    void desbloquearGuardar(){
        boolean desbloqueo=true;
        if(txdni.getText().equals("")){
            desbloqueo=false;}
        else if(txtel.getText().equals("")){
            desbloqueo=false;}
        else if(txdir.getText().equals("")){
            desbloqueo=false;}
        else if(txnombre.getText().equals("")){
            desbloqueo=false;
        }
        else if(btbloquear.isEnabled()==true || btmod.isEnabled()==true){
            desbloqueo=false;
        }
        else{
            desbloqueo=true;}
        btagregar.setEnabled(desbloqueo);
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
        txdni.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyReleased(KeyEvent arg0) {
        		if(!txdni.getText().matches("[0-9--]*")){
                    JOptionPane.showMessageDialog(null, "Solo valores numéricos","Advertencia",JOptionPane.ERROR_MESSAGE);
                    txdni.setText("");
        		}
        	}
        	@Override
        	public void keyTyped(KeyEvent arg0) {
        		desbloquearGuardar();
        	}
        });
        lbnombre = new javax.swing.JLabel();
        txnombre = new javax.swing.JTextField();
        txnombre.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyReleased(KeyEvent arg0) {
        	}
        	@Override
        	public void keyTyped(KeyEvent arg0) {
        		desbloquearGuardar();
        	}
        });
        lbdir = new javax.swing.JLabel();
        lbtel = new javax.swing.JLabel();
        txdir = new javax.swing.JTextField();
        txdir.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyReleased(KeyEvent arg0) {
        	}
        	@Override
        	public void keyTyped(KeyEvent arg0) {
        		desbloquearGuardar();
        	}
        });
        txtel = new javax.swing.JTextField();
        txtel.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyReleased(KeyEvent arg0) {
        		if(!txtel.getText().matches("[0-9--]*")){
                    JOptionPane.showMessageDialog(null, "Solo valores numéricos","Advertencia",JOptionPane.ERROR_MESSAGE);
                    txtel.setText("");
        		}
        	}
        	@Override
        	public void keyTyped(KeyEvent arg0) {
        		desbloquearGuardar();
        	}
        });
        btsalir = new javax.swing.JButton();
        btagregar = new javax.swing.JButton();
        btbloquear = new javax.swing.JButton();
        btmod = new javax.swing.JButton();
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

        checkhab.setText("Habilitado");
        checkhab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkhabActionPerformed(evt);
            }
        });
        
        JButton btnuevo = new JButton("Nuevo");
        btnuevo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		txdir.setText("");
                checkhab.setSelected(true);
                txdni.setEnabled(true);
                txdni.setText("");
                txnombre.setText("");
                txtel.setText("");
                btbloquear.setEnabled(false);
                btmod.setEnabled(false);
                btagregar.setEnabled(false);
        	}
        });

       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(lbdni)
        								.addComponent(lbnombre)
        								.addComponent(lbdir)
        								.addComponent(lbtel))
        							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        								.addComponent(txdir)
        								.addComponent(txdni)
        								.addComponent(txnombre)
        								.addComponent(txtel, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)))
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        								.addComponent(btnuevo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(btagregar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(btbloquear)))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btmod))
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(checkhab)
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(txbuscar, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)))
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        					.addGroup(layout.createSequentialGroup()
        						.addGap(-2147483648)
        						.addContainerGap(178, Short.MAX_VALUE))
        					.addGroup(layout.createSequentialGroup()
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addComponent(btsalir, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
        						.addContainerGap()))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(130)
        					.addComponent(btbuscar)
        					.addContainerGap())))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(checkhab)
        				.addComponent(txbuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btbuscar))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lbdni)
        				.addComponent(txdni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lbnombre)
        				.addComponent(txnombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(txdir, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbdir))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lbtel)
        				.addComponent(txtel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
        			.addComponent(btnuevo)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btagregar)
        				.addComponent(btbloquear)
        				.addComponent(btmod)
        				.addComponent(btsalir, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        jPanel1.getAccessibleContext().setAccessibleName("panel");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txbuscarActionPerformed
    	
    }//GEN-LAST:event_txbuscarActionPerformed

    private void txdniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txdniActionPerformed
    	if(txdni.getText().equals("")){
            txdni.requestFocus();
        }
        else{
            txdni.transferFocus(); 
        }
    }//GEN-LAST:event_txdniActionPerformed

    private void txtelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtelActionPerformed
    	if(txtel.getText().equals("")){
            txtel.requestFocus();
        }
        else{
            txtel.transferFocus(); 
        }
    }//GEN-LAST:event_txtelActionPerformed

    private void btsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsalirActionPerformed
        dispose();        
    }//GEN-LAST:event_btsalirActionPerformed

    private void btagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btagregarActionPerformed
    	int es;
        if(checkhab.isSelected()){es=1;}
        else{es=0;}
        String dni=txdni.getText();
        String tel=txtel.getText();
        id=id++;
        System.out.println(id);
        Cliente cli = new Cliente(id,txnombre.getText(),dni,txdir.getText(),tel,es);
        Pizzeria.AgregarCliente(cli);
    }//GEN-LAST:event_btagregarActionPerformed

    private void btbloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbloquearActionPerformed
    	int act;
        if(checkhab.isSelected()){act=0; checkhab.setSelected(false);}
        else{act=1; checkhab.setSelected(true);}
        
        int dni=Integer.parseInt(txdni.getText());
        Pizzeria.bloquearcliente(act,dni);
    }//GEN-LAST:event_btbloquearActionPerformed

    private void btmodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmodActionPerformed
    	int dni=Integer.parseInt(txdni.getText());
        int tel=Integer.parseInt(txtel.getText());
        Pizzeria.modificarcliente(dni,txnombre.getText(),txdir.getText(),tel);
    }//GEN-LAST:event_btmodActionPerformed

    private void txnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txnombreActionPerformed
    	if(txnombre.getText().equals("")){
            txnombre.requestFocus();
        }
        else{
            txnombre.transferFocus(); 
        }
    }//GEN-LAST:event_txnombreActionPerformed

    private void txdirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txdirActionPerformed
    	if(txdir.getText().equals("")){
            txdir.requestFocus();
        }
        else{
            txdir.transferFocus(); 
        }
    }//GEN-LAST:event_txdirActionPerformed

    private void checkhabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkhabActionPerformed
    }//GEN-LAST:event_checkhabActionPerformed

    private void btbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbuscarActionPerformed
    	if(txbuscar.getText().equals("")==false&&txbuscar.getText().equals(null)==false){
            String busqueda = txbuscar.getText();
            for(int i=0;i<clientes.size();i++){
                if(busqueda.equals(clientes.get(i).getNombreCliente())){
                    txdni.setText(String.valueOf(clientes.get(i).getDni()));
                    txdir.setText(clientes.get(i).getDireccion());
                    txtel.setText(String.valueOf(clientes.get(i).getTelefono()));
                    txnombre.setText(clientes.get(i).getNombreCliente());
                    if(clientes.get(i).getActivo()==1){checkhab.setSelected(true);}
                    else{checkhab.setSelected(false);}
                }
            }
            btbloquear.setEnabled(true);
            btmod.setEnabled(true);
            txdni.setEnabled(false);
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
    private javax.swing.JLabel lbdir;
    private javax.swing.JLabel lbdni;
    private javax.swing.JLabel lbnombre;
    private javax.swing.JLabel lbtel;
    private javax.swing.JTextField txbuscar;
    private javax.swing.JTextField txdir;
    private javax.swing.JTextField txdni;
    private javax.swing.JTextField txnombre;
    private javax.swing.JTextField txtel;
}
