package org.br.mineradora.singleton.grpc.hello;

import io.quarkus.grpc.MutinyService;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: hello.proto")
public interface HelloGrpc extends MutinyService {

    io.smallrye.mutiny.Uni<org.br.mineradora.singleton.grpc.hello.HelloReply> sayHello(org.br.mineradora.singleton.grpc.hello.HelloRequest request);
}
