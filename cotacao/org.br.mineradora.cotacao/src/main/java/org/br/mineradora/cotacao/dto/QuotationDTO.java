package org.br.mineradora.cotacao.dto;

import java.math.BigDecimal;
import java.util.Date;

public class QuotationDTO {

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
