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

import negocio.Categoria;
import negocio.Cliente;
import negocio.DetallePedido;
import negocio.MateriaPrima;
import negocio.Pedido;
import negocio.Producto;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.view.JasperViewer;
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
	
	public static ArrayList<Categoria> devuelveCategoria() {

		ArrayList<Categoria> categoria = new ArrayList<Categoria>();

		// Recorro el resultado y creo los clientes

		try {
			ResultSet result;
			result = Basededatos.consultasql("SELECT * FROM categoria");
			result.previous();
			while (result.next()) {

				categoria.add(new Categoria(result.getInt(1), result.getString(2)));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoria;

	}

	// Devuelve los productos
	public static ArrayList<Producto> devuelveProductos() {

		ArrayList<Producto> productos = new ArrayList<Producto>();

		// Recorro el resultado y creo los productos

		try {
			ResultSet result;
			result = Basededatos.consultasql("SELECT * FROM producto");
			result.previous();
			while (result.next()) {
 
				productos.add(new Producto(result.getInt(1), result.getString(2), result.getDouble(3), result.getInt(4),result.getInt(5)));

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
						datosProducto.getInt(4), datosProducto.getInt(5));

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
	public static String dameNumeroPedido() {

		ResultSet totalPedidosDelDia = null;
		String numeroPedido = null;
		String fechaDelDia = null;

		// Defino la fecha del dia
		fechaDelDia = Basededatos.dateToMySQLDate2(new Date());

		// Obtengo los pedidos del dia
		try {

			totalPedidosDelDia = Basededatos
					.consultasql("Select COUNT(*) from pedido WHERE pedido.FechaPedido ="
							+ "'" + fechaDelDia + "'");
			numeroPedido = String.valueOf((totalPedidosDelDia.getInt(1) + 1))
					+ "-" + fechaDelDia;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return numeroPedido;

	}

	public static void abrirReporte(String archivo, String parametroAPasarle,
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

				matPrima.add(new MateriaPrima(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4)));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return matPrima;
	}
	
	public static ArrayList<Pedido> devuelvepedidoEstado(){

		ArrayList<Pedido> pedidos=new ArrayList<Pedido>();
				
		//Recorro el resultado y creo las materias primas
		
		try {
			ResultSet result;
			result = Basededatos.consultasql("SELECT * FROM pedido" );
			result.previous();
			while (result.next()) {
				
				pedidos.add(new Pedido(result.getString(1),result.getString(2),result.getInt(3),result.getString(4),
                                        result.getDouble(5),result.getInt(8),result.getString(9)));
				
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pedidos;
	}

	public static void agregarmatprima(int id,String nombre, int categoria,
			int habilitado) {
		String sql = "INSERT INTO materiaprima (idMatPrima,Categoria,MateriaPrima,Habilitado) VALUES("+id
			 + "," + categoria +",'"+ nombre + "'"+"," + habilitado + ")";
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
			if (hab == 1) {
				JOptionPane.showMessageDialog(null, "Materia prima habilitada");
			} else if (hab == 0) {
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
	
	public static void modificarpedido(int id,int dc,String estado){
        String sql="UPDATE pedido SET ADomicilio="+dc+", Estado="+"'"+estado+"'"+ " WHERE IDPedido="+id;  
        try {
            Basededatos.ejecutarsql(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Pizzeria.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
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
		String sql = "INSERT INTO detallepedido (IDPedido,NumeroPedido,IDProducto,Cantidad,Observacion) VALUES("
				 
				+ detalle.getIdPedido()
				+ ","
				+ detalle.getNumeroPedido()
				+ ","
				+ detalle.getidproducto()
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

	
	
	public static void modificarpedido(String id, Double total) {
		String sql = "UPDATE pedido SET TotalPedido=" + total  + " WHERE IDPedido=" +id ;
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
	
	public static void AgregarCliente(Cliente cliente){
        String sql="INSERT INTO cliente (IDCliente,Cliente,DNI,Direccion,Telefono,Activo) VALUES("
                +cliente.getIdCliente()+","
        		+"'"+
                cliente.getNombreCliente()
                +"'"+
                ","+
                cliente.getDni()
                +","+
                "'"+
                cliente.getDireccion()
                +"'"+
                ","+
                cliente.getTelefono()
                +","+
                cliente.getActivo()+")";
        try {
            Basededatos.ejecutarsql(sql);
            JOptionPane.showMessageDialog(null,"Cliente guardado con exito");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al guardar");
            Logger.getLogger(Pizzeria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void modificarcliente(int dni,String nombre,String dir,int tel){
            String sql="UPDATE cliente SET Cliente="+"'"+nombre+"'"+",Direccion="+"'"+dir+"'"+",Telefono="+tel
                + " WHERE DNI="+dni;             
            try {
            Basededatos.ejecutarsql(sql);
            JOptionPane.showMessageDialog(null,"Cliente modificado con exito");
        } catch (SQLException ex) {
            Logger.getLogger(Pizzeria.class.getName()).log(Level.SEVERE, null, ex);
        }          
    }
    
    public static void bloquearcliente(int estado,int dni){
        String sql="UPDATE cliente SET Activo="+estado+" WHERE DNI= "+dni; 
        try {
            Basededatos.ejecutarsql(sql);
            JOptionPane.showMessageDialog(null,"Cliente modificado con exito");
        } catch (SQLException ex) {
            Logger.getLogger(Pizzeria.class.getName()).log(Level.SEVERE, null, ex);
        }          
    }

}
