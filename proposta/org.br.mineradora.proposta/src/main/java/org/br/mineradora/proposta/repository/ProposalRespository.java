package org.br.mineradora.proposta.repository;

import java.util.List;
import java.util.Optional;

import org.br.mineradora.proposta.entity.ProposalEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class ProposalRespository implements PanacheRepository<ProposalEntity> {

	@Inject
	EntityManager em;
	
	public Optional<ProposalEntity> findByCustomer(String costumer){
		return Optional.of(find("customer", costumer).firstResult());
	}
	
    private final String FIND_ALL_PROPOSTAS_VALIDAS = "select *  from tb_proposta "
    		+ "where (created + (proposal_valid_days || ' days')::interval) >= CURRENT_DATE;";
	
	@SuppressWarnings("unchecked")
	public List<ProposalEntity> findAllPropostasValidas(){
		return em.createNativeQuery(FIND_ALL_PROPOSTAS_VALIDAS, ProposalEntity.class).getResultList();
	}
}
