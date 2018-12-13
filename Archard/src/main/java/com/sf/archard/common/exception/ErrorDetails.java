package com.sf.archard.common.exception;

import org.springframework.http.HttpStatus;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class ErrorDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	private boolean isError;
	private Date timestamp;
	private String message;
	private String details;
	private HttpStatus HttpStatus;

	public ErrorDetails(boolean isError, Date timestamp, String message, String details, HttpStatus httpStatus) {
		this.isError = isError;
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.HttpStatus = httpStatus;
	}

}
