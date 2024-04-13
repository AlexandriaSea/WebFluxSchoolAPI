/**
 * Student Name: Wenjie Zhou
 * Student Number: 301337168
 * Submission Date: Apr 12, 2024
 */

package com.example.wenjiezhou_comp303_assignment4_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * The main entry point for the Spring Boot application. This class initializes and runs the Spring
 * application configured for a microservice architecture with WebFlux, enabling reactive REST API support.
 */

@EnableDiscoveryClient
@SpringBootApplication
public class WenjieZhouComp303Assignment4ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WenjieZhouComp303Assignment4ApiApplication.class, args);
        System.out.println("WebFlux REST API backend is running");
    }
}
