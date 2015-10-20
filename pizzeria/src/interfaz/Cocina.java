package interfaz;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import negocio.DetallePedido;
import datos.Pizzeria;

public class Cocina implements Runnable {

	private JFrame frame;
	private Thread h1;
	private JTable pendientes;
	private JTable sumaPendientes;
	private ArrayList<DetallePedido> detallePedidos;
	private DefaultTableModel dtm;
	private DefaultTableModel dtm2;
	private ResultSet lineasSumados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cocina window = new Cocina();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cocina() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 731, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(2, 2, 0, 0));
		JScrollPane scrollPane_1 = new JScrollPane();
		frame.getContentPane().add(scrollPane_1);

		dtm = new DefaultTableModel();
		pendientes = new JTable(dtm);

		// Agrego las filas a la tabla de pendientes
		dtm.addColumn("Pedido");
		dtm.addColumn("Producto");
		dtm.addColumn("Cant.");
		dtm.addColumn("Observacion");

		// Ajusto los anchos de las columnas
		pendientes.getColumnModel().getColumn(0).setPreferredWidth(100);
		pendientes.getColumnModel().getColumn(1).setPreferredWidth(300);
		pendientes.getColumnModel().getColumn(2).setPreferredWidth(50);
		pendientes.getColumnModel().getColumn(3).setPreferredWidth(300);
		scrollPane_1.setViewportView(pendientes);

		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane);

		dtm2 = new DefaultTableModel();
		sumaPendientes = new JTable(dtm2);

		// Agrego las filas a la tabla de sumaPendientes
		dtm2.addColumn("Producto");
		dtm2.addColumn("Cant. Total");
		// Ajusto los anchos de las columnas
		sumaPendientes.getColumnModel().getColumn(0).setPreferredWidth(400);
		sumaPendientes.getColumnModel().getColumn(1).setPreferredWidth(90);

		scrollPane.setViewportView(sumaPendientes);
		TableColumnModel columnModel = sumaPendientes.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(600);

		frame.setVisible(true);
		h1 = new Thread(this);
		h1.start();

	}

	@Override
	public void run() {

		Thread ct = Thread.currentThread();
		while (ct == h1) {
			detallePedidos = null;
			lineasSumados = null;
			// Cargo la lista de los no preparados

			try {

				detallePedidos = Pizzeria.devuelveNoPreparados();

				for (int i = 0; i < detallePedidos.size(); i++) {

					dtm.addRow(new Object[] {

					detallePedidos.get(i).getNumeroPedido(),
							detallePedidos.get(i).getProducto().getNombre(),
							detallePedidos.get(i).getCantidad(),
							detallePedidos.get(i).getObservacion() });

				}
				lineasSumados = Pizzeria.devuelveAcumulados();
				lineasSumados.previous();
				while (lineasSumados.next()) {
					dtm2.addRow(new Object[] {

					lineasSumados.getString(3), lineasSumados.getInt(2) });

				}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// Aca cargo la tabla

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			}

			int cantFilas = dtm.getRowCount();
			int cantFilasSumadas = dtm2.getRowCount();

			for (int j = 0; j < cantFilas; j++) {
				dtm.removeRow(0);
			}
			for (int h = 0; h < cantFilasSumadas; h++) {
				dtm2.removeRow(0);
			}
		}

	}
}
