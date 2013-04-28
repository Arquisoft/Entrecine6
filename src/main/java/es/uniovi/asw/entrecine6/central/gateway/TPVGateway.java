package es.uniovi.asw.entrecine6.central.gateway;

import java.rmi.Remote;
import java.rmi.RemoteException;

import es.uniovi.asw.entrecine6.central.model.Billboard;
import es.uniovi.asw.entrecine6.central.model.PaymentResult;
import es.uniovi.asw.entrecine6.central.model.Sale;

public interface TPVGateway extends Remote {

	PaymentResult cashPayment(Sale sale) throws RemoteException;

	PaymentResult creditCardPayment(Sale sale) throws RemoteException;

	boolean checkTicket(String code) throws RemoteException;

	Billboard getBillboard() throws RemoteException;
}
