package org.br.mineradora.report.entity;

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
@Table(name = "tb_opportunity")
@Data
@NoArgsConstructor
public class OpportunityEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Date date;
	
	@Column(name = "proposal_id")
	private Long proposalId;
	
	private String customer;
	
	@Column(name = "price_tonner")
	private BigDecimal priceTonne;

	@Column(name = "last_dollar_quotation")
	private BigDecimal lastDollarQuotation;
	
	
}
