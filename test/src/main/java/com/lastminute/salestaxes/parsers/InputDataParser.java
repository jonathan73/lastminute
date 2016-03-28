package com.lastminute.salestaxes.parsers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lastminute.salestaxes.dto.ProductDto;
import com.lastminute.salestaxes.dto.ProductType;
/**
 * This is a singleton class used to parse the input file.
 * @author jonathan
 *
 */
public final class InputDataParser {
    
    /**
     * A list of products without taxes.
     */
    private static final String NOTAX[] = {"chocolate", "book", "pill"};
    /**
     * The text of the output.
     */
    private static final String AT = " at";
    
    /**
     * A word in the row that identify an imported producs.
     */
    private static final String IMPORTED = "imported";
     
    /**
     * Internal singleton Object.
     */
    private static InputDataParser inputDataParser;
    
    /**
     * Default constructor.
     */
    private InputDataParser() {
        
    }
    /**
     * A static method used to retrieve a singleton instance.
     * @return a singleton InputDataParse Object.
     */
    public static InputDataParser getInstance() {
        if (inputDataParser == null) {
            inputDataParser = new InputDataParser();
        }
        return inputDataParser;
    }
    /**
     * Set the imported and the product type.
     * @param productDto the products.
     */
    private void updateProductFlags(ProductDto productDto) { 
        
        productDto.setProductType(ProductType.TAX);
        for (String item : NOTAX) {
            if (productDto.getDescription().indexOf(item) > -1) {
                productDto.setProductType(ProductType.NO_TAX);
            }
        }
        if (productDto.getDescription().indexOf(IMPORTED) > -1) {
            productDto.setImported(true);
        }
    }
    /**
     * Parse the input file.
     * @param file the input file
     * @return list of products.
     */
    public List<ProductDto> parse(File file) {

        final List<ProductDto> products = new ArrayList<ProductDto>();

        try (Scanner scanner = new Scanner(file);) {

            while (scanner.hasNextLine()) {
                try (Scanner dataScanner = new Scanner(scanner.nextLine());) {

                    while (dataScanner.hasNext()) {

                        final ProductDto productDto = new ProductDto();
                        productDto.setQuantity(dataScanner.nextInt());
                        final String line = dataScanner.nextLine();
                        productDto.setDescription(line.substring(1, line.lastIndexOf(AT)));
                        updateProductFlags(productDto);
                        final String num = line.substring(line.lastIndexOf(AT) + AT.length()).trim();
                        productDto.setPrice(Double.parseDouble(num));
                        products.add(productDto);

                    }
                    dataScanner.close();
                }

            }

            return products;

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

    }
}
