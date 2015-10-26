package negocio;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import datos.Basededatos;

public class Cliente {

	private int idCliente;
	private String nombreCliente;
	private String dni;
	private String direccion;
	private String telefono;
	private int activo;

	// Constructor con ID
	public Cliente(int idCliente, String nombreCliente, String dni,
			String direccion, String telefono, int estaActivo) {

		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
		this.activo = estaActivo;

	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	// Constructor sin ID
	public Cliente(String nombreCliente, String dni, String direccion,
			String telefono, int estaActivo) {

		this.nombreCliente = nombreCliente;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
		this.activo = estaActivo;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return this.nombreCliente;
	}

	   public static void AgregarCliente(String Nombre,int DNI,String Direccion,int Telefono,int Habilitado){
           String sql;
           try {
               //sql="INSERT INTO cliente2 (IdCliente,Nombre,DNI,Direccion,Telefono) VALUES(?,?,?,?,?)";
               Basededatos.ejecutarsql("INSERT INTO cliente (Cliente,DNI,"
               		+ "Direccion,Telefono,Activo) VALUES("+DNI+","+Nombre+","+DNI+","
               				+ ""+Direccion+","+Telefono+","+Habilitado+")");
           } catch (SQLException ex) {
               Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
           }
       } 
}
