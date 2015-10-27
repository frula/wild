package interfaz;

import com.mxrck.autocompleter.TextAutoCompleter;
import datos.Pizzeria;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import negocio.Cliente;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ABMcliente extends javax.swing.JFrame {

    ArrayList <Cliente> clientes= Pizzeria.devuelveClientes();
    int id=clientes.size()+1;
    public ABMcliente() {
        setResizable(false);
        initComponents();
        inicio();
        
        final TextAutoCompleter busqueda = new TextAutoCompleter(txbuscar);
		for (int i = 0; i < Pizzeria.devuelveClientes().size(); i++) {

			busqueda.addItem(clientes.get(i).getNombreCliente());
		}
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
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
        checkhab = new javax.swing.JCheckBox();
        btnuevo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setName("panel"); // NOI18N

        jLabel1.setFont(new java.awt.Font("MV Boli", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cliente");

     
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

        txbuscar.setText("Ingrese nombre de cliente");
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
        txdni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txdniKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txdniKeyTyped(evt);
            }
        });

        lbnombre.setText("Nombre:");

        txnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txnombreActionPerformed(evt);
            }
        });
        txnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txnombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txnombreKeyTyped(evt);
            }
        });

        lbdir.setText("Direccion:");

        lbtel.setText("Telefono:");

        txdir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txdirActionPerformed(evt);
            }
        });
        txdir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txdirKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txdirKeyTyped(evt);
            }
        });

        txtel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtelActionPerformed(evt);
            }
        });
        txtel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtelKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtelKeyTyped(evt);
            }
        });

        btsalir.setText("Salir");
        btsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsalirActionPerformed(evt);
            }
        });


        btagregar.setText("Agregar");
        btagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btagregarActionPerformed(evt);
            }
        });


        btbloquear.setText("Bloqueo/Desbloqueo");
        btbloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbloquearActionPerformed(evt);
            }
        });

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

        btnuevo.setText("Nuevo");
        btnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(checkhab))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(37)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(btnuevo, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(btagregar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btbloquear, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(btmod)
        					.addPreferredGap(ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
        					.addComponent(btsalir, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(txbuscar, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btbuscar)
        					.addGap(0, 4, Short.MAX_VALUE)))
        			.addContainerGap())
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(lbtel)
        				.addComponent(lbdni)
        				.addComponent(lbnombre)
        				.addComponent(lbdir))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(txdir, 294, 294, 294)
        				.addComponent(txtel, Alignment.LEADING, 294, 294, 294)
        				.addComponent(txdni, 294, 294, 294)
        				.addComponent(txnombre, Alignment.LEADING, 294, 294, 294))
        			.addGap(170))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(btbuscar)
        					.addComponent(txbuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addComponent(checkhab))
        			.addGap(35)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(lbdni)
        				.addComponent(txdni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txnombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbnombre))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lbdir)
        				.addComponent(txdir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lbtel)
        				.addComponent(txtel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(37)
        			.addComponent(btnuevo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    }// </editor-fold>                        

    void inicio(){
        checkhab.setEnabled(false);
        checkhab.setSelected(true);
        btagregar.setEnabled(false);
        btbloquear.setEnabled(false);
        btmod.setEnabled(false);
    }
    
    void actualizar(){
 	   this.clientes=Pizzeria.devuelveClientes();
    }
    
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
    
    private void txbuscarActionPerformed(java.awt.event.ActionEvent evt) {                                         

    }                                        

    private void txdniActionPerformed(java.awt.event.ActionEvent evt) {                                      
        if(txdni.getText().equals("")){
            txdni.requestFocus();
        }
        else{
            txdni.transferFocus(); 
        }
    }                                     

    private void txtelActionPerformed(java.awt.event.ActionEvent evt) {                                      
        if(txtel.getText().equals("")){
            txtel.requestFocus();
        }
        else{
            txtel.transferFocus(); 
        }
    }                                     

    private void btsalirActionPerformed(java.awt.event.ActionEvent evt) {                                        
        dispose();        
    }                                       

    private void btagregarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        int es;
        if(checkhab.isSelected()){es=1;}
        else{es=0;}
        String dni=txdni.getText();
        String tel=txtel.getText();
        id=id++;
        //System.out.println(id);
        Cliente cli = new Cliente(id,txnombre.getText().toUpperCase(),dni,txdir.getText(),tel,es);
        Pizzeria.AgregarCliente(cli);
        actualizar();
    }                                         

    private void btbloquearActionPerformed(java.awt.event.ActionEvent evt) {                                           
        int act;
        if(checkhab.isSelected()){act=0; checkhab.setSelected(false);}
        else{act=1; checkhab.setSelected(true);}
        
        int dni=Integer.parseInt(txdni.getText());
        Pizzeria.bloquearcliente(act,dni );
    }                                          

    private void btmodActionPerformed(java.awt.event.ActionEvent evt) {                                      
        int dni=Integer.parseInt(txdni.getText());
        int tel=Integer.parseInt(txtel.getText());
        Pizzeria.modificarcliente(dni,txnombre.getText(),txdir.getText(),tel);
    }                                     

    private void txnombreActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if(txnombre.getText().equals("")){
            txnombre.requestFocus();
        }
        else{
            txnombre.transferFocus(); 
        }
    }                                        

    private void txdirActionPerformed(java.awt.event.ActionEvent evt) {                                      
        if(txdir.getText().equals("")){
            txdir.requestFocus();
        }
        else{
            txdir.transferFocus(); 
        }
    }                                     

    private void checkhabActionPerformed(java.awt.event.ActionEvent evt) {                                         
    }                                        

    private void btbuscarActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if(txbuscar.getText().equals("")==false&&txbuscar.getText().equals(null)==false){
        String busqueda = txbuscar.getText().toUpperCase();
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
        btagregar.setEnabled(false);
        txdni.setEnabled(false);
        }
    }                                        

    private void btnuevoActionPerformed(java.awt.event.ActionEvent evt) {                                        
            txdir.setText("");
            checkhab.setSelected(true);
            txdni.setEnabled(true);
            txdni.setText("");
            txnombre.setText("");
            txtel.setText("");
            btbloquear.setEnabled(false);
            btmod.setEnabled(false);
            btagregar.setEnabled(false);
            // TODO add your handling code here:
    }                                       

    private void txdniKeyReleased(java.awt.event.KeyEvent evt) {                                  
        if(!txdni.getText().matches("[0-9--]*")){
            JOptionPane.showMessageDialog(null, "Solo valores numéricos","Advertencia",JOptionPane.ERROR_MESSAGE);
            txdni.setText("");
        }        // TODO add your handling code here:
    }                                 

    private void txtelKeyReleased(java.awt.event.KeyEvent evt) {                                  
        if(!txtel.getText().matches("[0-9--]*")){
            JOptionPane.showMessageDialog(null, "Solo valores numéricos","Advertencia",JOptionPane.ERROR_MESSAGE);
            txtel.setText("");
        }        // TODO add your handling code here:
    }                                 

    private void txdniKeyTyped(java.awt.event.KeyEvent evt) {                               
         desbloquearGuardar();
    }                              

    private void txnombreKeyTyped(java.awt.event.KeyEvent evt) {                                  
        desbloquearGuardar();// TODO add your handling code here:
    }                                 

    private void txdirKeyTyped(java.awt.event.KeyEvent evt) {                               
        desbloquearGuardar();// TODO add your handling code here:
    }                              

    private void txtelKeyTyped(java.awt.event.KeyEvent evt) {                               
        desbloquearGuardar();// TODO add your handling code here:
    }                              

    private void txnombreKeyReleased(java.awt.event.KeyEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    private void txdirKeyReleased(java.awt.event.KeyEvent evt) {                                  
        // TODO add your handling code here:
    }                                 

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
                ABMcliente dialog = new ABMcliente();
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

    // Variables declaration - do not modify                     
    private javax.swing.JButton btagregar;
    private javax.swing.JButton btbloquear;
    private javax.swing.JButton btbuscar;
    private javax.swing.JButton btmod;
    private javax.swing.JButton btnuevo;
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
    // End of variables declaration                   
}
