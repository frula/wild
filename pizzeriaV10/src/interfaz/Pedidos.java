 package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import negocio.Celda;
import negocio.CeldaP;
import negocio.Cliente;
import negocio.Itinerario;
import negocio.Pedido;
import negocio.Repartidor;
import datos.Basededatos;
import datos.Pizzeria;

public class Pedidos extends javax.swing.JDialog {
    final DefaultTableModel datostabla = new DefaultTableModel();
    ArrayList<Itinerario>itinerario = Pizzeria.devuelveItinerario();
    ArrayList<Repartidor> repartidor= Pizzeria.devuelveRepartidor();
    
    public Pedidos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        btactualizar.setVisible(false);
        getContentPane().add(jScrollPane1);
        tabla.setModel(datostabla);
        jScrollPane1.setViewportView(tabla);
        datostabla.setDataVector(new Object[][] { }, new Object[] {
         "IdPedido", "Nro Pedido", "Nro cliente", "Fecha","Total","Pagado","Adomicilio","Itinerario","Estado" });
        
        tabla.getColumnModel().getColumn(5).setCellEditor(new Celda());
        tabla.getColumnModel().getColumn(5).setCellRenderer(new CeldaP());
        
        tabla.getColumnModel().getColumn(6).setCellEditor(new Celda());
        tabla.getColumnModel().getColumn(6).setCellRenderer(new CeldaP());
               
        tabla.getColumnModel().getColumn(7).setCellEditor(new Celda());
        tabla.getColumnModel().getColumn(7).setCellRenderer(new CeldaP());
        
