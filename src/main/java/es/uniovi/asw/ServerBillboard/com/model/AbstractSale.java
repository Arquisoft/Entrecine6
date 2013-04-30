package main.java.es.uniovi.asw.ServerBillboard.com.model;

public abstract class AbstractSale implements Sale {
	
	protected Long id;
	
	protected int numberOfSeats;
	
	protected Session session;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	@Override
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	

}
