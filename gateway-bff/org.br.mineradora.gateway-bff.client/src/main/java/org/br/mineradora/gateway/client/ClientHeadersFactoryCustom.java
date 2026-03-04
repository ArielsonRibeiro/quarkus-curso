package org.br.mineradora.gateway.client;

import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;

import jakarta.ws.rs.core.MultivaluedHashMap;
import jakarta.ws.rs.core.MultivaluedMap;

public class ClientHeadersFactoryCustom implements ClientHeadersFactory {

	@Override
	public MultivaluedMap<String, String> update(MultivaluedMap<String, String> incomingHeaders,
			MultivaluedMap<String, String> clientOutgoingHeaders) {
		MultivaluedMap<String, String> headers = new MultivaluedHashMap<>();
        // Propaga cabeçalhos originais, se necessário
        headers.putAll(incomingHeaders); 
        headers.putAll(clientOutgoingHeaders); 
        
        return headers;
	}

}
