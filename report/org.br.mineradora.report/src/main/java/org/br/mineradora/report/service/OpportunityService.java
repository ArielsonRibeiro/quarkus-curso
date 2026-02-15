package org.br.mineradora.report.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.br.mineradora.report.dto.OpportunityDTO;
import org.br.mineradora.report.dto.ProposalDTO;
import org.br.mineradora.report.dto.QuotationDTO;

public interface OpportunityService {

	void buildOpportunity(ProposalDTO proposal);
	
	void saveQuotation(QuotationDTO quotation);
	
	List<OpportunityDTO>  generateOpportunitiesData();
	
	ByteArrayInputStream generateCSVInputStream();
}
