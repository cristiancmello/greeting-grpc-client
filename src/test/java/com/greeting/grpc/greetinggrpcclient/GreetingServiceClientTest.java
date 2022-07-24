package com.greeting.grpc.greetinggrpcclient;

import com.greeting.grpc.gen.proto.GreetingServiceGrpc.GreetingServiceBlockingStub;
import com.greeting.grpc.gen.proto.HelloRequest;
import com.greeting.grpc.gen.proto.HelloResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

public class GreetingServiceClientTest {
    GreetingServiceClient greetingServiceClient = new GreetingServiceClient();
    GreetingServiceBlockingStub greetingGrpcServer = mock(GreetingServiceBlockingStub.class);

    @BeforeEach
    void setup() {
        greetingServiceClient.setGreetingService(greetingGrpcServer);
    }

    @Test
    public void testHello() {
        HelloRequest helloRequest = HelloRequest.newBuilder()
                .setName("John")
                .setDog("Wally")
                .setILoveMyDog(true)
                .build();

        HelloResponse helloResponse = HelloResponse.newBuilder()
                .setGreeting("John have a dog called Wally and loves your dog")
                .build();

        when(greetingGrpcServer.hello(helloRequest)).thenReturn(helloResponse);

        assertThat(greetingServiceClient.receiveGreeting("John", "Wally", true))
                .contains("John have a dog called Wally and loves your dog");
    }
}
