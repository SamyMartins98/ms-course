package com.samymartins.hrworker.exception;

public class WorkerException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public WorkerException() {
        super("Ocorreu um erro na aplicação.");
    }

    public WorkerException(String message) {
        super(message);
    }

    public WorkerException(String message, Throwable cause) {
        super(message, cause);
    }

    public WorkerException(Throwable cause) {
        super(cause);
    }
}
