package org.br.mineradora.cotacao.repository;

import org.br.mineradora.cotacao.entity.CotacaoEnitity;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QuotationRepository implements PanacheRepository<CotacaoEnitity> {

}
