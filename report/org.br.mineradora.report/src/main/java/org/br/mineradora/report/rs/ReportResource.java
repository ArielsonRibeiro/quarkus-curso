package org.br.mineradora.report.rs;

import java.util.Date;

import org.br.mineradora.report.service.OpportunityService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("api/opportunity")
public class ReportResource {
	
	@Inject
	private OpportunityService service;

	@Path("/report")
	@GET
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response generateReport() {
		return Response.ok(service.generateCSVInputStream(), MediaType.APPLICATION_OCTET_STREAM)
				.header("content-disposition",
						"attachment; filename = "+ new Date() + "--opportunity-venda.csv")
				.build();
	}
}
