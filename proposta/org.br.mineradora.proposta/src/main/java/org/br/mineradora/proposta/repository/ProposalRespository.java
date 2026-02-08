package org.br.mineradora.proposta.repository;

import java.util.Optional;

import org.br.mineradora.proposta.entity.ProposalEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProposalRespository implements PanacheRepository<ProposalEntity> {

	
	public Optional<ProposalEntity> findByCustomer(String costumer){
		return Optional.of(find("customer", costumer).firstResult());
	}
}
