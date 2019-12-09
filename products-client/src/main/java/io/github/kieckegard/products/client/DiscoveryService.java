/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.products.client;

import com.netflix.appinfo.InstanceInfo;
import java.net.URI;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

/**
 *
 * @author pafer
 */

@Service
public class DiscoveryService {
    
    private DiscoveryClient  discoveryClient;

    @Autowired
    public DiscoveryService(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    public URI getInstance(final String appName) {
        
        List<ServiceInstance> instances = this.discoveryClient.getInstances(appName);
        
        System.out.println("instances size: " + instances.size());
        
        if (instances == null || instances.isEmpty()) {
            return null;
        }
        
        Random rand = new Random();
        int instanceIndex = rand.nextInt(instances.size());
        
        return instances.get(instanceIndex).getUri();
    }
}
