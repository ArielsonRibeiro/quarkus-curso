package org.br.mineradoria.gateway.rs;

import java.util.logging.Logger;

import org.br.mineradoria.gateway.dto.ProposalDetailsDTO;
import org.br.mineradoria.gateway.service.ProposalService;
import org.eclipse.microprofile.jwt.JsonWebToken;

import io.opentelemetry.instrumentation.annotations.WithSpan;
import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/trade")
@Authenticated
public class ProposalResource {

	private final Logger LOGGER = Logger.getLogger(ProposalResource.class.getName());

	@Inject
	private JsonWebToken jsonWebToken;

	@Inject
	private ProposalService service;

	@GET
	@Path("/{id}")
	@RolesAllowed({ "user", "manager" })
	@Produces(MediaType.APPLICATION_JSON)
	@WithSpan
	public ProposalDetailsDTO getProposal(@PathParam("id") long id) {
		return service.getProposal(id);
	}

	@DELETE
	@Path("/{id}")
	@RolesAllowed("manager")
	@WithSpan
	public Response deleteProposal(@PathParam("id") long id) {

		int status = service.deleteProposal(id).getStatus();

		if (status > 199 && status < 205) {
			return Response.ok().build();
		}
		return Response.status(status).build();
	}

	@POST
	@RolesAllowed("proposal-customer")
	@WithSpan
	public Response createProposal(ProposalDetailsDTO proposal) {
		return Response.status(service.createProposal(proposal).getStatus()).build();
	}

}
