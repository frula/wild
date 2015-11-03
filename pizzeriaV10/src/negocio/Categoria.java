package negocio;

public class Categoria {
	private int id;
	private String nombre;
	
	public Categoria(int id, String nombre){
		this.id=id;
		this.nombre=nombre;
		
	}
	
	public int getid(){
		return this.id;
	}
	
	public void setid(int id){
		this.id=id;
	}
	
	public String getnombre(){
		return this.nombre;
	}
	
	public void setnombre(String nombre){
		this.nombre=nombre;
	}

}
