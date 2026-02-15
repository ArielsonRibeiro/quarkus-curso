package org.br.mineradora.report.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_quotation")
public class QuotationEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Date date;
	
	private BigDecimal currencyPrice;

}
