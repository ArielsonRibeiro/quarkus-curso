package org.br.mineradora.gateway.bo.dto;

import java.math.BigDecimal;

public class ProposalDetailsDTO {

	private Long proposalId;
	
	private String customer;
	
	private BigDecimal priceTonne;
	
	private Integer tonnes;
	
	private String country;
	
	private String proposalValidDays;

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

	public Integer getTonnes() {
		return tonnes;
	}

	public void setTonnes(Integer tonnes) {
		this.tonnes = tonnes;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProposalValidDays() {
		return proposalValidDays;
	}

	public void setProposalValidDays(String proposalValidDays) {
		this.proposalValidDays = proposalValidDays;
	}

	@Override
	public String toString() {
		return "ProposalDetailsDTO [proposalId=" + proposalId + ", customer=" + customer + ", priceTonne=" + priceTonne
				+ ", tonnes=" + tonnes + ", country=" + country + ", proposalValidDays=" + proposalValidDays + "]";
	}
	
	
}
