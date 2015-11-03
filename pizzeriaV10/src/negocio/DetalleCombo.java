package negocio;

import java.util.ArrayList;

public class DetalleCombo {

	private int idCombo;
	private int producto;
	private int cantidad;
	
	public DetalleCombo(int idCombo, int producto, int cantidad) {
		this.idCombo = idCombo;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public int getIdCombo() {
		return idCombo;
	}

	public void setIdCombo(int idCombo) {
		this.idCombo = idCombo;
	}

	public int getProducto() {
		return producto;
	}

	public void setProducto(int producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
