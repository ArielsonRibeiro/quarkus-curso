package org.br.mineradora.gateway.bo.dto;

import java.math.BigDecimal;

public class OpportunityDTO {

	
	private Long proposalId;
	
	private String customer;
	
	private BigDecimal priceTonne;
	
	private BigDecimal lastDollarQuotation;

	public Long getProposalId() {
		return proposalId;
	}

	public void setProposalId(Long proposalId) {
		this.proposalId = proposalId;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public BigDecimal getPriceTonne() {
		return priceTonne;
	}

	public void setPriceTonne(BigDecimal priceTonne) {
		this.priceTonne = priceTonne;
	}

	public BigDecimal getLastDollarQuotation() {
		return lastDollarQuotation;
	}

	public void setLastDollarQuotation(BigDecimal lastDollarQuotation) {
		this.lastDollarQuotation = lastDollarQuotation;
	}

	@Override
	public String toString() {
		return "OpportunityDTO [proposalId=" + proposalId + ", customer=" + customer + ", priceTonne=" + priceTonne
				+ ", lastDollarQuotation=" + lastDollarQuotation + "]";
	}
	
}
