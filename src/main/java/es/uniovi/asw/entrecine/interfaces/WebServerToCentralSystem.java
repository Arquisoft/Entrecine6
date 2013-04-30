package main.java.es.uniovi.asw.entrecine.interfaces;

import main.java.es.uniovi.asw.ServerBillboard.com.model.Billboard;
import main.java.es.uniovi.asw.ServerBillboard.com.model.CreditCardSale;
import main.java.es.uniovi.asw.ServerBillboard.com.model.PaymentResult;
import main.java.es.uniovi.asw.ServerBillboard.com.model.Ticket;
import main.java.es.uniovi.asw.ServerBillboard.com.model.User;

public interface WebServerToCentralSystem {
	
	boolean register(User user);
	
	User login(String userName, String password);
	
	Billboard requestBillboard();
	
	PaymentResult payment(CreditCardSale sale);
	
	Ticket receiveTicket(CreditCardSale sale);
	
	void connect(String listener);

}
