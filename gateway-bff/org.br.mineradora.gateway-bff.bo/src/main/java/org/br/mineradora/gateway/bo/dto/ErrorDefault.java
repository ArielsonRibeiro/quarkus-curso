package org.br.mineradora.gateway.bo.dto;

import jakarta.json.bind.annotation.JsonbProperty;

public class ErrorDefault {

	private String error;
	
	@JsonbProperty("error_description")
	private String errorDescription;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	
}
