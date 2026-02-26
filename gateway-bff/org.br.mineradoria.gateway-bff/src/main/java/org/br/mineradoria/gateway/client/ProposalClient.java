package org.br.mineradoria.gateway.client;

import org.br.mineradora.library.interceptor.CustomExceptionHandling;
import org.br.mineradoria.gateway.client.exception.PropostaNaoLocalizadaException;
import org.br.mineradoria.gateway.dto.ProposalDetailsDTO;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.quarkus.oidc.token.propagation.reactive.AccessTokenRequestReactiveFilter;
import io.quarkus.rest.client.reactive.NotBody;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("/api/proposal")
@RegisterRestClient
@RegisterProvider(AccessTokenRequestReactiveFilter.class)
@RegisterClientHeaders
@CustomExceptionHandling
@ApplicationScoped
public interface ProposalClient {
 
	@GET
	@Path("/{id}")
	public ProposalDetailsDTO getProposal(@PathParam("id") long id)
		throws PropostaNaoLocalizadaException;
	
	@GET
	@Path("/all")
	@ClientHeaderParam(name = "headerTest", value = "{headerTest}")
	public Response getAllProposal(@QueryParam("expiradas") boolean expiradas
			, @NotBody String headerTest);
	
	@DELETE
	@Path("/{id}")
	public Response deleteProposal(@PathParam("id") long id);
	
	@POST
	public Response createProposal(ProposalDetailsDTO proposal);
}
