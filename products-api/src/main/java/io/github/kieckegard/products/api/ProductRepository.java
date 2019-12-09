/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.products.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author pafer
 */

@Service
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class ProductRepository {
    
    private final List<Product> products = Collections.synchronizedList(new ArrayList<>());
    
    private final Map<String, Comparator<Product>> comparables = new HashMap<>();

    public ProductRepository() {
    
        this.comparables.put("price", (p1, p2) -> p1.getPrice().compareTo(p2.getPrice()));
        this.comparables.put("title", (p1, p2) -> p1.getShortTitle().compareTo(p2.getShortTitle()));
        this.comparables.put("description", (p1, p2) -> p1.getDescription().compareTo(p2.getDescription()));
    }
    
    public void save(final Product product) {
        this.products.add(product);
    }
    
    public List<Product> listAll() {
        return this.products;
    }
    
    public List<Product> listAllSortedByParam(final String paramName) {
        
        final Comparator<Product> comparator = this.comparables.get(paramName);
        
        if (comparator == null) return this.listAll();
        
        return this.products.stream()
                .sorted((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()))
                .collect(toList());
        
    }
}
