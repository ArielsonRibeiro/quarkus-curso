package org.br.mineradora.singleton.grpc.hello;

import java.util.function.BiFunction;
import io.quarkus.grpc.MutinyClient;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: hello.proto")
public class HelloGrpcClient implements HelloGrpc, MutinyClient<MutinyHelloGrpcGrpc.MutinyHelloGrpcStub> {

    private final MutinyHelloGrpcGrpc.MutinyHelloGrpcStub stub;

    public HelloGrpcClient(String name, io.grpc.Channel channel, BiFunction<String, MutinyHelloGrpcGrpc.MutinyHelloGrpcStub, MutinyHelloGrpcGrpc.MutinyHelloGrpcStub> stubConfigurator) {
        this.stub = stubConfigurator.apply(name, MutinyHelloGrpcGrpc.newMutinyStub(channel));
    }

    private HelloGrpcClient(MutinyHelloGrpcGrpc.MutinyHelloGrpcStub stub) {
        this.stub = stub;
    }

    public HelloGrpcClient newInstanceWithStub(MutinyHelloGrpcGrpc.MutinyHelloGrpcStub stub) {
        return new HelloGrpcClient(stub);
    }

    @Override
    public MutinyHelloGrpcGrpc.MutinyHelloGrpcStub getStub() {
        return stub;
    }

    @Override
    public io.smallrye.mutiny.Uni<org.br.mineradora.singleton.grpc.hello.HelloReply> sayHello(org.br.mineradora.singleton.grpc.hello.HelloRequest request) {
        return stub.sayHello(request);
    }
}
