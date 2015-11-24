 package datos;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import negocio.Celda;
import negocio.CeldaP;
import negocio.Cliente;
import negocio.Itinerario;
import negocio.Pedido;
import negocio.Repartidor;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;

public class Pedidos extends javax.swing.JDialog implements ActionListener{
    final DefaultTableModel datostabla = new DefaultTableModel();
    ArrayList<Itinerario>itinerario = Pizzeria.devuelveItinerario();
    ArrayList<Repartidor> repartidor= Pizzeria.devuelveRepartidor();
	private JComboBox comboCheck;
	private String estadoActual;
    
    public Pedidos(java.awt.Frame parent, boolean modal) {
        //super(parent, modal);
    	this.setDefaultCloseOperation(0);
    	initComponents();
        getContentPane().add(jScrollPane1);
        tabla.setModel(datostabla);
        jScrollPane1.setViewportView(tabla);
        datostabla.setDataVector(new Object[][] { }, new Object[] {
         "IdPedido", "Nro Pedido", "Nro cliente", "Fecha","Total","Pagado","Adomicilio","Estado"});

               
        TableColumn pagado = tabla.getColumnModel().getColumn(5);
        comboCheck = new JComboBox();
        comboCheck.addItem("SI");
        comboCheck.addItem("NO");
        
        TableCellEditor tc2 =new DefaultCellEditor(comboCheck);
        pagado.setCellEditor(tc2);
        
        TableColumn Adom = tabla.getColumnModel().getColumn(6);
        TableCellEditor tc3 =new DefaultCellEditor(comboCheck);
        Adom.setCellEditor(tc3);
        
        TableColumn estado = tabla.getColumnModel().getColumn(7);
        comboEstado = new JComboBox();
        comboEstado.addItem("Preparando");
        comboEstado.addItem("Preparado");
        //comboEstado.addItem("En viaje");
        comboEstado.addItem("Entregado");
        comboEstado.addItem("Cancelado");
        
        TableCellEditor tc =new DefaultCellEditor(comboEstado);
        estado.setCellEditor(tc);
  
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);

        tabla.getColumnModel().getColumn(0).setMinWidth(0);

        tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        tabla.getColumnModel().getColumn(1).setPreferredWidth(25);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(35);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(25);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(15);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(15);
        tabla.getColumnModel().getColumn(7).setPreferredWidth(35);
        inicioTabla();
        // Capturo el evento del cambio en la tabla
        
