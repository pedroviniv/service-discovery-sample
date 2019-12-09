/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.products.client;

import java.util.List;
import java.util.Random;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * A random ServiceInstance chooser. it simply rands
 * a number between 0 (inclusive) and the size of the
 * list passed (exclusive) and retrieves the element using
 * the number as the index.
 * 
 * @author pafer
 */
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class RandomLoadBalancer implements LoadBalancer {
    
    final static Random RANDOM = new Random();

    @Override
    public ServiceInstance choose(@NotNull @NotEmpty List<ServiceInstance> instances) {
 
        int instanceIndex = RANDOM.nextInt(instances.size());
        return instances.get(instanceIndex);
    }
    
}
