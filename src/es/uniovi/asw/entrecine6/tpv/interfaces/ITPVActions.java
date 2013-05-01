package es.uniovi.asw.entrecine6.tpv.interfaces;

import es.uniovi.asw.entrecine6.tpv.model.Billboard;
import es.uniovi.asw.entrecine6.tpv.model.PaymentResult;
import es.uniovi.asw.entrecine6.tpv.model.Sale;

public interface ITPVActions {

	boolean checkTicket(String code);

	Billboard getBillboard();

	PaymentResult creditCardPayment(Sale sale);

	PaymentResult cashPayment(Sale sale);
}