        tabla.getModel().addTableModelListener(new TableModelListener() {
      
     			public void tableChanged(TableModelEvent evt) {
     				
     				if(tabla.isEditing()){
     		
     					//actualizo aDomicilio
     			
                        
     					actualizaADomicilio(String.valueOf(tabla.getValueAt(tabla.getSelectedRow(),6)),
    	    						Integer.valueOf(String.valueOf(tabla.getValueAt(tabla.getSelectedRow(),0))));
     				   
    	    			
    	        		//actualizo el pago
     				   	
     				   actualizaPagado(String.valueOf(tabla.getValueAt(tabla.getSelectedRow(),5)),
    	    					Integer.valueOf(String.valueOf(tabla.getValueAt(tabla.getSelectedRow(),0))));
     				   
     				
     	    				//actualizo el estado
     					actualizaEstado(String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 7))
     							,Integer.valueOf(String.valueOf(tabla.getValueAt(tabla.getSelectedRow(),0))),
     							estadoActual);
     					
     					comboEstado.removeAllItems();
     					comboEstado.addItem("Preparando");
                        comboEstado.addItem("Preparado");
                        comboEstado.addItem("En viaje");
                        comboEstado.addItem("Entregado");
        				comboEstado.addItem("Cancelado");
     				if(tabla.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn())!=null){
     					comboEstado.removeAllItems();
     					comboEstado.addItem("Preparando");
                        comboEstado.addItem("Preparado");
                        comboEstado.addItem("En viaje");
                        comboEstado.addItem("Entregado");
        				comboEstado.addItem("Cancelado");
     				}else if(tabla.getValueAt(tabla.getSelectedRow(), tabla.getSelectedColumn())==null){
       				 tabla.setValueAt(estadoActual, tabla.getSelectedRow(), tabla.getSelectedColumn());
     				}
     			
     				}
 
     			}    			
     		});
             
    }
    
    void actualizaADomicilio(String aDomicilio, int idPedido){
    	
    	int aDom;
    	if(aDomicilio=="SI"){
    		aDom=1;
    	}else aDom=0;
    	String sql = "UPDATE pedido SET Adomicilio="+"'"+ aDom +"'"+" WHERE IDPedido=" + "'" + idPedido + "'"; 
			try {
				Basededatos.ejecutarsql(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
    }
    void actualizaPagado(String pagado, int idPedido){
    	int pag;
    	if(pagado=="SI"){
    		pag=1;
    	}else pag=0;
    	String sql = "UPDATE pedido SET Pagado="+"'"+ pag +"'"+" WHERE IDPedido=" + "'" + idPedido + "'"; 
			try {
				Basededatos.ejecutarsql(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    void actualizaEstado(String nuevoEstado,int idPedido,String estadoActual){
    	String sql = "UPDATE pedido SET Estado="+"'"+ nuevoEstado +"'"+" WHERE IDPedido=" + "'" + idPedido + "'"; 	
    	try {
    		
    		Basededatos.ejecutarsql(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    void inicioTabla(){
    	String fecha=(Basededatos.dateToMySQLDate2(new Date()));
        ArrayList<Pedido> pedidofecha=Pizzeria.devuelvepedidofecha(fecha);
            for(int i=0;i<pedidofecha.size();i++){
                if(pedidofecha.get(i).getFechaPedido().equals(fecha)){
                Cliente cliente=Pizzeria.devuelvecliente(pedidofecha.get(i).getIdcliente());
            	 String nombreCliente= cliente.getNombreCliente();
                 String pagado;
                 String aDomicilio;
                 if(pedidofecha.get(i).getpagoconfirmado()==true){
                 	pagado="SI";
                 }else pagado="NO";
                 
                 if(pedidofecha.get(i).getAdomicilio()==true){
                 	aDomicilio="SI";
                 }else aDomicilio="NO"; 
            	 datostabla.addRow(new Object[] {
                 pedidofecha.get(i).getIdPedido(),pedidofecha.get(i).getNumeroPedido(),nombreCliente,
                 pedidofecha.get(i).getFechaPedido(),pedidofecha.get(i).getTotalPedido(),
                 pagado,aDomicilio,pedidofecha.get(i).getestado(),false});
                }
             } 
                                      
    }
    
    void borratabla(){
        int total=datostabla.getRowCount();
      
        	for (int i = total-1; i >= 0; i--) {
             datostabla.removeRow(0); 
            }
        
               }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        tabla.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
        		
        		estadoActual=String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 7));
                     
        		}
        		
        	@Override
        	public void mouseReleased(MouseEvent e) {
        		
        		if (tabla.getSelectedColumn()==7 && tabla.getValueAt(tabla.getSelectedRow(), 7) != null) {
        			
        			 if(estadoActual.equals("Preparado")){
        				comboEstado.setEnabled(true);        			 
        				comboEstado.removeItem("Preparando");
        				comboEstado.removeItem("En viaje");
        			 }else if(estadoActual.equals("Entregado")) {
             			comboEstado.setEnabled(false);
        				//tabla.setValueAt("Entregado", tabla.getSelectedRow(),7);
        				
             			//comboEstado.removeItem("Preparando");
             			//comboEstado.removeItem("Preparado");
             			//comboEstado.removeItem("Cancelado");
            		
        			 }else if(estadoActual.equals("Preparando")) {
             			comboEstado.setEnabled(true);
             			comboEstado.removeItem("En viaje");
        			 }else if(estadoActual.equals("Cancelado")) {
             			comboEstado.setEnabled(false);
             			//comboEstado.removeItem("Preparando");
             			//comboEstado.removeItem("Preparado");
             			//comboEstado.removeItem("Entregado");
            		
        			 }else if(estadoActual.equals("En viaje")) {
             			comboEstado.setEnabled(true);
             			comboEstado.removeItem("Preparando");
             			comboEstado.removeItem("Preparado");
             			
            		}
        			
            		
        		//aca termina
        		}
        	}
        	 });
        cbpedidos = new javax.swing.JComboBox();
        salir = new javax.swing.JToggleButton();
        salir.setVisible(false);
        lbguardar = new javax.swing.JLabel();
        btitinerario = new javax.swing.JButton();
        btitinerario.addActionListener(new ActionListener() {
        	private int ultimoIti;

			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent arg0) {
        
				String sql=("Select max(NumeroItinerario) from itinerario");
				ResultSet numIti;
				try {
				
					numIti = Basededatos.consultasql(sql);
					numIti.previous();
					while(numIti.next()){
						ultimoIti=numIti.getInt(1)+1;
					}
					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		for (int j=0;j<tabla.getRowCount();j++){ 
        			
       			 //Guardo si se pidio para itinerario
       			 String iti=String.valueOf(tabla.getValueAt(j, 8));
       			 //Consigo el id del pedido
       			 int idtab = (Integer.valueOf(String.valueOf(tabla.getValueAt(j, 0))));
       			 //fruta
       			 if(iti.equals("SI")){
       			 		//frula
       				 try {
							//Consigo el repartidor
       					 String idRepartidor=Busqueda.buscaUnValor(Busqueda.devuelveTabla("repartidor"), 
									 "Nombre",String.valueOf(cbrepartidor.getSelectedItem()),"IDRepartidor");
       					//Consigo la fecha
       					 String fecha=(Basededatos.dateToMySQLDate2(new Date()));
       					 
       					//Creo el itinerario y lo ingreso en la tabla itinerario
       					 Pizzeria.agregarItinerario2(ultimoIti,Integer.valueOf(idRepartidor),String.valueOf(idtab),fecha);
       				
       					//actualizo el estado a En viaje
      					actualizaEstado("En viaje"
      							,idtab,
      							estadoActual);
      					tabla.setValueAt("En viaje",tabla.getSelectedRow(),7);
      					
      					//Guardo el numero de itinerario en la tabla pedidos
      					String sql2 = "UPDATE pedido SET IDItinerario="+"'"+ ultimoIti +"'"+" WHERE IDPedido=" + "'" + idtab + "'"; 
      					try {
      						Basededatos.ejecutarsql(sql2);
      					} catch (SQLException e) {
      						// TODO Auto-generated catch block
      						e.printStackTrace();
      					}
       				 } catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
       				
       				 	
	                	}
       			 //Aca termina el if
       		 }
  
        		Pizzeria.abrirReporte(
						"C:\\Users\\gablopez\\Desktop\\Gustavo\\backup\\servidor\\pizzeria\\src\\It.jasper",
						ultimoIti, "numIti"); 
        	}
        });
        btitinerario.setVisible(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseReleased(evt);
            }
        });

        jScrollPane1.setViewportView(tabla);

        cbpedidos.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"--Pedidos--", "Todos","Preparados","No preparados", "No pagados","Envios a domicilio","Para Itinerario"}));
        cbpedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbpedidosActionPerformed(evt);
            }
        });

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        btitinerario.setText("Imprimir itinerario");
        
        cbrepartidor = new JComboBox();
        for(int i=0;i<repartidor.size();i++){
        	
        	cbrepartidor.addItem(repartidor.get(i).getnombre());
        }
        
        numIti = new JTextField();
        numIti.setBackground(Color.CYAN);
        numIti.setColumns(10);
        
        recepEnvios = new JButton("Recepcion Envios");
        recepEnvios.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if(numIti.getText().equals("")==false){
        		String sql4 = "UPDATE pedido SET Pagado=" + 1
        				+ " WHERE IDItinerario=" + numIti.getText();
        		
        		String estado="Entregado";
        	
        		String sql5 = "UPDATE pedido SET Estado="+"'"+ estado+"'"+" WHERE IDItinerario=" + numIti.getText();
        		try {
    				Basededatos.ejecutarsql(sql4);
    				Basededatos.ejecutarsql(sql5);
        		} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
        		}
        		borratabla();
        		numIti.setText("");
        	}
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(556, Short.MAX_VALUE)
        			.addComponent(lbguardar)
        			.addGap(374))
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(recepEnvios, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(numIti)
        				.addComponent(cbrepartidor, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(cbpedidos, Alignment.TRAILING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(btitinerario, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addGap(7)
        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
        			.addContainerGap())
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(840, Short.MAX_VALUE)
        			.addComponent(salir, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
        					.addGap(2))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(cbpedidos, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
        					.addGap(90)
        					.addComponent(cbrepartidor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(43)
        					.addComponent(numIti, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(recepEnvios)
        					.addGap(18)
        					.addComponent(btitinerario, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(lbguardar)
        						.addComponent(salir)))))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    void settablaNopreparado(){
    	btitinerario.setEnabled(true);
       	datostabla.setDataVector(new Object[][] { }, new Object[] {
    	         "IdPedido", "Nro Pedido", "Nro cliente", "Fecha","Total","Pagado","Adomicilio","Estado","Itinerario" });
    	  

        
        //tabla.getColumnModel().getColumn(8).setCellEditor(new Celda());
        //tabla.getColumnModel().getColumn(8).setCellRenderer(new CeldaP());

        TableColumn itinerario = tabla.getColumnModel().getColumn(8);       
        TableCellEditor tc5 =new DefaultCellEditor(comboCheck);
        itinerario.setCellEditor(tc5);
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);

        tabla.getColumnModel().getColumn(0).setMinWidth(0);

        tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
 
        tabla.getColumnModel().getColumn(1).setPreferredWidth(25);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(35);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(25);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(15);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(15);
        tabla.getColumnModel().getColumn(7).setPreferredWidth(35);
        tabla.getColumnModel().getColumn(8).setPreferredWidth(10);
        inicioTablaRepartidor();
 
    }
    
     	   

    void inicioTablaRepartidor(){
    	ArrayList<Repartidor> rep=Pizzeria.devuelveRepartidor();
    	for(int i=0;i<rep.size();i++){
    		
    	}
    }
    
    void settablaEstados(){
    	btitinerario.setEnabled(false);
    
    	 datostabla.setDataVector(new Object[][] { }, new Object[] {
    			 "IdPedido", "Nro Pedido", "Nro cliente", "Fecha","Total","Pagado","Adomicilio","Estado"});

    	                   	        
    	  TableColumn pagado = tabla.getColumnModel().getColumn(5);
          comboCheck = new JComboBox();
          comboCheck.addItem("SI");
          comboCheck.addItem("NO");
          
          TableCellEditor tc2 =new DefaultCellEditor(comboCheck);
          pagado.setCellEditor(tc2);
          
          TableColumn Adom = tabla.getColumnModel().getColumn(6);
          TableCellEditor tc3 =new DefaultCellEditor(comboCheck);
          Adom.setCellEditor(tc3);       
    	 
    	 TableColumn estado = tabla.getColumnModel().getColumn(7);
    	        comboEstado = new JComboBox();
    	        comboEstado.addItem("Preparando");
    	        comboEstado.addItem("Preparado");
    	        comboEstado.addItem("En viaje");
    	        comboEstado.addItem("Entregado");
    	        comboEstado.addItem("Cancelado");
    	        
    	        TableCellEditor tc =new DefaultCellEditor(comboEstado);
    	        estado.setCellEditor(tc);

    	        tabla.getColumnModel().getColumn(0).setMaxWidth(0);

    	        tabla.getColumnModel().getColumn(0).setMinWidth(0);

    	        tabla.getColumnModel().getColumn(0).setPreferredWidth(0);        
    	        tabla.getColumnModel().getColumn(1).setPreferredWidth(25);
    	        tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
    	        tabla.getColumnModel().getColumn(3).setPreferredWidth(35);
    	        tabla.getColumnModel().getColumn(4).setPreferredWidth(25);
    	        tabla.getColumnModel().getColumn(5).setPreferredWidth(15);
    	        tabla.getColumnModel().getColumn(6).setPreferredWidth(15);
    	        tabla.getColumnModel().getColumn(7).setPreferredWidth(35);
    }

    private void cbpedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbpedidosActionPerformed
    	
    	if(tabla.isEditing()==false){
       	borratabla();
    	ArrayList <Pedido> pedidos = Pizzeria.devuelvepedidoEstado();
        String elegido=String.valueOf(cbpedidos.getSelectedItem());      
        
        if(elegido.equals("--Pedidos--")){
        	//borratabla();
        	settablaEstados();
    		String fecha=(Basededatos.dateToMySQLDate2(new Date()));
            ArrayList<Pedido> pedidofecha=Pizzeria.devuelvepedidofecha(fecha);
            
            for(int i=0;i<pedidofecha.size();i++){
                if(pedidofecha.get(i).getFechaPedido().equals(fecha)){
                
                Cliente cliente=Pizzeria.devuelvecliente(pedidos.get(i).getIdcliente());
            	String nombreCliente= cliente.getNombreCliente();
                String pagado;
                String aDomicilio;
                if(pedidofecha.get(i).getpagoconfirmado()==true){
                	pagado="SI";
                }else pagado="NO";
                
                if(pedidofecha.get(i).getAdomicilio()==true){
                	aDomicilio="SI";
                }else aDomicilio="NO";    
            	
                datostabla.addRow(new Object[] {
                 pedidofecha.get(i).getIdPedido(),pedidofecha.get(i).getNumeroPedido(),nombreCliente,
                 pedidofecha.get(i).getFechaPedido(),pedidofecha.get(i).getTotalPedido(),
                 pagado,aDomicilio,pedidofecha.get(i).getestado(),false});
                }
             } 
         }
        
        else if(elegido.equals("Todos")){
        	settablaEstados();
          //borratabla();
          for(int i=0;i<pedidos.size();i++){ 
        
        	    Cliente cliente=Pizzeria.devuelvecliente(pedidos.get(i).getIdcliente());
        	    String nombreCliente= cliente.getNombreCliente();
        	    String pagado;
                String aDomicilio;
                if(pedidos.get(i).getpagoconfirmado()==true){
                	pagado="SI";
                }else pagado="NO";
                
                if(pedidos.get(i).getAdomicilio()==true){
                	aDomicilio="SI";
                }else aDomicilio="NO"; 
        	    datostabla.addRow(new Object[] {
                pedidos.get(i).getIdPedido(),pedidos.get(i).getNumeroPedido(),nombreCliente,
                pedidos.get(i).getFechaPedido(),pedidos.get(i).getTotalPedido(),
                pagado,aDomicilio,pedidos.get(i).getestado(),false});
        }  
        }else if(elegido.equals("No pagados")){
        	        
           //borratabla();
        	settablaEstados();
        	
           for(int i=0;i<pedidos.size();i++){
               if(pedidos.get(i).getpagoconfirmado()==false){
            	Cliente cliente=Pizzeria.devuelvecliente(pedidos.get(i).getIdcliente());
           	    String nombreCliente= cliente.getNombreCliente();
           	    String pagado;
           	    String aDomicilio;
           	    if(pedidos.get(i).getpagoconfirmado()==true){
               	pagado="SI";
           	    }else pagado="NO";
               
           	    if(pedidos.get(i).getAdomicilio()==true){
               	aDomicilio="SI";
               }else aDomicilio="NO";   
           	    
           	    datostabla.addRow(new Object[] {
                pedidos.get(i).getIdPedido(),pedidos.get(i).getNumeroPedido(),nombreCliente,
                pedidos.get(i).getFechaPedido(),pedidos.get(i).getTotalPedido(),
                pagado,aDomicilio,pedidos.get(i).getestado()});
               }
        }
        }else if(elegido.equals("Preparados")){
	        
   //borratabla();
	settablaEstados();
	
   for(int i=0;i<pedidos.size();i++){
       if(pedidos.get(i).getestado().equals("Preparado")){
    	Cliente cliente=Pizzeria.devuelvecliente(pedidos.get(i).getIdcliente());
   	    String nombreCliente= cliente.getNombreCliente();
    	  
   	   String pagado;
       String aDomicilio;
       if(pedidos.get(i).getpagoconfirmado()==true){
       	pagado="SI";
       }else pagado="NO";
       
       if(pedidos.get(i).getAdomicilio()==true){
       	aDomicilio="SI";
       }else aDomicilio="NO"; 
   	    datostabla.addRow(new Object[] {
        pedidos.get(i).getIdPedido(),pedidos.get(i).getNumeroPedido(),nombreCliente,
        pedidos.get(i).getFechaPedido(),pedidos.get(i).getTotalPedido(),
        pagado,aDomicilio,pedidos.get(i).getestado()});
       }
}
        
        }else if(elegido.equals("Para Itinerario")){
        	//datostabla.addColumn("Itinerario");
        	settablaNopreparado();
            
        	//borratabla();
            for(int i=0;i<pedidos.size();i++){
               if(pedidos.get(i).getestado().equals("Preparado")&&pedidos.get(i).getAdomicilio()==true){
            	Cliente cliente=Pizzeria.devuelvecliente(pedidos.get(i).getIdcliente());
           	    String nombreCliente= cliente.getNombreCliente();
           	   String pagado;
               String aDomicilio;
               if(pedidos.get(i).getpagoconfirmado()==true){
               	pagado="SI";
               }else pagado="NO";
               
               if(pedidos.get(i).getAdomicilio()==true){
               	aDomicilio="SI";
               }else aDomicilio="NO"; 
               
              
           	    datostabla.addRow(new Object[] {
                pedidos.get(i).getIdPedido(),pedidos.get(i).getNumeroPedido(),nombreCliente,
                pedidos.get(i).getFechaPedido(),pedidos.get(i).getTotalPedido(),
                pagado,aDomicilio,pedidos.get(i).getestado(),"NO"});
               }
            }
           
           
        }
        else if(elegido.equals("No preparados")){
        	//datostabla.addColumn("Itinerario");
        	settablaEstados();;
            
        	//borratabla();
            for(int i=0;i<pedidos.size();i++){
               if(pedidos.get(i).getestado().equals("Preparando")){
            	Cliente cliente=Pizzeria.devuelvecliente(pedidos.get(i).getIdcliente());
           	    String nombreCliente= cliente.getNombreCliente();
           	   String pagado;
               String aDomicilio;
               if(pedidos.get(i).getpagoconfirmado()==true){
               	pagado="SI";
               }else pagado="NO";
               
               if(pedidos.get(i).getAdomicilio()==true){
               	aDomicilio="SI";
               }else aDomicilio="NO"; 
               
           	    datostabla.addRow(new Object[] {
                pedidos.get(i).getIdPedido(),pedidos.get(i).getNumeroPedido(),nombreCliente,
                pedidos.get(i).getFechaPedido(),pedidos.get(i).getTotalPedido(),
                pagado,aDomicilio,pedidos.get(i).getestado()});
               }
            }
            
        }          
        else if(elegido.equals("Envios a domicilio")){
        	settablaEstados();
           for(int i=0;i<pedidos.size();i++){
               if(pedidos.get(i).getAdomicilio()==true){
            	Cliente cliente=Pizzeria.devuelvecliente(pedidos.get(i).getIdcliente());
           	    String nombreCliente= cliente.getNombreCliente();
           	   String pagado;
               String aDomicilio;
               if(pedidos.get(i).getpagoconfirmado()==true){
               	pagado="SI";
               }else pagado="NO";
               
               if(pedidos.get(i).getAdomicilio()==true){
               	aDomicilio="SI";
               }else aDomicilio="NO"; 
           	    datostabla.addRow(new Object[] {
                pedidos.get(i).getIdPedido(),pedidos.get(i).getNumeroPedido(),nombreCliente,
                pedidos.get(i).getFechaPedido(),pedidos.get(i).getTotalPedido(),
                pagado,aDomicilio,pedidos.get(i).getestado()});
               }
            } 
        }
    }
            
    }//GEN-LAST:event_cbpedidosActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void jScrollPane1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseReleased

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
    private javax.swing.JComboBox cbpedidos;
    private javax.swing.JButton btitinerario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbguardar;
    private javax.swing.JToggleButton salir;
    private javax.swing.JTable tabla;
    private javax.swing.JComboBox comboEstado;
    private JComboBox cbrepartidor;
    private JTextField numIti;
    private JButton recepEnvios;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
