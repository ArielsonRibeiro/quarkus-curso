package org.br.mineradora.rsproxy.grpc;

import java.util.Date;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.br.mineradora.rsproxy.auth.dto.IdentificadoDTO;
import org.br.mineradora.singleton.grpc.identificador.SingletonServiceGrpc;

import io.quarkus.grpc.GrpcClient;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class IdentificadorClient {

	@GrpcClient("identificador")
 	SingletonServiceGrpc grpc;

	
	private Logger LOGGER = LogManager.getLogManager().getLogger(IdentificadorClient.class.getName());
	
	
	public IdentificadoDTO getId() {
		long ini = System.currentTimeMillis();
		var id = grpc.gerarIdentificador(null).await().indefinitely();
		LOGGER.info("Tempo grpc: " + (System.currentTimeMillis() - ini));
		IdentificadoDTO retorno = new IdentificadoDTO();
		retorno.setData(new Date(id.getData()));
		retorno.setId(id.getSequencial());
		retorno.setMensagem(id.getUuid());
		return retorno;
		
	}
}
