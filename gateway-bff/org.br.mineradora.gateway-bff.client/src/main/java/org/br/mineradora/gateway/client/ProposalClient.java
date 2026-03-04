package org.br.mineradora.gateway.client;

import java.util.List;

import org.br.mineradora.gateway.client.proposta.to.ProposalDetailsDTO;
import org.br.mineradora.library.interceptor.CustomExceptionHandling;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.quarkus.oidc.token.propagation.reactive.AccessTokenRequestReactiveFilter;
import io.quarkus.rest.client.reactive.NotBody;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("/api/proposal")
@RegisterRestClient
@RegisterProvider(AccessTokenRequestReactiveFilter.class)
@RegisterClientHeaders
@CustomExceptionHandling
@ApplicationScoped
public interface ProposalClient
//extends ProposalResourceApi Não funciona se estender
{

    @POST
    @Consumes({ "application/json" })
    @Produces({ "text/plain" })
    Long createProposal(ProposalDetailsDTO proposalDetailsDTO);

    @DELETE
    @Path("/{id}")
    void deleteProposal(@PathParam("id") Long id) throws PropostaNaoLocalizadaException;

    @GET
    @Path("/all")
    @Produces({ "application/json" })
    List<ProposalDetailsDTO> getAllProposal(@QueryParam("expiradas") Boolean expiradas);

    @GET
    @Path("/{id}")
    @Produces({ "application/json" })
    ProposalDetailsDTO getProposal(@PathParam("id") Long id) throws PropostaNaoLocalizadaException;

	@GET
	@Path("/all")
	@ClientHeaderParam(name = "headerTest", value = "{headerTest}")
	public Response getAllProposal(@QueryParam("expiradas") boolean expiradas
			, @NotBody String headerTest);

}
