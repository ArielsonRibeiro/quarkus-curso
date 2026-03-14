package org.br.mineradora;

import org.br.mineradora.singleton.grpc.hello.HelloGrpc;
import org.br.mineradora.singleton.grpc.hello.HelloReply;
import org.br.mineradora.singleton.grpc.hello.HelloRequest;

import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;

@GrpcService
public class HelloGrpcService implements HelloGrpc {

    @Override
    public Uni<HelloReply> sayHello(HelloRequest request) {
        return Uni.createFrom().item("Hello " + request.getName() + "!")
                .map(msg -> HelloReply.newBuilder().setMessage(msg).build());
    }

}
