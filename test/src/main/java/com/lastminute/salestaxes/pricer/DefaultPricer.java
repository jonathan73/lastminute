package com.lastminute.salestaxes.pricer;

import com.lastminute.salestaxes.dto.ProductDto;
/**
 * Used to retrieve the tax rate of standard products.
 * @author jonathan
 * @see NoTaxPricer
 *
 */
public class DefaultPricer extends AbstractPricer {
    /**
     * The default tax rate value.
     */
    private static final double DEFAULT_TAX_RATE = 10;
    
    /**
     * Return the tax rate.
     */
    @Override
    public double getTaxRate(ProductDto productDto) {
     
        return DEFAULT_TAX_RATE;
    }
 

}
