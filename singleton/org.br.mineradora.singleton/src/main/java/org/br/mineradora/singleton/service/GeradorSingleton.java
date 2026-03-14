package org.br.mineradora.singleton.service;

import org.br.mineradora.singleton.grpc.identificador.Identificador;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GeradorSingleton {

	private long id = 1;
	
	public synchronized Identificador getIdentificador() {
		var builder = Identificador.newBuilder();
		builder.setUuid(new StringBuilder().append("id-").append(id).toString());
		builder.setData(System.currentTimeMillis());
		builder.setSequencial(id);
		id++;
		return builder.build();
		
	}
}
