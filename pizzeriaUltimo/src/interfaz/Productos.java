package interfaz;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import negocio.Producto;
import com.mxrck.autocompleter.TextAutoCompleter;
import datos.Pizzeria;

//import com.mxrck.autocompleter.TextAutoCompleter;

public class Productos {

	private JFrame frmProductos;
	private JTextField producto;
	private JTextField precio;
	private JButton btnNewButton_2;
	private JButton btnNewButton_4;
	private Producto productoEncontrado;
	private JLabel lblEstado;
	private JButton btnNewButton_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Productos window = new Productos();
					window.frmProductos.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Productos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		// Defino el estilo
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) {
		}
		frmProductos = new JFrame();
		frmProductos.setResizable(false);
		frmProductos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmProductos.setTitle("Productos");
		frmProductos.setBounds(100, 100, 434, 257);
		frmProductos.getContentPane().setLayout(null);
		productoEncontrado = new Producto();
		final JComboBox Cat = new JComboBox();
		Cat.setToolTipText("");
		Cat.setBounds(283, 86, 125, 24);
		frmProductos.getContentPane().add(Cat);
		Cat.addItem("ELABORADO");
		Cat.addItem("LISTO");
		JLabel lblDescripcion = new JLabel("Producto:");
		lblDescripcion.setBounds(24, 53, 71, 14);
		frmProductos.getContentPane().add(lblDescripcion);

		producto = new JTextField();
		producto.setBounds(104, 50, 304, 24);
		frmProductos.getContentPane().add(producto);
		producto.setColumns(10);

		// Cargo las busquedas

		final TextAutoCompleter productos = new TextAutoCompleter(producto);
		for (int i = 0; i < Pizzeria.devuelveProductos().size(); i++) {

			productos.addItem(Pizzeria.devuelveProductos().get(i));

		}

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(24, 96, 46, 14);
		frmProductos.getContentPane().add(lblPrecio);

		precio = new JTextField();
		precio.setBounds(104, 91, 86, 24);
		frmProductos.getContentPane().add(precio);
		precio.setColumns(10);

		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// String a=textField.getText();
				// int a1=Integer.parseInt(a);
				if (producto.getText().equals("")
						|| precio.getText().equals("")) {
					JOptionPane.showMessageDialog(frmProductos,
							"No fue ingresado ningun dato", "Problemas",
							JOptionPane.WARNING_MESSAGE);
				} else {
		
					if (Producto.existeProducto(producto.getText())) {
						JOptionPane.showMessageDialog(frmProductos,
								"El producto ya existe", "Problemas",
								JOptionPane.WARNING_MESSAGE);
					} else {

						String a2 = precio.getText();
						Double a3 = Double.parseDouble(a2);

						String a4 = String.valueOf(Cat.getSelectedItem());
						String a6 = producto.getText();
						try {

							Producto.agregarProducto(a6, a3, a4, 0);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						// Basededatos.ejecutarsql("INSERT INTO producto(Producto,Precio,Categoria) VALUES(a,precio,categoria)");

					}
					producto.setText("");
					precio.setText("");
					lblEstado.setText("");
					final TextAutoCompleter productos = new TextAutoCompleter(producto);
					for (int i = 0; i < Pizzeria.devuelveProductos().size(); i++) {

						productos.addItem(Pizzeria.devuelveProductos().get(i));

					}
				}
			}
		});
		btnNewButton.setBounds(25, 184, 92, 28);
		frmProductos.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// lleno los campos
				Producto productoEncontrado = (Producto) productos.getItemSelected();
				
				if (producto.getText().toUpperCase().equals("")||productoEncontrado.getNombre()==null) {
					JOptionPane.showMessageDialog(frmProductos,
							"NO existe producto ingrese nuevamente codigo",
							"Problemas", JOptionPane.WARNING_MESSAGE);
				} else {

					producto.setText(productoEncontrado.getNombre().toUpperCase());
					precio.setText(String.valueOf(productoEncontrado.getPrecio()));
					Cat.setSelectedItem(productoEncontrado.getCategoria());

					if (productoEncontrado.getEstado() == true) {
						lblEstado.setText("Activo");
					} else if (productoEncontrado.getEstado() == false) {
						lblEstado.setText("Inactivo");
					}

					btnNewButton_2.setVisible(true);
					btnNewButton_5.setVisible(true);
				}

			}
		});
		btnNewButton_1.setBounds(309, 11, 99, 28);
		frmProductos.getContentPane().add(btnNewButton_1);

		btnNewButton_2 = new JButton("Modificar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Producto aModificar=(Producto)productos.getItemSelected();
					
					double pre = Double.valueOf(precio.getText());
					String cat = String.valueOf(Cat.getSelectedItem());
					
					Producto p1 = new Producto(producto.getText(),pre, cat,
							aModificar.getEstado());
					Producto.modificarProducto(p1,aModificar.getIdProducto());

					btnNewButton_2.setVisible(false);
					btnNewButton_5.setVisible(false);

					final TextAutoCompleter productos = new TextAutoCompleter(producto);
					for (int i = 0; i < Pizzeria.devuelveProductos().size(); i++) {

						productos.addItem(Pizzeria.devuelveProductos().get(i));

					}
				producto.setText("");
				precio.setText("");
				lblEstado.setText("");
			}
		});
		btnNewButton_2.setBounds(20, 11, 86, 28);
		frmProductos.getContentPane().add(btnNewButton_2);
		btnNewButton_2.setVisible(false);

		JButton btnNewButton_3 = new JButton("Salir");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmProductos.setVisible(false);
			}
		});
		btnNewButton_3.setBounds(322, 184, 86, 28);
		frmProductos.getContentPane().add(btnNewButton_3);

		JLabel lblNewLabel = new JLabel("Estado");
		lblNewLabel.setBounds(24, 136, 60, 14);
		frmProductos.getContentPane().add(lblNewLabel);

		btnNewButton_4 = new JButton("Aplicar");
		btnNewButton_4.setBounds(163, 11, 99, 28);
		frmProductos.getContentPane().add(btnNewButton_4);

		btnNewButton_5 = new JButton("Cambio estado");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Cargo las busquedas

				final TextAutoCompleter productos = new TextAutoCompleter(producto);
				for (int i = 0; i < Pizzeria.devuelveProductos().size(); i++) {

					productos.addItem(Pizzeria.devuelveProductos().get(i));

				}
				Producto filtrado=(Producto)productos.getItemSelected();
				Producto.cambiarEstado(filtrado.getEstado(),
						filtrado.getIdProducto());
				
				btnNewButton_5.setVisible(false);
				btnNewButton_2.setVisible(false);
				producto.setText("");
				precio.setText("");
				lblEstado.setText("");
			}
		});
		btnNewButton_5.setBounds(293, 122, 115, 28);
		frmProductos.getContentPane().add(btnNewButton_5);
		btnNewButton_5.setVisible(false);

		lblEstado = new JLabel("");
		lblEstado.setBounds(104, 131, 86, 19);
		frmProductos.getContentPane().add(lblEstado);

		JLabel label_1 = new JLabel("Categoria");
		label_1.setBounds(203, 92, 71, 14);
		frmProductos.getContentPane().add(label_1);
		btnNewButton_4.setVisible(false);

	}

	public void setVisible(boolean b) {
		frmProductos.setVisible(b);

	}
}
