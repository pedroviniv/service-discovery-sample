/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.products.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 * @author pafer
 */

@SpringBootApplication
@EnableScheduling
public class Loader {
    
    public static void main(String[] args) {
        
        SpringApplication.run(Loader.class, args);
    }
}
