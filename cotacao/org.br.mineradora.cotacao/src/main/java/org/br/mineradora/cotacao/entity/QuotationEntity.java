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

@Entity
@Table(name = "tb_quotation")
@Data
@NoArgsConstructor
public class QuotationEntity {
	
	@Id
	@GeneratedValue
	private Long id;

	private Date date;
	
	@Column(name = "currency_price")
	private BigDecimal currencyPrice;
}
