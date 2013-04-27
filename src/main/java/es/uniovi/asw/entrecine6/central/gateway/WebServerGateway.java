package es.uniovi.asw.entrecine6.central.gateway;

import es.uniovi.asw.entrecine6.central.business.listener.BillboardUpdateListener;
import es.uniovi.asw.entrecine6.central.model.Billboard;
import es.uniovi.asw.entrecine6.central.model.CreditCardSale;
import es.uniovi.asw.entrecine6.central.model.PaymentResult;
import es.uniovi.asw.entrecine6.central.model.Ticket;
import es.uniovi.asw.entrecine6.central.model.User;

public interface WebServerGateway {
	
	boolean register(User user);
	
	User login(String userName, String password);
	
	Billboard requestBillboard();
	
	PaymentResult payment(CreditCardSale sale);
	
	Ticket receiveTicket(CreditCardSale sale);
	
	void connect(BillboardUpdateListener listener);

}
