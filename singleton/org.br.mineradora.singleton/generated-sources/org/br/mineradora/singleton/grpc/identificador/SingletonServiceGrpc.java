package org.br.mineradora.singleton.grpc.identificador;

import io.quarkus.grpc.MutinyService;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: SequencialUnico.proto")
public interface SingletonServiceGrpc extends MutinyService {

    io.smallrye.mutiny.Uni<org.br.mineradora.singleton.grpc.identificador.Identificador> gerarIdentificador(com.google.protobuf.Empty request);
}
