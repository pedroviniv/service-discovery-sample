/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.products.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author pafer
 */

@Configuration
public class RestTemplateProvider {
    
    @Bean
    public RestTemplate provide() {
        return new RestTemplate();
    }
}
