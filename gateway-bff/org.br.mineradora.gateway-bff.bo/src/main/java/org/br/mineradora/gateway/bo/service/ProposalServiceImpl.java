package org.br.mineradora.gateway.bo.service;

import org.br.mineradora.gateway.bo.client.ProposalClient;
import org.br.mineradora.gateway.bo.client.exception.PropostaNaoLocalizadaException;
import org.br.mineradora.gateway.bo.dto.ProposalDetailsDTO;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class ProposalServiceImpl implements ProposalService {

	@Inject
	@RestClient
	private ProposalClient proposalClient;
	
	public ProposalDetailsDTO getProposal(long id) throws PropostaNaoLocalizadaException {
		return proposalClient.getProposal(id);
	}
	
	public Response getAllProposal(boolean expiradas) {
		return proposalClient.getAllProposal(expiradas, "Testando Headers");
	}
	
	public Response deleteProposal(long id) {
		return proposalClient.deleteProposal(id);
	}
	
	public Response createProposal(ProposalDetailsDTO proposal) {
		return proposalClient.createProposal(proposal);
	}

}
