package negocio;

public class Itinerario {
	private int idItinerario;
	private int IdRepartidor;
	private int idIPedido;
	private String fecha;
	
	public Itinerario(int idI, int idR,int idP, String fecha){
		this.idItinerario=idI;
		this.IdRepartidor=idR;
		this.idIPedido=idP;
		this.fecha=fecha;
	}
	
	public int getItinerario(){
		return idItinerario;
	}
	
	public int getRepartidor(){
		return IdRepartidor;
	} 
	
	public int getPedido(){
		return idIPedido;
	}
	
	public String getFecha(){
		return fecha;
	}
	
	public void setItinerario(int itinerario){
		this.idItinerario=itinerario;
	}

	public void setRepartidor(int repartidor){
		this.IdRepartidor=repartidor;
	}

	public void setPedido(int pedido){
		this.idIPedido=pedido;
	}
}
