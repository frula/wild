package interfaz;

import java.awt.EventQueue;
import java.awt.Label;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.HTMLDocument.Iterator;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

import negocio.Combo;
import negocio.Producto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Combos {

	private JFrame frmCombos;
	private JTable table;
	private JTextField textField_1;
	private JComboBox comboBox;
	private ArrayList listaProductos;
	private ArrayList listaCantidades;
    //private Map<String,String> lista;
    private JTextField textField_2;
    private int cantidad;
    private JTextField textField;
    private JLabel label;
    private JLabel lblNewLabel_1;
    private Combo nuevo;
    private JButton btnEstado_1;
    private JButton btnNewButton;
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
		
			try
			{
			 UIManager.setLookAndFeel(
			 UIManager.getSystemLookAndFeelClassName());
			}
			 catch(Exception e) {}
		cantidad=0;
		frmCombos = new JFrame();
		frmCombos.setResizable(false);
		frmCombos.setTitle("Combos");
		frmCombos.setBounds(100, 100, 450, 300);
		frmCombos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCombos.getContentPane().setLayout(null);
		listaProductos=new ArrayList();
		listaCantidades=new ArrayList();
		//lista=new HashMap<String,String>();
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("Producto");
		model.addColumn("Cantidad");
		
		JLabel lblNewLabel = new JLabel("N\u00B0 Combo");
		lblNewLabel.setBounds(24, 21, 79, 21);
		frmCombos.getContentPane().add(lblNewLabel);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//int aux=Integer.parseInt(textField.getText());
			if(textField.getText().equals("")){
				 JOptionPane.showMessageDialog(frmCombos,"No existe combo","Problemas", JOptionPane.WARNING_MESSAGE);	
			}
			else{
				
				int can=Integer.parseInt(textField.getText());	
				
			nuevo=Combo.buscarCombo(can);
			
			String s=Integer.toString(nuevo.getNumeroCombo());
			textField.setText(s);
			String d=Double.toString(nuevo.getPrecio());
			textField_1.setText(d);
			int i=0;
			label.setText(nuevo.getProducto());
			String est="";
			if(nuevo.getEstado()==true){
				est="Activo";
			}
			else{
				est="Inactivo";
			}
			lblNewLabel_1.setText(est);
			btnEstado_1.setVisible(true);
			btnNewButton.setVisible(true);
			
			}
			textField.setText("");
		  }
		});
		btnBuscar.setBounds(253, 20, 89, 23);
		frmCombos.getContentPane().add(btnBuscar);
		
		JLabel lblSeleccioneProducto = new JLabel("Seleccione producto");
		lblSeleccioneProducto.setBounds(10, 95, 99, 14);
		frmCombos.getContentPane().add(lblSeleccioneProducto);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//comboBox.getSelectedItem().toString();
				if(textField_2.getText().equals("")){
					 JOptionPane.showMessageDialog(frmCombos,"No ingreso cantidad de producto","Problemas", JOptionPane.WARNING_MESSAGE);	
				}
				else{
				int j=0;
				boolean continuar=true;
				String valor="";
				while(j<listaProductos.size()){
					if(listaProductos.get(j).equals(comboBox.getSelectedItem().toString())){
						continuar=false;
					    String s= listaCantidades.get(j).toString();
						int aux= Integer.parseInt(s); 
						int aux2=Integer.parseInt(textField_2.getText()); 
						int aux3=aux+aux2;
					    valor=Integer.toString(aux3);
					    listaCantidades.remove(j);
					    listaProductos.remove(j);
					    textField_2.setText(valor);
					    
					 
					 // System.out.println("colgo");
					}
					j++;
				}
				
				
				if(continuar==true){
				listaCantidades.add(textField_2.getText());
				listaProductos.add(comboBox.getSelectedItem().toString());
				}else{
					 listaCantidades.add(valor);
					  listaProductos.add(comboBox.getSelectedItem().toString());
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
				table.setModel(model);
				}
				}	
			
		});
		btnAgregar.setBounds(253, 54, 89, 23);
		frmCombos.getContentPane().add(btnAgregar);
		
		JButton btnAplicar = new JButton("Aplicar");
		btnAplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(textField_2.getText().equals("") || textField_1.getText().equals("") || listaProductos.size()==0 ){
					JOptionPane.showMessageDialog(frmCombos,"No fueron ingresados datos","Problemas", JOptionPane.WARNING_MESSAGE);	

				}
				else{
				int i=0;
				String texto="";
				cantidad++;
				while(i<listaProductos.size()){
					texto=(""+texto+" "+listaCantidades.get(i).toString()+" "+listaProductos.get(i).toString());
					i++;
					}
				double aux=Double.parseDouble(textField_1.getText());
				//int aux1=Integer.parseInt(textField.getText());
				// int j=Combo.ultimoCombo();
				 
				int j=Combo.cantidadCombos();
				j++;
				Combo.agregarCombo(aux,texto,j,1);
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				lblNewLabel_1.setText("");
				DefaultTableModel model=new DefaultTableModel();
				model.addColumn("Producto");
				model.addColumn("Cantidad");	
				table.setModel(model);
				ArrayList lista=new ArrayList();
				listaProductos=lista;
			 }
			}
		});
		btnAplicar.setBounds(352, 54, 89, 23);
		frmCombos.getContentPane().add(btnAplicar);
		
		
		btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String texto="";
				int i=0;
				while(i<listaProductos.size()){
					texto=(""+texto+" "+listaCantidades.get(i).toString()+" "+listaProductos.get(i).toString());
					i++;
					}
				  double aux=Double.parseDouble(textField_1.getText());
				  int aux1=Integer.parseInt(textField.getText());
				  
				  boolean valor=true;
				  if(textField_2.toString().equals("1")){
					valor=true;  
				  }
				  else if(textField_2.toString().equals("0")){
					  valor=false;
				  }
				Combo nuevoCombo=new Combo(texto,aux1,aux,valor);
				
				nuevo.modificar(nuevoCombo);
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				lblNewLabel_1.setText("");
				DefaultTableModel model=new DefaultTableModel();
				model.addColumn("Producto");
				model.addColumn("Cantidad");	
				table.setModel(model);
				
				btnEstado_1.setVisible(false);
				btnNewButton.setVisible(false);
				label.setVisible(false);
				lblNewLabel_1.setVisible(false);
			}
		});
		btnNewButton.setBounds(352, 20, 89, 23);
		btnNewButton.setVisible(false);
		frmCombos.getContentPane().add(btnNewButton);
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(90, 231, 86, 20);
		frmCombos.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(24, 231, 60, 20);
		frmCombos.getContentPane().add(lblPrecio);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 124, 299, 98);
		frmCombos.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.setModel(model);
		
		comboBox = new JComboBox();
		comboBox.setBounds(119, 92, 107, 21);
		frmCombos.getContentPane().add(comboBox);
		ArrayList p=Producto.listaProductos();
		comboBox.setModel(new DefaultComboBoxModel(new String[]{}));
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(236, 95, 60, 14);
		frmCombos.getContentPane().add(lblCantidad);
		
		textField_2 = new JTextField();
		textField_2.setBounds(315, 92, 86, 20);
		frmCombos.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		btnEstado_1 = new JButton("cambiar estado");
		btnEstado_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Combo.cambiarEstado(nuevo.getEstado(),nuevo.getNumeroCombo());
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				lblNewLabel_1.setText("");
				DefaultTableModel model=new DefaultTableModel();
				model.addColumn("Producto");
				model.addColumn("Cantidad");	
				table.setModel(model);
				btnEstado_1.setVisible(false);
				btnNewButton.setVisible(false);
				label.setVisible(false);
				lblNewLabel_1.setVisible(false);
			}
		});
		btnEstado_1.setBounds(319, 199, 112, 23);
		btnEstado_1.setVisible(false);
		frmCombos.getContentPane().add(btnEstado_1);
		
		textField = new JTextField();
		textField.setBounds(96, 21, 79, 21);
		frmCombos.getContentPane().add(textField);
		textField.setColumns(10);
		
		label = new JLabel("");
		label.setBounds(24, 63, 202, 21);
		frmCombos.getContentPane().add(label);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(236, 234, 46, 14);
		frmCombos.getContentPane().add(lblEstado);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(306, 234, 73, 14);
		frmCombos.getContentPane().add(lblNewLabel_1);
		int i=0;
		while(i<p.size()){
		   comboBox.addItem(p.get(i));
		   i++;
		
		}
	}

	public void setVisible(boolean b) {
		frmCombos.setVisible(b);
		
	}
}
