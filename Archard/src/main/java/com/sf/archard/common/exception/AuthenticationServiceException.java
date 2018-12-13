package com.sf.archard.common.exception;

public class AuthenticationServiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AuthenticationServiceException() {
		super();
	}

	public AuthenticationServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public AuthenticationServiceException(String message) {
		super(message);
	}

	public AuthenticationServiceException(Throwable cause) {
		super(cause);
	}

}
