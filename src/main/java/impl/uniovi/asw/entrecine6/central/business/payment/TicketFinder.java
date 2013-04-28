package impl.uniovi.asw.entrecine6.central.business.payment;

import es.uniovi.asw.entrecine6.central.business.exception.BusinessException;
import es.uniovi.asw.entrecine6.central.infrastructure.DBServicesFactory;
import es.uniovi.asw.entrecine6.central.model.Ticket;

public class TicketFinder {

	public boolean validateCode(String ticketCode) {
		Ticket ticket;
		try {
			ticket = DBServicesFactory.getSalesDBService()
					.getTicket(ticketCode);

			if (ticket != null && ticket.getCode().equals(ticketCode))
				return true;
			
		} catch (BusinessException e) {
			e.printStackTrace();
		}

		return false;
	}

}
