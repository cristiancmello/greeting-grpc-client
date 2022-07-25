package com.greeting.grpc.greetinggrpcclient;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringBootTest
@DirtiesContext
@SpringJUnitConfig(classes = { GreetingServiceIntegrationTestConfiguration.class })
public class GreetingServiceClientTest {
    @Autowired
    private GreetingServiceClient greetingServiceClient;

    @Test
    @DirtiesContext
    public void testHello() {
        assertThat(greetingServiceClient.receiveGreeting("John", "Wally", true))
                .isEqualTo("John have a dog called Wally and loves your dog");
    }
}

