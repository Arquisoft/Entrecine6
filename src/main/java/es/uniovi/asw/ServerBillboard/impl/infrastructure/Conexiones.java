package main.java.es.uniovi.asw.ServerBillboard.impl.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexiones {

	public static Connection getConectionLocalDataBase() throws SQLException,
			ClassNotFoundException {
		String SQL_DRV = "org.hsqldb.jdbcDriver";
		String SQL_URL = "jdbc:hsqldb:hsql://localhost";
		// Obtenemos la conexión a la base de datos.
		Class.forName(SQL_DRV);
		return DriverManager.getConnection(SQL_URL, "sa", "");
	}
}
