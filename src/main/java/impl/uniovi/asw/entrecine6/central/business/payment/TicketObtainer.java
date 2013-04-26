package impl.uniovi.asw.entrecine6.central.business.payment;

import java.util.Random;

import es.uniovi.asw.entrecine6.central.infrastructure.PersistenceFactory;
import es.uniovi.asw.entrecine6.central.model.CreditCardSale;
import es.uniovi.asw.entrecine6.central.model.Ticket;

public class TicketObtainer {

	private final static int CODE_LENGTH = 10;

	public Ticket generateTicket(CreditCardSale sale) {
		Ticket ticket = new Ticket(generateCode(), sale);	
		PersistenceFactory.getTicketPersistenceService().saveTicket(ticket);
		return ticket;
	}

	private String generateCode() {
		StringBuffer code = new StringBuffer();
		long milis = new java.util.GregorianCalendar().getTimeInMillis();
		Random r = new Random(milis);
		int i = 0;
		while (i <= CODE_LENGTH) {
			char c = (char) r.nextInt(255);
			if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
				code.append(c);
				i++;
			}
		}
		return code.toString();
	}
}
