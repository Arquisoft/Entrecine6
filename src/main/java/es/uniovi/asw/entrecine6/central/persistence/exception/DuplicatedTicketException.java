package es.uniovi.asw.entrecine6.central.persistence.exception;

public class DuplicatedTicketException extends Exception {

	private static final long serialVersionUID = -5555124205180040709L;

	public DuplicatedTicketException() {
	}

	public DuplicatedTicketException(String message) {
		super(message);
	}

	public DuplicatedTicketException(Throwable cause) {
		super(cause);
	}

	public DuplicatedTicketException(String message, Throwable cause) {
		super(message, cause);
	}

}
