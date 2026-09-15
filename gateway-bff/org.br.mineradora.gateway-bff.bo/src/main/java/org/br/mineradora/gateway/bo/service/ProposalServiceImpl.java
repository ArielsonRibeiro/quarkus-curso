package org.br.mineradora.gateway.bo.service;


import java.util.List;

import org.br.mineradora.rsproxy.ProposalClient;
import org.br.mineradora.rsproxy.PropostaNaoLocalizadaException;
import org.br.mineradora.rsproxy.proposta.to.ProposalDetailsDTO;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProposalServiceImpl implements ProposalService {

	@Inject
	@RestClient
	private ProposalClient proposalClient;
	
	public ProposalDetailsDTO getProposal(long id) throws PropostaNaoLocalizadaException {
		return proposalClient.getProposal(id);
	}
	
	public List<ProposalDetailsDTO> getAllProposal(boolean expiradas) {
		return proposalClient.getAllProposal(expiradas);
	}
	
	public void deleteProposal(long id) throws PropostaNaoLocalizadaException {
		proposalClient.deleteProposal(id);
	}
	
	public Long createProposal(ProposalDetailsDTO proposal) {
		return proposalClient.createProposal(proposal);
	}

}
