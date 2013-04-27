package impl.uniovi.asw.entrecine6.central.business.payment;

import es.uniovi.asw.entrecine6.central.infrastructure.DBServicesFactory;
import es.uniovi.asw.entrecine6.central.model.Ticket;

public class TicketFinder {

	public boolean validateCode(String ticketCode) {
		Ticket ticket = DBServicesFactory.getSalesPersistenceService()
				.getTicket(ticketCode);
		
		if (ticket != null && ticket.getCode().equals(ticketCode))
			return true;
		
		return false;
	}

}
