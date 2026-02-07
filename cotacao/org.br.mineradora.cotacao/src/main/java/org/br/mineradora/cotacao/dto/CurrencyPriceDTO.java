package org.br.mineradora.cotacao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CurrencyPriceDTO {
	
	@JsonProperty("USDBRL")
	private USDBRL usdbrl;

	public CurrencyPriceDTO() {
		super();
	}

}
