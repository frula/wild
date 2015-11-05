package negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import datos.Basededatos;
import datos.Busqueda;

public class DetalleCompra {

	private String MateriaPrima;
	//private MateriaPrima  materiaprima;
	private int cant;
	private int idCompra;
	
	DetalleCompra(){
		this.MateriaPrima="";
		//this.materiaprima=new MateriaPrima();
		this.cant=0;
		this.idCompra=0;
	}
	
	public DetalleCompra(String Materia, int cant,int idCompra){
		this.MateriaPrima=Materia;
		this.cant=cant;
		this.idCompra=idCompra;
	}
	
	public void setMateriaPrima(String valor){
		this.MateriaPrima=valor;
	}
	public void setCantidad(int cant){
		this.cant=cant;
	}
	public void setIdCompra(int compra){
		this.idCompra=compra;
	}
	public String getMateriaprima(){
		return this.MateriaPrima;
	}
	public int getCantidad(){
		return this.cant; 
	}
	public int getIdCompra(){
		return this.idCompra;
	}

	public static ArrayList<DetalleCompra> buscar(String text) {
		ArrayList<DetalleCompra> nuevo=new ArrayList<DetalleCompra>();
		DetalleCompra c=null;
		try {
			ResultSet pro=Busqueda.devuelveTabla("detallecompra");
			if(pro.getString(4).equals(text)){
				//System.out.println(pro.getString(1)+"salio");
				c=new DetalleCompra(pro.getString(2),pro.getInt(3),pro.getInt(4));
			    nuevo.add(c);  
			}
			
			while(pro.next()){
				if(pro.getString(4).equals(text)){
					c=new DetalleCompra(pro.getString(2),pro.getInt(3),pro.getInt(4));
				    nuevo.add(c);  
				}
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nuevo;
	}
	
	public static void modificar(String nombre, int cantidad, int idCompra){
		
		try {
			Basededatos.ejecutarsql("UPDATE detallecompra SET IdMateriaPrima='"+nombre+"' WHERE IdCompra="+idCompra+"");
			Basededatos.ejecutarsql("UPDATE detallecompra SET Cantidad='"+cantidad+"' WHERE IdCompra="+idCompra+"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void eliminar(String nombre,int numeroCompra){
		try {
			Basededatos.ejecutarsql("DELETE FROM detallecompra WHERE IdMateriaPrima='"+nombre+"'"+",IdCompra= "+numeroCompra+"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
