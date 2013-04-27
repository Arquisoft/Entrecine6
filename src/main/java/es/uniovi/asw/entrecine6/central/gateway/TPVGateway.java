package es.uniovi.asw.entrecine6.central.gateway;

import java.rmi.Remote;
import java.rmi.RemoteException;

import es.uniovi.asw.entrecine6.central.model.Billboard;
import es.uniovi.asw.entrecine6.central.model.CashSale;
import es.uniovi.asw.entrecine6.central.model.CreditCardSale;
import es.uniovi.asw.entrecine6.central.model.PaymentResult;

public interface TPVGateway extends Remote {

	PaymentResult cashPayment(CashSale sale) throws RemoteException;

	PaymentResult creditCardPayment(CreditCardSale sale) throws RemoteException;

	boolean checkTicket(String code) throws RemoteException;

	Billboard getBillboard() throws RemoteException;
}
