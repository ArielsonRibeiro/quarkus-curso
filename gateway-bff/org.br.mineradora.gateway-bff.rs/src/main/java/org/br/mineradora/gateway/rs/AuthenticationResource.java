package org.br.mineradora.gateway.rs;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.security.auth.login.LoginException;

import org.br.mineradora.library.exception.RestExceptionHandler;
import org.br.mineradora.rsproxy.OAuthClient;
import org.br.mineradora.rsproxy.auth.dto.TokenOAuthDTO;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/v1/oauth")
@PermitAll
@RunOnVirtualThread
public class AuthenticationResource {
	
	private final Logger LOGGER = Logger.getLogger(AuthenticationResource.class.getName());

	@Inject
	@RestClient
	private OAuthClient oauth;

	@Path("/token")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public TokenOAuthDTO autenticar(@FormParam("username") String username, @FormParam("password") String password,
			@FormParam("grant_type") String grantType) {
		try {
			return oauth.login(username, password, grantType);
		} catch (LoginException e) {
			throw RestExceptionHandler.throwException(401, e);
		} catch(Exception e) {
			LOGGER.log(Level.WARNING, e.getMessage(), e);
			throw RestExceptionHandler.throwException(400, e);
		}
	}
}
