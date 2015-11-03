package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import negocio.Cliente;
import negocio.DetallePedido;
import negocio.Pedido;
import negocio.Producto;

import com.mxrck.autocompleter.TextAutoCompleter;

import datos.Basededatos;
import datos.Pizzeria;

public class FormPedido2 extends javax.swing.JDialog {
    ArrayList <Producto> productos = Pizzeria.devuelveProductos();
    ArrayList <Pedido> pedidos = Pizzeria.devuelvepedido();
    ArrayList <Cliente> clientes = Pizzeria.devuelveClientes();
    ArrayList <DetallePedido> detalle = Pizzeria.devuelvedetallepedido();
    private Cliente clienteSeleccionado;
    private Producto productoSeleccionado;
    private Double totalPedido;
    final DefaultTableModel datostabla = new DefaultTableModel();
    //ahora +1
    int idped=pedidos.size()+1;

    public FormPedido2(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        inicio();
       getContentPane().add(jScrollPane);
       String[] columna = new String[] { "Cod", "Producto", "Cant.",
				"Tot.linea", "Observacion" };
	datostabla.setColumnIdentifiers(columna);
        tabdet.setModel(datostabla);
	jScrollPane.setViewportView(tabdet);
    }
    
    void borratabla(){
        int total=datostabla.getRowCount();
        for (int i = total-1; i >= 0; i--) {
             datostabla.removeRow(i); 
            }
    }
    
