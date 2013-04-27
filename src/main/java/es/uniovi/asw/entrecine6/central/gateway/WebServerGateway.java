package es.uniovi.asw.entrecine6.central.gateway;

import java.rmi.Remote;
import java.rmi.RemoteException;

import es.uniovi.asw.entrecine6.central.business.listener.BillboardUpdateListener;
import es.uniovi.asw.entrecine6.central.model.Billboard;
import es.uniovi.asw.entrecine6.central.model.CreditCardSale;
import es.uniovi.asw.entrecine6.central.model.PaymentResult;
import es.uniovi.asw.entrecine6.central.model.Ticket;
import es.uniovi.asw.entrecine6.central.model.User;

public interface WebServerGateway extends Remote {

	boolean register(User user) throws RemoteException;

	User login(String userName, String password) throws RemoteException;

	Billboard requestBillboard() throws RemoteException;

	PaymentResult payment(CreditCardSale sale) throws RemoteException;

	Ticket receiveTicket(CreditCardSale sale) throws RemoteException;

	void connect(BillboardUpdateListener listener) throws RemoteException;

}
