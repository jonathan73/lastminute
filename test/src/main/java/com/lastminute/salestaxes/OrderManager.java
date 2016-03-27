package com.lastminute.salestaxes;

import java.util.ArrayList;
import java.util.Collection; 

import org.apache.log4j.Logger;

import com.lastminute.salestaxes.dto.OrderDto;
import com.lastminute.salestaxes.dto.ProductDto;
import com.lastminute.salestaxes.pricer.AbstractPricer;
import com.lastminute.salestaxes.pricer.DefaultPricer;
import com.lastminute.salestaxes.pricer.NoTaxPricer;
import com.lastminute.salestaxes.utils.NumberUtils;
/**
 * This is the class used to process the order.
 * @author jonathan
 *
 */
public class OrderManager {
    /**
     * The logger used in the class.
     */
    private Logger log = Logger.getLogger(OrderManager.class);
    
    /**
     * Purchase the products.
     * @param products a list of products.
     * @return an order.
     */
    public OrderDto purchase(final Collection<ProductDto> products) {
        
        final OrderDto orderDto = new OrderDto();
        orderDto.setProducts(new ArrayList<ProductDto>());
        
        final AbstractPricer defaulPricer = new  DefaultPricer();
        final AbstractPricer notaxPricer = new NoTaxPricer();
        log.debug("-----------------------------");
        log.debug("Purchaising ...");
        for (ProductDto productDto : products) {
            log.debug(
                      String.format("%d %s at %.2f", 
                          productDto.getQuantity(), 
                          productDto.getDescription(), 
                          productDto.getPrice()
                      )
            );
            switch (productDto.getProductType()) {
            case TAX:
                defaulPricer.applyPrice(productDto);
                break;
            case NO_TAX:
                notaxPricer.applyPrice(productDto);
            default:
                break;
            }
            orderDto.getProducts().add(productDto);
        }
        
        double total = 0d;
        double totalPrice = 0d;
             
        for (ProductDto productDto : products) {
            totalPrice += productDto.getPrice();
            total       += productDto.getTotal();
        }
        total = NumberUtils.round(total);
        totalPrice = NumberUtils.round(totalPrice);
        orderDto.setSaleTaxes(NumberUtils.round(total - totalPrice));
        orderDto.setTotal(total);     
        
        log.debug("-----------------------------");
        log.debug("Your order ...");
        for (ProductDto productDto : products) {
            log.debug(
                String.format("%d %s at %.2f", 
                    productDto.getQuantity(), 
                    productDto.getDescription(), 
                    productDto.getTotal()
                )
            );
        }
        log.debug(orderDto.toString());        
        return orderDto;
    }

}
