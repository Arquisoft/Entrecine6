package main.java.es.uniovi.asw.ServerBillboard;

import java.sql.Connection;
import java.sql.DriverManager;

public class ServerBilboardManager {

	/**
	 * Solicita la actualizaci�n de la cartelera. Esta actualizaci�n se solicitar� cuando se realice una modificaci�n en la cartelera.
	 * RMI
	 */
	public void RequestBillboard() {
		//
	}

	/**
	 * Solicita la conexi�n del servidor con las actualizaciones de la cartelera.
	 * @return conexion a la base de datos local
	 * @throws Exception Excepcion tratada
	 * RMI
	 */
	public Connection Connect() throws Exception {
		String SQL_DRV = "org.hsqldb.jdbcDriver";
		String SQL_URL = "jdbc:hsqldb:hsql://localhost";
		Class.forName(SQL_DRV);
		return DriverManager.getConnection(SQL_URL, "sa", "");
	}
	
	/**
	 * Solicita modificar la base de dato en cuando se produce una actualizaci�n de la base de datos general.
	 */
	public void SetBillboard(){
		//setBillboard
	}
}
