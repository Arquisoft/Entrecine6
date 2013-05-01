package impl.uniovi.asw.entrecine6.tpv;

import es.uniovi.asw.entrecine6.tpv.interfaces.ITPVActions;
import es.uniovi.asw.entrecine6.tpv.model.Billboard;
import es.uniovi.asw.entrecine6.tpv.model.PaymentResult;
import es.uniovi.asw.entrecine6.tpv.model.Sale;

public class TPVActions implements ITPVActions {

	@Override
	public PaymentResult cashPayment(Sale sale) {
		// TPVGatewayImpl tpvg = new TPVGatewayImpl();
		// return tpvg.cashPayment(sale);
		// TODO Conectar al Gateway del sistema central
		return null;
	}

	@Override
	public PaymentResult creditCardPayment(Sale sale) {
		// TPVGatewayImpl tpvg = new TPVGatewayImpl();
		// return tpvg.cashPayment(sale);
		// TODO Conectar al Gateway del sistema central
		return null;
	}

	@Override
	public boolean checkTicket(String code) {
		// TPVGatewayImpl tpvg = new TPVGatewayImpl();
		// return tpvg.checkTicket(code);
		// TODO Conectar al Gateway del sistema central
		return false;
	}

	@Override
	public Billboard getBillboard() {
		// TPVGatewayImpl tpvg = new TPVGatewayImpl();
		// return tpvg.getBillboard();
		// TODO Conectar al Gateway del sistema central
		return null;
	}

}
