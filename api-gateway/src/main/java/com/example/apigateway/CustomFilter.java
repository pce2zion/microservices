package com.example.apigateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
@Slf4j
public class CustomFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
     ServerHttpRequest request = exchange.getRequest();

        log.info("Authorization = " + request.getHeaders().getFirst("Authorization"));
        return chain.filter(exchange).then(Mono.fromRunnable(()-> {
            ServerHttpResponse response = exchange.getResponse();
            log.info("Post filter = " + response.getStatusCode());
        }));
        //the return statement above routes it to the next route the api gateway is supposed to go to eg signup or whatever endpoint.
        // it is to go to next .here we
        // just logged the request headers but we can actually implement spring security measures here

    }
}
