package org.br.mineradora.gateway.rs;

import org.br.mineradora.gateway.bo.service.GrpcTeste;
import org.br.mineradora.gateway.client.auth.dto.IdentificadoDTO;

import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/v1/grpc")
@PermitAll
@RunOnVirtualThread
public class GrpcTesteResource {

	@Inject
	private GrpcTeste proxy;
	
	@Path("")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public IdentificadoDTO getIdentificador() {
		return proxy.getIdentificador();
	}
	
}
