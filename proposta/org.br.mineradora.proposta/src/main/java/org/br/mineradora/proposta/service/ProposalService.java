package org.br.mineradora.proposta.service;


import java.util.List;

import org.br.mineradora.proposta.dto.ProposalDetailsDTO;

public interface ProposalService {

	public ProposalDetailsDTO findFullProposal(long id);
	public void removeProposal(long id);
	public long creatProposal(ProposalDetailsDTO proposal);
	public List<ProposalDetailsDTO> listAllProposal(boolean incluirExpiradas);
}
