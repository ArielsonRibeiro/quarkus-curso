package org.br.mineradora.proposta.rs;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.br.mineradora.library.exception.RestExceptionHandler;
import org.br.mineradora.proposta.dto.ProposalDetailsDTO;
import org.br.mineradora.proposta.exception.PropostaNaoLocalizadaException;
import org.br.mineradora.proposta.service.ProposalService;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.extensions.Extension;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

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
import jakarta.ws.rs.core.MediaType;
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
	@Operation(operationId =  "getProposal")
	@APIResponses(value = {
			@APIResponse(
				responseCode = "200",
				description = "",
				content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ProposalDetailsDTO.class))
			),
			@APIResponse(
					responseCode = "404",
					description = "",
					content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = PropostaNaoLocalizadaException.class)),
					extensions = {@Extension(name = "type", parseValue = true, value = "{\"faultId\": \"PropostaNaoLocalizadaException\"}")}
				),
	})
	public ProposalDetailsDTO getProposal(@PathParam("id") long id) 
			throws PropostaNaoLocalizadaException {
		var p = service.findFullProposal(id);
		if(p != null)
			return p;
		throw RestExceptionHandler.throwException(404, new PropostaNaoLocalizadaException("Proposta Não localizada"));
	}
	
	@GET
	@Path("/all")
	@RolesAllowed({"user", "manager"})
	@Operation(operationId =  "getAllProposal")
	public List<ProposalDetailsDTO> getAllProposal(@QueryParam("expiradas") boolean expiradas) {
		LOGGER.info("Testando headers recebidos: " + httpHeaders.getRequestHeaders());
		return service.listAllProposal(expiradas);
	}
	
	@DELETE
	@Path("/{id}")
	@RolesAllowed("manager")
	@Operation(operationId =  "deleteProposal")
	public void deleteProposal(@PathParam("id") long id)
			throws PropostaNaoLocalizadaException{
		service.removeProposal(id);
	}
	
	@POST
	@RolesAllowed("proposal-customer")
	@Operation(operationId =  "createProposal")
	public long createProposal(ProposalDetailsDTO proposal) {
		try {
			LOGGER.info("---- Criando nova proposta de Compra ----");
			return service.creatProposal(proposal);
		} catch(Exception e) {
			LOGGER.log(Level.SEVERE, "[createProposal]", e);
			throw RestExceptionHandler.throwException(400, e);
		}
	}
	
}
