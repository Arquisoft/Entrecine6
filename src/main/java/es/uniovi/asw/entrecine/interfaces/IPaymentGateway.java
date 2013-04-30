package main.java.es.uniovi.asw.entrecine.interfaces;

import main.java.es.uniovi.asw.ServerBillboard.com.model.CreditCardSale;

public interface IPaymentGateway {
	
	boolean pay(CreditCardSale sale);

}
