package com.archidelion.archard.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidDataException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidDataException(String exception) {
		super(exception);
	}

}