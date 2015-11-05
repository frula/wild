package negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import datos.Basededatos;
import datos.Busqueda;

public class Compra {

	
	private int NumeroCompra;
	private String Proveedor;
	private boolean Enviado;
	private ArrayList<DetalleCompra> materiasPrimas;
	
	
	Compra(){
		this.NumeroCompra=0;
		this.Proveedor="";
		this.Enviado=false;
	}
	Compra(int numero,String proveedor,boolean estado){
		this.NumeroCompra=numero;
		this.Proveedor=proveedor;
		this.Enviado=estado;
	}
	
	public void setNumeroCompra(int com){
		this.NumeroCompra=com;
	}
	public void SetProveedor(String prove){
		this.Proveedor=prove;
	}
	public void SetEnviados(boolean est){
		this.Enviado=est;
	}
	public int getNumeroCompra(){
		return this.NumeroCompra;
	}
	public String getProveedor(){
		return this.Proveedor;
	}
	public boolean getEnviado(){
		return this.Enviado;
	}
	
	public static void agregar(String proveedor, int estado,ArrayList<DetalleCompra> detalle){
		int num=dameProsimaoNumeroCompra();
		try {
			ResultSet pro=Busqueda.devuelveTabla("compra");
			
			//verifico estado de compra
			boolean valor=true;
			if(estado==1){
				valor=true;
			}
			if(estado==0){
				valor=false;
			}
			
			
			// agrrego a la tabla compra
			Basededatos.ejecutarsql("INSERT INTO compra(NumeroCompra,Proveedor,Estado) VALUES("+num+",'"+proveedor+"',"+valor+")");
			
			// agrego a la tabla detalle de compra
			
			ResultSet detalleCom=Busqueda.devuelveTabla("detallecompra");
			
			int j=0;
			DetalleCompra nuevo=new DetalleCompra();
			while(j<detalle.size()){
				nuevo=detalle.get(j);
				Basededatos.ejecutarsql("INSERT INTO detallecompra(IdMateriaPrima,Cantidad,IdCompra) VALUES('"+nuevo.getMateriaprima()+"',"+nuevo.getCantidad()+","+nuevo.getIdCompra()+")");
				j++;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public static int dameProsimaoNumeroCompra(){
		int i=0;
		int valor=0;
		try {
			
			ResultSet pro=Busqueda.devuelveTabla("compra");
			
			//if(pro.getInt(2) Instanceof)
			
			//i++;
			while(pro.next()){
				valor=pro.getInt(2);
				i++;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valor+1;
	}
	public static Compra buscar(String compra){
		int com=Integer.parseInt(compra);
		Compra nueva=null;
		try {
			ResultSet pro=Busqueda.devuelveTabla("compra");
			if(pro.getInt(2)==com && pro.getInt(4)==1){
				nueva=new Compra(pro.getInt(2),pro.getString(3),true);
				return nueva;
			}
			
			while(pro.next()){
				if(pro.getInt(2)==com && pro.getInt(4)==1){
					nueva=new Compra(pro.getInt(2),pro.getString(3),true);
					return nueva;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nueva;
	}
}
