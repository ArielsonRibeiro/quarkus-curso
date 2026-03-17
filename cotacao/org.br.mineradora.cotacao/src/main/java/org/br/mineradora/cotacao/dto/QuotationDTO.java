package org.br.mineradora.cotacao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.quarkus.runtime.annotations.RegisterForReflection;


@RegisterForReflection
public class QuotationDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date date;

	private BigDecimal currencyPrice;

	public QuotationDTO() {
		super();
	}

	public QuotationDTO(Date date, BigDecimal currencyPrice) {
		super();
		this.date = date;
		this.currencyPrice = currencyPrice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getCurrencyPrice() {
		return currencyPrice;
	}

	public void setCurrencyPrice(BigDecimal currencyPrice) {
		this.currencyPrice = currencyPrice;
	}
}
