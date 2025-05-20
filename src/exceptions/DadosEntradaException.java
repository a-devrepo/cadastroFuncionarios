package exceptions;

public class DadosEntradaException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DadosEntradaException(String message) {
		super(message);
	}

	public DadosEntradaException(String message, Throwable cause) {
		super(message, cause);
	}
}
