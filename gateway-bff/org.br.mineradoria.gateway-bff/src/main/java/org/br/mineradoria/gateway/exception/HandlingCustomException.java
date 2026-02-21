package org.br.mineradoria.gateway.exception;

import org.br.mineradoria.gateway.dto.ErrorDefault;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class HandlingCustomException {
	// TODO Melhoria implementar como interceptador para ficar generica

	public static WebApplicationException throwException(int status, Exception e) {
		ErrorDefault error = new ErrorDefault();
		error.setError(e.getClass().getSimpleName());
		error.setErrorDescription(e.getMessage());
		Response resp = Response.status(status).entity(error).build();
		return new CustomRestException(resp);
	}
}
