package es.uniovi.asw.entrecine6.central.infrastructure.bank;

import es.uniovi.asw.entrecine6.central.model.CreditCardSale;

public class DoPayment {
	
	private IPaymentGateway paymentGateway;
	
	public void setPaymentGateway(IPaymentGateway paymentGateway) {
		this.paymentGateway = paymentGateway;
	}

	public boolean doPayment(CreditCardSale sale){
		return paymentGateway.pay(sale);
	}

}
