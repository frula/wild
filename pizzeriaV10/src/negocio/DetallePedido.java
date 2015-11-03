package negocio;

public class DetallePedido {

	private String idPedido;
	private int idproducto;
	private String numeroPedido;
	private Producto producto;
	private int cantidad;
	private String observacion;
	private Double precioUnitario;

	public DetallePedido(String idPedido, String numPed,
			Producto productoIngresado, int cantidad, String observacion) {

		this.idPedido = idPedido;
		this.numeroPedido = numPed;
		this.producto = productoIngresado;
		this.cantidad = cantidad;
		this.observacion = observacion;
	}

	public DetallePedido(String idPedido, int productoIngresado,
			int cantidad, String observacion) {

		this.idPedido = idPedido;
		this.idproducto = productoIngresado;
		this.cantidad = cantidad;
		this.observacion = observacion;
	
	}

	public DetallePedido(int productoIngresado,
			int cantidad) {

		this.idproducto = productoIngresado;
		this.cantidad = cantidad;
		
	}
	public String getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
	}

	public String getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
    
    public int getidproducto(){
       return idproducto;
   }
    
    public Double getprecioUnitario(){
        return precioUnitario;
    }
}
