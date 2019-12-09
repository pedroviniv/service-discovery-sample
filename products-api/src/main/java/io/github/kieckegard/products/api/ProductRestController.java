/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.products.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pafer
 */

@RestController
@RequestMapping("/api/products")
public class ProductRestController {
    
    private ProductRepository products;

    @Autowired
    public ProductRestController(ProductRepository products) {
        this.products = products;
    }
    
    @PostMapping
    public ResponseEntity create(@RequestBody Product product) {
        
        this.products.save(product);
        
        return ResponseEntity.ok().build();
    }
    
    @GetMapping
    public ResponseEntity<List<Product>> listAll(@RequestParam(name = "sortedBy", required = false, defaultValue = "none") final String param) {
        
        
        return ResponseEntity.ok(this.products.listAllSortedByParam(param));
    }
    
    
}
