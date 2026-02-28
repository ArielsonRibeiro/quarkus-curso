package org.br.mineradora.gateway.bo.client;

import javax.security.auth.login.LoginException;

import org.br.mineradora.gateway.bo.dto.TokenOAuthDTO;
import org.br.mineradora.library.interceptor.CustomExceptionHandling;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/realms/quarkus/protocol/openid-connect")
@RegisterRestClient
@RegisterClientHeaders(value = ClientHeadersFactoryCustom.class)
@CustomExceptionHandling
@ApplicationScoped
public interface OAuthClient {

	@Path("/token")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public TokenOAuthDTO login(@FormParam("username") String username
			, @FormParam("password") String password, @FormParam("grant_type") String  grantType)
		throws LoginException;
}
