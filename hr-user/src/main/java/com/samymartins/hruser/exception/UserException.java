package com.samymartins.hruser.exception;

public class UserException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public UserException() {
        super("Ocorreu um erro na aplicação.");
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(Throwable cause) {
        super(cause);
    }
}
