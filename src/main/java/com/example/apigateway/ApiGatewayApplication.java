package com.example.apigateway;

import com.example.apigateway.service.ICreditService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}


    @Bean
    ApplicationRunner init(ICreditService creditService) {
        return args -> Stream.of("1", "2", "3", "4").forEach(key -> {
            System.out.println("redis request key " + key);
            creditService.saveCredit(key, 10);
            System.out.println("saved " + key);
        });
    }

}
