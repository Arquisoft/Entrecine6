package es.uniovi.asw.entrecine6.central.business;

import es.uniovi.asw.entrecine6.central.model.CashSale;
import es.uniovi.asw.entrecine6.central.model.CreditCardSale;
import es.uniovi.asw.entrecine6.central.model.PaymentResult;
import es.uniovi.asw.entrecine6.central.model.Ticket;

public interface PaymentService {
	
	PaymentResult creditCardPayment(CreditCardSale sale);
	
	PaymentResult cashPayment(CashSale sale);
	
	PaymentResult serverPayment(CreditCardSale sale);
	
	Ticket obtainTicket(CreditCardSale sale);

	boolean checkTicket(String ticketCode);

}
