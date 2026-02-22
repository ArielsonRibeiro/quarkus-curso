package org.br.mineradora.library.exception;

import org.br.mineradora.library.dto.ErrorDefault;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class RestExceptionHandler {
	// TODO Melhoria implementar como interceptador para ficar generica

	public static WebApplicationException throwException(int status, Exception e) {
		ErrorDefault error = new ErrorDefault();
		error.setError(e.getClass().getSimpleName());
		error.setErrorDescription(e.getMessage());
		Response resp = Response.status(status).entity(error).build();
		return new CustomRestException(resp);
	}
}
