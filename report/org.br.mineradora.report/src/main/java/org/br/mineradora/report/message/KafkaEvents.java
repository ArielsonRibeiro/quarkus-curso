package org.br.mineradora.report.message;

import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.br.mineradora.report.dto.ProposalDTO;
import org.br.mineradora.report.dto.QuotationDTO;
import org.br.mineradora.report.service.OpportunityService;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import io.smallrye.reactive.messaging.annotations.Blocking;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

public class KafkaEvents {
	
	private static final Logger LOGGER = LogManager.getLogManager().getLogger(KafkaEvents.class.getName());


	@Inject
	OpportunityService opportunityService;
	
	@Incoming("proposal-channel")
	@Transactional
	public void reciveProposal(ProposalDTO proposal) {
		LOGGER.info("Recebendo Nova Proposta");
		opportunityService.buildOpportunity(proposal);
	}
	
	@Incoming("quotation-channel")
	@Blocking
	@Transactional
	public void receiveQuotation(QuotationDTO quotation) {
		LOGGER.info("Reecebendo Nova Quotação");
		opportunityService.saveQuotation(quotation);
	}
}
