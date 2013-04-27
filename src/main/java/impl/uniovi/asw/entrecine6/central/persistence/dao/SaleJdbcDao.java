package impl.uniovi.asw.entrecine6.central.persistence.dao;

import java.sql.Connection;

import es.uniovi.asw.entrecine6.central.persistence.dao.SaleDao;

public class SaleJdbcDao implements SaleDao {

	private Connection connection;

	@Override
	public void setConnection(Connection con) {
		this.connection = con;
	}
	
}
