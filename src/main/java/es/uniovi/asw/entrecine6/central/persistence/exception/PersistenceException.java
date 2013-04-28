package es.uniovi.asw.entrecine6.central.persistence.exception;

public class PersistenceException extends RuntimeException {

	public PersistenceException() {
		super();
	}

	public PersistenceException(String message, Throwable cause) {
		super(message, cause);
	}

	public PersistenceException(String message) {
		super(message);
	}

	public PersistenceException(Throwable cause) {
		super(cause);
	}

	private static final long serialVersionUID = -2093817605790994448L;
}
