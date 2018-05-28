package com.microecom.meccatalogquery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MecCatalogQueryApplication {

    private static final Logger LOG = LoggerFactory.getLogger(MecCatalogQueryApplication.class);

    public static void main(String[] args) {
		SpringApplication.run(MecCatalogQueryApplication.class, args);
	}

}