        TableColumn estado = tabla.getColumnModel().getColumn(8);
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("No preparado");
        comboBox.addItem("Preparado");
        comboBox.addItem("Entregado");
        TableCellEditor tc =new DefaultCellEditor(comboBox);
        estado.setCellEditor(tc);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            if (tabla.editCellAt(tabla.getSelectedRow(), 6)) {
                                //btguardar.requestFocus();
				}
            if(tabla.isEditing()){
		tabla.getCellEditor().stopCellEditing();
            }
        }
        });    
        
        inicioTabla();

    }
    
    void inicioTabla(){
    	String fecha=(Basededatos.dateToMySQLDate2(new Date()));
        ArrayList<Pedido> pedidofecha=Pizzeria.devuelvepedidofecha(fecha);
            for(int i=0;i<pedidofecha.size();i++){
                if(pedidofecha.get(i).getFechaPedido().equals(fecha)){
                Cliente cliente=Pizzeria.devuelvecliente(pedidofecha.get(i).getIdcliente());
            	 String nombreCliente= cliente.getNombreCliente();
                 datostabla.addRow(new Object[] {
                 pedidofecha.get(i).getIdPedido(),pedidofecha.get(i).getNumeroPedido(),nombreCliente,
                 pedidofecha.get(i).getFechaPedido(),pedidofecha.get(i).getTotalPedido(),
                 pedidofecha.get(i).getpagoconfirmado(),pedidofecha.get(i).getAdomicilio(),false,pedidofecha.get(i).getestado()});
                }
             } 
                                      
    }
    
    void borratabla(){
        int total=datostabla.getRowCount();
        for (int i = total-1; i >= 0; i--) {
             datostabla.removeRow(i); 
            }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btactualizar = new javax.swing.JButton();
        cbpedidos = new javax.swing.JComboBox();
        btguardar = new javax.swing.JButton();
        btcancelar = new javax.swing.JButton();
        salir = new javax.swing.JToggleButton();
        lbguardar = new javax.swing.JLabel();
        btitinerario = new javax.swing.JButton();
        btitinerario.addActionListener(new ActionListener() {
        	@SuppressWarnings("null")
			public void actionPerformed(ActionEvent arg0) {
        		ArrayList<Pedido>pedidosNuevos = new ArrayList<Pedido>();
        		ArrayList<Cliente> clientes=Pizzeria.devuelveClientes();
        		ArrayList <Pedido> pedidos = Pizzeria.devuelvepedidoEstado();
        		
        		 for (int j=0;j<tabla.getRowCount();j++){ 
        			 boolean iti=(Boolean) (tabla.getValueAt(j, 7));
        			 String idtab = (String.valueOf(tabla.getValueAt(j, 0)));
	                if(iti){
	                	for(int p=0;p<pedidos.size();p++){
	               			  String idped = (pedidos.get(p).getIdPedido());
	               			if(idtab.equals(idped)){
		               		  String idpedcli=String.valueOf(pedidos.get(p).getIdcliente());

	               		    for(int i=0;i<clientes.size();i++){
                              String idclie =(String.valueOf(clientes.get(i).getIdCliente()));
	                			  if(idpedcli.equals(idclie)){ 
	                		          int idcliente=clientes.get(i).getIdCliente();
	                		          String nombre =clientes.get(i).getNombreCliente();
	                		          String dni=clientes.get(i).getDni();
	                		          String direccion = clientes.get(i).getDireccion();
	                		          String telefono = clientes.get(i).getTelefono();
	                		          int activo = clientes.get(i).getActivo();
	                		          Cliente cli=new Cliente(idcliente,nombre,dni,direccion,telefono,activo);
	                		          
	                		          String numeropedido=(String.valueOf(pedidos.get(p).getNumeroPedido()));
	                		          String fecha=pedidos.get(p).getFechaPedido();
	                		          double total=pedidos.get(p).getTotalPedido();
	                		          int paga=pedidos.get(p).getintpagoconfirmado();
	                		          int Adom=pedidos.get(p).getintdom();
	                		          String est=pedidos.get(p).getestado();
	                		          
	                		          Pedido ped = new Pedido(idped,numeropedido,cli,fecha,total,paga,Adom,est);
	                		          pedidosNuevos.add(ped);
	                	}}}}
	                	}}
        		 
        		 for(int i=0;i<pedidosNuevos.size();i++){
        			 //int id=itinerario.size()+1;
        			 String fecha=(Basededatos.dateToMySQLDate2(new Date()));
        			 String idP=pedidosNuevos.get(i).getIdPedido();
        			 int idR=(int)(Math.random()*((repartidor.size()+1)-1))+1;
        			 //System.out.println(idR);
        			 Pizzeria.agregarItinerario(idR,idP,fecha);
        		 }
        		 
        	}
        });
        btitinerario.setVisible(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseReleased(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Pagado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        btactualizar.setText("Actualizar");
        btactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btactualizarActionPerformed(evt);
            }
        });

        cbpedidos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Pedidos--", "Todos", "No pagado", "No preparado", "No pagado ni preparado", "Envios a domicilio" }));
        cbpedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbpedidosActionPerformed(evt);
            }
        });

        btguardar.setText("Guardar");
        btguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btguardarActionPerformed(evt);
            }
        });

        btcancelar.setText("Cancelar");
        btcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcancelarActionPerformed(evt);
            }
        });

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        btitinerario.setText("Imprimir itinerario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btactualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 476, Short.MAX_VALUE)
                .addComponent(lbguardar)
                .addGap(294, 294, 294)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbpedidos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btcancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btitinerario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbpedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128)
                        .addComponent(btguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btitinerario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btactualizar)
                        .addComponent(salir))
                    .addComponent(lbguardar, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btactualizarActionPerformed
        ArrayList <Pedido> pedidos = Pizzeria.devuelvepedido();
        for(int i=0;i<pedidos.size();i++){
            datostabla.addRow(new Object[] {
            pedidos.get(i).getIdPedido(),pedidos.get(i).getNumeroPedido(),pedidos.get(i).getIdcliente(),
            pedidos.get(i).getFechaPedido(),pedidos.get(i).getTotalPedido(),
            null,null});
        }
    }//GEN-LAST:event_btactualizarActionPerformed

    private void cbpedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbpedidosActionPerformed
            ArrayList <Pedido> pedidos = Pizzeria.devuelvepedidoEstado();
            String elegido=cbpedidos.getSelectedItem().toString();
            borratabla();
            
            if(elegido.equals("--Pedidos--")){
        		String fecha=(Basededatos.dateToMySQLDate2(new Date()));
                ArrayList<Pedido> pedidofecha=Pizzeria.devuelvepedidofecha(fecha);
                for(int i=0;i<pedidofecha.size();i++){
                    if(pedidofecha.get(i).getFechaPedido().equals(fecha)){
                    Cliente cliente=Pizzeria.devuelvecliente(pedidos.get(i).getIdcliente());
                	String nombreCliente= cliente.getNombreCliente();
                     datostabla.addRow(new Object[] {
                     pedidofecha.get(i).getIdPedido(),pedidofecha.get(i).getNumeroPedido(),nombreCliente,
                     pedidofecha.get(i).getFechaPedido(),pedidofecha.get(i).getTotalPedido(),
                     pedidofecha.get(i).getpagoconfirmado(),pedidofecha.get(i).getAdomicilio(),false,pedidofecha.get(i).getestado()});
                    }
                 } 
             }
            
            else if(elegido.equals("Todos")){
              //borratabla();
              for(int i=0;i<pedidos.size();i++){
            	    Cliente cliente=Pizzeria.devuelvecliente(pedidos.get(i).getIdcliente());
            	    String nombreCliente= cliente.getNombreCliente();
                    datostabla.addRow(new Object[] {
                    pedidos.get(i).getIdPedido(),pedidos.get(i).getNumeroPedido(),nombreCliente,
                    pedidos.get(i).getFechaPedido(),pedidos.get(i).getTotalPedido(),
                    pedidos.get(i).getpagoconfirmado(),pedidos.get(i).getAdomicilio(),false,pedidos.get(i).getestado()});
            }  
            }
            else if(elegido.equals("No pagado")){
               //borratabla();
               for(int i=0;i<pedidos.size();i++){
                   if(pedidos.get(i).getpagoconfirmado()==false){
                	Cliente cliente=Pizzeria.devuelvecliente(pedidos.get(i).getIdcliente());
               	    String nombreCliente= cliente.getNombreCliente();
                	   datostabla.addRow(new Object[] {
                    pedidos.get(i).getIdPedido(),pedidos.get(i).getNumeroPedido(),nombreCliente,
                    pedidos.get(i).getFechaPedido(),pedidos.get(i).getTotalPedido(),
                    pedidos.get(i).getpagoconfirmado(),pedidos.get(i).getAdomicilio(),false,pedidos.get(i).getestado()});
                   }
            }
            }
            else if(elegido.equals("No preparado")){
                //borratabla();
                for(int i=0;i<pedidos.size();i++){
                	System.out.println(pedidos.get(i).getestado().equals("null"));
                   if(pedidos.get(i).getestado().equals("null")
                		   ||pedidos.get(i).getestado().equals("No preparado")){
                	Cliente cliente=Pizzeria.devuelvecliente(pedidos.get(i).getIdcliente());
               	    String nombreCliente= cliente.getNombreCliente();
                    datostabla.addRow(new Object[] {
                    pedidos.get(i).getIdPedido(),pedidos.get(i).getNumeroPedido(),nombreCliente,
                    pedidos.get(i).getFechaPedido(),pedidos.get(i).getTotalPedido(),
                    pedidos.get(i).getpagoconfirmado(),pedidos.get(i).getAdomicilio(),false,pedidos.get(i).getestado()});
                   }
                }      
            }
            else if(elegido.equals("No pagado ni preparado")){
                //borratabla();
                for(int i=0;i<pedidos.size();i++){
                   if((pedidos.get(i).getestado().equals(null) || pedidos.get(i).getestado().equals("null")
                		   || pedidos.get(i).getestado().equals("No preparado"))){
                	   //if(pedidos.get(i).getpagoconfirmado()==false){
                	   Cliente cliente=Pizzeria.devuelvecliente(pedidos.get(i).getIdcliente());
               	    String nombreCliente= cliente.getNombreCliente();
                    datostabla.addRow(new Object[] {
                    pedidos.get(i).getIdPedido(),pedidos.get(i).getNumeroPedido(),nombreCliente,
                    pedidos.get(i).getFechaPedido(),pedidos.get(i).getTotalPedido(),
                    pedidos.get(i).getpagoconfirmado(),pedidos.get(i).getAdomicilio(),false,pedidos.get(i).getestado()});
                   }//}
                } 
            }
            
            else if(elegido.equals("Envios a domicilio")){
               for(int i=0;i<pedidos.size();i++){
                   if(pedidos.get(i).getAdomicilio()==true){
                	Cliente cliente=Pizzeria.devuelvecliente(pedidos.get(i).getIdcliente());
               	    String nombreCliente= cliente.getNombreCliente();
                    datostabla.addRow(new Object[] {
                    pedidos.get(i).getIdPedido(),pedidos.get(i).getNumeroPedido(),nombreCliente,
                    pedidos.get(i).getFechaPedido(),pedidos.get(i).getTotalPedido(),
                    pedidos.get(i).getpagoconfirmado(),pedidos.get(i).getAdomicilio(),false,pedidos.get(i).getestado()});
                   }
                } 
            }
            
            
    }//GEN-LAST:event_cbpedidosActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void btcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btcancelarActionPerformed

    private void btguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btguardarActionPerformed
        btguardar.requestFocus();
        for(int i=0;i<datostabla.getRowCount();i++){
               int id=Integer.valueOf(String.valueOf(tabla.getValueAt(i, 0)));
               int pa;
               int dc;
               boolean pagadoseleccion=((Boolean) tabla.getValueAt(i,5)).booleanValue();
               boolean Adomicilio=((Boolean) tabla.getValueAt(i,6)).booleanValue();
               String estado=String.valueOf(tabla.getValueAt(i,8));

               if(pagadoseleccion==false){pa=0;}
               else{pa=1;}
              
               
               if(Adomicilio==false){dc=0;}
               else{dc=1;}
               
               Pizzeria.modificarpedido(id, pa, dc,estado);
        }
    }//GEN-LAST:event_btguardarActionPerformed

    private void jScrollPane1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseReleased

    private void tablaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaMouseReleased

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
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Pedidos dialog = new Pedidos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btactualizar;
    private javax.swing.JButton btcancelar;
    private javax.swing.JButton btguardar;
    private javax.swing.JComboBox cbpedidos;
    private javax.swing.JButton btitinerario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbguardar;
    private javax.swing.JToggleButton salir;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
