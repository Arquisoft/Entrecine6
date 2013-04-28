package es.uniovi.asw.entrecine6.central.infrastructure.bank.impl;

import es.uniovi.asw.entrecine6.central.infrastructure.bank.IPaymentGateway;
import es.uniovi.asw.entrecine6.central.model.Sale;

public class PaymentGateway implements IPaymentGateway{

	@Override
	public boolean pay(Sale sale) {
		return true;
	}

}
