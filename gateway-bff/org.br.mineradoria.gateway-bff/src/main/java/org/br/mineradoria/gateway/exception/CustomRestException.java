package org.br.mineradoria.gateway.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class CustomRestException extends WebApplicationException {

	private static final long serialVersionUID = 1L;

	public CustomRestException(Response response) {
		super(response);
	}

}
