package negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import datos.Busqueda;

public class Categoria2 {
private String categoria;

Categoria2(){
	this.categoria="";
}
Categoria2(String categoria){
	this.categoria=categoria;
}

public static ArrayList categorias(){
	String c="categoria";
	ArrayList cate=new ArrayList();
	ResultSet pro;
	try {
		pro = Busqueda.devuelveTabla(c);
		cate.add(pro.getString(2));	
		while(pro.next()){
	
			System.out.println(pro.getString(2));
		cate.add(pro.getString(2));	
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return cate;
}
public static int numeroCategoria(String categoria){
	String c="categoria";
	ArrayList cate=new ArrayList();
	ResultSet pro;
	try {
		pro = Busqueda.devuelveTabla(c);
		int i=1;
		if(pro.getString(2).equals(categoria)){
			return pro.getInt(1);
		}
		cate.add(pro.getString(2));	
		while(pro.next()){
			if(pro.getString(2).equals(categoria)){
				return pro.getInt(1);
			}
	       
			//System.out.println(pro.getString(2));
		cate.add(pro.getString(2));	
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return 0;
}
public static String dameCategoria(int valor){
	String c="categoria";
	ResultSet pro;
	try {
		pro = Busqueda.devuelveTabla(c);
		
		if(pro.getInt(1)==valor){
			return pro.getString(2);
		}
		
		while(pro.next()){
			if(pro.getInt(1)==valor){
				return pro.getString(2);
			}
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "";
}
}
