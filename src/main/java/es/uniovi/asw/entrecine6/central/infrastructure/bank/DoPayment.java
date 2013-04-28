package es.uniovi.asw.entrecine6.central.infrastructure.bank;

import es.uniovi.asw.entrecine6.central.model.Sale;

public class DoPayment {
	
	private IPaymentGateway paymentGateway;
	
	public void setPaymentGateway(IPaymentGateway paymentGateway) {
		this.paymentGateway = paymentGateway;
	}

	public boolean doPayment(Sale sale){
		return paymentGateway.pay(sale);
	}

}
