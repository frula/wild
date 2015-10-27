package interfaz;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import negocio.Combo;
import negocio.DetalleCombo;
import negocio.Producto;

import com.mxrck.autocompleter.TextAutoCompleter;

import datos.Basededatos;
import datos.Busqueda;
import datos.Pizzeria;

public class Combos {

	private JFrame frmCombos;
	private JTable table;
	private JTextField precio;
	private JTextField cant;
	private int cantidad;
	private JTextField combo;
	private Producto comboSeleccionado;
	private JButton btnNewButton;
	private JTextField proAAgregar;
	private ArrayList<DetalleCombo> detalleDeComboSeleccionado;
	private JTextField observacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Combos window = new Combos();
					window.frmCombos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Combos() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}
		cantidad = 0;
		frmCombos = new JFrame();
		frmCombos.setResizable(false);
		frmCombos.setTitle("Combos");
		frmCombos.setBounds(100, 100, 571, 332);
		frmCombos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCombos.getContentPane().setLayout(null);
		combo = new JTextField();
		combo.setBounds(84, 21, 344, 21);
		frmCombos.getContentPane().add(combo);
		combo.setColumns(10);
		proAAgregar = new JTextField();
		proAAgregar.setBounds(115, 111, 313, 20);
		frmCombos.getContentPane().add(proAAgregar);
		proAAgregar.setColumns(10);

		// Cargo los productos con los productos

		final TextAutoCompleter proAElegir = new TextAutoCompleter(proAAgregar);
		for (int i = 0; i < Pizzeria.devuelveProductos().size(); i++) {

			proAElegir.addItem(Pizzeria.devuelveProductos().get(i));
		}

		JLabel lblCombo = new JLabel("Combo");
		lblCombo.setBounds(10, 21, 46, 21);
		frmCombos.getContentPane().add(lblCombo);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(441, 20, 112, 23);
		frmCombos.getContentPane().add(btnBuscar);

		JLabel lblSeleccioneProducto = new JLabel("Seleccione producto");
		lblSeleccioneProducto.setBounds(10, 114, 99, 14);
		frmCombos.getContentPane().add(lblSeleccioneProducto);

		// Cargo los combos para las busquedas
		final TextAutoCompleter combos = new TextAutoCompleter(combo);
		for (int i = 0; i < Pizzeria.devuelvecombos().size(); i++) {

			combos.addItem(Pizzeria.devuelvecombos().get(i));
		}

		// Creo el panel contenedor
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 143, 418, 119);
		// Creo la tabla
		table = new JTable();
		scrollPane.setViewportView(table);
		// Creo el modelo para la tabla
		final DefaultTableModel productos = new DefaultTableModel();
		productos.addColumn("Producto");
		productos.addColumn("Cantidad");
		productos.addColumn("Precio");
		table.setModel(productos);

		// Agrego un nuevo item a la tabla
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (proAAgregar.getText() != null
						&& proAAgregar.getText().equals("") == false) {

					Producto proSeleccionado = (Producto) proAElegir
							.getItemSelected();
					String cantidad = cant.getText();
					String descripcion = proSeleccionado.getNombre();
					String precioSelec = String.valueOf(proSeleccionado
							.getPrecio());

					if (cant.getText() != null
							&& cant.getText().equals("") == false
							&& combo.getText() != null
							&& combo.getText().equals("") == false) {

						// verifico primero si no esta el item cargado ya
						int repetido = 0;
						int fila = 0;
						for (int j = 0; j < table.getRowCount(); j++) {

							if (table.getValueAt(j, 0).equals(
									proSeleccionado.getNombre())) {

								repetido = 1;
								fila = j;
							}

						}
						// Cargo el item nuevo
						if (repetido == 0) {
							productos.addRow(new Object[] { descripcion,
									cantidad, precioSelec });
						} else if (repetido == 1) {
							Integer valorAnterior = 0;
							valorAnterior = Integer.valueOf(String
									.valueOf(table.getValueAt(fila, 1)))
									+ Integer.valueOf(cant.getText());
							productos.setValueAt(valorAnterior, fila, 1);
						}

					}
				}
				cant.setText("");
				proAAgregar.setText("");
			}

		});
		btnAgregar.setBounds(10, 80, 89, 23);
		frmCombos.getContentPane().add(btnAgregar);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Borro los datos viejos

				try {
					Basededatos.ejecutarsql("DELETE FROM producto WHERE IDProducto="
							+ comboSeleccionado.getIdProducto());
					Basededatos
							.ejecutarsql("DELETE FROM detallecombo WHERE IDCombo="
									+ comboSeleccionado.getIdProducto());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Cargo los datos nuevos

				try {
					// Cargo el encabezado

					Basededatos
							.ejecutarsql("INSERT INTO producto (Producto,Precio,Categoria,Estado) VALUES ('"
									+ combo.getText()
									+ "', '"
									+ precio.getText()
									+ "', '"
									+ "Combo"
									+ "' , '"
									+ 0
									+ "' )");

					// Cargo el detalle

					String idProducPrincipal = Busqueda.buscaUnValor(
							Busqueda.devuelveTabla("producto"), "Producto",
							combo.getText(),
							"IDProducto");
					
					for (int r = 0; r < productos.getRowCount(); r++) {

						String idProduc = Busqueda.buscaUnValor(
								Busqueda.devuelveTabla("producto"), "Producto",
								String.valueOf(table.getValueAt(r, 0)),
								"IDProducto");

						Basededatos
								.ejecutarsql("INSERT INTO detallecombo (IDCombo,Producto,Cantidad) VALUES ('"
										+ idProducPrincipal
										+ "', '"
										+ idProduc
										+ "', '"
										+ table.getValueAt(r, 1)
										+ "')");

					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (int i = 0; i < productos.getRowCount(); i++) {
					productos.removeRow(i);
				}
				for (int j = 0; j < productos.getRowCount(); j++) {
					productos.removeRow(j);
				}
				combo.setText("");
				observacion.setText("");
				precio.setText("");
				proAAgregar.setText("");
				cant.setText("");
				// Cargo los combos para las busquedas
				final TextAutoCompleter combos = new TextAutoCompleter(combo);
				for (int i = 0; i < Pizzeria.devuelvecombos().size(); i++) {

					combos.addItem(Pizzeria.devuelvecombos().get(i));
				}
			}

		});
		btnModificar.setBounds(441, 110, 112, 23);
		frmCombos.getContentPane().add(btnModificar);

		btnNewButton = new JButton("Nuevo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			combo.setText("");
			precio.setText("");
			cant.setText("");
			proAAgregar.setText("");
			observacion.setText("");
			for (int i = 0; i < productos.getRowCount(); i++) {
				productos.removeRow(i);
			}
			for (int j = 0; j < productos.getRowCount(); j++) {
				productos.removeRow(j);
			}
			}
		});
		btnNewButton.setBounds(441, 47, 112, 23);
		frmCombos.getContentPane().add(btnNewButton);

		precio = new JTextField();
		precio.setBounds(76, 273, 86, 20);
		frmCombos.getContentPane().add(precio);
		precio.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 273, 60, 20);
		frmCombos.getContentPane().add(lblPrecio);
		frmCombos.getContentPane().add(scrollPane);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(236, 84, 60, 14);
		frmCombos.getContentPane().add(lblCantidad);

		cant = new JTextField();
		cant.setBounds(316, 81, 89, 20);
		frmCombos.getContentPane().add(cant);
		cant.setColumns(10);

		JButton btnQuitar = new JButton("Quitar");
		btnQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				productos.removeRow(table.getSelectedRow());
			}
		});
		btnQuitar.setBounds(117, 80, 99, 23);
		frmCombos.getContentPane().add(btnQuitar);

		JLabel lblObservacion = new JLabel("Observacion");
		lblObservacion.setBounds(10, 48, 65, 21);
		frmCombos.getContentPane().add(lblObservacion);

		observacion = new JTextField();
		observacion.setColumns(10);
		observacion.setBounds(84, 48, 344, 21);
		frmCombos.getContentPane().add(observacion);
		
		JButton ingresar = new JButton("Ingresar");
		ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Cargo el encabezado

				try {
					if(combo.getText()!=null&&combo.getText().equals("")==false&&
							precio.getText()!=null&&precio.getText().equals("")==false&&
							productos.getRowCount()>0){
					Basededatos
							.ejecutarsql("INSERT INTO producto (Producto,Precio,Categoria,Estado) VALUES ('"
									+ combo.getText()
									+ "', '"
									+ precio.getText()
									+ "', '"
									+ "Combo"
									+ "' , '"
									+ 0
									+ "' )");
					// Cargo el detalle

					for (int r = 0; r < productos.getRowCount(); r++) {

						String idProduc = Busqueda.buscaUnValor(
								Busqueda.devuelveTabla("producto"), "Producto",
								combo.getText(),
								"IDProducto");
						String idProducDeCombo = Busqueda.buscaUnValor(
								Busqueda.devuelveTabla("producto"), "Producto",
								String.valueOf(table.getValueAt(r,0)),
								"IDProducto");
						Basededatos
								.ejecutarsql("INSERT INTO detallecombo (IDCombo,Producto,Cantidad) VALUES ('"
										+ idProduc
										+ "', '"
										+ idProducDeCombo
										+ "', '"
										+ table.getValueAt(r, 1)
										+ "')");

					}
				combo.setText("");
				observacion.setText("");
				precio.setText("");
				proAAgregar.setText("");
				cant.setText("");
				for (int i = 0; i < productos.getRowCount(); i++) {
					productos.removeRow(i);
				}
				for (int j = 0; j < productos.getRowCount(); j++) {
					productos.removeRow(j);
				}	
					}
					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		});
		ingresar.setBounds(441, 270, 112, 23);
		frmCombos.getContentPane().add(ingresar);

		// Mando la opcion de buscar
		btnBuscar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// Cargo los combos para las busquedas
				final TextAutoCompleter combos = new TextAutoCompleter(combo);
				for (int i = 0; i < Pizzeria.devuelvecombos().size(); i++) {

					combos.addItem(Pizzeria.devuelvecombos().get(i));
				}
				// lleno los campos
				comboSeleccionado = (Producto) combos.getItemSelected();
				
				detalleDeComboSeleccionado = Pizzeria
						.devuelvedetallecombo(comboSeleccionado.getIdProducto());
			
				if (comboSeleccionado != null) {
					precio.setText(String.valueOf(comboSeleccionado
							.getPrecio()));

					for (int j = 0; j < detalleDeComboSeleccionado.size(); j++) {
						String descProducto = null;
						try {
							descProducto = Busqueda.buscaUnValor(Busqueda
									.devuelveTabla("producto"), "IDProducto",
									String.valueOf(detalleDeComboSeleccionado
											.get(j).getProducto()), "Producto");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						String precioDeProducto = null;
						try {
							precioDeProducto = Busqueda.buscaUnValor(Busqueda
									.devuelveTabla("producto"), "IDProducto",
									String.valueOf(detalleDeComboSeleccionado
											.get(j).getProducto()), "Precio");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						productos.addRow(new Object[] {
								descProducto,
								String.valueOf(detalleDeComboSeleccionado
										.get(j).getCantidad()),
								precioDeProducto });

					}
				}
			}
		});
		// Completo los campos con el combo seleccionado
		combo.getDocument().addDocumentListener(
				new javax.swing.event.DocumentListener() {

					public void insertUpdate(javax.swing.event.DocumentEvent evt) {

					}

					public void removeUpdate(javax.swing.event.DocumentEvent evt) {
						// limpio al cambiar

					}

					public void changedUpdate(
							javax.swing.event.DocumentEvent evt) {

					}

				});
	}

	public void setVisible(boolean b) {
		frmCombos.setVisible(b);

	}
}
