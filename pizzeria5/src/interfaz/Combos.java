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

import datos.Busqueda;
import datos.Pizzeria;

public class Combos {

	private JFrame frmCombos;
	private JTable table;
	private JTextField precio;
	private ArrayList listaProductos;
	private ArrayList listaCantidades;
	private JTextField cant;
	private int cantidad;
	private JTextField combo;
	private JLabel lblNewLabel_1;
	private Combo comboSeleccionado;
	private Combo nuevo;
	private JButton btnEstado_1;
	private JButton btnNewButton;
	private JTextField proAAgregar;

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
		frmCombos.setBounds(100, 100, 571, 300);
		frmCombos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCombos.getContentPane().setLayout(null);
		combo = new JTextField();
		combo.setBounds(66, 21, 362, 21);
		frmCombos.getContentPane().add(combo);
		combo.setColumns(10);
		proAAgregar = new JTextField();
		proAAgregar.setBounds(115, 92, 313, 20);
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
		btnBuscar.setBounds(441, 106, 112, 23);
		frmCombos.getContentPane().add(btnBuscar);

		JLabel lblSeleccioneProducto = new JLabel("Seleccione producto");
		lblSeleccioneProducto.setBounds(10, 95, 99, 14);
		frmCombos.getContentPane().add(lblSeleccioneProducto);

		// Cargo los combos para las busquedas
		final TextAutoCompleter combos = new TextAutoCompleter(combo);
		for (int i = 0; i < Pizzeria.devuelvecombos().size(); i++) {

			combos.addItem(Pizzeria.devuelvecombos().get(i));
		}

		// Creo el panel contenedor
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 124, 418, 98);
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
				
				if(proAAgregar.getText()!=null && proAAgregar.getText().equals("")==false){
				Producto proSeleccionado = (Producto) proAElegir
						.getItemSelected();
				String cantidad = cant.getText();
				String descripcion = proSeleccionado.getNombre();
				String precioSelec = String.valueOf(proSeleccionado.getPrecio());
				
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
						productos.addRow(new Object[] { descripcion, cantidad,
								precioSelec });
					} else if (repetido == 1) {
						Integer valorAnterior = 0;
						valorAnterior = Integer.valueOf(String.valueOf(table
								.getValueAt(fila, 1)))
								+ Integer.valueOf(cant.getText());
						productos.setValueAt(valorAnterior, fila, 1);
					}

				}
				}
				cant.setText("");
			proAAgregar.setText("");
			}

		});
		btnAgregar.setBounds(10, 61, 89, 23);
		frmCombos.getContentPane().add(btnAgregar);

		JButton btnAplicar = new JButton("Aplicar");
		btnAplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnAplicar.setBounds(441, 230, 112, 23);
		frmCombos.getContentPane().add(btnAplicar);

		btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(441, 61, 112, 23);
		btnNewButton.setVisible(false);
		frmCombos.getContentPane().add(btnNewButton);

		precio = new JTextField();
		precio.setBounds(90, 231, 86, 20);
		frmCombos.getContentPane().add(precio);
		precio.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(24, 231, 60, 20);
		frmCombos.getContentPane().add(lblPrecio);
		frmCombos.getContentPane().add(scrollPane);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(236, 65, 60, 14);
		frmCombos.getContentPane().add(lblCantidad);

		cant = new JTextField();
		cant.setBounds(316, 62, 89, 20);
		frmCombos.getContentPane().add(cant);
		cant.setColumns(10);

		btnEstado_1 = new JButton("cambiar estado");
		btnEstado_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnEstado_1.setBounds(441, 20, 112, 23);
		btnEstado_1.setVisible(false);
		frmCombos.getContentPane().add(btnEstado_1);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(236, 234, 46, 14);
		frmCombos.getContentPane().add(lblEstado);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(306, 234, 73, 14);
		frmCombos.getContentPane().add(lblNewLabel_1);

		JButton btnQuitar = new JButton("Quitar");
		btnQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				productos.removeRow(table.getSelectedRow());
			}
		});
		btnQuitar.setBounds(117, 61, 99, 23);
		frmCombos.getContentPane().add(btnQuitar);

		// Mando la opcion de buscar
		btnBuscar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// lleno los campos
				comboSeleccionado = (Combo) combos.getItemSelected();
				ArrayList<DetalleCombo> detalleDeComboSeleccionado = Pizzeria
						.devuelvedetallecombo(comboSeleccionado.getIdCombo());

				if (comboSeleccionado != null) {
					precio.setText(String.valueOf(comboSeleccionado
							.getPrecioCombo()));
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
