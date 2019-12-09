/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.products.api;

import java.math.BigDecimal;

/**
 *
 * @author pafer
 */
public class Product {
    
    private String shortTitle;
    private String description;
    private BigDecimal price;

    public Product() {
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "shortTitle=" + shortTitle + ", description=" + description + ", price=" + price + '}';
    }
}
