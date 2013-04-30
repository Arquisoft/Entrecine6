package main.java.es.uniovi.asw.ServerBillboard;

import java.sql.SQLException;

import main.java.es.uniovi.asw.ServerBillboard.com.model.Billboard;

public interface ServerBillboardManager {

	/**
	 * Devuelve el String con la URL
	 * @return URL
	 */
	public String Connect();

	/**
	 * Devuelve la Billboard local
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Billboard getLocalBillboard() throws ClassNotFoundException, SQLException;

	/**
	 * Actualiza la base de datos local con la remota
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void setLocalBillboard() throws ClassNotFoundException, SQLException;
}
