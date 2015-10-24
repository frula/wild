package negocio;

public class MateriaPrima {
        private int idmp;
        private String nombremp;
	private String categoria;
	private int habilitado;
        

public MateriaPrima(int idmp,String nombremp, String categoria,int habilitado){
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
}
