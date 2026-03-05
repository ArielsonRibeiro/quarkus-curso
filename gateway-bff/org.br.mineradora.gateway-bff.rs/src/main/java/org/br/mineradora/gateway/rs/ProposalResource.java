package org.br.mineradora.gateway.rs;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.br.mineradora.gateway.bo.service.ProposalService;
import org.br.mineradora.gateway.client.PropostaNaoLocalizadaException;
import org.br.mineradora.gateway.client.proposta.to.ProposalDetailsDTO;
import org.br.mineradora.library.exception.RestExceptionHandler;
import org.eclipse.microprofile.jwt.JsonWebToken;

import io.opentelemetry.instrumentation.annotations.WithSpan;
import io.quarkus.security.Authenticated;
import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/trade")
@Authenticated
@RunOnVirtualThread
public class ProposalResource {

	private final Logger LOGGER = Logger.getLogger(ProposalResource.class.getName());

	@Inject
	private JsonWebToken jsonWebToken;

	@Inject
	private ProposalService service;
	
	@Context
    private HttpHeaders httpHeaders;

	@GET
	@Path("/{id}")
	@RolesAllowed({ "user", "manager" })
	@Produces(MediaType.APPLICATION_JSON)
	@WithSpan
	public ProposalDetailsDTO getProposal(@PathParam("id") long id) {
		try {
			return service.getProposal(id);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			throw RestExceptionHandler.throwException(400, e);
		}
	}

	@GET
	@Path("/all")
	@RolesAllowed({ "user", "manager" })
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProposalDetailsDTO> getAllProposal(@QueryParam("expiradas") boolean expiradas) {
		try {
			return service.getAllProposal(expiradas);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			throw RestExceptionHandler.throwException(400, e);
		}
	}

	@DELETE
	@Path("/{id}")
	@RolesAllowed("manager")
	@WithSpan
	public void deleteProposal(@PathParam("id") long id) {
		
		try {
			service.deleteProposal(id);
		} catch (PropostaNaoLocalizadaException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			throw RestExceptionHandler.throwException(404, e);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			throw RestExceptionHandler.throwException(400, e);
		}

	}

	@POST
	@RolesAllowed("proposal-customer")
	@WithSpan
	public void createProposal(ProposalDetailsDTO proposal) {
		try {
			service.createProposal(proposal);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
			throw RestExceptionHandler.throwException(400, e);
		}
	}

}
