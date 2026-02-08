package org.br.mineradora.proposta.service;

import java.util.Date;

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
	public void creatProposal(ProposalDetailsDTO proposal) {
		ProposalDTO proposalDTO = buildAndSaveNewProposal(proposal);
		kafkaEvents.sendProposalDTO(proposalDTO);
	}
	
	private ProposalDTO buildAndSaveNewProposal(ProposalDetailsDTO proposal) {
		proposal.setProposalId(null);
		ProposalEntity entity = fill(proposal);
		proposalRespository.persist(entity);
		return ProposalDTO.builder()
				.customer(entity.getCustomer())
				.priceTonner(entity.getPriceTonne())
				.proposalId(entity.getId())
				.build();
		
	}
	
	private ProposalEntity fill(ProposalDetailsDTO proposal) {
		return ProposalEntity.builder()
					.id(proposal.getProposalId())
					.country(proposal.getCountry())
					.customer(proposal.getCustomer())
					.priceTonne(proposal.getPriceTonne())
					.proposalValidDays(proposal.getProposalValidDays())
					.created(new Date())
					.tonnes(proposal.getTonnes()).build();
	}

	private ProposalDetailsDTO fill(ProposalEntity proposal) {
		return ProposalDetailsDTO.builder().country(proposal.getCountry()).customer(proposal.getCustomer())
				.priceTonne(proposal.getPriceTonne()).proposalId(proposal.getId())
				.proposalValidDays(proposal.getProposalValidDays()).tonnes(proposal.getTonnes()).build();

	}

}
