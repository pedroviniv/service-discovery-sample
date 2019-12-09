/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.products.client;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author pafer
 */

@Component
public class Test {
    
    private DiscoveryService discoveryService;
    private RestTemplate restTemplate;
    
    @Value("${products-api.id}")
    private String productsApiId;
    
    @Value("${products-api.endpoints.products}")
    private String productEndPoint;

    @Autowired
    public Test(DiscoveryService eurekaService, RestTemplate restTemplate) {
        this.discoveryService = eurekaService;
        this.restTemplate = restTemplate;
    }
    
    @Scheduled(fixedDelay = 2000)
    public void run() {
        
        final URI uri = this.discoveryService.getInstance(this.productsApiId);
        System.out.println("service instance: " + uri);
        String json = this.restTemplate.getForObject(uri.toString() + this.productEndPoint, String.class);
        System.out.println("returned: " + json);
    }
}
