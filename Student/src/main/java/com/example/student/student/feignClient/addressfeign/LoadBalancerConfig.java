package com.example.student.student.feignClient.addressfeign;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@LoadBalancerClient(name = "address-service" )
public class LoadBalancerConfig {

    @LoadBalanced
    @Bean
    public Feign.Builder feignBuilder() {
        return  Feign.builder();
    }
}
