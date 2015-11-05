package negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import datos.Basededatos;
import datos.Busqueda;

public class Proveedor {
	
	//private int codigo;
	private String nombre;
	private String tipo;
	private String direccion;
	private String telefono;
	private int estado;
	private int i=0;
	
	public Proveedor(){
		//this.codigo=0;
		this.nombre="";
		this.tipo="";
		this.direccion="";
		this.telefono="";
		this.estado=0;
	}
	
	
	Proveedor(String nombre,String tipo,String telefono,int estado){
		//this.codigo=codigo;
		this.nombre=nombre;
		this.tipo=tipo;
		this.direccion=direccion;
		this.telefono=telefono;
		this.estado=estado;
	}
	
	
	
	
	public String getNombre(){
		return this.nombre;
	}
	
	public String getTipo(){
		return this.tipo;
	}
	public String getDireccion(){
		return this.direccion;
	}
	public String getTelefono(){
		return this.telefono;
		
	}
	
	
	public void setNombre(String nombre){
		  this.nombre=nombre;
	}
	public void setTipo(String tipo){
		this.tipo=tipo;
	}
	public void setDireccion(String direccion){
		this.direccion=direccion;
	}
	public void setTelefono(String telefono){
		this.telefono=telefono;
	}
	public int getEstado(){
		return this.estado;
	}
	
	/*public void  modificar(int codigo,String nombre,int tipo,String direccion,String telefono){
           this.setCodigo(codigo);
           this.setNombre(nombre);
           this.setTipo(tipo);
           this.setDireccion(direccion);
           this.setTelefono(telefono);
	}*/
	
	public Proveedor buscar(int codigo){
		Proveedor p=null;
		return p;
	}
	
	public void crear(String nombre,String categoria,String tel,int estado){
		/*i++;
		Proveedor p=new Proveedor(codigo,nombre,tipo,direccion,telefono);
		String s=Integer.toString(codigo);
		String s1=Integer.toString(tipo);*/
		try {
			int aux=Categoria2.numeroCategoria(categoria);
			Basededatos.ejecutarsql("INSERT INTO proveedor(Nombre,Telefono,Categoria,Activo) VALUES('"+nombre+"','"+tel+"',"+aux+","+estado+")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Proveedor buscar(String nombre){
		
	
		Proveedor p = null;
		ArrayList proveedor=new ArrayList();
		
		String prov ="proveedor";
		try {
			ResultSet pro=Busqueda.devuelveTabla(prov);
			
			if(pro.getString(2).equals(nombre)){
				String s=Categoria2.dameCategoria(pro.getInt(4));
				p=new Proveedor(pro.getString(2),s,pro.getString(3),pro.getInt(5));	
			 return p; 
			}
			
			while(pro.next()){
				//int a=Integer.parseInt(pro.getString(4));
				if(pro.getString(2).equals(nombre)){
					String s=Categoria2.dameCategoria(pro.getInt(4));
					p=new Proveedor(pro.getString(2),s,pro.getString(3),pro.getInt(5));
					
				 return p; 
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;

	}
	public void modificar(String nombre,String tipo,String telefono){
		int i=Categoria2.numeroCategoria(tipo);
		   String prove ="proveedor";
					try {
						ResultSet pro=Busqueda.devuelveTabla(prove);
						
						while(pro.next()){
							//String aux=Integer.toString(com.numeroCombo);
							if(pro.getString(2).equals(this.nombre)){
								
								Basededatos.ejecutarsql("UPDATE proveedor SET Categoria="+i+" WHERE Nombre='"+pro.getString(2)+"'");
								Basededatos.ejecutarsql("UPDATE proveedor SET Telefono='"+telefono+"' WHERE Nombre='"+pro.getString(2)+"'");
								Basededatos.ejecutarsql("UPDATE proveedor SET Nombre='"+nombre+"' WHERE Nombre='"+pro.getString(2)+"'");
								//Basededatos.ejecutarsql("UPDATE cliente SET Telefono='"+tel+"' WHERE DNI='"+pro.getString(3)+"'");
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	}
	
	public void cambiarEstado(){
		int valor=0;  
		if(this.estado==1){
			  valor=0;
		  }
		if(this.estado==0){
			valor=1;
		}
		try {
			Basededatos.ejecutarsql("UPDATE proveedor SET Activo="+valor+" WHERE Nombre='"+this.nombre+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static boolean existeProveedor(String text) {
try {
			
			ResultSet pro=Busqueda.devuelveTabla("proveedor");
			while(pro.next()){
				if(pro.getString(2).equals(text)){
			     return true;
				}
			  }
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	
	 public static ArrayList dameProveedores(){
		   String prove="proveedor";
		   ArrayList nuevo=new ArrayList();
		   try {
				ResultSet pro=Busqueda.devuelveTabla(prove);
				nuevo.add(pro.getString(2));
				while(pro.next()){
					nuevo.add(pro.getString(2));						
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return nuevo;
	   }
	
}
