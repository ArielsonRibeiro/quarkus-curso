package org.br.mineradoria.gateway.interceptor;

import java.util.logging.Logger;

import javax.security.auth.login.LoginException;

import org.br.mineradoria.gateway.dto.ErrorDefault;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@Interceptor
@CustomExceptionHandling
public class CustomExceptionHandlingInterceptor {
	
	private final Logger LOGGER = Logger.getLogger(CustomExceptionHandlingInterceptor.class.getName());

	@AroundInvoke
	public Object intercept(InvocationContext ctx) throws Exception {
		try {
			return ctx.proceed();
		} catch(WebApplicationException e) {
			// TODO Implementar um tratamento mais generico
			Response resp = e.getResponse();
			
			ErrorDefault error = resp.readEntity(ErrorDefault.class);
			
			if(error.getErrorDescription() != null)
				throw new LoginException(error.getErrorDescription());
			LOGGER.warning("Error: "+ resp.readEntity(String.class));			
			throw e;
		}
	}

}
