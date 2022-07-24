package com.greeting.grpc.greetinggrpcclient;

import com.greeting.grpc.gen.proto.HelloResponse;
import org.springframework.stereotype.Service;

import net.devh.boot.grpc.client.inject.GrpcClient;

import com.greeting.grpc.gen.proto.HelloRequest;
import com.greeting.grpc.gen.proto.GreetingServiceGrpc.GreetingServiceBlockingStub;

@Service
public class GreetingServiceClient {
    GreetingServiceBlockingStub greetingService;

    @GrpcClient("greeting-grpc-server")
    public void setGreetingService(GreetingServiceBlockingStub greetingService) {
        this.greetingService = greetingService;
    }

    public String receiveGreeting(String name, String dog, boolean loveDog) {
        HelloRequest request = HelloRequest.newBuilder()
                .setName(name)
                .setDog(dog)
                .setILoveMyDog(loveDog)
                .build();

        HelloResponse response = greetingService.hello(request);

        return response.getGreeting();
    }
}
