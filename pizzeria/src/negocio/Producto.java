package negocio;

public class Producto {

	private String nombre;
	private Double precio;
	private int categoria;
	private int idProducto;
	private int activo;

	// Constructor sin ID
	public Producto(String Nombre, Double Precio, int Categoria, int estaActivo) {

		nombre = Nombre;
		precio = Precio;
		categoria = Categoria;
		activo = estaActivo;
	}

	// Constructor con ID
	public Producto(int IDPro, String Nombre, Double Precio, int Categoria,
			int estaActivo) {

		idProducto = IDPro;
		nombre = Nombre;
		precio = Precio;
		categoria = Categoria;
		activo = estaActivo;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
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

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return this.nombre;
	}

}
