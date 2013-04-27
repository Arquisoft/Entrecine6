package es.uniovi.asw.entrecine6.central.model;

@SuppressWarnings("serial")
public class CashSale extends AbstractSale {

	public CashSale(Long id, int numberOfSeats, Session session) {
		this.id = id;
		this.numberOfSeats = numberOfSeats;
		this.session = session;
	}

	@Override
	public String getPaymentInfo() {
		return "Cash";
	}

}
