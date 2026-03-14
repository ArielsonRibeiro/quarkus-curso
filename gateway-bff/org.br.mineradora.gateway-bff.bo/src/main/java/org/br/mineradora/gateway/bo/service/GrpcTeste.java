package org.br.mineradora.gateway.bo.service;

import org.br.mineradora.gateway.client.auth.dto.IdentificadoDTO;
import org.br.mineradora.gateway.client.grpc.IdentificadorClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class GrpcTeste {

	@Inject
	IdentificadorClient client;
	
	public IdentificadoDTO getIdentificador() {
		return client.getId();
	}
	
}
