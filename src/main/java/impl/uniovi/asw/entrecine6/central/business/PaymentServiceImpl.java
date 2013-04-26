package impl.uniovi.asw.entrecine6.central.business;

import impl.uniovi.asw.entrecine6.central.business.payment.CashPayment;
import impl.uniovi.asw.entrecine6.central.business.payment.CreditCardPayment;
import impl.uniovi.asw.entrecine6.central.business.payment.TicketFinder;
import impl.uniovi.asw.entrecine6.central.business.payment.TicketObtainer;
import es.uniovi.asw.entrecine6.central.business.PaymentService;
import es.uniovi.asw.entrecine6.central.model.CashSale;
import es.uniovi.asw.entrecine6.central.model.CreditCardSale;
import es.uniovi.asw.entrecine6.central.model.PaymentResult;
import es.uniovi.asw.entrecine6.central.model.Ticket;

public class PaymentServiceImpl implements PaymentService{

	@Override
	public PaymentResult creditCardPayment(CreditCardSale sale) {
		return new CreditCardPayment().doPayment(sale);
	}

	@Override
	public PaymentResult cashPayment(CashSale sale) {
		return new CashPayment().doPayment(sale);
	}

	@Override
	public PaymentResult serverPayment(CreditCardSale sale) {
		return new CreditCardPayment().doPayment(sale);
	}

	@Override
	public Ticket obtainTicket(CreditCardSale sale) {
		return new TicketObtainer().generateTicket(sale);
	}

	@Override
	public boolean checkTicket(String ticketCode) {
		return new TicketFinder().validateCode(ticketCode);
	}

}
