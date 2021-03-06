package com.archidelion.archard.bean;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class ErrorDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date timestamp;
	private String message;
	private String details;

	public ErrorDetails(Date timestamp, String message, String details) {
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

}
