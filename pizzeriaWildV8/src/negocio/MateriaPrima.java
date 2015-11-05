package negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import datos.Busqueda;

public class MateriaPrima {
        private int idmp;
        private String nombremp;
        private String categoria;
        private int habilitado;
        

public MateriaPrima(int idmp, String categoria,String nombremp,int habilitado){
    this.idmp=idmp;
    this.nombremp=nombremp;
    this.categoria=categoria;
    this.habilitado=habilitado;
}

public int getidmp(){
    return idmp;
}
public void setidmp(int idmp){
    this.idmp=idmp;
}
public String getnombre(){
    return nombremp;
}
public void setnombre(String nombre){
    this.nombremp=nombre;
}
public String getcategoria(){
    return categoria;
}
public void setcategoria(String categoria){
    this.categoria=categoria;
}
public int gethabilitado(){
    return habilitado;
}
public void sethabilitado(int habilitado){
    this.habilitado=habilitado;
}

public static ArrayList materiasPrimasDeCategoria(int categoria) {
	String materiaprima="materiaPrima";
	ArrayList nuevo=new ArrayList();
	   try {
			ResultSet pro=Busqueda.devuelveTabla(materiaprima);
			int i=0;
			if(pro.getInt(2)==categoria){
			nuevo.add(pro.getString(3));
			}
			while(pro.next()){
				if(pro.getInt(2)==categoria){
					nuevo.add(pro.getString(3));
					}						
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nuevo;
      }

}
