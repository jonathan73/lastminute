package com.lastminute.salestaxes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter; 
import java.util.Collection;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.lastminute.salestaxes.dto.OrderDto;
import com.lastminute.salestaxes.dto.ProductDto;
import com.lastminute.salestaxes.parsers.InputDataParser;
/**
 * Main class used for running.
 * @author jonathan
 *
 */
public class Main {
    /**
     * The logger.
     */
    private static Logger log = Logger.getLogger(Main.class);
    /**
     * The main method.
     * @param args the arguments
     * @throws Exception a generic exception
     */
    public static void main(String[] args) throws Exception {
        
        BasicConfigurator.configure();
        
        if (args.length != 2) {
        	log.info("Specify : inputFile outputFile");
        	return;
        }
          
        final File inputFile  = new File(args[0]);
        if (inputFile.isFile() && inputFile.exists()) {
         
            final String outputFile = args[1];
            
            log.info("Using paramters  file " + inputFile + " " + outputFile);  
            final InputDataParser orderParser = InputDataParser.getInstance();
            log.debug("Parsing " + inputFile);
            final Collection<ProductDto> productsToPurchase = orderParser.parse(inputFile);
            log.debug("Found " + productsToPurchase.size() + " productsToPurchase");
            final OrderManager purchaseManager = new OrderManager();
            final OrderDto orderDto = purchaseManager.purchase(productsToPurchase);
            log.debug("Placed an order with " + orderDto.getProducts().size() + " products");
            
            PrintWriter writer = null;
            try {
                writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outputFile)));
                writer.println("-----------------------------");
                writer.println("Your order ...");
                for (ProductDto productDto : orderDto.getProducts()) {
                    writer.println(
                            String.format("%d %s at %.2f", 
                                productDto.getQuantity(), 
                                productDto.getDescription(), 
                                productDto.getTotal()
                            )
                    );
                }
                writer.println(orderDto);
                log.info("Order placed in  " + outputFile + " created");
            } finally {
                if (writer != null) {
                    writer.close();
                }
            }            
            
        } else {
            throw new IllegalArgumentException(String.format("File %s does not exists", inputFile));
        }
        

    }

}
