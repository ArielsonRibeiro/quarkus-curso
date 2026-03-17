package org.br.mineradora.cotacao.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyPriceDTO implements Serializable {

	private static final long serialVersionUID = 1L;
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
