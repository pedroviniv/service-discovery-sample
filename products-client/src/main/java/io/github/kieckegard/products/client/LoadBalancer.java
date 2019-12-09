/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.products.client;

import java.util.List;
import org.springframework.cloud.client.ServiceInstance;

/**
 * Simple load balancer contract. it receives
 * a list of {@link ServiceInstance}, choose one them
 * and returns it.
 * 
 * @author pafer
 */
public interface LoadBalancer {
    
    /**
     * chooses one of the {@link ServiceInstance} passed.
     * @param instances 
     * @return 
     */
    ServiceInstance choose(List<ServiceInstance> instances);
}
