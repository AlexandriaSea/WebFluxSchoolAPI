package com.example.wenjiezhou_comp303_assignment4_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class WenjieZhouComp303Assignment4ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WenjieZhouComp303Assignment4ApiApplication.class, args);
        System.out.println("REST API backend is running");
    }
}
