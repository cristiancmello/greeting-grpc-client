package com.greeting.grpc.greetinggrpcclient;

import net.devh.boot.grpc.client.autoconfigure.GrpcClientAutoConfiguration;
import net.devh.boot.grpc.server.autoconfigure.GrpcServerAutoConfiguration;
import net.devh.boot.grpc.server.autoconfigure.GrpcServerFactoryAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ImportAutoConfiguration({
        GrpcServerAutoConfiguration.class, // create required server beans
        GrpcServerFactoryAutoConfiguration.class, // select server implementation
        GrpcClientAutoConfiguration.class // support @GrpcClient annotation
})
public class GreetingServiceIntegrationTestConfiguration {
    @Bean
    GreetingServiceClient greetingServiceClient() {
        return new GreetingServiceClient();
    }

    @Bean
    GreetingServiceImplForMyServiceIntegrationTest greetingServiceImpl() {
        return new GreetingServiceImplForMyServiceIntegrationTest();
    }
}
