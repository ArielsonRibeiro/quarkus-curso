package org.br.mineradora.proposta.rs;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.br.mineradora.proposta.dto.ProposalDetailsDTO;
import org.br.mineradora.proposta.service.ProposalService;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/api/proposal")
public class ProposalResource {

	private final Logger LOGGER = Logger.getLogger(ProposalResource.class.getName());
	
	@Inject
	private ProposalService service;
	
	@GET
	@Path("/{id}")
	public ProposalDetailsDTO getProposal(@PathParam("id") long id) {
		return service.findFullProposal(id);
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteProposal(@PathParam("id") long id) {
		service.removeProposal(id);
	}
	
	@POST
	public Response createProposal(ProposalDetailsDTO proposal) {
		try {
			LOGGER.info("---- Cirando nova proposta de Compra ----");
			service.creatProposal(proposal);
			return Response.ok().build();
		} catch(Exception e) {
			LOGGER.log(Level.SEVERE, "[createProposal]", e);
			return Response.serverError().build();
		}
	}
	
}