    void inicio (){
        
        btconfirmar.setEnabled(false);
        btmodificar.setEnabled(false);
        bteliminar.setEnabled(false);
        pedido.setEnabled(false);
        fecha.setEnabled(false);
        dni.setEnabled(false);
        direccion.setEnabled(false);
        telefono.setEnabled(false);
        precio.setEnabled(false);
        total.setEnabled(false);
        // Defino la fecha del dia
	fecha.setText(Basededatos.dateToMySQLDate2(new Date()));
        String id=String.valueOf(idped)+"-"+ String.valueOf(fecha.getText());
        final TextAutoCompleter clientes = new TextAutoCompleter(cliente);
		for (int i = 0; i < Pizzeria.devuelveClientes().size(); i++) {

			clientes.addItem(Pizzeria.devuelveClientes().get(i));

		}

		final TextAutoCompleter productos = new TextAutoCompleter(producto);
		for (int i = 0; i < Pizzeria.devuelveProductos().size(); i++) {

			productos.addItem(Pizzeria.devuelveProductos().get(i));
		}
                
                final TextAutoCompleter busqueda = new TextAutoCompleter(txbuscar);
		for (int i = 0; i < Pizzeria.devuelvepedido().size(); i++) {

			busqueda.addItem(Pizzeria.devuelvepedido().get(i).getNumeroPedido());
		}
                       
        // Completo los campos con el cliente seleccionado
		cliente.getDocument().addDocumentListener(
				new javax.swing.event.DocumentListener() {

					public void insertUpdate(javax.swing.event.DocumentEvent evt) {

						// lleno los campos
						clienteSeleccionado = (Cliente) clientes
								.getItemSelected();
						if (clienteSeleccionado != null) {
							dni.setText(clienteSeleccionado.getDni());
							telefono.setText(clienteSeleccionado.getTelefono());
							direccion.setText(clienteSeleccionado
									.getDireccion());
						}

					}

					public void removeUpdate(javax.swing.event.DocumentEvent evt) {
						// limpio al cambiar
						dni.setText("");
						telefono.setText("");
						direccion.setText("");
					}

					public void changedUpdate(
							javax.swing.event.DocumentEvent evt) {
						// limpio al cambiar
						dni.setText("");
						telefono.setText("");
						direccion.setText("");
					}
                                        

				});
                
        // Completo los campos con el producto seleccionado
		producto.getDocument().addDocumentListener(
				new javax.swing.event.DocumentListener() {

					public void insertUpdate(javax.swing.event.DocumentEvent evt) {
						precio.setText("");
						// lleno los campos
						productoSeleccionado = (Producto) productos
								.getItemSelected();

						if (productoSeleccionado != null) {

							precio.setText(String.valueOf(productoSeleccionado
									.getPrecio()));
						}

					}

					public void removeUpdate(javax.swing.event.DocumentEvent evt) {
						// limpio al cambiar
						precio.setText("");

					}

					public void changedUpdate(
							javax.swing.event.DocumentEvent evt) {
						// limpio al cambiar
						precio.setText("");
					}

				});
                
                // Capturo el evento del cambio en la tabla
		tabdet.getModel().addTableModelListener(new TableModelListener() {

			public void tableChanged(TableModelEvent evt) {

			}
		});
                
                
                // capturo el evento de la columna cantidad
		tabdet.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyReleased(java.awt.event.KeyEvent e) {
                        
			Integer cantidad = null;
			Double precioUnitario = null;
			Double totalLinea = null;

			if (tabdet.editCellAt(tabdet.getSelectedRow(), 2)) {
				if (tabdet.getValueAt(tabdet.getSelectedRow(), 2) != null
                                        && tabdet.getValueAt(tabdet.getSelectedRow(), 2).equals("") == false) {

					cantidad = Integer.valueOf(String.valueOf(tabdet.getValueAt(tabdet.getSelectedRow(), 2)));
					precioUnitario = Double.valueOf(String.valueOf(tabdet.getValueAt(tabdet.getSelectedRow(), 3)));

					totalLinea = cantidad * precioUnitario;
					
					tabdet.setValueAt(totalLinea, tabdet.getSelectedRow(), 4);
				
				}
				totalPedido = 0.0;

				for (int i = 0; i < datostabla.getRowCount(); i++) {

					totalPedido = totalPedido+Double.valueOf(String.valueOf(tabdet.getValueAt(i, 4)));

				}
				total.setText(String.valueOf(totalPedido));
				}
			}

		});
                
                // Agregar producto al pedido
		btnAgregarproducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				datostabla.addRow(new Object[] {

				productoSeleccionado.getIdProducto(),
						productoSeleccionado.getNombre(), 1,
						productoSeleccionado.getPrecio(), null, null });
                                
                                Integer cantidad = null;
                                Double precioUnitario = null;
                                Double totalLinea = null;
				
                                for (int i=0;i<tabdet.getRowCount();i++){

                                cantidad = Integer.valueOf(String.valueOf(tabdet.getValueAt(i, 2)));
				precioUnitario = Double.valueOf(String.valueOf(tabdet.getValueAt(i, 3)));

				totalLinea = cantidad * precioUnitario;
                                tabdet.setValueAt(totalLinea, i, 4);
                                }
                                totalPedido = 0.0;
                                for (int i = 0; i < datostabla.getRowCount(); i++) {

					totalPedido = totalPedido+Double.valueOf(String.valueOf(tabdet.getValueAt(i, 4)));

				}
                                total.setText(String.valueOf(totalPedido));
                        }       
		});
                
                // Eliminar fila de la tabla
		btnEliminarproducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				datostabla.removeRow(tabdet.getSelectedRow());
				totalPedido = 0.0;

				for (int i = 0; i < datostabla.getRowCount(); i++) {

					totalPedido = totalPedido+ Double.valueOf(String.valueOf(tabdet.getValueAt(i, 4)));

				}

				total.setText(String.valueOf(totalPedido));
			}

		});
                
                
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnAgregarproducto = new javax.swing.JButton();
        btnEliminarproducto = new javax.swing.JButton();
        pedido = new javax.swing.JTextField();
        fecha = new javax.swing.JTextField();
        cliente = new javax.swing.JTextField();
        direccion = new javax.swing.JTextField();
        dni = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        precio = new javax.swing.JTextField();
        producto = new javax.swing.JTextField();
        jScrollPane = new javax.swing.JScrollPane();
        tabdet = new javax.swing.JTable();
        btconfirmar = new javax.swing.JButton();
        total = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        chpreparado = new javax.swing.JCheckBox();
        chpagado = new javax.swing.JCheckBox();
        btnuevo = new javax.swing.JButton();
        txbuscar = new javax.swing.JTextField();
        btbuscar = new javax.swing.JButton();
        btmodificar = new javax.swing.JButton();
        bteliminar = new javax.swing.JToggleButton();
        chdomicilio = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setForeground(new java.awt.Color(51, 0, 51));

        jLabel1.setText("Pedido:");

        jLabel2.setText("Fecha:");

        jLabel3.setText("Cliente:");

        jLabel4.setText("DNI:");

        jLabel5.setText("Direccion:");

        jLabel6.setText("Telefono:");

        jLabel7.setText("Producto:");

        jLabel8.setText("Precio:");

        btnAgregarproducto.setText("AgregarProducto");
        btnAgregarproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarproductoActionPerformed(evt);
            }
        });

        btnEliminarproducto.setText("QuitarProducto");

        cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteActionPerformed(evt);
            }
        });

        precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioActionPerformed(evt);
            }
        });

        tabdet.setModel(new javax.swing.table.DefaultTableModel(
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
        tabdet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabdetMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabdetMousePressed(evt);
            }
        });
        tabdet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabdetKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabdetKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tabdetKeyTyped(evt);
            }
        });
        jScrollPane.setViewportView(tabdet);

        btconfirmar.setText("Confirmar pedido");
        btconfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btconfirmarActionPerformed(evt);
            }
        });

        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });

        jLabel9.setText("Total:");

        chpreparado.setText("Preparado");
        chpreparado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chpreparadoActionPerformed(evt);
            }
        });

        chpagado.setText("Pagado");
        chpagado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chpagadoActionPerformed(evt);
            }
        });

        btnuevo.setText("Nuevo");
        btnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnuevoActionPerformed(evt);
            }
        });

        txbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txbuscarActionPerformed(evt);
            }
        });

        btbuscar.setText("Buscar");
        btbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbuscarActionPerformed(evt);
            }
        });

        btmodificar.setText("Modificar");
        btmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmodificarActionPerformed(evt);
            }
        });

        bteliminar.setText("Eliminar");
        bteliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bteliminarActionPerformed(evt);
            }
        });

        chdomicilio.setText("A domicilio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btconfirmar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btmodificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bteliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnuevo)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(303, 303, 303)
                                .addComponent(jLabel2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(producto, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(jLabel3)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dni, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(precio, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(fecha)
                            .addComponent(direccion)
                            .addComponent(telefono))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btbuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chpagado)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAgregarproducto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEliminarproducto))
                                    .addComponent(chdomicilio)
                                    .addComponent(chpreparado))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btbuscar))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chpreparado))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chpagado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chdomicilio)))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarproducto)
                    .addComponent(btnEliminarproducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btconfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bteliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarproductoActionPerformed
        cliente.setEnabled(false);
	btconfirmar.setEnabled(true);
    }//GEN-LAST:event_btnAgregarproductoActionPerformed

    
    private void tabdetKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabdetKeyReleased
        
    }//GEN-LAST:event_tabdetKeyReleased

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

    private void tabdetKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabdetKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tabdetKeyTyped

    private void tabdetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabdetKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tabdetKeyPressed

    private void tabdetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabdetMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabdetMouseClicked

    private void tabdetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabdetMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tabdetMousePressed

    private void btconfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btconfirmarActionPerformed
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        int pr;
        if(chpreparado.isSelected()){pr=1;}
        else{ pr=0;}
        int pa;
        if(chpagado.isSelected()){ pa=1;}
        else{pa=0;}
        int dc;
        if(chdomicilio.isSelected()){ dc=1;}
        else{dc=0;}
        String id=String.valueOf(idped)+"-"+ String.valueOf(fecha.getText());

        int idcli=clienteSeleccionado.getIdCliente();
        Double subtot=Double.parseDouble(precio.getText());
        Double tot=Double.parseDouble(total.getText());
        idped++;
        
        Pizzeria.agregarPedido(pedido.getText(),idped,idcli,sqlDate,subtot,tot, pr, pa,dc);

        for(int i=0;i<datostabla.getRowCount();i++){
            
               int idproduct=Integer.valueOf(String.valueOf(tabdet.getValueAt(i, 0)));
               int cant=Integer.valueOf(String.valueOf(tabdet.getValueAt(i, 2)));
               String ob = String.valueOf(tabdet.getValueAt(i, 5));
               if(ob.equals(null)){
                   ob="";
               }
               else{ob= String.valueOf(tabdet.getValueAt(i, 5));}
               Double precio=Double.valueOf(String.valueOf(tabdet.getValueAt(i, 3)));
               DetallePedido detalle= new DetallePedido(id,idproduct,cant,ob);
               
               Pizzeria.agregarDetallePedido(detalle);
        } 
        pedidos = Pizzeria.devuelvepedido();
    }//GEN-LAST:event_btconfirmarActionPerformed

    private void clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteActionPerformed
        
    }//GEN-LAST:event_clienteActionPerformed

    private void chpreparadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chpreparadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chpreparadoActionPerformed

    private void chpagadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chpagadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chpagadoActionPerformed

    private void precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioActionPerformed

    private void btnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnuevoActionPerformed
            String id=String.valueOf(idped)+"-"+ String.valueOf(fecha.getText());
            pedido.setText(id);
            fecha.setText(Basededatos.dateToMySQLDate2(new Date()));    
            cliente.setText("");
            cliente.setEnabled(true);
            telefono.setText("");
            direccion.setText("");
            dni.setText("");
            producto.setText("");
            precio.setText("");
            chpagado.setSelected(false);
            chpreparado.setSelected(false);
            chdomicilio.setSelected(false);
            borratabla();
            btmodificar.setEnabled(false);
            bteliminar.setEnabled(false);
            btconfirmar.setEnabled(false);
    }//GEN-LAST:event_btnuevoActionPerformed

    private void txbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txbuscarActionPerformed

    private void btbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbuscarActionPerformed
  
    	borratabla();
        if(txbuscar.getText().equals("")==false&&txbuscar.getText().equals(null)==false){
        String busqueda = txbuscar.getText();

        for (int i=0;i<pedidos.size();i++){
            if(busqueda.equals(pedidos.get(i).getNumeroPedido())){
                    pedido.setText(String.valueOf(pedidos.get(i).getIdPedido()));
                    fecha.setText(String.valueOf(pedidos.get(i).getFechaPedido()));
                    total.setText(String.valueOf(pedidos.get(i).getTotalPedido()));
                    chpagado.setSelected(pedidos.get(i).getpagoconfirmado());
                    chpreparado.setSelected(pedidos.get(i).getpreparado());
                    
                    for(int j=0;j<clientes.size();j++){
                        if(pedidos.get(i).getIdcliente()==clientes.get(j).getIdCliente())
                        cliente.setText(String.valueOf(clientes.get(j).getNombreCliente()));
                        cliente.setEnabled(false);
                        direccion.setText(String.valueOf(clientes.get(j).getDireccion()));
                        dni.setText(String.valueOf(clientes.get(j).getDni()));
                        telefono.setText(String.valueOf(clientes.get(j).getTelefono()));
                    }
                    
                    for(int h=0;h<detalle.size();h++){
                        String pro = null;
                        if(pedidos.get(i).getIdPedido().equals(detalle.get(h).getIdPedido())){
                      
                            Double tot=pedidos.get(i).getTotalPedido();
                            for(int k=0;k<productos.size();k++){
                             
                                if(detalle.get(h).getidproducto()==productos.get(k).getIdProducto()){
                                	
                                	pro=productos.get(k).getNombre();
                                }
                            }
                            datostabla.addRow(new Object[] {

				detalle.get(h).getidproducto(),
						pro, detalle.get(h).getCantidad(),
						tot, detalle.get(h).getObservacion() });
                        }}}
           }
        btconfirmar.setEnabled(false);
        btmodificar.setEnabled(true);
        bteliminar.setEnabled(true);
        precio.setText("");
        producto.setText("");
        }
        else{
            JOptionPane.showMessageDialog(null,"El pedido no existe");
        }
        
    }//GEN-LAST:event_btbuscarActionPerformed

    private void btmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmodificarActionPerformed
        int pa;
        int pr;
        int idp = 0;
        if(chpagado.isSelected()==true){pa=1;}
        else{pa=0;}
        if(chpreparado.isSelected()==true){pr=1;}
        else{pr=0;}
        String id=pedido.getText();
        Double tot=Double.valueOf(total.getText());        
        Pizzeria.modificarpedido(id,tot, pa, pr);
        for(int i=0;i<detalle.size();i++){
            if(id.equals(detalle.get(i).getIdPedido())){
                for(int k=0;k<productos.size();k++){
                    for (int j=0;j<tabdet.getRowCount();j++){ 
                    if(productos.get(k).getNombre()==String.valueOf(tabdet.getValueAt(j, 1))){
                        idp=productos.get(k).getIdProducto();
                        int cant=Integer.valueOf(String.valueOf(tabdet.getValueAt(j, 2)));
                        String ob = String.valueOf(tabdet.getValueAt(j, 4));
                
                
                        Pizzeria.modificardetalle(id,idp, cant, ob); }}}
                    }
                }
        
        pedidos.equals(Pizzeria.devuelvepedido());
    }//GEN-LAST:event_btmodificarActionPerformed

    private void bteliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bteliminarActionPerformed
        if(pedido.getText().equals("")==false){
            String id=pedido.getText();
            Pizzeria.eliminardetalle(id);
            Pizzeria.eliminarpedido(id);
            btnuevo.requestFocus();
        }
    }//GEN-LAST:event_bteliminarActionPerformed

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
            java.util.logging.Logger.getLogger(FormPedido2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPedido2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPedido2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPedido2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormPedido2 dialog = new FormPedido2(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btbuscar;
    private javax.swing.JButton btconfirmar;
    private javax.swing.JToggleButton bteliminar;
    private javax.swing.JButton btmodificar;
    private javax.swing.JButton btnAgregarproducto;
    private javax.swing.JButton btnEliminarproducto;
    private javax.swing.JButton btnuevo;
    private javax.swing.JCheckBox chdomicilio;
    private javax.swing.JCheckBox chpagado;
    private javax.swing.JCheckBox chpreparado;
    private javax.swing.JTextField cliente;
    private javax.swing.JTextField direccion;
    private javax.swing.JTextField dni;
    private javax.swing.JTextField fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTextField pedido;
    private javax.swing.JTextField precio;
    private javax.swing.JTextField producto;
    private javax.swing.JTable tabdet;
    private javax.swing.JTextField telefono;
    private javax.swing.JTextField total;
    private javax.swing.JTextField txbuscar;
    // End of variables declaration//GEN-END:variables
}
