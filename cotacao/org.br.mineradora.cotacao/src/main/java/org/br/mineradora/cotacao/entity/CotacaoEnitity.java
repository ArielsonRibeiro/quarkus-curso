package org.br.mineradora.cotacao.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cotacao")
public class CotacaoEnitity {
	
	@Id
	@GeneratedValue
	private long id;
	
	private Date date;
	
	@Column(name = "currency_price")
	private BigDecimal currencyPrice;
	
	@Column(name = "pct_change")
	private String pctChange;
	
	private String pair;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getPctChange() {
		return pctChange;
	}

	public void setPctChange(String pctChange) {
		this.pctChange = pctChange;
	}

	public String getPair() {
		return pair;
	}

	public void setPair(String pair) {
		this.pair = pair;
	}
	
}
