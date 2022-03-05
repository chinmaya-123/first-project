package com.project.shoppingcart.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class EmailExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmailExistException(String message) {
		super(message);
	}

}
