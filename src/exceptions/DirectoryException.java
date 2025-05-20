package exceptions;

public class DirectoryException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public DirectoryException(String message) {
		super(message);
	}

	public DirectoryException(String message, Throwable cause) {
		super(message, cause);
	}
}
