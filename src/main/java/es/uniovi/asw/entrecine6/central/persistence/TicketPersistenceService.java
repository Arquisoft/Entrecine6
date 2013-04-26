package es.uniovi.asw.entrecine6.central.persistence;

import es.uniovi.asw.entrecine6.central.model.Ticket;

public interface TicketPersistenceService {
	
	void saveTicket(Ticket ticket);
	
	Ticket getTicket(String ticketCode);

}
