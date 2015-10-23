package negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import datos.Basededatos;
import datos.Busqueda;

public class Producto {

	private String nombre;
	private Double precio;
	private int categoria;
	//private String idProducto;
	private boolean estado;
	
	public Producto(){
		
		this.nombre="";
		this.precio=0.0;
		this.categoria=0;
		//this.idProducto="";
		this.estado=true;
				
	}
	//Constructor sin ID
	public Producto(String Nombre, Double Precio,int Categoria,boolean estado) {

		nombre = Nombre;
		precio = Precio;
		categoria=Categoria;
		//idProducto=id;
		this.estado=estado;
	}
	
    public boolean getEstado(){
    	return estado;
    }
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getCategoria() {
		return categoria;
	}
	/*public String getId(){
		return this.idProducto;
	}*/

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	/*public String getIDProducto() {
		return idProducto;
	}*/

	/*public void setIDProducto(String idProducto) {
		this.idProducto = idProducto;
	}*/
	
	public static void agregarProducto(String descripcion,Double precio,int categoria,int estado) throws SQLException{
		
		try {
		Basededatos.ejecutarsql("INSERT INTO producto(Producto,Precio,Categoria,Estado) VALUES('"+descripcion+"',"+precio+","+categoria+","+estado+")");
	}
		catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		
		
    } 
	
	public static Producto buscarProducto(String nombre) {
		Producto p=new Producto();
		ArrayList produc=new ArrayList();
		
		String producto ="producto";
		String codigo ="Codigo";
		try {
			ResultSet pro=Busqueda.devuelveTabla(producto);
			while(pro.next()){
				
				double p1=Double.parseDouble(pro.getString(3));
				int i=Integer.parseInt(pro.getString(4));
			   // p=new Producto(pro.getString(3),p1,i,pro.getString(2));
				produc.add(p);
				
				int j=Integer.parseInt(pro.getString(5));
				boolean est;
				
				if(j==1){
					
					est=true;
				}else{
					est=false;
				}
				
				if(pro.getString(2).equals(nombre)){
					
				 p=new Producto(pro.getString(2),p1,i,est);
				 return p; 
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return p;
	}
	 
	public static void modificarProducto(Producto nuevo) {
		String producto ="producto";
		try {
			ResultSet pro=Busqueda.devuelveTabla(producto);
			
			while(pro.next()){
				if(pro.getString(2).equals(nuevo.getNombre())){
					Basededatos.ejecutarsql("UPDATE producto SET Precio="+nuevo.getPrecio()+" WHERE Producto='"+pro.getString(2)+"'");
					//Basededatos.ejecutarsql("UPDATE producto SET Producto='"+nuevo.getNombre()+" WHERE Producto='"+pro.getString(2)+"'");
					Basededatos.ejecutarsql("UPDATE producto SET Categoria="+nuevo.getCategoria()+" WHERE Producto='"+pro.getString(2)+"'");
					//Basededatos.ejecutarsql("UPDATE producto SET Codigo='"+nuevo.getId()+"WHERE Codigo='"+pro.getString(2)+"'");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void cambiarEstado(boolean estado,String nombre){
		String producto ="producto";
		try {
			ResultSet pro=Busqueda.devuelveTabla(producto);
			int valor=0;
			
			if(estado==true){
				valor=0;
			} 
			else{
				valor=1;
			}
			System.out.println(valor);
			while(pro.next()){
				if(pro.getString(2).equals(nombre)){
					Basededatos.ejecutarsql("UPDATE producto SET Estado="+valor+" WHERE Producto='"+pro.getString(2)+"'");
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static ArrayList listaProductos(){
		ArrayList produc=new ArrayList();
		
		String producto ="producto";
		   ResultSet pro;
			 try {
				pro = Busqueda.devuelveTabla(producto);
			
				while(pro.next()){
				    produc.add(pro.getString(2));
					} 
			 
			 
			 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			 return produc;	     
				
		}
	
	public static boolean existeProducto(String produc){
		String producto ="producto";
		boolean valor=false;
		try {
			ResultSet pro=Busqueda.devuelveTabla(producto);
			
			while(pro.next()){
				if(pro.getString(2).equals(produc)){
					valor=true;
					return valor;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valor;
	}
		/*public static int categorias(){
			String producto ="producto";
			int valor=0;
			try {
				ResultSet pro=Busqueda.devuelveTabla(producto);
				
				while(pro.next()){
					if(pro.getString(2).equals(produc)){
						valor=true;
						return valor;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return valor;
		}*/
			
		

   
	
}
