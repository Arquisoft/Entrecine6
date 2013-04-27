package es.uniovi.asw.entrecine6.central.gateway;

import es.uniovi.asw.entrecine6.central.model.Billboard;
import es.uniovi.asw.entrecine6.central.model.CashSale;
import es.uniovi.asw.entrecine6.central.model.CreditCardSale;
import es.uniovi.asw.entrecine6.central.model.PaymentResult;

public interface TPVGateway {
	
	PaymentResult cashPayment(CashSale sale);
	
	PaymentResult creditCardPayment(CreditCardSale sale);
	
	boolean checkTicket(String code);
	
	Billboard getBillboard();
}
