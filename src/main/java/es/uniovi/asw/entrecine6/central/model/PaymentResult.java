package es.uniovi.asw.entrecine6.central.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PaymentResult implements Serializable{
	
	public static enum ErrorCode{ OKEY, INVALIDPAYMENT, SESSIONFULL, INTERNALERROR}

	// Codigo de error
	private ErrorCode errorCode;
	
	// Asientos asignados a la venta para mostrarlos por pantalla
	private int[] seats;
	
	// Misma venta que la enviada, pero con el campo id con un valor
	// Debe usarse como parametro al pedir el ticket
	private Sale sale;
	
	public PaymentResult(ErrorCode error){
		this.errorCode = error;
	}

	public PaymentResult(ErrorCode errorCode, int[] seats, Sale sale) {
		this.errorCode = errorCode;
		this.seats = seats;
		this.sale = sale;
	}

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

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

}
