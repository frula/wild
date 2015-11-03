package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import datos.BackUP;

public class MenuPrincipal extends JFrame implements ActionListener {

	private JMenuBar mb;
	private JMenu menu1, menu2, menu3;
	private JMenuItem mi1, mi3;
	private JTextField ultimaRestauracion;
	private JTextField ultimoBackup;
	private Cocina formCocina;
	private JButton btnCliente;
	private JButton btnPedidos;

	public MenuPrincipal() {

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
		}

		// Creo el formulario de pedidos
		formCocina = new Cocina();

		// Tamaño inicial de ventana
		this.setSize(440, 247);
		getContentPane().setLayout(null);

		JButton btnPedido = new JButton("Pedido");
		btnPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				FormPedido formPedidos = new FormPedido();
				formPedidos.setVisible(true);

			}
		});
		btnPedido.setBounds(22, 33, 90, 28);
		getContentPane().add(btnPedido);

		btnCliente = new JButton("Clientes");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ABMcliente clientes = new ABMcliente();
				clientes.setVisible(true);
			}
		});
		btnCliente.setBounds(308, 33, 90, 28);
		getContentPane().add(btnCliente);

		JButton btnMateriasPrimas = new JButton("Materias Primas");
		btnMateriasPrimas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormMatPrima matPrimas = new FormMatPrima(
						new javax.swing.JFrame(), true);
				matPrimas.setVisible(true);
			}
		});
		btnMateriasPrimas.setBounds(148, 33, 125, 28);
		getContentPane().add(btnMateriasPrimas);

		btnPedidos = new JButton("Pedidos");
		btnPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Pedidos formularioPedidos = new Pedidos(
						new javax.swing.JFrame(), true);
				formularioPedidos.setVisible(true);
			}
		});
		btnPedidos.setBounds(22, 85, 90, 28);
		getContentPane().add(btnPedidos);
		
		JButton btnProductos = new JButton("Productos");
		btnProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Productos formularioProductos = new Productos();
				formularioProductos.setVisible(true);
			
			}
		});
		btnProductos.setBounds(148, 85, 125, 28);
		getContentPane().add(btnProductos);
		
		JButton btnCombos = new JButton("Combos");
		btnCombos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				Combos formularioCombo = new Combos();
				formularioCombo.setVisible(true);
			}
		});
		btnCombos.setBounds(308, 85, 90, 28);
		getContentPane().add(btnCombos);
		
		JButton btnProveedores = new JButton("Proveedores");
		btnProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				proveedores formularioProveedores = new proveedores(
						new javax.swing.JFrame(), true);
				formularioProveedores.setVisible(true);
			}
		});
		btnProveedores.setBounds(22, 134, 90, 28);
		getContentPane().add(btnProveedores);

		// Creo el menu contenedor
		mb = new JMenuBar();
		setJMenuBar(mb);

		// Creo el menu principal
		menu1 = new JMenu("Opciones de Sistema");
		mb.add(menu1);

		// Creo y agrego los submenus
		menu2 = new JMenu("Backup");
		menu2.addActionListener(this);
		menu1.add(menu2);
		ultimoBackup = new JTextField();
		ultimoBackup.setEnabled(false);
		menu2.add(ultimoBackup);
		ultimoBackup.setColumns(10);
		menu3 = new JMenu("Restaurar");
		menu3.addActionListener(this);
		menu1.add(menu3);

		ultimaRestauracion = new JTextField();
		ultimaRestauracion.setEnabled(false);
		menu3.add(ultimaRestauracion);
		ultimaRestauracion.setColumns(10);

		// Agrego opciones a los submenus
		mi1 = new JMenuItem("Realizar nuevo Backup");
		menu2.add(mi1);
		mi1.addActionListener(this);
		mi3 = new JMenuItem("Restaurar Sistema");
		menu3.add(mi3);
		mi3.addActionListener(this);

	}

	// Capturo los eventos de las opciones
	public void actionPerformed(ActionEvent e) {
		int respuesta;
		// Accion de backup
		if (e.getSource() == mi1) {

			respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro?",
					"Alerta!", JOptionPane.YES_NO_OPTION);

			if (respuesta == 0) {
				BackUP c = new BackUP();
				c.generarBackUp("c:\\backupPrueba.sql");
				JOptionPane.showMessageDialog(null,
						"Operación realizada correctamente");
			} else
				JOptionPane.showMessageDialog(null, "Operación cancelada");

		}
		// Accion de restauracion
		if (e.getSource() == mi3) {
			respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro?",
					"Alerta!", JOptionPane.YES_NO_OPTION);
			if (respuesta == 0) {
				BackUP c = new BackUP();
				c.restaurarBackUp("c:\\backupPrueba.sql");
				JOptionPane.showMessageDialog(null,
						"Operación realizada correctamente");

			} else
				JOptionPane.showMessageDialog(null, "Operación cancelada");
		}

	}
}