package es.uniovi.asw.entrecine6.central.business.exception;

public class BusinessException extends Exception {

	public BusinessException() {
		super();
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	private static final long serialVersionUID = 1058931814311702510L;
}
