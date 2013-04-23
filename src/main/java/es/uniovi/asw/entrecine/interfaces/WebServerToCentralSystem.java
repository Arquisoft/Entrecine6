package es.uniovi.asw.entrecine.interfaces;

import es.uniovi.asw.entrecine.listener.BillboardUpdateListener;
import es.uniovi.asw.entrecine.model.Billboard;
import es.uniovi.asw.entrecine.model.CreditCardSale;
import es.uniovi.asw.entrecine.model.PaymentResult;
import es.uniovi.asw.entrecine.model.Ticket;
import es.uniovi.asw.entrecine.model.User;

public interface WebServerToCentralSystem {
	
	boolean register(User user);
	
	User login(String userName, String password);
	
	Billboard requestBillboard();
	
	PaymentResult payment(CreditCardSale sale);
	
	Ticket receiveTicket();
	
	void connect(BillboardUpdateListener listener);

}
