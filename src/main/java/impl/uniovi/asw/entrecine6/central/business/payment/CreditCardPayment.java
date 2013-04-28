package impl.uniovi.asw.entrecine6.central.business.payment;

import impl.uniovi.asw.entrecine6.central.business.payment.sales.SalesManager;
import es.uniovi.asw.entrecine6.central.business.exception.BusinessException;
import es.uniovi.asw.entrecine6.central.infrastructure.BankFactory;
import es.uniovi.asw.entrecine6.central.infrastructure.bank.DoPayment;
import es.uniovi.asw.entrecine6.central.model.PaymentResult;
import es.uniovi.asw.entrecine6.central.model.Sale;

public class CreditCardPayment {

	public PaymentResult doPayment(Sale sale) {
		DoPayment gateway = BankFactory.createDoPayment();

		if (gateway.doPayment(sale) == false) {
			return new PaymentResult(PaymentResult.ErrorCode.INVALIDPAYMENT);
		}

		int[] seats;
		try {
			seats = SalesManager.saveSale(sale);
		} catch (BusinessException e) {
			e.printStackTrace();
			return new PaymentResult(PaymentResult.ErrorCode.SESSIONFULL);
		}

		return new PaymentResult(PaymentResult.ErrorCode.OKEY, seats, sale);
	}

}
