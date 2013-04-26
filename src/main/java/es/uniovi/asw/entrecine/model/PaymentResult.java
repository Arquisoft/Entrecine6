package es.uniovi.asw.entrecine.model;

public class PaymentResult {

	private boolean paid = false;

	private boolean sessionFull = false;
	
	private String errorMessage = "";

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

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
