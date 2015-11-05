package interfaz;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import negocio.Categoria2;
import negocio.Compra;
import negocio.DetalleCombo;
import negocio.DetalleCompra;
import negocio.MateriaPrima;
import negocio.Producto;
import negocio.Proveedor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class interfazCompra {

	private static JFrame frmCompra;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
    private JLabel lblNewLabel_2; 
    private JLabel label;
    private JComboBox comboBox; 
    private JComboBox comboBox_1;
    private ArrayList listaProductos;
    private ArrayList listaCantidades;
    private JTextField textField_1;
    private JButton btnNewButton_2;
    private int numeroCompra;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazCompra window = new interfazCompra();
					window.frmCompra.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public interfazCompra() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		listaProductos=new ArrayList();
		listaCantidades=new ArrayList();
		//detCompra=new ArrayList();
		frmCompra = new JFrame();
		frmCompra.setTitle("Compra");
		frmCompra.setBounds(100, 100, 450, 300);
		frmCompra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCompra.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("N\u00B0");
		lblNewLabel.setBounds(20, 11, 31, 14);
		frmCompra.getContentPane().add(lblNewLabel);
		
		JLabel lblProveedor = new JLabel("Proveedor");
		lblProveedor.setBounds(20, 36, 83, 14);
		frmCompra.getContentPane().add(lblProveedor);
		
		comboBox = new JComboBox();
		comboBox.setBounds(104, 33, 88, 20);
		frmCompra.getContentPane().add(comboBox);
		
		// lleno combobox proveedores
		ArrayList proveedores=Proveedor.dameProveedores(); 
		int i=0;
		while(i<proveedores.size()){
			comboBox.addItem(proveedores.get(i));
			i++;
		}
		
		
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(20, 61, 46, 14);
		frmCompra.getContentPane().add(lblNombre);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(104, 61, 88, 14);
		frmCompra.getContentPane().add(lblNewLabel_2);
		
		JLabel lblTel = new JLabel("Tel");
		lblTel.setBounds(20, 86, 46, 14);
		frmCompra.getContentPane().add(lblTel);
		
		label = new JLabel("");
		label.setBounds(104, 86, 88, 14);
		frmCompra.getContentPane().add(label);
		
		JLabel lblMateriaPrima = new JLabel("Materia Prima");
		lblMateriaPrima.setBounds(20, 116, 83, 14);
		frmCompra.getContentPane().add(lblMateriaPrima);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(104, 111, 88, 20);
		frmCompra.getContentPane().add(comboBox_1);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(223, 116, 66, 14);
		frmCompra.getContentPane().add(lblCantidad);
		
		textField = new JTextField();
		textField.setBounds(299, 113, 77, 19);
		frmCompra.getContentPane().add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		table.setBounds(61, 214, 272, -59);
		frmCompra.getContentPane().add(table);
		// Creo el modelo para la tabla
				final DefaultTableModel compra = new DefaultTableModel();
				compra.addColumn("Producto");
				compra.addColumn("Cantidad");
		
				table_1 = new JTable();
				
		JButton btnGuardar = new JButton("Guardar");
		
		
		
		  
		  btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				final DefaultTableModel c= new DefaultTableModel();
				  c.addColumn("Producto");
				  c.addColumn("Cantidad");
				  table_1.setModel(c);
				
				ArrayList<DetalleCompra> detCompra=new ArrayList<DetalleCompra>();
				
			int i=0;
			int aux=Compra.dameProsimaoNumeroCompra();
			
			while(i<listaProductos.size()){
				int a=Integer.parseInt(listaCantidades.get(i).toString());
				DetalleCompra nuervo=new DetalleCompra(listaProductos.get(i).toString(),a,aux);
				detCompra.add(nuervo);
				i++;
			}
				
				
				Compra.agregar(comboBox.getSelectedItem().toString(),1,detCompra);
			}
		});
		btnGuardar.setBounds(18, 228, 77, 23);
		frmCompra.getContentPane().add(btnGuardar);
		
		JButton btnCancelar = new JButton("cancelar");
		btnCancelar.setBounds(104, 228, 77, 23);
		frmCompra.getContentPane().add(btnCancelar);
		
		JButton btnImprimir = new JButton("imprimir");
		btnImprimir.setBounds(191, 228, 89, 23);
		frmCompra.getContentPane().add(btnImprimir);
		
		
		
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int j=0;
				boolean continuar=true;
				String valor="";
				while(j<listaProductos.size()){
					if(listaProductos.get(j).equals(comboBox_1.getSelectedItem().toString())){
						continuar=false;
					    String s= listaCantidades.get(j).toString();
						int aux= Integer.parseInt(s); 
						int aux2=Integer.parseInt(textField.getText()); 
						int aux3=aux+aux2;
					    valor=Integer.toString(aux3);
					    listaCantidades.remove(j);
					    listaProductos.remove(j);
					    textField.setText(valor);
					    
					 
					 // System.out.println("colgo");
					}
					j++;
				}
				
				
				if(continuar==true){
				listaCantidades.add(textField.getText());
				listaProductos.add(comboBox_1.getSelectedItem().toString());
				}else{
					 listaCantidades.add(valor);
					  listaProductos.add(comboBox_1.getSelectedItem().toString());
				}
				DefaultTableModel model=new DefaultTableModel();
				model.addColumn("Producto");
				model.addColumn("Cantidad");	
				
				int i=0;
				
				while(i<listaProductos.size()){
					System.out.println(listaProductos.get(i).toString());
				model.addRow(new String[]{listaProductos.get(i).toString(),listaCantidades.get(i).toString()});
				i++;
				}
				table_1.setModel(model);
				}
				
						
					
				
		
				
			/*	listaProductos.add(comboBox_1.getSelectedItem().toString());
				listaCantidades.add(textField.getText());
				
				final DefaultTableModel compra = new DefaultTableModel();
				compra.addColumn("Producto");
				compra.addColumn("Cantidad");
			     
                i=0;
                
				while(i<listaProductos.size()){
					System.out.println(listaProductos.get(i).toString());
				compra.addRow(new String[]{listaProductos.get(i).toString(),listaCantidades.get(i).toString()});
				i++;
				}
				table_1.setModel(compra);*/
				
				
		});
		btnAgregar.setBounds(299, 145, 77, 23);
		frmCompra.getContentPane().add(btnAgregar);
		
		JButton btnBuscar = new JButton("Agregar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				// busco proveedor
				Proveedor nuevoProveedor=Proveedor.buscar(comboBox.getSelectedItem().toString());
				
				
				
				// lleno label telefono y proveedor nombre
						lblNewLabel_2.setText(nuevoProveedor.getNombre());
						label.setText(nuevoProveedor.getTelefono());
						
						// llenar combobox 
						int tipo=Categoria2.numeroCategoria(nuevoProveedor.getTipo());
						
						ArrayList materiasPrimas=MateriaPrima.materiasPrimasDeCategoria(tipo);
						// vacio combobox 
						int i=0;
						/*while(i<materiasPrimas.size()){
							
							comboBox_1.removeItem(materiasPrimas.get(i));
							i++;
						}*/
						
						 int itemCount = comboBox_1.getItemCount();

						    for(i=0;i<itemCount;i++){
						        comboBox_1.removeItemAt(0);
						     }
						
						//JComboBox comboBox_3 = new JComboBox();
						 i=0;
						while(i<materiasPrimas.size()){
							
							comboBox_1.addItem(materiasPrimas.get(i));
							i++;
						}
						
						
					
			}
		});
		
		btnBuscar.setBounds(223, 32, 77, 23);
		frmCompra.getContentPane().add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 141, 266, 76);
		frmCompra.getContentPane().add(scrollPane);
		
		
		//table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		//productos.addColumn("Precio");
		table_1.setModel(compra);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnNewButton_2.setVisible(true);
				numeroCompra=Integer.parseInt(textField_1.getText());
				Compra nueva=Compra.buscar(textField_1.getText());

				lblNewLabel_2.setText(nueva.getProveedor());
				
			
				
				Proveedor p=Proveedor.buscar(nueva.getProveedor());
				// llenar combobox 
				int tipo=Categoria2.numeroCategoria(p.getTipo());
				
				ArrayList materiasPrimas=MateriaPrima.materiasPrimasDeCategoria(tipo);
				 int i=0;
					while(i<materiasPrimas.size()){
						
						comboBox_1.addItem(materiasPrimas.get(i));
						i++;
					} 	
				
				// lleno lable tel
				label.setText(p.getTelefono());
				
				ArrayList<DetalleCompra> nuevoDetalle= DetalleCompra.buscar(textField_1.getText());
				
				final DefaultTableModel c= new DefaultTableModel();
				  c.addColumn("Producto");
				  c.addColumn("Cantidad");
				 i=0;
				while(i<nuevoDetalle.size()){
					
					listaProductos.add(nuevoDetalle.get(i).getMateriaprima());
					
					String aux=Integer.toString(nuevoDetalle.get(i).getCantidad());
					
					listaCantidades.add(aux);
					
					c.addRow(new String[]{nuevoDetalle.get(i).getMateriaprima(),aux});
					i++;
				}
			table_1.setModel(c);	
			}
		});
		btnNewButton.setBounds(224, 8, 76, 20);
		frmCompra.getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(104, 8, 88, 20);
		frmCompra.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Eliminar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final DefaultTableModel c= new DefaultTableModel();
				 c.addColumn("Producto");
				 c.addColumn("Cantidad");
				System.out.print(table_1.getSelectedRow());
				
				//elinimo de la tabla
				DetalleCompra.eliminar(listaProductos.get(table_1.getSelectedRow()).toString(),numeroCompra);
				
				listaProductos.remove(table_1.getSelectedRow());
				listaCantidades.remove(table_1.getSelectedRow());
				
				
				
				int i=0;
				while(i<listaProductos.size()){
					c.addRow(new String[]{listaProductos.get(i).toString(),listaCantidades.get(i).toString()});
					i++;
				}
				table_1.setModel(c);
				
				
				
				
	           /* int i=0;
				
				while(i<listaProductos.size()){
					System.out.println(listaProductos.get(i).toString());
				c.addRow(new String[]{listaProductos.get(i).toString(),listaCantidades.get(i).toString()});
				i++;
				}
				table_1.setModel(c);
				}*/
				
				
			}
		});
		btnNewButton_1.setBounds(299, 179, 77, 24);
		frmCompra.getContentPane().add(btnNewButton_1);
		
	    btnNewButton_2 = new JButton("Modificar");
	    btnNewButton_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		btnNewButton_2.setVisible(false);
	    		int j=0;
	    		while(j<listaProductos.size()){
	    			int aux=Integer.parseInt(listaCantidades.get(j).toString());
	    		DetalleCompra.modificar(listaProductos.get(j).toString(),aux,numeroCompra);
	    		j++;
	    		}
	    	}
	    });
		btnNewButton_2.setBounds(299, 214, 77, 23);
		frmCompra.getContentPane().add(btnNewButton_2);
		btnNewButton_2.setVisible(false);
		
		
	}

	public static void setVisible(boolean b) {
		frmCompra.setVisible(true);
		
	}
}
