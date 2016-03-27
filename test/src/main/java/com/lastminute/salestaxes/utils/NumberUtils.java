package com.lastminute.salestaxes.utils;

import java.text.DecimalFormat;
/**
 * This class is user to round numbers.
 * @author jonathan
 *
 */
public class NumberUtils {
    /**
     * constant value for rounding.
     */
    private static final double ROUNDED_0_5 = 0.05d; 
    /**
     * Constant value for round 2 decimals.
     */
    private static final double ROUNDED_TWO_DECIMAL = 100d; 
    /**
     * The defaul decimal format.
     */
    private static final DecimalFormat NUMBER_FORMAT = new DecimalFormat("0.00");
    /**
     * Round the nuber neares 0.5.
     * @param input to round.
     * @return the rounded number.
     */
    public static double roundNearest(double input) {
        
        return Math.ceil(input / ROUNDED_0_5) * ROUNDED_0_5;
        
    }
    
    /**
     * Round the price with 2 decimals.
     * @param price a input file.
     * @return the rounded prices.
     */
    public static  double round(double price) {
        price = price * ROUNDED_TWO_DECIMAL;
        price = Math.round(price);
        price = price / ROUNDED_TWO_DECIMAL;
        return price;
    }
    
    /**
     * Format the number with two decimals.
     * @param number input number
     * @return the formatted number
     */
    public static String format(double number) { 
        return NUMBER_FORMAT.format(number);
    }

}
