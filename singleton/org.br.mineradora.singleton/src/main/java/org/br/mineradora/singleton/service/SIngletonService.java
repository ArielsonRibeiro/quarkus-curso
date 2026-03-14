package org.br.mineradora.singleton.service;

import org.br.mineradora.singleton.grpc.identificador.Identificador;
import org.br.mineradora.singleton.grpc.identificador.SingletonServiceGrpc;

import com.google.protobuf.Empty;

import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;

@GrpcService
public class SIngletonService implements SingletonServiceGrpc{

	@Inject
	private GeradorSingleton gerador;
	
	@Override
	public Uni<Identificador> gerarIdentificador(Empty request) {
		 return Uni.createFrom().item(() -> gerador.getIdentificador());
	}	

}
