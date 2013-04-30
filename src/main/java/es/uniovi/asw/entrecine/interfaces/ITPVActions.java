package main.java.es.uniovi.asw.entrecine.interfaces;

import main.java.es.uniovi.asw.ServerBillboard.com.model.Billboard;
import main.java.es.uniovi.asw.ServerBillboard.com.model.CashSale;
import main.java.es.uniovi.asw.ServerBillboard.com.model.CreditCardSale;
import main.java.es.uniovi.asw.ServerBillboard.com.model.PaymentResult;

public interface ITPVActions {
	
	PaymentResult cashPayment(CashSale sale);
	
	PaymentResult creditCardPayment(CreditCardSale sale);
	
	boolean checkTicket(String code);
	
	Billboard getBillboard();
}
