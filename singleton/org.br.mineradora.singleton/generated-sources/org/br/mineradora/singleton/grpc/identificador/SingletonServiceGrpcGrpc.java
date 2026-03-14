package org.br.mineradora.singleton.grpc.identificador;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class SingletonServiceGrpcGrpc {

    private SingletonServiceGrpcGrpc() {
    }

    public static final java.lang.String SERVICE_NAME = "SingletonServiceGrpc";

    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty, org.br.mineradora.singleton.grpc.identificador.Identificador> getGerarIdentificadorMethod;

    @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/' + "gerarIdentificador", requestType = com.google.protobuf.Empty.class, responseType = org.br.mineradora.singleton.grpc.identificador.Identificador.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<com.google.protobuf.Empty, org.br.mineradora.singleton.grpc.identificador.Identificador> getGerarIdentificadorMethod() {
        io.grpc.MethodDescriptor<com.google.protobuf.Empty, org.br.mineradora.singleton.grpc.identificador.Identificador> getGerarIdentificadorMethod;
        if ((getGerarIdentificadorMethod = SingletonServiceGrpcGrpc.getGerarIdentificadorMethod) == null) {
            synchronized (SingletonServiceGrpcGrpc.class) {
                if ((getGerarIdentificadorMethod = SingletonServiceGrpcGrpc.getGerarIdentificadorMethod) == null) {
                    SingletonServiceGrpcGrpc.getGerarIdentificadorMethod = getGerarIdentificadorMethod = io.grpc.MethodDescriptor.<com.google.protobuf.Empty, org.br.mineradora.singleton.grpc.identificador.Identificador>newBuilder().setType(io.grpc.MethodDescriptor.MethodType.UNARY).setFullMethodName(generateFullMethodName(SERVICE_NAME, "gerarIdentificador")).setSampledToLocalTracing(true).setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(com.google.protobuf.Empty.getDefaultInstance())).setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(org.br.mineradora.singleton.grpc.identificador.Identificador.getDefaultInstance())).setSchemaDescriptor(new SingletonServiceGrpcMethodDescriptorSupplier("gerarIdentificador")).build();
                }
            }
        }
        return getGerarIdentificadorMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static SingletonServiceGrpcStub newStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<SingletonServiceGrpcStub> factory = new io.grpc.stub.AbstractStub.StubFactory<SingletonServiceGrpcStub>() {

            @java.lang.Override
            public SingletonServiceGrpcStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new SingletonServiceGrpcStub(channel, callOptions);
            }
        };
        return SingletonServiceGrpcStub.newStub(factory, channel);
    }

    /**
     * Creates a new blocking-style stub that supports all types of calls on the service
     */
    public static SingletonServiceGrpcBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<SingletonServiceGrpcBlockingV2Stub> factory = new io.grpc.stub.AbstractStub.StubFactory<SingletonServiceGrpcBlockingV2Stub>() {

            @java.lang.Override
            public SingletonServiceGrpcBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new SingletonServiceGrpcBlockingV2Stub(channel, callOptions);
            }
        };
        return SingletonServiceGrpcBlockingV2Stub.newStub(factory, channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static SingletonServiceGrpcBlockingStub newBlockingStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<SingletonServiceGrpcBlockingStub> factory = new io.grpc.stub.AbstractStub.StubFactory<SingletonServiceGrpcBlockingStub>() {

            @java.lang.Override
            public SingletonServiceGrpcBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new SingletonServiceGrpcBlockingStub(channel, callOptions);
            }
        };
        return SingletonServiceGrpcBlockingStub.newStub(factory, channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static SingletonServiceGrpcFutureStub newFutureStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<SingletonServiceGrpcFutureStub> factory = new io.grpc.stub.AbstractStub.StubFactory<SingletonServiceGrpcFutureStub>() {

            @java.lang.Override
            public SingletonServiceGrpcFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new SingletonServiceGrpcFutureStub(channel, callOptions);
            }
        };
        return SingletonServiceGrpcFutureStub.newStub(factory, channel);
    }

    /**
     */
    public interface AsyncService {

        /**
         */
        default void gerarIdentificador(com.google.protobuf.Empty request, io.grpc.stub.StreamObserver<org.br.mineradora.singleton.grpc.identificador.Identificador> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGerarIdentificadorMethod(), responseObserver);
        }
    }

    /**
     * Base class for the server implementation of the service SingletonServiceGrpc.
     */
    public static abstract class SingletonServiceGrpcImplBase implements io.grpc.BindableService, AsyncService {

        @java.lang.Override
        public io.grpc.ServerServiceDefinition bindService() {
            return SingletonServiceGrpcGrpc.bindService(this);
        }
    }

    /**
     * A stub to allow clients to do asynchronous rpc calls to service SingletonServiceGrpc.
     */
    public static class SingletonServiceGrpcStub extends io.grpc.stub.AbstractAsyncStub<SingletonServiceGrpcStub> {

        private SingletonServiceGrpcStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected SingletonServiceGrpcStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SingletonServiceGrpcStub(channel, callOptions);
        }

        /**
         */
        public void gerarIdentificador(com.google.protobuf.Empty request, io.grpc.stub.StreamObserver<org.br.mineradora.singleton.grpc.identificador.Identificador> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(getChannel().newCall(getGerarIdentificadorMethod(), getCallOptions()), request, responseObserver);
        }
    }

    /**
     * A stub to allow clients to do synchronous rpc calls to service SingletonServiceGrpc.
     */
    public static class SingletonServiceGrpcBlockingV2Stub extends io.grpc.stub.AbstractBlockingStub<SingletonServiceGrpcBlockingV2Stub> {

        private SingletonServiceGrpcBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected SingletonServiceGrpcBlockingV2Stub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SingletonServiceGrpcBlockingV2Stub(channel, callOptions);
        }

        /**
         */
        public org.br.mineradora.singleton.grpc.identificador.Identificador gerarIdentificador(com.google.protobuf.Empty request) throws io.grpc.StatusException {
            return io.grpc.stub.ClientCalls.blockingV2UnaryCall(getChannel(), getGerarIdentificadorMethod(), getCallOptions(), request);
        }
    }

    /**
     * A stub to allow clients to do limited synchronous rpc calls to service SingletonServiceGrpc.
     */
    public static class SingletonServiceGrpcBlockingStub extends io.grpc.stub.AbstractBlockingStub<SingletonServiceGrpcBlockingStub> {

        private SingletonServiceGrpcBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected SingletonServiceGrpcBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SingletonServiceGrpcBlockingStub(channel, callOptions);
        }

        /**
         */
        public org.br.mineradora.singleton.grpc.identificador.Identificador gerarIdentificador(com.google.protobuf.Empty request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(getChannel(), getGerarIdentificadorMethod(), getCallOptions(), request);
        }
    }

    /**
     * A stub to allow clients to do ListenableFuture-style rpc calls to service SingletonServiceGrpc.
     */
    public static class SingletonServiceGrpcFutureStub extends io.grpc.stub.AbstractFutureStub<SingletonServiceGrpcFutureStub> {

        private SingletonServiceGrpcFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected SingletonServiceGrpcFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SingletonServiceGrpcFutureStub(channel, callOptions);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<org.br.mineradora.singleton.grpc.identificador.Identificador> gerarIdentificador(com.google.protobuf.Empty request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(getChannel().newCall(getGerarIdentificadorMethod(), getCallOptions()), request);
        }
    }

    private static final int METHODID_GERAR_IDENTIFICADOR = 0;

    private static final class MethodHandlers<Req, Resp> implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>, io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {

        private final AsyncService serviceImpl;

        private final int methodId;

        MethodHandlers(AsyncService serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch(methodId) {
                case METHODID_GERAR_IDENTIFICADOR:
                    serviceImpl.gerarIdentificador((com.google.protobuf.Empty) request, (io.grpc.stub.StreamObserver<org.br.mineradora.singleton.grpc.identificador.Identificador>) responseObserver);
                    break;
                default:
                    throw new AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch(methodId) {
                default:
                    throw new AssertionError();
            }
        }
    }

    public static io.grpc.ServerServiceDefinition bindService(AsyncService service) {
        return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor()).addMethod(getGerarIdentificadorMethod(), io.grpc.stub.ServerCalls.asyncUnaryCall(new MethodHandlers<com.google.protobuf.Empty, org.br.mineradora.singleton.grpc.identificador.Identificador>(service, METHODID_GERAR_IDENTIFICADOR))).build();
    }

    private static abstract class SingletonServiceGrpcBaseDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {

        SingletonServiceGrpcBaseDescriptorSupplier() {
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return org.br.mineradora.singleton.grpc.identificador.SingletonGrpc.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("SingletonServiceGrpc");
        }
    }

    private static final class SingletonServiceGrpcFileDescriptorSupplier extends SingletonServiceGrpcBaseDescriptorSupplier {

        SingletonServiceGrpcFileDescriptorSupplier() {
        }
    }

    private static final class SingletonServiceGrpcMethodDescriptorSupplier extends SingletonServiceGrpcBaseDescriptorSupplier implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {

        private final java.lang.String methodName;

        SingletonServiceGrpcMethodDescriptorSupplier(java.lang.String methodName) {
            this.methodName = methodName;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
            return getServiceDescriptor().findMethodByName(methodName);
        }
    }

    private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

    public static io.grpc.ServiceDescriptor getServiceDescriptor() {
        io.grpc.ServiceDescriptor result = serviceDescriptor;
        if (result == null) {
            synchronized (SingletonServiceGrpcGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME).setSchemaDescriptor(new SingletonServiceGrpcFileDescriptorSupplier()).addMethod(getGerarIdentificadorMethod()).build();
                }
            }
        }
        return result;
    }
}
