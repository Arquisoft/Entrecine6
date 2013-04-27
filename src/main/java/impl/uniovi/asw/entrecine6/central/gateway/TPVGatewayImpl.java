package impl.uniovi.asw.entrecine6.central.gateway;

import es.uniovi.asw.entrecine6.central.business.BillboardService;
import es.uniovi.asw.entrecine6.central.business.PaymentService;
import es.uniovi.asw.entrecine6.central.gateway.TPVGateway;
import es.uniovi.asw.entrecine6.central.infrastructure.ServicesFactory;
import es.uniovi.asw.entrecine6.central.model.Billboard;
import es.uniovi.asw.entrecine6.central.model.CashSale;
import es.uniovi.asw.entrecine6.central.model.CreditCardSale;
import es.uniovi.asw.entrecine6.central.model.PaymentResult;

public class TPVGatewayImpl implements TPVGateway{
	
	public TPVGatewayImpl(){}

	@Override
	public PaymentResult cashPayment(CashSale sale) {
		PaymentService service = ServicesFactory.getPaymentService();
		return service.cashPayment(sale);
	}

	@Override
	public PaymentResult creditCardPayment(CreditCardSale sale) {
		PaymentService service = ServicesFactory.getPaymentService();
		return service.creditCardPayment(sale);
	}

	@Override
	public boolean checkTicket(String code) {
		PaymentService service = ServicesFactory.getPaymentService();
		return service.checkTicket(code);
	}

	@Override
	public Billboard getBillboard() {
		BillboardService service = ServicesFactory.getBillboardService();
		return service.getTPVBillboard();
	}

}
