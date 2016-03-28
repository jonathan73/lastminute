package com.lastminute.salestaxes;

import java.util.ArrayList;
import java.util.Collection; 

import org.apache.log4j.Logger;

import com.lastminute.salestaxes.dto.OrderDto;
import com.lastminute.salestaxes.dto.ProductDto; 
import com.lastminute.salestaxes.pricer.Pricer;
import com.lastminute.salestaxes.utils.NumberUtils;
/**
 * Used to process the order.
 * @author jonathan
 *
 */
public class OrderManager {
    /**
     * Used to set the total price of the product.
     */
    private Pricer pricer = new Pricer();
    
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
            pricer.applyPrice(productDto);
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
