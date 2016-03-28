package com.lastminute.salestaxes.dto;
/**
 * Identifies the type of product.
 * @author jonathan
 *
 */
public enum ProductType {
    /**
     * Products can have tax rate or not.
     */
    TAX, NO_TAX {
        /**
         * No tax rate value.
         */
        private static final double NOTAX_RATE = 0;
        
        @Override
        public double getTaxRate() {
            return NOTAX_RATE;
        }
        
    };
    /**
     * Default tax rate value.
     */
    private static final double DEFAULT_TAX_RATE = 10;    
    /**
     * 
     * @return tax rate of the product type.
     */
    public double getTaxRate() {
        return DEFAULT_TAX_RATE;
    }
    
    
    
}
