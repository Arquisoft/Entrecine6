package es.uniovi.asw.entrecine6.central.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Sale implements Serializable{
	
	private Long id;
	
	private int numberOfSeats;
	
	private Session session;
	
	private String paymentInfo;

	public Sale(Long id, int numberOfSeats, Session session, String paymentInfo) {
		super();
		this.id = id;
		this.numberOfSeats = numberOfSeats;
		this.session = session;
		this.paymentInfo = paymentInfo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public String getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}


}
