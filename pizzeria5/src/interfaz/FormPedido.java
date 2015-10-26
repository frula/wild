package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import negocio.Cliente;
import negocio.DetallePedido;
import negocio.Pedido;
import negocio.Producto;
import com.mxrck.autocompleter.TextAutoCompleter;
import datos.Basededatos;
import datos.Busqueda;
import datos.Pizzeria;

public class FormPedido extends JFrame implements ActionListener {

	private JMenuBar mbar;
	private JMenu opciones;
	private JMenuItem buscarPedido;
	private Pedido pedidoActivo;
	private JTextField pedido;
	private JTextField fechaPedido;
	private JTextField cliente;
	private JTextField dni;
	private JTextField direccion;
	private JTextField telefono;
	private JTextField producto;
	private JTextField precio;
	private Producto productoSeleccionado;
	private Cliente clienteSeleccionado;
	private DetallePedido linea;
	private ArrayList<DetallePedido> lineasPedido;
	private JTextField total;
	private Double totalPedido;
	private Integer cantidad;
	private Double precioUnitario;
	private Double totalLinea;
	private String numeroPed;

	public FormPedido() {
		setResizable(false);
		getContentPane().setBackground(new Color(51, 51, 102));
		setTitle("Pedidos");
		setSize(new Dimension(910, 561));

		// Creo el menu contenedor
		mbar = new JMenuBar();
		mbar.setBackground(new Color(102, 102, 153));
		setJMenuBar(mbar);

		// Creo el menu principal
		opciones = new JMenu("Opciones de pedido");
		mbar.add(opciones);
		buscarPedido = new JMenuItem("Consultar pedido");
		buscarPedido.addActionListener(this);
		opciones.add(buscarPedido);
		getContentPane().setLayout(null);

		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblCliente.setForeground(new Color(255, 255, 255));
		lblCliente.setBounds(26, 64, 55, 16);
		getContentPane().add(lblCliente);

		pedido = new JTextField();
		pedido.setHorizontalAlignment(SwingConstants.CENTER);
		pedido.setEnabled(false);
		pedido.setBounds(93, 18, 129, 28);
		getContentPane().add(pedido);
		pedido.setColumns(10);

		JLabel lblpedido = new JLabel("Pedido");
		lblpedido.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblpedido.setForeground(new Color(255, 255, 255));
		lblpedido.setBounds(26, 24, 63, 16);
		getContentPane().add(lblpedido);

		fechaPedido = new JTextField();
		fechaPedido.setHorizontalAlignment(SwingConstants.CENTER);
		fechaPedido.setEnabled(false);
		fechaPedido.setBounds(325, 18, 122, 28);
		getContentPane().add(fechaPedido);
		fechaPedido.setColumns(10);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblFecha.setForeground(new Color(255, 255, 255));
		lblFecha.setBounds(258, 24, 55, 16);
		getContentPane().add(lblFecha);

		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblProducto.setForeground(new Color(255, 255, 255));
		lblProducto.setBounds(26, 144, 55, 16);
		getContentPane().add(lblProducto);

		JButton btnAgregarproducto = new JButton("AgregarProducto");
		btnAgregarproducto.setBounds(605, 138, 131, 28);
		getContentPane().add(btnAgregarproducto);

		JButton btnEliminarproducto = new JButton("QuitarProducto");
		btnEliminarproducto.setBounds(742, 138, 131, 28);
		getContentPane().add(btnEliminarproducto);

		cliente = new JTextField();
		cliente.setBounds(93, 58, 354, 28);
		getContentPane().add(cliente);
		cliente.setColumns(10);

		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblDNI.setForeground(new Color(255, 255, 255));
		lblDNI.setBounds(26, 104, 38, 16);
		getContentPane().add(lblDNI);

		dni = new JTextField();
		dni.setEnabled(false);
		dni.setColumns(10);
		dni.setBounds(93, 98, 129, 28);
		getContentPane().add(dni);

		JLabel lbldireccion = new JLabel("Direccion");
		lbldireccion.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbldireccion.setForeground(new Color(255, 255, 255));
		lbldireccion.setBounds(452, 64, 55, 16);
		getContentPane().add(lbldireccion);

		direccion = new JTextField();
		direccion.setEnabled(false);
		direccion.setColumns(10);
		direccion.setBounds(519, 58, 354, 28);
		getContentPane().add(direccion);

		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblTelefono.setForeground(new Color(255, 255, 255));
		lblTelefono.setBounds(234, 104, 55, 16);
		getContentPane().add(lblTelefono);

		telefono = new JTextField();
		telefono.setEnabled(false);
		telefono.setColumns(10);
		telefono.setBounds(316, 98, 129, 28);
		getContentPane().add(telefono);

		final JCheckBox delivery = new JCheckBox("Delivery");
		delivery.setFont(new Font("SansSerif", Font.BOLD, 12));
		delivery.setForeground(Color.WHITE);
		delivery.setBounds(519, 103, 122, 18);
		getContentPane().add(delivery);

		producto = new JTextField();
		producto.setColumns(10);
		producto.setBounds(93, 138, 354, 28);
		getContentPane().add(producto);

		precio = new JTextField();
		precio.setHorizontalAlignment(SwingConstants.CENTER);
		precio.setEnabled(false);
		precio.setColumns(10);
		precio.setBounds(519, 138, 74, 28);
		getContentPane().add(precio);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPrecio.setForeground(new Color(255, 255, 255));
		lblPrecio.setBounds(452, 144, 38, 16);
		getContentPane().add(lblPrecio);

		// Defino la tabla de detalle y sus campos
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 191, 847, 248);
		getContentPane().add(scrollPane);
		final JTable tabdet = new JTable();
		final DefaultTableModel datostabla = new DefaultTableModel();

