package org.br.mineradora.cotacao.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
}
