package negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import datos.Basededatos;
import datos.Busqueda;

public class Producto {

	private String nombre;
	private Double precio;
	private String categoria;
	private int idProducto;
	private boolean estado;

	public Producto() {

		this.nombre = "";
		this.precio = 0.0;
		this.categoria = "";
		// this.idProducto="";
		this.estado = true;

	}

	// Constructor sin ID
	public Producto(String Nombre, Double Precio, String Categoria,
			boolean estado) {

		nombre = Nombre;
		precio = Precio;
		categoria = Categoria;
		this.estado = estado;
	}

	// Constructor con ID
	public Producto(int IDPro, String Nombre, Double Precio, String Categoria,
			int estaActivo) {

		idProducto = IDPro;
		nombre = Nombre;
		precio = Precio;
		categoria = Categoria;
		if (estaActivo == 0) {
			estado = true;
		} else if (estaActivo == 1) {
			estado = false;
		}
	}

	public boolean getEstado() {
		return estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public static void agregarProducto(String descripcion, Double precio,
			String categoria, int estado) throws SQLException {

		try {

			Basededatos
					.ejecutarsql("INSERT INTO producto (Producto,Precio,Categoria,Estado) VALUES ('"
							+ descripcion.toUpperCase()
							+ "', '"
							+ precio
							+ "', '" + categoria + "' , '" + estado + "')");
		} catch (SQLException ex) {
			// Logger.getLogger(Producto.class.getName()).log(Level.SEVERE,
			// null, ex);
		}

	}

	public static Producto buscarProducto(String nombre) {
		Producto p = new Producto();
		ArrayList produc = new ArrayList();

		String producto = "producto";
		String codigo = "Codigo";
		try {
			ResultSet pro = Busqueda.devuelveTabla(producto);
			while (pro.next()) {

				double p1 = Double.parseDouble(pro.getString(3));
				String cat = pro.getString(4);
				// p=new Producto(pro.getString(3),p1,i,pro.getString(2));
				produc.add(p);

				int j = Integer.parseInt(pro.getString(5));
				boolean est;

				if (j == 1) {

					est = true;
				} else {
					est = false;
				}

				if (pro.getString(2).equals(nombre)) {

					p = new Producto(pro.getString(2), p1, cat, est);
					return p;
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return p;
	}

	public static void modificarProducto(Producto nuevo, int idProducto) {

		try {
			Basededatos.ejecutarsql("UPDATE producto SET Precio="
					+ nuevo.getPrecio() + " WHERE IDProducto='" + idProducto
					+ "'");
			// Basededatos.ejecutarsql("UPDATE producto SET Producto='"+nuevo.getNombre()+" WHERE Producto='"+pro.getString(2)+"'");
			Basededatos.ejecutarsql("UPDATE producto SET Categoria="
					+ nuevo.getCategoria() + " WHERE IDProducto='" + idProducto
					+ "'");
			// Basededatos.ejecutarsql("UPDATE producto SET Codigo='"+nuevo.getId()+"WHERE Codigo='"+pro.getString(2)+"'");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void cambiarEstado(boolean estado, int idPro) {
		System.out.println(estado);
		int valor = 0;

		try {
			if (estado == true) {
				valor = 1;
			}
			if (estado == false) {
				valor = 0;
			}
			String sql = "UPDATE producto SET Estado=" + valor
					+ " WHERE IDProducto=" + idPro;
			Basededatos.ejecutarsql(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static ArrayList listaProductos() {
		ArrayList produc = new ArrayList();

		String producto = "producto";
		ResultSet pro;
		try {
			pro = Busqueda.devuelveTabla(producto);

			while (pro.next()) {
				produc.add(pro.getString(2));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return produc;

	}

	public static boolean existeProducto(String produc) {
		String producto = "producto";
		boolean valor = false;
		try {
			ResultSet pro = Busqueda.devuelveTabla(producto);

			while (pro.next()) {
				if (pro.getString(2).equals(produc)) {
					valor = true;
					return valor;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valor;
	}

	@Override
	public String toString() {
		return this.nombre;
	}

}
