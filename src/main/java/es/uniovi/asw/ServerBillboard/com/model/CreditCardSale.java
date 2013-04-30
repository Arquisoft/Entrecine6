package main.java.es.uniovi.asw.ServerBillboard.com.model;

public class CreditCardSale extends AbstractSale {

	private String creditCardNumber;

	public CreditCardSale(Long id, int numberOfSeats, Session session,
			String creditCardNumber) {
		this.id = id;
		this.numberOfSeats = numberOfSeats;
		this.session = session;
		this.creditCardNumber = creditCardNumber;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	@Override
	public String getPaymentInfo() {
		return creditCardNumber;
	}

}
