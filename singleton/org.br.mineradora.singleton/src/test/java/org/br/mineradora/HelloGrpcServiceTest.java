package org.br.mineradora;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.br.mineradora.singleton.grpc.hello.HelloGrpc;
import org.br.mineradora.singleton.grpc.hello.HelloReply;
import org.br.mineradora.singleton.grpc.hello.HelloRequest;
import org.junit.jupiter.api.Test;

import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.junit.QuarkusTest;
@QuarkusTest
class HelloGrpcServiceTest {
    @GrpcClient()
    HelloGrpc helloGrpc;

    @Test
    void testHello() {
        HelloReply reply = helloGrpc
                .sayHello(HelloRequest.newBuilder().setName("Neo").build()).await().atMost(Duration.ofSeconds(5));
        assertEquals("Hello Neo!", reply.getMessage());
    }

}
