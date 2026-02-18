package org.br.mineradora.proposta.filter;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Provider
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {

    private static final Logger LOG = Logger.getLogger(LoggingFilter.class);

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        // Log request info
        LOG.infof("Request: %s %s", requestContext.getMethod(), requestContext.getUriInfo().getPath());

        // To log the body, you must copy the input stream and replace it
        if (requestContext.hasEntity()) {
            InputStream entityStream = requestContext.getEntityStream();
            byte[] bytes = entityStream.readAllBytes();
            String body = new String(bytes, StandardCharsets.UTF_8);
            LOG.infof("Request Body: %s", body);
            // Re-set the entity stream for the actual resource method to read
            requestContext.setEntityStream(new ByteArrayInputStream(bytes));
        }
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        // Log response info
        LOG.infof("Response Status: %d", responseContext.getStatus());
        
        // Logging response body requires similar stream manipulation for the response entity
        // Note: Logging the response body can be more complex as you may need to wrap 
        // the OutputStream or handle the entity directly before it's written.
    }
}
