package es.uniovi.asw.entrecine.central.system.model;

public class PaymentResult {

	private boolean paid;

	private boolean sessionFull;

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public boolean isSessionFull() {
		return sessionFull;
	}

	public void setSessionFull(boolean sessionFull) {
		this.sessionFull = sessionFull;
	}
}
