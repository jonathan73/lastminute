package com.lastminute.salestaxes.dto;

/**
 * This is a class model that contain the product data.
 * 
 * @author jonathan
 *
 */

public class ProductDto {
    /**
     * Product description.
     */
    private String description; 
    /**
     * Product price.
     */
    private double price;
    /**
     * Total price.
     */
    private double total;
    /**
     * Product type.
     */
    private ProductType productType;
    /**
     * Flag for imported products.
     */
    private boolean imported;
    /**
     * Quantity of a products.
     */
    private int quantity;

    /**
     * Pruducts quantity.
     * @return number of products.
     */
    public int getQuantity() {
        return quantity;
    }
    /**
     * Set the  number of products.
     * @param quantity a integer value.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    /**
     * identify if a product is imported.
     * @return a boolean that is true if the product is imported.
     */
    public boolean isImported() {
        return imported;
    }

    /**
     * Set the product imported flag.
     * @param imported true if the product is imported.
     */
    public void setImported(boolean imported) {
        this.imported = imported;
    }

    /**
     * Identify the type of product.
     * @return TAX or NO_TAX
     */
    public ProductType getProductType() {
        return productType;
    }
    /**
     * Set the type of product.
     * @param productType Only TAX or NO_TAX is admitted.
     */
    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    /**
     * Return the description of product.
     * @return a string of the product description.
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Set the product description.
     * @param description product description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * a product price.
     * @return the product price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the product price.
     * @param price thr product price.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Return the price total the includes taxes.
     * @return price.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Set the total price.
     * @param total total price
     */
    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {

        return String.format("%d %s: %.2f", this.getQuantity(), this.getDescription(), this.total);

    }

}
