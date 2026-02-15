package org.br.mineradora.proposta.service;

import org.br.mineradora.proposta.dto.ProposalDetailsDTO;

public interface ProposalService {

	public ProposalDetailsDTO findFullProposal(long id);
	public void removeProposal(long id);
	public long creatProposal(ProposalDetailsDTO proposal);
}
