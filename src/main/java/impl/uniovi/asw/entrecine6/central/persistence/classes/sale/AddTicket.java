package impl.uniovi.asw.entrecine6.central.persistence.classes.sale;

import impl.uniovi.asw.entrecine6.central.persistence.DataEncryptor;
import impl.uniovi.asw.entrecine6.central.persistence.Invoke;

import java.sql.SQLException;

import es.uniovi.asw.entrecine6.central.business.exception.BusinessException;
import es.uniovi.asw.entrecine6.central.infrastructure.PersistenceFactory;
import es.uniovi.asw.entrecine6.central.infrastructure.jdbc.Jdbc;
import es.uniovi.asw.entrecine6.central.model.Sale;
import es.uniovi.asw.entrecine6.central.model.Ticket;
import es.uniovi.asw.entrecine6.central.persistence.dao.SaleDao;
import es.uniovi.asw.entrecine6.central.persistence.exception.DuplicatedTicketException;

public class AddTicket implements Invoke {

	private Ticket ticket;

	public AddTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public Object invoke() throws SQLException, BusinessException {
		DataEncryptor encryptor = new DataEncryptor("AS");
		SaleDao dao = PersistenceFactory.getSaleDao();

		dao.setConnection(Jdbc.getCurrentConnection());

		Sale sale = ticket.getInfo();

		String encodedInfo = encryptor.encrypt(sale.getPaymentInfo());

		Sale encodedSale = new Sale(sale.getId(), sale.getNumberOfSeats(),
				sale.getSession(), encodedInfo);

		Ticket encodedTicket = new Ticket(ticket.getId(), ticket.getCode(),
				encodedSale);

		try {
			dao.saveTicket(encodedTicket);
		} catch (DuplicatedTicketException e) {
			throw new BusinessException(e.getMessage());
		}

		return null;
	}
}
