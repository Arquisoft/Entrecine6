package es.uniovi.asw.entrecine.model;

public class AbstractSale implements Sale {
	
	private Long id;
	
	private int numberOfSeats;
	
	private Session session;

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
