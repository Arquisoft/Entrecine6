package es.uniovi.asw.entrecine.model;

public class Ticket {
	
	private Long id;
	
	private String code;
	
	private Sale info;

	public Ticket(Long id, String code, Sale info) {
		this.id = id;
		this.code = code;
		this.info = info;
	}

	public Ticket(String code, Sale info) {
		this.code = code;
		this.info = info;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Sale getInfo() {
		return info;
	}

	public void setInfo(Sale info) {
		this.info = info;
	}

	

}
