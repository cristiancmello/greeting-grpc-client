package com.greeting.grpc.greetinggrpcclient;

import com.greeting.grpc.gen.proto.GreetingServiceGrpc.GreetingServiceImplBase;
import com.greeting.grpc.gen.proto.HelloRequest;
import com.greeting.grpc.gen.proto.HelloResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreetingServiceImplForMyServiceIntegrationTest extends GreetingServiceImplBase {
    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String greeting = String.format("%s have a dog called %s and loves your dog",
                request.getName(),
                request.getDog()
        );

        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
