package es.uniovi.asw.entrecine6.central.persistence.exception;

/**
 * Thrown if an operation needs to save an entity and it already exists 
 * in the persistence system 
 */
public class OccupiedSeatException extends Exception {

	public OccupiedSeatException() {
	}

	public OccupiedSeatException(String message) {
		super(message);
	}

	public OccupiedSeatException(Throwable cause) {
		super(cause);
	}

	public OccupiedSeatException(String message, Throwable cause) {
		super(message, cause);
	}

	private static final long serialVersionUID = -869974233276021892L;
}
