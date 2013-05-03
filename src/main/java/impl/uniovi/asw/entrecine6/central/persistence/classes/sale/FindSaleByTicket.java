package impl.uniovi.asw.entrecine6.central.persistence.classes.sale;

import impl.uniovi.asw.entrecine6.central.persistence.Invoke;

import java.sql.SQLException;

import es.uniovi.asw.entrecine6.central.infrastructure.PersistenceFactory;
import es.uniovi.asw.entrecine6.central.infrastructure.jdbc.Jdbc;
import es.uniovi.asw.entrecine6.central.persistence.dao.SaleDao;

public class FindSaleByTicket implements Invoke {
	
	private String ticketCode;

	public FindSaleByTicket(String ticketCode) {
		this.ticketCode = ticketCode;
	}

	@Override
	public Object invoke() throws SQLException {
		SaleDao dao = PersistenceFactory.getSaleDao();
		
		dao.setConnection(Jdbc.getCurrentConnection());
		
		return dao.findSaleByTicket(ticketCode);
	}

}
