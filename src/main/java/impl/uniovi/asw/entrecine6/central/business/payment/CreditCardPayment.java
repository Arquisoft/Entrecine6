package impl.uniovi.asw.entrecine6.central.business.payment;

import impl.uniovi.asw.entrecine6.central.business.payment.sales.SalesManager;
import es.uniovi.asw.entrecine6.central.infrastructure.BankFactory;
import es.uniovi.asw.entrecine6.central.infrastructure.bank.DoPayment;
import es.uniovi.asw.entrecine6.central.model.CreditCardSale;
import es.uniovi.asw.entrecine6.central.model.PaymentResult;

public class CreditCardPayment {

	public PaymentResult doPayment(CreditCardSale sale) {
		DoPayment gateway = BankFactory.createDoPayment();
		
		if(gateway.doPayment(sale) == false){
			return new PaymentResult(PaymentResult.ErrorCode.INVALIDPAYMENT);
		}
		
		int[] seats = SalesManager.saveSale(sale);
		
		if(seats == null){
			return new PaymentResult(PaymentResult.ErrorCode.SESSIONFULL);
		}
		
		return new PaymentResult(PaymentResult.ErrorCode.OKEY, seats, sale);
	}
	
	

}
