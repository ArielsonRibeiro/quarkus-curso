package org.br.mineradora.proposta.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_proposta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProposalEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String customer;
	
	@Column(name = "price_tonne")
	private BigDecimal priceTonne;
	
	private Integer tonnes;
	
	private String country;
	
	@Column(name = "proposal_valid_days")
	private String proposalValidDays;
	
	private Date created;

}
