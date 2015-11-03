/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import negocio.Categoria;
import negocio.MateriaPrima;

import com.mxrck.autocompleter.TextAutoCompleter;

import datos.Pizzeria;

public class FormMatPrima extends javax.swing.JDialog {
    ArrayList <MateriaPrima> materiasprimas = Pizzeria.devuelveMateriaPrima();
    
    public FormMatPrima(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        limpiar();
        bloquear();
        iniciocombobox();
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btsalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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
        txbuscar.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent arg0) {
        		final TextAutoCompleter busqueda = new TextAutoCompleter(txbuscar);
        		for (int i = 0; i < Pizzeria.devuelveMateriaPrima().size(); i++) {

        			busqueda.addItem(materiasprimas.get(i).getnombre());
        		}
        	}
        });

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
        
        cbcat = new JComboBox();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel2)
        						.addComponent(jLabel4)
        						.addComponent(jLabel3))
        					.addGap(30)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(txidmatp, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
        						.addComponent(txmatprima, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
        						.addComponent(cbcat, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(btnuevo)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btagregar)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btbloquear)))
        			.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
        			.addComponent(btmodificar)
        			.addGap(24))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(10)
        			.addComponent(chhab)
        			.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
        			.addComponent(txbuscar, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btbuscar))
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(369, Short.MAX_VALUE)
        			.addComponent(btsalir))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btbuscar)
        				.addComponent(txbuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(chhab))
        			.addGap(47)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel4)
        				.addComponent(txidmatp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(cbcat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txmatprima, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel3))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btmodificar)
        				.addComponent(btbloquear)
        				.addComponent(btagregar)
        				.addComponent(btnuevo))
        			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(btsalir))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void limpiar (){
       txidmatp.setText("");
       txmatprima.setText("");
    }
    
    void iniciocombobox(){
    	ArrayList<Categoria> categoria=Pizzeria.devuelveCategoria();
    	for(int i=0;i<categoria.size();i++){
    		cbcat.addItem(categoria.get(i).getnombre());
    	}
    }
    
    void bloquear(){
       txidmatp.setEnabled(false);
       txmatprima.setEnabled(false);
       
       btnuevo.setEnabled(true);
       btagregar.setEnabled(false);
       btbloquear.setEnabled(false);
       btmodificar.setEnabled(false);
       chhab.setEnabled(false);
    }
    
       void desbloquear(){
       txidmatp.setEnabled(false);
      // txcat.setEnabled(true);
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
         if(es==0){chhab.setSelected(false);}
         else if(es==1){chhab.setSelected(true);}
       }
       
       void actualizar(){
    	   this.materiasprimas=Pizzeria.devuelveMateriaPrima();
       }
    
    private void btagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btagregarActionPerformed
    	ArrayList <Categoria> categoria = Pizzeria.devuelveCategoria();
    	
        //0=EstaMarcado 1=NOestaMarcado
        int es;
        if(chhab.isSelected()){
           es=1; 
        }
        else{
            es=0;
        }
        String nombre=txmatprima.getText().toUpperCase();
        int id=Integer.parseInt(txidmatp.getText());
        int cat = 0;
        String cateselec=(String) cbcat.getSelectedItem();
        //String cat=txcat.getText();
        for(int i=0;i<categoria.size();i++){
        	if(cateselec.equals(categoria.get(i).getnombre())){
        		cat=categoria.get(i).getid();
        	}
        }
        Pizzeria.agregarmatprima(id,nombre,cat,es);
        bloquear();
        actualizar();
    }//GEN-LAST:event_btagregarActionPerformed

    private void btbloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbloquearActionPerformed
        int id=Integer.parseInt(txidmatp.getText());
        int es;
        if(chhab.isSelected()){
           es=0; 
        }
        else{
            es=1;
        }
        Pizzeria.bloquarDesbloquearMatprima(id, es);
        desbloquearBloqHab(es);
        actualizar();
    }//GEN-LAST:event_btbloquearActionPerformed

	private void btmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmodificarActionPerformed
    	ArrayList <Categoria> categoria = Pizzeria.devuelveCategoria();
        String nombre=txmatprima.getText().toUpperCase();
        int id=Integer.parseInt(txidmatp.getText());
        int cat = 0;
        for(int i=0;i<categoria.size();i++){
        	if(cbcat.getSelectedItem().equals(categoria.get(i).getnombre())){
        		cat=categoria.get(i).getid();
        	}
        }
        
        Pizzeria.modificarmatprima(id, nombre,cat);      
        actualizar();
    }//GEN-LAST:event_btmodificarActionPerformed

    private void txidmatpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txidmatpActionPerformed
        if(txidmatp.getText().equals("")){
            txidmatp.requestFocus();
        }
        else{
            txidmatp.transferFocus(); 
        }
    }//GEN-LAST:event_txidmatpActionPerformed

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
    	ArrayList<Categoria> categoria = Pizzeria.devuelveCategoria();
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
    	ArrayList <Categoria>categoria=Pizzeria.devuelveCategoria();
        String nombre=txbuscar.getText().toUpperCase();

        boolean existe=false;
        for(int i=0;i<materiasprimas.size();i++){
        if(nombre.equals(materiasprimas.get(i).getnombre())){
            String id=Integer.toString(materiasprimas.get(i).getidmp());
            txidmatp.setText(id);
            txmatprima.setText(materiasprimas.get(i).getnombre());
            int cat=Integer.valueOf(materiasprimas.get(i).getcategoria());
            //txcat.setText(cat); 
            if(materiasprimas.get(i).gethabilitado()==1){
            chhab.setSelected(true);
            }
            else if (materiasprimas.get(i).gethabilitado()==0){
            chhab.setSelected(false);         
            }
            
            for(int j=0;j<categoria.size();j++){
            	if(cat==categoria.get(j).getid()){
            		cbcat.setSelectedItem(categoria.get(j).getnombre());
            	}
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
    private javax.swing.JTextField txidmatp;
    private javax.swing.JTextField txmatprima;
    private JComboBox cbcat;
}
