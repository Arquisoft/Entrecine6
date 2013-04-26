package impl.uniovi.asw.entrecine6.central.business.payment;

import es.uniovi.asw.entrecine6.central.infrastructure.PersistenceFactory;
import es.uniovi.asw.entrecine6.central.model.Ticket;

public class TicketFinder {

	public boolean validateCode(String ticketCode) {
		Ticket ticket = PersistenceFactory.getTicketPersistenceService()
				.getTicket(ticketCode);
		
		if (ticket != null && ticket.getCode().equals(ticketCode))
			return true;
		
		return false;
	}

}
