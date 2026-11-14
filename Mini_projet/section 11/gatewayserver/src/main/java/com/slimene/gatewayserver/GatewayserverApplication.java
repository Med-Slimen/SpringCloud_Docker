package com.slimene.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
public class GatewayserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayserverApplication.class, args);
    }
    @Bean
    public RouteLocator MyRouteConfig(RouteLocatorBuilder routeLocatorBuilder)
    {
        return routeLocatorBuilder.routes()
                .route(p -> p
                        .path("/api/departements/**")
                        .uri("lb://departement"))
                .route(p -> p
                        .path("/api/projets/**")
                        .filters( f -> f.circuitBreaker(config -> {
                            config.setName("projetCircuitBreaker").setFallbackUri("forward:/contactAdmin");

                            // Treat HTTP 500 and 503 from the microservice as circuit breaker failures
                            config.setStatusCodes(Set.of("500", "503"));

                        }))
                        .uri("lb://projet"))
                .build();
    }
}
