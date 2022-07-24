package com.greeting.grpc.greetinggrpcclient;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Bean;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class GreetingGrpcClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(GreetingGrpcClientApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(GreetingServiceClient greetingServiceClient) {
		return (args) -> {
			var greeting = greetingServiceClient.receiveGreeting("Cristian", "Lully", true);

			log.info(greeting);
		};
	}
}
