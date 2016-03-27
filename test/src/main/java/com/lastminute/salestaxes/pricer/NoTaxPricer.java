package com.lastminute.salestaxes.pricer;

import com.lastminute.salestaxes.dto.ProductDto;
/**
 * This is the class used for products without tax.
 * @author jonathan
 *
 */
public class NoTaxPricer extends AbstractPricer {

    @Override
    public double getTaxRate(ProductDto productDto) {
     
        return 0;
        
    }
 

}
