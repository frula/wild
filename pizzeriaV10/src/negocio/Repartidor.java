package negocio;

public class Repartidor {
	private int id;
	private String nombre;
	private String telefono;
	private String vehiculo;
	private boolean Activo;
	
	public Repartidor(int id,String nombre,String telefono,String vehiculo,int activo){
		this.id=id;
		this.nombre=nombre;
		this.telefono=telefono;
		this.vehiculo=vehiculo;
		
		if(activo==1){this.Activo=true;}
		else{this.Activo=false;}
		
	}
	
	public int getid(){
		return id;
	}
	
	public String getnombre(){
		return nombre;
		
	}
	
	public String getTelefono(){
		return telefono;
	}
	
	public String getVehiculo(){
		return vehiculo;
	}
	
	public boolean getActivo(){
		return Activo;
	}
 
}
