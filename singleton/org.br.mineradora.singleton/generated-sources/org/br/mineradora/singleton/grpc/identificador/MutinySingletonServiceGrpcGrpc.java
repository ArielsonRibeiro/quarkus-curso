package org.br.mineradora.singleton.grpc.identificador;

import static org.br.mineradora.singleton.grpc.identificador.SingletonServiceGrpcGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: SequencialUnico.proto")
public final class MutinySingletonServiceGrpcGrpc implements io.quarkus.grpc.MutinyGrpc {

    private MutinySingletonServiceGrpcGrpc() {
    }

    public static MutinySingletonServiceGrpcStub newMutinyStub(io.grpc.Channel channel) {
        return new MutinySingletonServiceGrpcStub(channel);
    }

    public static class MutinySingletonServiceGrpcStub extends io.grpc.stub.AbstractStub<MutinySingletonServiceGrpcStub> implements io.quarkus.grpc.MutinyStub {

        private SingletonServiceGrpcGrpc.SingletonServiceGrpcStub delegateStub;

        private MutinySingletonServiceGrpcStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = SingletonServiceGrpcGrpc.newStub(channel);
        }

        private MutinySingletonServiceGrpcStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = SingletonServiceGrpcGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected MutinySingletonServiceGrpcStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MutinySingletonServiceGrpcStub(channel, callOptions);
        }

        public io.smallrye.mutiny.Uni<org.br.mineradora.singleton.grpc.identificador.Identificador> gerarIdentificador(com.google.protobuf.Empty request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::gerarIdentificador);
        }
    }

    public static abstract class SingletonServiceGrpcImplBase implements io.grpc.BindableService {

        private String compression;

        /**
         * Set whether the server will try to use a compressed response.
         *
         * @param compression the compression, e.g {@code gzip}
         */
        public SingletonServiceGrpcImplBase withCompression(String compression) {
            this.compression = compression;
            return this;
        }

        public io.smallrye.mutiny.Uni<org.br.mineradora.singleton.grpc.identificador.Identificador> gerarIdentificador(com.google.protobuf.Empty request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override
        public io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor()).addMethod(org.br.mineradora.singleton.grpc.identificador.SingletonServiceGrpcGrpc.getGerarIdentificadorMethod(), asyncUnaryCall(new MethodHandlers<com.google.protobuf.Empty, org.br.mineradora.singleton.grpc.identificador.Identificador>(this, METHODID_GERAR_IDENTIFICADOR, compression))).build();
        }
    }

    private static final int METHODID_GERAR_IDENTIFICADOR = 0;

    private static final class MethodHandlers<Req, Resp> implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>, io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {

        private final SingletonServiceGrpcImplBase serviceImpl;

        private final int methodId;

        private final String compression;

        MethodHandlers(SingletonServiceGrpcImplBase serviceImpl, int methodId, String compression) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
            this.compression = compression;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch(methodId) {
                case METHODID_GERAR_IDENTIFICADOR:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.google.protobuf.Empty) request, (io.grpc.stub.StreamObserver<org.br.mineradora.singleton.grpc.identificador.Identificador>) responseObserver, compression, serviceImpl::gerarIdentificador);
                    break;
                default:
                    throw new java.lang.AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch(methodId) {
                default:
                    throw new java.lang.AssertionError();
            }
        }
    }
}
