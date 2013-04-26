package impl.uniovi.asw.entrecine6.central.business.payment;

import impl.uniovi.asw.entrecine6.central.business.payment.sales.SalesManager;
import es.uniovi.asw.entrecine6.central.model.CashSale;
import es.uniovi.asw.entrecine6.central.model.PaymentResult;

public class CashPayment {

	public PaymentResult doPayment(CashSale sale) {
		int[] seats = SalesManager.saveSale(sale);

		if (seats == null) {
			return new PaymentResult(PaymentResult.ErrorCode.SESSIONFULL);
		}

		return new PaymentResult(PaymentResult.ErrorCode.OKEY, seats, sale);
	}

}