		String[] columna = new String[] { "Cod", "Producto", "Cant.", "Precio",
				"Tot.linea", "Observacion" };
		datostabla.setColumnIdentifiers(columna);
		tabdet.setModel(datostabla);
		scrollPane.setViewportView(tabdet);

		tabdet.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if (tabdet.getValueAt(tabdet.getSelectedRow(), 2) != null
						&& tabdet.getValueAt(tabdet.getSelectedRow(), 3) != null) {
					cantidad = Integer.valueOf(String.valueOf(tabdet
							.getValueAt(tabdet.getSelectedRow(), 2)));
					precioUnitario = Double.valueOf(String.valueOf(tabdet
							.getValueAt(tabdet.getSelectedRow(), 3)));

					totalLinea = cantidad * precioUnitario;

					tabdet.setValueAt(totalLinea, tabdet.getSelectedRow(), 4);

					totalPedido = 0.0;
					for (int i = 0; i < datostabla.getRowCount(); i++) {

						totalPedido = totalPedido
								+ Double.valueOf(String.valueOf(tabdet
										.getValueAt(i, 4)));

					}
					total.setText(String.valueOf(totalPedido));
				}

			}
		});

		// Agregar producto al pedido
		btnAgregarproducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// verifico primero si no esta el item cargado ya
				int repetido = 0;
				int fila = 0;
				for (int j = 0; j < tabdet.getRowCount(); j++) {

					if (tabdet.getValueAt(j, 0).equals(
							productoSeleccionado.getIdProducto())) {

						repetido = 1;
						fila = j;
					}

				}
				// Cargo el item nuevo
				if (repetido == 0) {
					datostabla.addRow(new Object[] {

					productoSeleccionado.getIdProducto(),
							productoSeleccionado.getNombre(), 1,
							productoSeleccionado.getPrecio(), null, null });

				} else if (repetido == 1) {
					Integer valorAnterior = 0;
					valorAnterior = Integer.valueOf(String.valueOf(tabdet
							.getValueAt(fila, 2))) + 1;
					datostabla.setValueAt(valorAnterior, fila, 2);
				}
				// Actualizo el total

				for (int l = 0; l < tabdet.getRowCount(); l++) {

					totalLinea = Integer.valueOf(String.valueOf(tabdet
							.getValueAt(l, 2)))
							* Double.valueOf(String.valueOf(tabdet.getValueAt(
									l, 3)));
					tabdet.setValueAt(totalLinea, l, 4);

				}
				totalPedido = 0.0;
				for (int i = 0; i < datostabla.getRowCount(); i++) {

					totalPedido = totalPedido
							+ Double.valueOf(String.valueOf(tabdet.getValueAt(
									i, 4)));

				}
				total.setText(String.valueOf(totalPedido));
			}
		});

		// Cargo las busquedas

		final TextAutoCompleter clientes = new TextAutoCompleter(cliente);
		for (int i = 0; i < Pizzeria.devuelveClientes().size(); i++) {

			clientes.addItem(Pizzeria.devuelveClientes().get(i));

		}

		final TextAutoCompleter productos = new TextAutoCompleter(producto);
		for (int i = 0; i < Pizzeria.devuelveProductos().size(); i++) {

			productos.addItem(Pizzeria.devuelveProductos().get(i));
		}

		// Defino la fecha del dia
		fechaPedido.setText(Basededatos.dateToMySQLDate2(new Date()));

		JLabel lblTot = new JLabel("Total:");
		lblTot.setForeground(Color.WHITE);
		lblTot.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblTot.setBounds(716, 462, 38, 16);
		getContentPane().add(lblTot);

		total = new JTextField();
		total.setHorizontalAlignment(SwingConstants.CENTER);
		total.setEnabled(false);
		total.setColumns(10);
		total.setBounds(769, 456, 104, 28);
		getContentPane().add(total);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(26, 462, 90, 28);
		getContentPane().add(btnConfirmar);

		JButton btnNuevoPedido = new JButton("Nuevo Pedido");
		btnNuevoPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cliente.setEnabled(true);
				cliente.setText("");
				producto.setEnabled(true);
				producto.setText("");
				pedido.setText("");
				dni.setText("");
				precio.setText("");
				direccion.setText("");
				delivery.setEnabled(true);
				delivery.setSelected(false);
				tabdet.setEnabled(true);
				for (int i = 0; i < tabdet.getRowCount(); i++) {
					datostabla.removeRow(i);
				}
			}
		});
		btnNuevoPedido.setBounds(733, 18, 140, 28);
		getContentPane().add(btnNuevoPedido);

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

				if (!tabdet.isEditing()) {
					if (tabdet.editCellAt(tabdet.getSelectedRow(), 2)) {

						if (tabdet.getValueAt(tabdet.getSelectedRow(), 2) != null
								&& tabdet
										.getValueAt(tabdet.getSelectedRow(), 2)
										.equals("") == false) {

							cantidad = Integer.valueOf(String.valueOf(tabdet
									.getValueAt(tabdet.getSelectedRow(), 2)));
							precioUnitario = Double.valueOf(String
									.valueOf(tabdet.getValueAt(
											tabdet.getSelectedRow(), 3)));

							totalLinea = cantidad * precioUnitario;

							tabdet.setValueAt(totalLinea,
									tabdet.getSelectedRow(), 4);

						}

						totalPedido = 0.0;

						for (int i = 0; i < datostabla.getRowCount(); i++) {

							totalPedido = totalPedido
									+ Double.valueOf(String.valueOf(tabdet
											.getValueAt(i, 4)));

						}
						total.setText(String.valueOf(totalPedido));

					}
				}
			}

		});

		// Eliminar fila de la tabla
		btnEliminarproducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				datostabla.removeRow(tabdet.getSelectedRow());
				totalPedido = 0.0;

				for (int i = 0; i < datostabla.getRowCount(); i++) {

					totalPedido = totalPedido
							+ Double.valueOf(String.valueOf(tabdet.getValueAt(
									i, 4)));

				}

				total.setText(String.valueOf(totalPedido));
			}

		});
		// Doy ingreso al pedido
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Obtengo el numero de pedido
				Integer numeroPedido;
				numeroPedido = Pizzeria.dameNumeroPedido();
				pedido.setText(String.valueOf(numeroPedido));
				// Armo el encabezado del pedido
				pedidoActivo = new Pedido(pedido.getText(),
						clienteSeleccionado, fechaPedido.getText(), 0.0);
				boolean entregaADomicilio = delivery.isSelected();
				int valorEntrega = 0;
				if (entregaADomicilio == true) {
					valorEntrega = 1;
				} else if (entregaADomicilio == false) {
					valorEntrega = 0;
				}

				try {
					// Inserto los datos
					Basededatos.ejecutarsql("INSERT INTO pedido (NumeroPedido,Cliente,FechaPedido,TotalPedido,Preparado,Pagado,Adomicilio) VALUES ('"
							+ pedidoActivo.getNumeroPedido()
							+ "', '"
							+ pedidoActivo.getClientePedido().getIdCliente()
							+ "', '"
							+ pedidoActivo.getFechaPedido()
							+ "' , '"
							+ total.getText()
							+ "' , '"
							+ 0
							+ "','"
							+ 0
							+ "','"
							+ valorEntrega + "' )");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String numeroPed = null;
				try {
					numeroPed = Busqueda.buscaUnValor(
							Busqueda.devuelveTabla("pedido"), "NumeroPedido",
							pedidoActivo.getNumeroPedido(), "IDPedido");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (int k = 0; k < tabdet.getRowCount(); k++) {

					try {

						Basededatos
								.ejecutarsql("INSERT INTO detallepedido (IDPedido,NumeroPedido,IDProducto,Cantidad,Observacion) VALUES ('"
										+ numeroPed
										+ "', '"
										+ pedidoActivo.getNumeroPedido()
										+ "', '"
										+ tabdet.getValueAt(k, 0)
										+ "' , '"
										+ tabdet.getValueAt(k, 2)
										+ "' , '"
										+ tabdet.getValueAt(k, 5)
										+ "')");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				cliente.setEnabled(false);
				producto.setEnabled(false);
				tabdet.setEnabled(false);
				delivery.setEnabled(false);
				System.out.println(pedidoActivo.getIdPedido());
				Pizzeria.abrirReporte(
						"C:\\Users\\gablopez\\Desktop\\Gustavo\\backup\\servidor\\pizzeria\\src\\ticket.jasper",
						Integer.valueOf(numeroPed), "NumPedido");

			}
			// aca termina el ingreso

		});
		// aca termina la clase
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}
}
