package es.uniovi.asw.entrecine.interfaces;

import es.uniovi.asw.entrecine.model.CreditCardSale;

public interface IPaymentGateway {
	
	boolean pay(CreditCardSale sale);

}
