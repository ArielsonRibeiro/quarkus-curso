package org.br.mineradora.proposta.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_proposta")
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "ProposalEntity [id=" + id + ", customer=" + customer + ", priceTonne=" + priceTonne + ", tonnes="
				+ tonnes + ", country=" + country + ", proposalValidDays=" + proposalValidDays + ", created=" + created
				+ "]";
	}
	

}
