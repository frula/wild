package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

import datos.Basededatos;
import datos.Pizzeria;

import negocio.Producto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

//import com.mxrck.autocompleter.TextAutoCompleter;

public class Productos {

	private JFrame frmProductos;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
    private JButton btnNewButton_2;
    private JButton btnNewButton_4;
    private Producto NuevoProducto;
    private JLabel label;
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
		try
		{
		 UIManager.setLookAndFeel(
		 UIManager.getSystemLookAndFeelClassName());
		}
		 catch(Exception e) {}
		frmProductos = new JFrame();
		frmProductos.setResizable(false);
		frmProductos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmProductos.setTitle("Productos");
		frmProductos.setBounds(100, 100, 450, 300);
		frmProductos.getContentPane().setLayout(null);
		NuevoProducto=new Producto();
		
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(24, 40, 71, 14);
		frmProductos.getContentPane().add(lblDescripcion);
		
		textField_1 = new JTextField();
		textField_1.setBounds(104, 37, 86, 20);
		frmProductos.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(24, 86, 46, 14);
		frmProductos.getContentPane().add(lblPrecio);
		
		textField_2 = new JTextField();
		textField_2.setBounds(104, 83, 86, 20);
		frmProductos.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCaregoria = new JLabel("Caregoria");
		lblCaregoria.setBounds(24, 132, 71, 14);
		frmProductos.getContentPane().add(lblCaregoria);
		
		textField_3 = new JTextField();
		textField_3.setBounds(104, 129, 86, 20);
		frmProductos.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//String a=textField.getText();
				//int a1=Integer.parseInt(a);
				 if(textField_1.getText().equals("") || textField_2.getText().equals("") || textField_3.getText().equals("")){
					    JOptionPane.showMessageDialog(frmProductos,"No fue ingresado ningun dato","Problemas", JOptionPane.WARNING_MESSAGE);	
			      }
				 else{
				//int aux=Integer.parseInt((textField_3.getText());
				/*if(Productos.categorias()<aux){
					JOptionPane.showMessageDialog(frmProductos,"No existe categoria","Problemas", JOptionPane.WARNING_MESSAGE);	
				}*/
					 
					 
				if(Producto.existeProducto(textField_1.getText())){
					 JOptionPane.showMessageDialog(frmProductos,"El producto ya existe","Problemas", JOptionPane.WARNING_MESSAGE);
				}else{
				
				String a2=textField_2.getText();
				Double a3=Double.parseDouble(a2);
				
				String a4=textField_3.getText();
				int a5=Integer.parseInt(a4);
			    String a6=textField_1.getText();   
					try {

						Producto.agregarProducto(a6,a3,a5,1);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//Basededatos.ejecutarsql("INSERT INTO producto(Producto,Precio,Categoria) VALUES(a,textField_2,textField_3)"); 
					
			 }
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				label.setText("");
			 }
			}	 
		});
		btnNewButton.setBounds(277, 36, 99, 23);
		frmProductos.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			    NuevoProducto=Producto.buscarProducto(textField_1.getText());
			    if(NuevoProducto.getNombre().equals("")){
			    JOptionPane.showMessageDialog(frmProductos,"NO existe producto ingrese nuevamente codigo","Problemas", JOptionPane.WARNING_MESSAGE);	
			    }
			    else{
	         	//System.out.println(NuevoProducto.getNombre()+" "+NuevoProducto.getPrecio().toString()+" "+NuevoProducto.getId()+" "+NuevoProducto.getEstado() );
				textField_1.setText(NuevoProducto.getNombre());
				textField_2.setText(NuevoProducto.getPrecio().toString());
				String cate=Integer.toString(NuevoProducto.getCategoria());
				textField_3.setText(cate);
				
				if(NuevoProducto.getEstado()==true){
					label.setText("Activo");
				}else if( NuevoProducto.getEstado()==false){
					label.setText("Inactivo");
				}
				
				btnNewButton_2.setVisible(true);
				btnNewButton_5.setVisible(true);
			    }
			}
		});
		btnNewButton_1.setBounds(277, 82, 99, 23);
		frmProductos.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Modificar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//btnNewButton_4.setVisible(true);
				
				if(NuevoProducto.getNombre().equals(textField_1.getText())!=true){
					 JOptionPane.showMessageDialog(frmProductos,"NO sepuede modificarel atributo nombre","Problemas", JOptionPane.WARNING_MESSAGE);	
				}
				else{
				
				double pre=Double.parseDouble(textField_2.getText());
				int i=Integer.parseInt(textField_3.getText());
				boolean est;
				if(NuevoProducto.getEstado()==true){
					est=true;
				}
				else{
					est=false;
				}
				Producto p1=new Producto(textField_1.getText(),pre,i,est);
				NuevoProducto.modificarProducto(p1);
				
				btnNewButton_2.setVisible(false);
				btnNewButton_5.setVisible(false);
				
			  }
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				label.setText("");
			}		
		});
		btnNewButton_2.setBounds(277, 128, 114, 23);
		frmProductos.getContentPane().add(btnNewButton_2);
		btnNewButton_2.setVisible(false);
		
		JButton btnNewButton_3 = new JButton("Salir");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmProductos.setVisible(false);
			}
		});
		btnNewButton_3.setBounds(168, 214, 86, 23);
		frmProductos.getContentPane().add(btnNewButton_3);
		
		
		JLabel lblNewLabel = new JLabel("Estado");
		lblNewLabel.setBounds(24, 176, 60, 14);
		frmProductos.getContentPane().add(lblNewLabel);
		
		btnNewButton_4 = new JButton("Aplicar");
		btnNewButton_4.setBounds(264, 214, 86, 22);
		frmProductos.getContentPane().add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("Cambiar estado");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NuevoProducto.cambiarEstado(NuevoProducto.getEstado(),NuevoProducto.getNombre());
				btnNewButton_5.setVisible(false); 
				btnNewButton_2.setVisible(false);
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				label.setText("");
			}
		});
		btnNewButton_5.setBounds(277, 162, 114, 23);
		frmProductos.getContentPane().add(btnNewButton_5);
		btnNewButton_5.setVisible(false);
		
		label = new JLabel("");
		label.setBounds(104, 176, 86, 19);
		frmProductos.getContentPane().add(label);
		btnNewButton_4.setVisible(false);
		
		
		  
		
	}

	public void setVisible(boolean b) {
		frmProductos.setVisible(b);
		
	}
}
