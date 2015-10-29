package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import negocio.Categoria;
import negocio.Categoria2;
import negocio.Proveedor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class proveedores extends javax.swing.JDialog{

	private JFrame frmProveedores;
	private JTextField textField_1;
	private JTextField textField_4;
	private JButton btnModificar;
	private Proveedor proveedor;
	private JTextField textField;
	private JComboBox comboBox;
	private JLabel lblNewLabel;
    private JLabel lblNewLabel_2; 
    private JButton btnModificarEstado;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public proveedores() {
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
	 catch(Exception e) {};
		frmProveedores = new JFrame();
		frmProveedores.setResizable(false);
		frmProveedores.setTitle("Proveedores");
		frmProveedores.setBounds(100, 100, 450, 300);
		frmProveedores.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmProveedores.getContentPane().setLayout(null);
		proveedor=new Proveedor();
		
		JButton btnBuscar = new JButton("buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(Proveedor.existeProveedor(textField.getText())==false){
					JOptionPane.showMessageDialog(frmProveedores,"No existe proveedor","Problemas", JOptionPane.WARNING_MESSAGE);
				  } 
				else{
				
				proveedor=Proveedor.buscar(textField.getText());
				textField_1.setText(proveedor.getNombre());
				textField_4.setText(proveedor.getTelefono());
				
				if(proveedor.getEstado()==1){
				lblNewLabel_2.setText("Activo");
				}
				if(proveedor.getEstado()==0){
				lblNewLabel_2.setText("Inactivo");
				}
				//lblNewLabel_4.setVisible(true);
				btnModificar.setVisible(true);
				btnModificarEstado.setVisible(true);
				//lblNewLabel_4.setText(proveedor.getTipo());
			 }
			}	
		});
		btnBuscar.setBounds(144, 174, 89, 23);
		frmProveedores.getContentPane().add(btnBuscar);
		
		this.btnModificar = new JButton("modificar");
		btnModificar.setVisible(false);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				proveedor.modificar(textField_1.getText(),comboBox.getSelectedItem().toString(),textField_4.getText());
				//lblNewLabel_4.setVisible(true);
			    btnModificarEstado.setVisible(false);
			    btnModificar.setVisible(false);
			    textField_1.setText("");
			    textField_4.setText("");
			    lblNewLabel_2.setText("");
			    //lblNewLabel_4.setText("");
			}
		});
		btnModificar.setBounds(323, 57, 89, 23);
		frmProveedores.getContentPane().add(btnModificar);
		
		JLabel lblDescripcion = new JLabel("Nombre");
		lblDescripcion.setBounds(22, 28, 62, 23);
		frmProveedores.getContentPane().add(lblDescripcion);
		
		textField_1 = new JTextField();
		textField_1.setBounds(94, 28, 106, 23);
		frmProveedores.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Categoria");
		lblNewLabel_1.setBounds(22, 57, 56, 23);
		frmProveedores.getContentPane().add(lblNewLabel_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(94, 91, 105, 23);
		frmProveedores.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tel");
		lblNewLabel_3.setBounds(22, 91, 62, 23);
		frmProveedores.getContentPane().add(lblNewLabel_3);
		
		JButton btnAceptar = new JButton("Guardar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(textField_1.getText().equals("")==true || textField_4.getText().equals("")==true){
					JOptionPane.showMessageDialog(frmProveedores,"No fueron ingresados datos","Problemas", JOptionPane.WARNING_MESSAGE);	
				}
				else{
				proveedor.crear(textField_1.getText(),comboBox.getSelectedItem().toString(),textField_4.getText(),1);
				 textField_1.setText("");
				 textField_4.setText("");
				 lblNewLabel_2.setText("");
				 //lblNewLabel_4.setText("");
			}
			}	
		});
		
		
		btnAceptar.setBounds(323, 28, 89, 23);
		frmProveedores.getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmProveedores.setVisible(false);
			}
		});
		btnCancelar.setBounds(323, 91, 89, 23);
		frmProveedores.getContentPane().add(btnCancelar);
		
		textField = new JTextField();
		textField.setBounds(10, 174, 89, 23);
		frmProveedores.getContentPane().add(textField);
		textField.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBounds(94, 57, 106, 23);
		ArrayList lista=Categoria2.categorias();
		//comboBox.setModel(new DefaultComboBoxModel(new String[]{}));
		int i=0;
		while(i<lista.size()){
			//System.out.println(lista.get(i));
			comboBox.addItem(lista.get(i));
			i++;
		}
		frmProveedores.getContentPane().add(comboBox);
		
		lblNewLabel = new JLabel("Estado");
		lblNewLabel.setBounds(22, 120, 56, 29);
		frmProveedores.getContentPane().add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(94, 125, 106, 24);
		frmProveedores.getContentPane().add(lblNewLabel_2);
		
		btnModificarEstado = new JButton("Modificar estado");
		btnModificarEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				proveedor.cambiarEstado();
				textField_1.setText("");
				textField_4.setText("");
				lblNewLabel_2.setText("");
				//lblNewLabel_4.setText("");
				btnModificarEstado.setVisible(false);
				btnModificar.setVisible(false);
			}
		});
		btnModificarEstado.setBounds(290, 125, 120, 23);
		frmProveedores.getContentPane().add(btnModificarEstado);
		btnModificarEstado.setVisible(false);
		
		
	}

	public void setVisible(boolean b) {
		frmProveedores.setVisible(b);
		
	}
	
	 public static void main(String args[]) {
	        /* Set the Nimbus look and feel */
	        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
	        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
	         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
	         */
		 
	        try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(FormCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(FormCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(FormCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(FormCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        //</editor-fold>

	        /* Create and display the dialog */
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	          
	            	final proveedores dialog = new proveedores();
	                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
	                    @Override
	                    public void windowClosing(java.awt.event.WindowEvent e) {
	                        System.exit(0);
	                     
	                    }
	                    
	                });
	                dialog.setVisible(true);
	
	            }
	        });
	    }
}
