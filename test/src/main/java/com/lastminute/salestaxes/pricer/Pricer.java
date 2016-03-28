package com.lastminute.salestaxes.pricer;

import com.lastminute.salestaxes.dto.ProductDto;
import com.lastminute.salestaxes.utils.NumberUtils;
/**
 * Used to apply prices with different tax rate based on product type.
 * @author jonathan  
 * @see com.lastminute.salestaxes.OrderManager
 */
public class Pricer {
    /**
     * The defaul tax rate.
     */
    private static final double DEFAULT_IMPORT_TAX_RATE = 5d;
    /**
     * Apply the price to the product. Used by OrderManager. 
     * @param productDto the product.
     * @see com.lastminute.salestaxes.OrderManager
     */
    public final void applyPrice(ProductDto productDto) {
        
        double tax = productDto.getProductType().getTaxRate();
        if (productDto.isImported()) {
            tax += DEFAULT_IMPORT_TAX_RATE;
        }            
        final double taxedprice = NumberUtils.roundNearest(productDto.getPrice() / 100 * tax);  
        final double finalprice = productDto.getPrice() + taxedprice;
        productDto.setTotal(NumberUtils.round(finalprice));
         
    }     
    
}
