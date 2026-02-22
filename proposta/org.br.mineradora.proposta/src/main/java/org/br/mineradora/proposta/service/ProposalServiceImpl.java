package org.br.mineradora.proposta.service;

import java.util.Date;
import java.util.List;

import org.br.mineradora.proposta.dto.ProposalDTO;
import org.br.mineradora.proposta.dto.ProposalDetailsDTO;
import org.br.mineradora.proposta.entity.ProposalEntity;
import org.br.mineradora.proposta.message.KafkaEvents;
import org.br.mineradora.proposta.repository.ProposalRespository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProposalServiceImpl implements ProposalService {

	@Inject
	private ProposalRespository proposalRespository;
	
	@Inject
	private KafkaEvents kafkaEvents;
	
	@Override
	public ProposalDetailsDTO findFullProposal(long id) {
		ProposalEntity proposal = proposalRespository.findById(id);
		if(proposal == null)
			return null;
		return fill(proposal);
	}

	@Override
	@Transactional
	public void removeProposal(long id) {
		proposalRespository.deleteById(id);
	}

	@Override
	@Transactional
	public long creatProposal(ProposalDetailsDTO proposal) {
		ProposalDTO proposalDTO = buildAndSaveNewProposal(proposal);
		kafkaEvents.sendProposalDTO(proposalDTO);
		return proposalDTO.getProposalId();
	}
	
	private ProposalDTO buildAndSaveNewProposal(ProposalDetailsDTO proposal) {
		proposal.setProposalId(null);
		ProposalEntity entity = fill(proposal);
		proposalRespository.persist(entity);
		
		var result = new ProposalDTO();
		result.setCustomer(entity.getCustomer());
		result.setPriceTonner(entity.getPriceTonne());
		result.setProposalId(entity.getId());
		
		return result;
		
	}
	
	private ProposalEntity fill(ProposalDetailsDTO proposal) {
		var result = new ProposalEntity();
		result.setId(proposal.getProposalId());
		result.setCountry(proposal.getCountry());
		result.setCustomer(proposal.getCustomer());
		result.setPriceTonne(proposal.getPriceTonne());
		result.setProposalValidDays(proposal.getProposalValidDays());
		result.setCreated(new Date());
		result.setTonnes(proposal.getTonnes());
		return result;
		
	}

	private ProposalDetailsDTO fill(ProposalEntity proposal) {
		var result = new ProposalDetailsDTO();
		result.setCountry(proposal.getCountry());
		result.setCustomer(proposal.getCustomer());
		result.setPriceTonne(proposal.getPriceTonne());
		result.setProposalId(proposal.getId());
		result.setProposalValidDays(proposal.getProposalValidDays());
		result.setTonnes(proposal.getTonnes());
		return result;

	}

	@Override
	public List<ProposalDetailsDTO> listAllProposal(boolean incluirExpiradas) {
		if (incluirExpiradas)
			return proposalRespository.findAll().stream().map(this::fill).toList();

		return proposalRespository.findAllPropostasValidas().stream().map(this::fill).toList();
	}

}
