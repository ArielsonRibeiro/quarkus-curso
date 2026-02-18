package org.br.mineradoria.gateway.client;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.br.mineradoria.gateway.dto.OpportunityDTO;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.quarkus.oidc.token.propagation.reactive.AccessTokenRequestReactiveFilter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("api/opportunity")
@RegisterRestClient
@RegisterProvider(AccessTokenRequestReactiveFilter.class)
@RegisterClientHeaders
@ApplicationScoped
public interface ReportClient {

	@GET
	@Path("/report/data")
	List<OpportunityDTO>  generateOpportunitiesData();
	
	@GET
	@Path("/report")
	ByteArrayInputStream generateCSVInputStream();
}
