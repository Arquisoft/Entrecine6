package es.uniovi.asw.entrecine.interfaces;

import es.uniovi.asw.entrecine.model.Billboard;
import es.uniovi.asw.entrecine.model.CashSale;
import es.uniovi.asw.entrecine.model.CreditCardSale;
import es.uniovi.asw.entrecine.model.PaymentResult;

public interface ITPVActions {
	
	PaymentResult cashPayment(CashSale sale);
	
	PaymentResult creditCardPayment(CreditCardSale sale);
	
	boolean checkTicket(String code);
	
	Billboard getBillboard();
}
