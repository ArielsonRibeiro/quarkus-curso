package org.br.mineradoria.gateway.service;

import org.br.mineradoria.gateway.client.exception.PropostaNaoLocalizadaException;
import org.br.mineradoria.gateway.dto.ProposalDetailsDTO;

import jakarta.ws.rs.core.Response;

public interface ProposalService {

	public ProposalDetailsDTO getProposal(long id) throws PropostaNaoLocalizadaException;
	
	public Response getAllProposal(boolean expiradas);
	
	public Response deleteProposal(long id);
	
	public Response createProposal(ProposalDetailsDTO proposal);
}
