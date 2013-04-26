package es.uniovi.asw.entrecine6.central.infrastructure.bank;

import es.uniovi.asw.entrecine6.central.model.CreditCardSale;

public interface IPaymentGateway {

	boolean pay(CreditCardSale sale);

}