package es.uniovi.asw.entrecine6.central.business;

import es.uniovi.asw.entrecine6.central.model.PaymentResult;
import es.uniovi.asw.entrecine6.central.model.Sale;
import es.uniovi.asw.entrecine6.central.model.Ticket;

public interface PaymentService {
	
	PaymentResult creditCardPayment(Sale sale);
	
	PaymentResult cashPayment(Sale sale);
	
	PaymentResult serverPayment(Sale sale);
	
	Ticket obtainTicket(Sale sale);

	boolean checkTicket(String ticketCode);

}
