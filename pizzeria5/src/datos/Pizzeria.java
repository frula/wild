package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import negocio.Cliente;
import negocio.Combo;
import negocio.DetalleCombo;
import negocio.DetallePedido;
import negocio.MateriaPrima;
import negocio.Pedido;
import negocio.Producto;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Pizzeria {

	// Devuelve los clientes
	public static ArrayList<Cliente> devuelveClientes() {

		ArrayList<Cliente> clientes = new ArrayList<Cliente>();

		// Recorro el resultado y creo los clientes

		try {
			ResultSet result;
			result = Basededatos.consultasql("SELECT * FROM cliente");
			result.previous();
			while (result.next()) {

				clientes.add(new Cliente(result.getInt(1), result.getString(2),
						result.getString(3), result.getString(4), result
								.getString(5), result.getInt(6)));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientes;

	}

	// Devuelve los productos
	public static ArrayList<Producto> devuelveProductos() {

		ArrayList<Producto> productos = new ArrayList<Producto>();

		// Recorro el resultado y creo los productos

		try {
			ResultSet result;
			result = Busqueda.devuelveTabla("producto");
			result.previous();
			while (result.next()) {

				productos.add(new Producto(result.getInt(1), result
						.getString(2), result.getDouble(3), result.getString(4),
						result.getInt(5)));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productos;

	}

	// Devuelve los pedidos no preparados
	public static ArrayList<DetallePedido> devuelveNoPreparados()

	throws SQLException {

		Producto productoActivo;
		DetallePedido linea;

		ArrayList<DetallePedido> lineasDetalle = new ArrayList<DetallePedido>();

		ResultSet datosProducto;
		ResultSet productosDeDetallePedidos;

		ResultSet pendientesDePreparacion;
		pendientesDePreparacion = Busqueda.filtroATabla("pedido", "Preparado",
				"0");

		// Recorro los pendientes de preparacion
		pendientesDePreparacion.previous();
		while (pendientesDePreparacion.next()) {

			// Obtengo las lineas del pedido en detallepedidos
			productosDeDetallePedidos = Busqueda.filtroATabla("detallePedido",
					"IDPedido", pendientesDePreparacion.getString(1));

			productosDeDetallePedidos.previous();

			while (productosDeDetallePedidos.next()) {

				// Guardo los datos del producto de cada linea
				datosProducto = Busqueda.filtroATabla("producto", "IDProducto",
						productosDeDetallePedidos.getString(3));

				// Construyo el productos

				productoActivo = new Producto(datosProducto.getInt(1),
						datosProducto.getString(2), datosProducto.getDouble(3),
						datosProducto.getString(4), datosProducto.getInt(5));

				// Construyo la linea
				linea = new DetallePedido(
						String.valueOf(pendientesDePreparacion.getInt(1)),
						pendientesDePreparacion.getString(2), productoActivo,
						productosDeDetallePedidos.getInt(4),
						productosDeDetallePedidos.getString(5));

				lineasDetalle.add(linea);
			}
		}

		return lineasDetalle;
	}

	// Devuelve la suma de lo pendiente
	public static ResultSet devuelveAcumulados() {
		ResultSet lineas = null;
		try {
			lineas = Basededatos
					.consultasql("Select "
							+ "detallepedido.IDProducto, sum(detallepedido.Cantidad) as totalAcumulado, producto.Producto from pedido inner join"
							+ " detallepedido on pedido.IDPedido=detallepedido.IDPedido inner join producto on detallepedido.IDProducto=producto.IDProducto WHERE pedido.Preparado = 0 GROUP BY detallepedido.IDProducto ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lineas;
	}

	// Genera numero de pedido
	public static Integer dameNumeroPedido() {

		ResultSet totalPedidosDelDia = null;
		Integer numeroPedido = null;
		String fechaDelDia = null;

		// Defino la fecha del dia
		fechaDelDia = Basededatos.dateToMySQLDate2(new Date());

		// Obtengo los pedidos del dia
		try {

			totalPedidosDelDia = Basededatos
					.consultasql("Select COUNT(*) from pedido WHERE pedido.FechaPedido ="
							+ "'" + fechaDelDia + "'");
			numeroPedido = (totalPedidosDelDia.getInt(1) + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return numeroPedido;

	}

	public static void abrirReporte(String archivo, Integer parametroAPasarle,
			String nombreParametro)

	{
		String fileName = archivo;

		Basededatos.establecerConexion();
		JasperPrint print;
		try {
			Map parametro = new HashMap();
			parametro.put(nombreParametro, parametroAPasarle);

			print = JasperFillManager.fillReport(fileName, parametro,
					Basededatos.getConexion());
			JasperViewer jviewer = new JasperViewer(print, false);
			jviewer.setVisible(true);
			Basededatos.establecerConexion();

		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Devuelve materias primas
	public static ArrayList<MateriaPrima> devuelveMateriaPrima() {

		ArrayList<MateriaPrima> matPrima = new ArrayList<MateriaPrima>();

		// Recorro el resultado y creo las materias primas

		try {
			ResultSet result;
			result = Basededatos.consultasql("SELECT * FROM materiaprima");
			result.previous();
			while (result.next()) {

				matPrima.add(new MateriaPrima(result.getInt(1), result
						.getString(2), result.getString(3), result.getInt(4)));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return matPrima;
	}

	public static void agregarmatprima(String nombre, String categoria,
			int habilitado) {
		String sql = "INSERT INTO materiaprima (MateriaPrima,Categoria,Habilitado) VALUES("
				+ nombre + "'" + "," + categoria + "," + habilitado + ")";
		try {
			Basededatos.ejecutarsql(sql);

			JOptionPane.showMessageDialog(null,
					"Registro guardado exitosamente");

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al guardar registro");
			Logger.getLogger(Pizzeria.class.getName()).log(Level.SEVERE, null,
					ex);
		}
	}

	public static void bloquarDesbloquearMatprima(int id, int hab) {
		String sql = "UPDATE materiaprima SET Habilitado=" + hab
				+ " WHERE IdMatPrima=" + id;
		try {
			Basededatos.ejecutarsql(sql);
			if (hab == 0) {
				JOptionPane.showMessageDialog(null, "Materia prima habilitada");
			} else if (hab == 1) {
				JOptionPane.showMessageDialog(null,
						"Materia prima No habilitada");
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error modificar registro");
			Logger.getLogger(Pizzeria.class.getName()).log(Level.SEVERE, null,
					ex);
		}
	}

	public static void modificarmatprima(int id, String nombre, int categoria) {
		String sql = "UPDATE materiaprima SET MateriaPrima=" + "'" + nombre
				+ "'," + "Categoria=" + categoria + " WHERE IdMatPrima=" + id;
		try {
			Basededatos.ejecutarsql(sql);
			JOptionPane.showMessageDialog(null,
					"Registro modificado exitosamente");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al modificar registro");
			Logger.getLogger(Pizzeria.class.getName()).log(Level.SEVERE, null,
					ex);
		}
	}

	public static ArrayList<Pedido> devuelvepedido() {

		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

		// Recorro el resultado y creo las materias primas

		try {
			ResultSet result;
			result = Basededatos.consultasql("SELECT * FROM pedido");
			result.previous();
			while (result.next()) {

				pedidos.add(new Pedido(result.getString(1),
						result.getString(2), result.getInt(3), Basededatos
								.dateToMySQLDate2(result.getDate(4)), result
								.getDouble(5), result.getInt(6), result
								.getInt(7), result.getInt(8)));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pedidos;
	}

	public static ArrayList<DetallePedido> devuelvedetallepedido() {

		ArrayList<DetallePedido> detalle = new ArrayList<DetallePedido>();

		// Recorro el resultado y creo las materias primas

		try {
			ResultSet result;
			result = Basededatos.consultasql("SELECT * FROM detallepedido");
			result.previous();
			while (result.next()) {

				detalle.add(new DetallePedido(result.getString(1), result
						.getInt(3), result.getInt(4),
						result.getString(5)));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return detalle;
	}

	public static void agregarPedido(String id, int numpedido, int cliente,
			Date fecha, Double subtotal, Double total, int pagado,
			int preparado, int dc) {
		// se podria pedir un pedido en el metodo
		// System.out.println(id);
		String sql = "INSERT INTO pedido (IDPedido,NumeroPedido,Cliente,FechaPedido,SubTotal,TotalPedido,PagoConfirmado,PedidoPreparado,EntregaDomicilio)"
				+ " VALUES("
				+ "'"
				+ id
				+ "'"
				+ ","
				+ numpedido
				+ ","
				+ cliente
				+ ","
				+ "'"
				+ fecha
				+ "'"
				+ ","
				+ subtotal
				+ ","
				+ total
				+ ","
				+ pagado + "," + preparado + "," + dc + ")";

		try {
			Basededatos.ejecutarsql(sql);
			JOptionPane.showMessageDialog(null, "Pedido agregado");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al ingresar registro");
			Logger.getLogger(Pizzeria.class.getName()).log(Level.SEVERE, null,
					ex);
		}
	}

	public static void agregarDetallePedido(DetallePedido detalle) {
		String sql = "INSERT INTO detallepedido (IDPedido,IDProducto,PrecioUnitario,Cantidad,Observacion) VALUES("
				+ "'"
				+ detalle.getIdPedido()
				+ "'"
				+ ","
				+ detalle.getidproducto()
				+ ","
				+ detalle.getprecioUnitario()
				+ ","
				+ detalle.getCantidad()
				+ ","
				+ "'"
				+ detalle.getObservacion() + "'" + ")";
		try {
			Basededatos.ejecutarsql(sql);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al ingresar detalle");
			Logger.getLogger(Pizzeria.class.getName()).log(Level.SEVERE, null,
					ex);
		}
	}

	public static void modificarpedido(String id, int pa, int pr, int dc) {
		String sql = "UPDATE pedido SET Pagado=" + pa + ",Preparado=" + pr
				+ ",Adomicilio=" + dc + " WHERE IDPedido=" + "'" + id + "'";
		try {
			Basededatos.ejecutarsql(sql);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error modificar registro");
			Logger.getLogger(Pizzeria.class.getName()).log(Level.SEVERE, null,
					ex);
		}

	}

	public static void modificarpedido(String id, Double total, int pagado,
			int preparado) {
		String sql = "UPDATE pedido SET TotalPedido=" + total + "," + "Pagado="
				+ pagado + ",Preparado=" + preparado + " WHERE IDPedido=" + "'"
				+ id + "'";
		try {
			Basededatos.ejecutarsql(sql);
			JOptionPane.showMessageDialog(null,
					"Registro modificado exitosamente");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al modificar registro");
			Logger.getLogger(Pizzeria.class.getName()).log(Level.SEVERE, null,
					ex);
		}
	}

	public static void modificardetalle(String id, int idp, int cant, String ob) {
		String sql = "UPDATE detallepedido SET Cantidad=" + cant
				+ ",Observacion=" + "'" + ob + "'" + " WHERE IDPedido=" + "'"
				+ id + "'" + " and IDProducto=" + idp;
		System.out.println(sql);
		try {
			Basededatos.ejecutarsql(sql);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al modificar registro");
			Logger.getLogger(Pizzeria.class.getName()).log(Level.SEVERE, null,
					ex);
		}
	}

	public static void eliminardetalle(String id) {
		String sql = "DELETE FROM detallepedido WHERE IDPedido=" + "'" + id
				+ "'";

		try {
			Basededatos.ejecutarsql(sql);
		} catch (SQLException ex) {
			Logger.getLogger(Pizzeria.class.getName()).log(Level.SEVERE, null,
					ex);
		}
	}

	public static void eliminarpedido(String id) {
		String sql = "DELETE FROM pedido WHERE IDPedido=" + "'" + id + "'";
		try {
			Basededatos.ejecutarsql(sql);
			JOptionPane.showMessageDialog(null,
					"Registro eliminado exitosamente");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al eliminar registro");
			Logger.getLogger(Pizzeria.class.getName()).log(Level.SEVERE, null,
					ex);
		}
	}

	public static ArrayList<Combo> devuelvecombos() {

		ArrayList<Combo> combos = new ArrayList<Combo>();

		// Recorro el resultado y creo las materias primas

		try {
			ResultSet result;
			result = Busqueda.devuelveTabla("combo");
			result.previous();
			while (result.next()) {
				boolean estado=false;
				if(result.getInt(5)==0){
					estado=true;
				}
				if(result.getInt(5)==1){
					estado=false;
				}
				combos.add(new Combo(result.getInt(1),result.getString(2),
						result.getDouble(3), result.getString(4),estado));
						}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return combos;
	}

	public static ArrayList<DetalleCombo> devuelvedetallecombo(int idCombo) {

		ArrayList<DetalleCombo> detalle = new ArrayList<DetalleCombo>();

		// Recorro el resultado y creo las materias primas

		try {
			ResultSet result;
			result = Basededatos.consultasql("SELECT * FROM detallecombo");
			result.previous();
			while (result.next()) {

				if(result.getInt(1)==idCombo){
				detalle.add(new DetalleCombo(result.getInt(1), result
						.getInt(2), result.getInt(3)));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return detalle;
	}
}
