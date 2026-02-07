package org.br.mineradora.cotacao.client;

import org.br.mineradora.cotacao.dto.CurrencyPriceDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/last")
@RegisterRestClient
@ApplicationScoped
public interface CurrencyPriceClient {

	@GET
	@Path("/{pair}")
	@Produces(MediaType.APPLICATION_JSON)
	public CurrencyPriceDTO getPriceByPair(@PathParam("pair") String pair);
}
