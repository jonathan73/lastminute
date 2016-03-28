package com.lastminute.salestaxes.dto;

import java.util.ArrayList;
import java.util.List;
/**
 * This is a model class for the order.
 * @author jonathan
 *
 */
public class OrderDto {
    /**
     * Products list.
     */
    private List<ProductDto> products = new ArrayList<ProductDto>();
    /**
     * Tax for sales.
     */
    private double saleTaxes;
    /**
     * Total price of the order.
     */
    private double total;
    /**
     * @return a list of products.
     */
    public final List<ProductDto> getProducts() {
        return products;
    }
    /**
     * Set a list of products.
     * @param products a list of products
     */
    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }

    /**
     * tax sales.
     * @return sale taxes
     */
    public double getSaleTaxes() {
        return saleTaxes;
    }

    /**
     * Set tax sales.
     * @param saleTaxes a tax sales
     */
    public void setSaleTaxes(double saleTaxes) {
        this.saleTaxes = saleTaxes;
    }

    /**
     * Return the total price that includes the tax.
     * @return total price
     */
    public double getTotal() {
        return total;
    }

    /**
     * Set the total price.
     * @param total The total price
     */
    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() { 
        
        return String.format("Sales Taxes: %.2f\nTotal : %.2f ", this.getSaleTaxes(), this.getTotal());
        
    }
    
}
