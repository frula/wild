package negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import datos.Basededatos;
import datos.Busqueda;

public class Combo {
	private double precio;
	private String productos;
	private boolean estado;
	private int  numeroCombo;
	
	
	
	Combo(){
		this.precio=0.0;
		this.productos="";
		this.estado=false;
		this.numeroCombo=0;
	}
	public Combo(String productos,int numeroCombo,double precio,boolean estado){
		
		this.productos=productos;
		this.precio=precio;
		this.estado=estado;
		this.numeroCombo=numeroCombo;
		int i=0;
		
	}
	public String getProducto(){
	return this.productos;
	}
	public boolean getEstado(){
		return this.estado;
	}
	public int getNumeroCombo(){
		return this.numeroCombo;
	}
	public double getPrecio(){
		return this.precio;
	}
	
	public static void agregarCombo(double precio,String productos,int combo,int estado){
		try {
			Basededatos.ejecutarsql("INSERT INTO combos(Precio,Productos,N°Combo,Estado) VALUES("+precio+",'"+productos+"',"+combo+","+estado+")");
		}
			catch (SQLException ex) {
	            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
	        }
			
		
	}
	
	public static Combo buscarCombo(int numeroCombo){
		Combo c=new Combo();
		ArrayList produc=new ArrayList();
		
		String combos ="combos";
		try {
			ResultSet pro=Busqueda.devuelveTabla(combos);
			while(pro.next()){
				
				double p1=Double.parseDouble(pro.getString(2));
				
				int j=Integer.parseInt(pro.getString(5));
				boolean est;
				
				if(j==1){
					
					est=true;
				}else{
					est=false;
				}
				
				int a=Integer.parseInt(pro.getString(4));
				if(a==numeroCombo){
					c=new Combo(pro.getString(3).toString(),numeroCombo,p1,est);
				 return c; 
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	   
	public void modificar(Combo com){
		   if(this.numeroCombo==com.numeroCombo){
			   String combo ="combos";
				try {
					ResultSet pro=Busqueda.devuelveTabla(combo);
					
					while(pro.next()){
						String aux=Integer.toString(com.numeroCombo);
						if(pro.getString(4).equals(aux)){
							Basededatos.ejecutarsql("UPDATE combos SET Precio="+com.getPrecio()+" WHERE N°Combo="+pro.getString(4)+"");
							//Basededatos.ejecutarsql("UPDATE producto SET Producto='"+nuevo.getNombre()+" WHERE Producto='"+pro.getString(2)+"'");
							Basededatos.ejecutarsql("UPDATE combos SET Productos='"+com.getProducto()+"' WHERE N°Combo="+pro.getString(4)+"");
							//Basededatos.ejecutarsql("UPDATE producto SET Codigo='"+nuevo.getId()+"WHERE Codigo='"+pro.getString(2)+"'");
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   }
		
		
		
	}
	public static void cambiarEstado(boolean estado, int numeroCombo){
		String combos ="combos";
		try {
			ResultSet pro=Busqueda.devuelveTabla(combos);
			int valor=0;
			
			if(estado==true){
				valor=0;
			} 
			else{
				valor=1;
			}
			//System.out.println(valor);
			while(pro.next()){
				String n=Integer.toString(numeroCombo);
				if(pro.getString(4).equals(n)){
					int aux=Integer.parseInt(pro.getString(4));
					Basededatos.ejecutarsql("UPDATE combos SET Estado="+valor+" WHERE N°Combo="+aux+"");
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static int cantidadCombos(){
		String combos ="combos";
		int valor=1;
		try {
			ResultSet pro=Busqueda.devuelveTabla(combos);
			while(pro.next()){
				valor++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valor;
	}
	public static boolean existeCombo(int combo){
		String combos ="combos";
		boolean valor=false;
		try {
			ResultSet pro=Busqueda.devuelveTabla(combos);
			while(pro.next()){
				if(pro.getInt(4)==combo){
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
