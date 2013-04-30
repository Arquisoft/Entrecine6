package es.uniovi.asw.entrecine6.central.persistence.exception;

/**
 * Thrown if an operation needs to save an entity and it already exists 
 * in the persistence system 
 */
public class SessionFullException extends Exception {

	public SessionFullException() {
	}

	public SessionFullException(String message) {
		super(message);
	}

	public SessionFullException(Throwable cause) {
		super(cause);
	}

	public SessionFullException(String message, Throwable cause) {
		super(message, cause);
	}

	private static final long serialVersionUID = -869974233276021892L;
}
