package org.br.mineradora.gateway.bo.service;

import java.util.List;

import org.br.mineradora.gateway.client.PropostaNaoLocalizadaException;
import org.br.mineradora.gateway.client.proposta.to.ProposalDetailsDTO;

public interface ProposalService {

	public ProposalDetailsDTO getProposal(long id) throws PropostaNaoLocalizadaException;
	
	public List<ProposalDetailsDTO> getAllProposal(boolean expiradas);
	
	public void deleteProposal(long id) throws PropostaNaoLocalizadaException;
	
	public Long createProposal(ProposalDetailsDTO proposal);
}
