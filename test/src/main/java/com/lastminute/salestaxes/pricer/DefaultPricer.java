package com.lastminute.salestaxes.pricer;

import com.lastminute.salestaxes.dto.ProductDto;
/**
 * This is the default Pricer.
 * @author jonathan
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
