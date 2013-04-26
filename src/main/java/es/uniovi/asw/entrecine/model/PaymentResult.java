package es.uniovi.asw.entrecine.model;

public class PaymentResult {
	
	public static enum ErrorCode{ OKEY, INVALIDPAYMENT, SESSIONFULL, INTERNALERROR}

	// Codigo de error
	private ErrorCode errorCode;
	
	// Asientos asignados a la venta para mostrarlos por pantalla
	private int[] seats;

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public int[] getSeats() {
		return seats;
	}

	public void setSeats(int[] seats) {
		this.seats = seats;
	}
	
	
}
