package org.br.mineradora.report.service;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.br.mineradora.report.dto.OpportunityDTO;
import org.br.mineradora.report.dto.ProposalDTO;
import org.br.mineradora.report.dto.QuotationDTO;
import org.br.mineradora.report.entity.OpportunityEntity;
import org.br.mineradora.report.entity.QuotationEntity;
import org.br.mineradora.report.repository.OpportunityRepository;
import org.br.mineradora.report.repository.QuotationRespository;
import org.br.mineradora.report.utils.CSVHelper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class OpportunityServiceImpl implements OpportunityService {

	@Inject
	QuotationRespository quotationRespository;
	
	@Inject
	OpportunityRepository opportunityRepository;
	
	@Override
	public void buildOpportunity(ProposalDTO proposal) {
		List<QuotationEntity> quotations = quotationRespository.findAll().list();
		
		Collections.reverse(quotations);
		
		OpportunityEntity opportunityEntit = new OpportunityEntity();
		
		opportunityEntit.setDate(new Date());
		opportunityEntit.setProposalId(proposal.getProposalId());
		opportunityEntit.setCustomer(proposal.getCustomer());
		opportunityEntit.setPriceTonne(proposal.getPriceTonner());
		opportunityEntit.setLastDollarQuotation(quotations.get(0).getCurrencyPrice());

		opportunityRepository.persist(opportunityEntit);
	}

	@Override
	public void saveQuotation(QuotationDTO quotation) {
		QuotationEntity enitity = new QuotationEntity();
		enitity.setCurrencyPrice(quotation.getCurrencyPrice());
		enitity.setDate(quotation.getDate());
		
		quotationRespository.persist(enitity);
		
		
	}

	@Override
	public List<OpportunityDTO> generateOpportunitiesData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ByteArrayInputStream generateCSVInputStream() {
		List<OpportunityDTO> lista = new ArrayList<>();
		
		opportunityRepository.findAll().list().forEach(o -> {
			OpportunityDTO opp = OpportunityDTO.builder().customer(o.getCustomer())
			.lastDollarQuotation(o.getLastDollarQuotation())
			.priceTonne(o.getPriceTonne())
			.proposalId(o.getProposalId()).build();
			lista.add(opp);
		} );
		
		return CSVHelper.OpportunitiesToCSV(lista);
	}

}
