package datos;

import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Busqueda {

	// filtro
	public static ResultSet devuelveTabla(String tabla) throws SQLException {

		ResultSet result = Basededatos.consultasql("SELECT * FROM " + tabla);

		return result;

	}

	// filtro con condicion
	public static ResultSet filtroATabla(String tabla, String nomColumna,
			String filtro) throws SQLException {

		ResultSet result = Basededatos.consultasql("SELECT * FROM " + tabla
				+ " WHERE " + nomColumna + " ='" + filtro + "'");

		return result;

	}

	// Metodo filtro sobre filtro
	public static String buscaUnValor(ResultSet datosDondeBuscar,
			String columnaFiltro, String filtro, String columnaDevuelta)
			throws SQLException {

		try {
			datosDondeBuscar.previous();
			while (datosDondeBuscar.next()) {

				if (datosDondeBuscar.getString(
						datosDondeBuscar.findColumn(columnaFiltro)).equals(
						filtro) == true) {

					return datosDondeBuscar.getString(datosDondeBuscar
							.findColumn(columnaDevuelta));

				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

}
