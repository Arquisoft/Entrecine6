package es.uniovi.asw.entrecine6.central.infrastructure;

import es.uniovi.asw.entrecine6.central.infrastructure.bank.DoPayment;
import es.uniovi.asw.entrecine6.central.infrastructure.bank.impl.PaymentGateway;

public class BankFactory {

	private static DoPayment bank;

	public static DoPayment createDoPayment() {
		if (bank == null) {
			bank = new DoPayment();
			bank.setPaymentGateway(new PaymentGateway());
		}
		return bank;
	}

}
