package org.br.mineradora.proposta.rs;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.br.mineradora.library.exception.RestExceptionHandler;
import org.br.mineradora.proposta.dto.ProposalDetailsDTO;
import org.br.mineradora.proposta.exception.PropostaNaoLocalizadaException;
import org.br.mineradora.proposta.service.ProposalService;
import org.eclipse.microprofile.jwt.JsonWebToken;

import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;

@Path("/api/proposal")
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
	@RolesAllowed({"user", "manager"})
	public ProposalDetailsDTO getProposal(@PathParam("id") long id) {
		var p = service.findFullProposal(id);
		if(p != null)
			return p;
		throw RestExceptionHandler.throwException(404, new PropostaNaoLocalizadaException("Proposta Não localizada"));
	}
	
	@GET
	@Path("/all")
	@RolesAllowed({"user", "manager"})
	public List<ProposalDetailsDTO> getAllProposal(@QueryParam("expiradas") boolean expiradas) {
		LOGGER.info("Testando headers recebidos: " + httpHeaders.getRequestHeaders());
		return service.listAllProposal(expiradas);
	}
	
	@DELETE
	@Path("/{id}")
	@RolesAllowed("manager")
	public void deleteProposal(@PathParam("id") long id) {
		service.removeProposal(id);
	}
	
	@POST
//	@RolesAllowed("proposal-customer")
	public Response createProposal(ProposalDetailsDTO proposal) {
		try {
			LOGGER.info("---- Criando nova proposta de Compra ----");
			return Response.ok(service.creatProposal(proposal)).build();
		} catch(Exception e) {
			LOGGER.log(Level.SEVERE, "[createProposal]", e);
			return Response.serverError().build();
		}
	}
	
}
