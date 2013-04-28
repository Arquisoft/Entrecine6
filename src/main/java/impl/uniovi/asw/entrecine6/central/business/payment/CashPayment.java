package impl.uniovi.asw.entrecine6.central.business.payment;

import impl.uniovi.asw.entrecine6.central.business.payment.sales.SalesManager;
import es.uniovi.asw.entrecine6.central.business.exception.BusinessException;
import es.uniovi.asw.entrecine6.central.model.PaymentResult;
import es.uniovi.asw.entrecine6.central.model.Sale;

public class CashPayment {

	public PaymentResult doPayment(Sale sale) {
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
