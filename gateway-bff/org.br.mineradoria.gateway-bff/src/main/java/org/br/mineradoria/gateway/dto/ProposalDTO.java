package org.br.mineradoria.gateway.dto;

import java.math.BigDecimal;

public class ProposalDTO {

	private Long proposalId;
	
	private String customer;
	
	private BigDecimal priceTonner;

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

	public BigDecimal getPriceTonner() {
		return priceTonner;
	}

	public void setPriceTonner(BigDecimal priceTonner) {
		this.priceTonner = priceTonner;
	}

	@Override
	public String toString() {
		return "ProposalDTO [proposalId=" + proposalId + ", customer=" + customer + ", priceTonner=" + priceTonner
				+ "]";
	}

}
