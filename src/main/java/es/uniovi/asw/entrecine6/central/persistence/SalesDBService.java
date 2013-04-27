package es.uniovi.asw.entrecine6.central.persistence;

import es.uniovi.asw.entrecine6.central.model.Sale;
import es.uniovi.asw.entrecine6.central.model.Ticket;

public interface SalesDBService {
	
	void saveTicket(Ticket ticket);
	
	Ticket getTicket(String ticketCode);

	int[] saveSale(Sale sale);

}
