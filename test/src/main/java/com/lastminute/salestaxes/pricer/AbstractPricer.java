package com.lastminute.salestaxes.pricer;

import com.lastminute.salestaxes.dto.ProductDto;
import com.lastminute.salestaxes.utils.NumberUtils;
/**
 * This is the abstract class the apply the price based on the taxrate.
 * There are several extension of this class.
 * @author jonathan 
 */
public abstract class AbstractPricer {
    /**
     * The defaul tax rate.
     */
    private static final double DEFAULT_IMPORT_TAX_RATE = 5d;
    /**
     * Apply the price to the product.
     * @param productDto the product.
     */
    public final void applyPrice(ProductDto productDto) {
        double tax = getTaxRate(productDto);
        if (productDto.isImported()) {
            tax += getImportTaxRate();
        }            
        final double taxedprice = NumberUtils.roundNearest(productDto.getPrice() / 100 * tax);  
        final double finalprice = productDto.getPrice() + taxedprice;
        productDto.setTotal(NumberUtils.round(finalprice));
         
    }    
    /**
     * Calculate the tax rate of the product.
     * @param productDto The product.
     * @return the tax Rate
     */
    protected abstract double getTaxRate(ProductDto productDto);
    /**
     * Return the import tax rate. 
     * @return the import tax rate.
     */
    protected double getImportTaxRate() {
        return DEFAULT_IMPORT_TAX_RATE;
    }
}
