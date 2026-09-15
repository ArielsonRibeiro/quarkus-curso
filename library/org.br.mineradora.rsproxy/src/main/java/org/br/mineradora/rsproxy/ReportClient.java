package org.br.mineradora.rsproxy;

import java.util.List;

import org.br.mineradora.library.interceptor.CustomExceptionHandling;
import org.br.mineradora.rsproxy.report.to.OpportunityDTO;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.quarkus.oidc.token.propagation.reactive.AccessTokenRequestReactiveFilter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/api/opportunity/report")
@RegisterRestClient(configKey = "url-report-service")
@RegisterProvider(AccessTokenRequestReactiveFilter.class)
@RegisterClientHeaders
@CustomExceptionHandling
@ApplicationScoped
public interface ReportClient {
	 /**
     * Get Report
     *
     */
    @GET
    @Path("/data")
    @Produces({ "application/json" })
    List<OpportunityDTO> generateOpportunitiesData();

    /**
     * Generate Report
     *
     */
    @GET
    @Produces({ "application/octet-stream" })
    Response generateCSVInputStream();
}
