package org.br.mineradora.gateway.bo.service;

import org.br.mineradora.gateway.bo.client.exception.PropostaNaoLocalizadaException;
import org.br.mineradora.gateway.bo.dto.ProposalDetailsDTO;

import jakarta.ws.rs.core.Response;

public interface ProposalService {

	public ProposalDetailsDTO getProposal(long id) throws PropostaNaoLocalizadaException;
	
	public Response getAllProposal(boolean expiradas);
	
	public Response deleteProposal(long id);
	
	public Response createProposal(ProposalDetailsDTO proposal);
}
