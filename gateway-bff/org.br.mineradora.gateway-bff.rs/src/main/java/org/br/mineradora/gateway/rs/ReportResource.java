package org.br.mineradora.gateway.rs;

import java.util.Date;
import java.util.List;

import org.br.mineradora.gateway.bo.dto.OpportunityDTO;
import org.br.mineradora.gateway.bo.service.ReportService;
import org.eclipse.microprofile.jwt.JsonWebToken;

import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("api/opportunity")
@Authenticated
public class ReportResource {
	
	@Inject
	private JsonWebToken jsonWebToken;
	
	@Inject
	private ReportService service;

	@Path("/report")
	@GET
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	@RolesAllowed("manager")
	public Response generateReport() {
		return Response.ok(service.generateCSVInputStream(), MediaType.APPLICATION_OCTET_STREAM)
				.header("content-disposition",
						"attachment; filename = "+ new Date() + "--opportunity-venda.csv")
				.build();
	}
	
	@Path("/report/data")
	@GET
	@RolesAllowed("manager")
	public List<OpportunityDTO> getReport() {
		return service.generateOpportunitiesData();
	}
}