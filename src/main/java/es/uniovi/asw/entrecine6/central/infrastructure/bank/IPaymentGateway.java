package es.uniovi.asw.entrecine6.central.infrastructure.bank;

import es.uniovi.asw.entrecine6.central.model.Sale;

public interface IPaymentGateway {

	boolean pay(Sale sale);

}