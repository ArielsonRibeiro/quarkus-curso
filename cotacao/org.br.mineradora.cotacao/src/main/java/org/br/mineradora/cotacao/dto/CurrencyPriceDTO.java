package org.br.mineradora.cotacao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyPriceDTO {
	
	@JsonProperty("USDBRL")
	private USDBRL usdbrl;

	public CurrencyPriceDTO() {
		super();
	}

	public USDBRL getUsdbrl() {
		return usdbrl;
	}

	public void setUsdbrl(USDBRL usdbrl) {
		this.usdbrl = usdbrl;
	}
	
	

}
