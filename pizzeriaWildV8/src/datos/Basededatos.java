package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JTextField;

public class Basededatos {
	static Connection conexion;
	// static String bd="crmbuddies";
	static String bd = "pizzeria";
	static String user = "root";
	static String password = "1234";
	static String server = "jdbc:mysql://127.0.0.1/" + bd;
	static final Pattern numberPattern = Pattern.compile("-?\\d+");

	public static void establecerConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(server, user, password);
		} catch (Exception e) {
			System.out.println("Imposible realizar conexion con la BD");
			e.printStackTrace();
		}
	}

	public static Connection getConexion() {
		return conexion;
	}

	public static void cerrar(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				System.out.print("No es posible cerrar la Conexion");
			}
		}
	}

	public static void cerrar(java.sql.Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}
	}

	public static void cerrarconexion() {

		if (conexion != null) {
			try {
				conexion.close();
			} catch (Exception e) {
			}
		}
	}

	public static ResultSet consultasql(String sql) throws SQLException {

		establecerConexion();
		Statement stmt = Basededatos.getConexion().createStatement();
		ResultSet resultado = stmt.executeQuery(sql);
		if (resultado.next())
			return resultado;
		System.err.println("La consulta está vacia");
		// cerrarconexion();
		return resultado;

	}

	public static void ejecutarsql(String sql) throws SQLException {

		// establecerConexion();
		Statement stmt = Basededatos.getConexion().createStatement();
		stmt.execute(sql);
		// cerrarconexion();
	}

	// Metodo para completar los datos en los textbox
	public static void llenaTextField(JTextField cajaALlenar, ResultSet consulta,
			int valorDelGetString) {

		try {
			while (consulta.next()) {

				cajaALlenar.setText(consulta.getString(valorDelGetString));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Metodo que convierte la fecha actual de tipo DATE a tipo DATE de Mysql
	public static String dateToMySQLDate2(Date fecha)
	{
	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
	return sdf.format(fecha);
	}
	public static void insert(String tabla,String nombreColumna,String valor){
		
		try {
			Basededatos.ejecutarsql("INSERT INTO '"+tabla+"' ('"+nombreColumna+"') VALUES ('"+valor+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
