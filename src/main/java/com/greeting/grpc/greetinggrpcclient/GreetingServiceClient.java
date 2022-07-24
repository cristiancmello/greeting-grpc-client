package com.greeting.grpc.greetinggrpcclient;

import org.springframework.stereotype.Service;

import net.devh.boot.grpc.client.inject.GrpcClient;

import com.greeting.grpc.gen.proto.HelloRequest;
import com.greeting.grpc.gen.proto.GreetingServiceGrpc.GreetingServiceBlockingStub;

@Service
public class GreetingServiceClient {
    @GrpcClient("greeting-grpc-server")
    GreetingServiceBlockingStub greetingServiceBlockingStub;

    public String receiveGreeting(String name, String dog, boolean loveDog) {
        HelloRequest request = HelloRequest.newBuilder()
                .setName(name)
                .setDog(dog)
                .setILoveMyDog(loveDog)
                .build();

        return greetingServiceBlockingStub.hello(request).getGreeting();
    }
}
