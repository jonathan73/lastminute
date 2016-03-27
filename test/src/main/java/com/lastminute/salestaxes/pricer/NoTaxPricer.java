package com.lastminute.salestaxes.pricer;

import com.lastminute.salestaxes.dto.ProductDto;
/**
 * Used to retrieve the tax rate of products without taxes.
 * @author jonathan
 * @see DefaultPricer
 *
 */
public class NoTaxPricer extends AbstractPricer {

    @Override
    public double getTaxRate(ProductDto productDto) {
     
        return 0;
        
    }
 

}
