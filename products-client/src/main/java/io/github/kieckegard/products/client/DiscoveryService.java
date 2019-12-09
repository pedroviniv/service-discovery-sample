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
    private LoadBalancer loadBalancer;

    @Autowired
    public DiscoveryService(DiscoveryClient discoveryClient,
            LoadBalancer loadBalancer) {
        this.discoveryClient = discoveryClient;
        this.loadBalancer = loadBalancer;
    }

    public URI getInstance(final String appName) {
        
        final List<ServiceInstance> instances = this.discoveryClient.getInstances(appName);
        
        if (instances == null || instances.isEmpty()) {
            return null;
        }
        
        System.out.println("instances size: " + instances.size());
        
        final ServiceInstance chosed = this.loadBalancer.choose(instances);
        
        return chosed.getUri();
    }
}
