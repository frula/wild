package interfaz;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import negocio.DetallePedido;
import datos.Busqueda;
import datos.Pizzeria;

public class Cocina extends JFrame implements Runnable {

	private JFrame frame;
	private Thread h1;
	private JTable pendientes;
	private JTable sumaPendientes;
	private ArrayList<DetallePedido> detallePedidos;
	private DefaultTableModel dtm;
	private DefaultTableModel dtm2;
	private ResultSet lineasSumados;
	private ArrayList<DetallePedido> lineasSumadas;

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
	//---------------calculo aca la suma----------------------------
				
				//Empiezo a calcular la suma de lo pendiente
				lineasSumados = Pizzeria.devuelveAcumulados();
				lineasSumados.previous();
				
				while (lineasSumados.next()) {
					
				//Consigo la categoria del item sumado en el que estoy parado	
				String categoria=Busqueda.buscaUnValor(Busqueda.devuelveTabla("producto"),"IDProducto",lineasSumados.getString(1),"Categoria");
				
				if(categoria.equals("ELABORADO")){	
				
					
						dtm2.addRow(new Object[] {
						lineasSumados.getString(3), lineasSumados.getInt(2)});			
					
				
				}
				sumaPendientes.setVisible(false);
				if(categoria.equals("Combo")){	
					
					for(int u=0;u<lineasSumados.getInt(2);u++){
						
						//Consigo los id de los productos del combo
					ResultSet itemsDelCombo=Busqueda.filtroATabla("detallecombo", "IDCombo", lineasSumados.getString(1));
					
					//Recorro los productos del combo
					itemsDelCombo.previous();
					while(itemsDelCombo.next()){
						
						//Obtengo el nombre del producto dentro del combo
						String desc=Busqueda.buscaUnValor(Busqueda.devuelveTabla("producto"),"IDProducto",itemsDelCombo.getString(2),"Producto");
						String cat=Busqueda.buscaUnValor(Busqueda.devuelveTabla("producto"),"IDProducto",itemsDelCombo.getString(2),"Categoria");
						if(cat.equals("ELABORADO")){
							
							dtm2.addRow(new Object[] {
								desc,itemsDelCombo.getInt(3)});
						}
					}
				}
				}
				}	
				
				/*
				//Sirve para ver los registros agregados a la tabla
				for(int o=0;o<dtm2.getRowCount();o++){
					System.out.println(dtm2.getValueAt(o, 0)+" "+dtm2.getValueAt(o, 1));	
				}
			*/
			//Hasta aca va todo bien
				
				for(int k=0;k<dtm2.getRowCount();k++){
					
					//Pongo el sumador en cero
					int suma=0;
					
					for(int w=0;w<dtm2.getRowCount();w++){
						
						if(String.valueOf(dtm2.getValueAt(k,0)).equals(String.valueOf(dtm2.getValueAt(w,0)))&& k!=w){
							
							suma=Integer.valueOf(String.valueOf(dtm2.getValueAt(k, 1)))+Integer.valueOf(String.valueOf(dtm2.getValueAt(w,1)));
							dtm2.setValueAt(suma,k,1);
							//dtm2.removeRow(w);
							dtm2.setValueAt(0, w, 1);
						}
						
					}
				
				}
				
				for(int z=0;z<dtm2.getRowCount();z++){
					
					if(String.valueOf(dtm2.getValueAt(z, 1)).equals("0")){
						dtm2.removeRow(z);
					z=z-1;
					}
				
				}
				
				sumaPendientes.setVisible(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// Aca cargo la tabla

			try {
				Thread.sleep(8000);
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
	
	public void actualizarPantalla(){ 
		SwingUtilities.updateComponentTreeUI(this); 
		this.validateTree(); 
		} 

}
