package org.br.mineradora.singleton.grpc.identificador;

import io.grpc.BindableService;
import io.quarkus.grpc.GrpcService;
import io.quarkus.grpc.MutinyBean;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: SequencialUnico.proto")
public class SingletonServiceGrpcBean extends MutinySingletonServiceGrpcGrpc.SingletonServiceGrpcImplBase implements BindableService, MutinyBean {

    private final SingletonServiceGrpc delegate;

    SingletonServiceGrpcBean(@GrpcService SingletonServiceGrpc delegate) {
        this.delegate = delegate;
    }

    @Override
    public io.smallrye.mutiny.Uni<org.br.mineradora.singleton.grpc.identificador.Identificador> gerarIdentificador(com.google.protobuf.Empty request) {
        try {
            return delegate.gerarIdentificador(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }
}
