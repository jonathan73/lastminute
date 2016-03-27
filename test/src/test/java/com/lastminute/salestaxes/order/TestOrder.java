package com.lastminute.salestaxes.order;

import static junit.framework.Assert.assertEquals;

import java.io.File;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.junit.Test;

import com.lastminute.salestaxes.OrderManager;
import com.lastminute.salestaxes.dto.OrderDto;
import com.lastminute.salestaxes.dto.ProductDto;
import com.lastminute.salestaxes.parsers.InputDataParser;
 
public class TestOrder {
    
    static{
        BasicConfigurator.configure();
    }

    /**
     * Test Input 1 parameters. The input data is in input1.txt. Output should be:
     * 1 book : 12.49 
     * 1 music CD: 16.49 
     * 1 chocolate bar: 0.85 
     * Sales Taxes: 1.50 
     * Total: 29.83
     */
    @Test
    public void testInput1(){
        
        InputDataParser orderParser = InputDataParser.getInstance();
        Collection<ProductDto>productsToPurchase = orderParser.parse(new File(getClass().getClassLoader().getResource("inputfiles/input_1.txt").getFile()));
        OrderManager purchaseManager = new OrderManager();
        OrderDto orderDto = purchaseManager.purchase(productsToPurchase); 
        
        //test the number of products. 
        assertEquals(orderDto.getProducts().size(),3);
        
        List<ProductDto> products = orderDto.getProducts();
        assertEquals(products.get(0).getTotal(), 12.49);
        assertEquals(products.get(1).getTotal(), 16.49);
        assertEquals(products.get(2).getTotal(), 0.85); 
        
        assertEquals(orderDto.getSaleTaxes(), 1.50d);
        assertEquals(orderDto.getTotal(), 29.83d);
        
    }
    /**
     * Test Input 2 parameters. The input data is in input_2.txt. Output should be:
     * 1 imported box of chocolates: 10.50 
     * 1 imported bottle of perfume: 54.65 
     * Sales Taxes: 7.65 
     * Total: 65.15 
     */
    @Test
    public void testInput2(){ 
        
        InputDataParser orderParser = InputDataParser.getInstance();
        Collection<ProductDto>productsToPurchase = orderParser.parse(new File(getClass().getClassLoader().getResource("inputfiles/input_2.txt").getFile()));
        OrderManager purchaseManager = new OrderManager();
        OrderDto orderDto = purchaseManager.purchase(productsToPurchase); 
        
        //test the number of products. 
        assertEquals(orderDto.getProducts().size(),2);
        
        List<ProductDto> products = orderDto.getProducts();
        assertEquals(products.get(0).getTotal(), 10.50);
        assertEquals(products.get(1).getTotal(), 54.65);
        
        assertEquals(orderDto.getSaleTaxes(), 7.65d);
        assertEquals(orderDto.getTotal(), 65.15d);
        
    }
    
    /**
     * Test Input 3 parameters. The input data is in input_3.txt. Output should be:
     * 1 imported bottle of perfume: 32.19 
     * 1 bottle of perfume: 20.89 
     * 1 packet of headache pills: 9.75 
     * 1 imported box of chocolates: 11.85 
     * Sales Taxes: 6.70 
     * Total: 74.68 
     */
    @Test
    public void testInput3(){ 
         
        InputDataParser orderParser = InputDataParser.getInstance();
        Collection<ProductDto>productsToPurchase = orderParser.parse(new File(getClass().getClassLoader().getResource("inputfiles/input_3.txt").getFile()));
        OrderManager purchaseManager = new OrderManager();
        OrderDto orderDto = purchaseManager.purchase(productsToPurchase);  
        
        //test the number of products. 
        assertEquals(orderDto.getProducts().size(),4);
        
        List<ProductDto> products = orderDto.getProducts();
        assertEquals(products.get(0).getTotal(), 32.19);
        assertEquals(products.get(1).getTotal(), 20.89);  
        assertEquals(products.get(2).getTotal(), 9.75);  
        assertEquals(products.get(3).getTotal(), 11.85);  
        
        assertEquals(orderDto.getSaleTaxes(), 6.70d);
        assertEquals(orderDto.getTotal(), 74.68d);
        
    }
    
}
