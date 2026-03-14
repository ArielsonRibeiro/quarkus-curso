package org.br.mineradora.singleton.grpc.identificador;

import java.util.function.BiFunction;
import io.quarkus.grpc.MutinyClient;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: SequencialUnico.proto")
public class SingletonServiceGrpcClient implements SingletonServiceGrpc, MutinyClient<MutinySingletonServiceGrpcGrpc.MutinySingletonServiceGrpcStub> {

    private final MutinySingletonServiceGrpcGrpc.MutinySingletonServiceGrpcStub stub;

    public SingletonServiceGrpcClient(String name, io.grpc.Channel channel, BiFunction<String, MutinySingletonServiceGrpcGrpc.MutinySingletonServiceGrpcStub, MutinySingletonServiceGrpcGrpc.MutinySingletonServiceGrpcStub> stubConfigurator) {
        this.stub = stubConfigurator.apply(name, MutinySingletonServiceGrpcGrpc.newMutinyStub(channel));
    }

    private SingletonServiceGrpcClient(MutinySingletonServiceGrpcGrpc.MutinySingletonServiceGrpcStub stub) {
        this.stub = stub;
    }

    public SingletonServiceGrpcClient newInstanceWithStub(MutinySingletonServiceGrpcGrpc.MutinySingletonServiceGrpcStub stub) {
        return new SingletonServiceGrpcClient(stub);
    }

    @Override
    public MutinySingletonServiceGrpcGrpc.MutinySingletonServiceGrpcStub getStub() {
        return stub;
    }

    @Override
    public io.smallrye.mutiny.Uni<org.br.mineradora.singleton.grpc.identificador.Identificador> gerarIdentificador(com.google.protobuf.Empty request) {
        return stub.gerarIdentificador(request);
    }
}
