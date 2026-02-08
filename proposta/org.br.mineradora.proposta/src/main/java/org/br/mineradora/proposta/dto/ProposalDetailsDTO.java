package org.br.mineradora.proposta.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Jacksonized
public class ProposalDetailsDTO {

	private Long proposalId;
	
	private String customer;
	
	private BigDecimal priceTonne;
	
	private Integer tonnes;
	
	private String country;
	
	private String proposalValidDays;
	
}
