package negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import datos.Basededatos;
import datos.Busqueda;

public class Combo extends Producto{

	private int idCombo;
	private String nombreCombo;
	private double precioCombo;
	private String observacion;
	private boolean  estado;
	
	public Combo(int idComb,String nombreCombo, double precioCombo, String observacion,
			boolean estado) {
		this.idCombo=idComb;
		this.nombreCombo = nombreCombo;
		this.precioCombo = precioCombo;
		this.observacion = observacion;
		this.estado = estado;
	}	

	
	public int getIdCombo() {
		return idCombo;
	}


	public void setIdCombo(int idCombo) {
		this.idCombo = idCombo;
	}


	public String getNombreCombo() {
		return nombreCombo;
	}

	public void setNombreCombo(String nombreCombo) {
		this.nombreCombo = nombreCombo;
	}

	public double getPrecioCombo() {
		return precioCombo;
	}

	public void setPrecioCombo(double precioCombo) {
		this.precioCombo = precioCombo;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return this.nombreCombo;
	}
	
}