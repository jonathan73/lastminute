package com.lastminute.salestaxes.parsers;

import static junit.framework.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;

import com.lastminute.salestaxes.dto.ProductDto;
import com.lastminute.salestaxes.dto.ProductType;
import com.lastminute.salestaxes.parsers.InputDataParser;
/**
 * Test if the parser works correctly and creates the correct Product DTO.
 * - Test if the product has tax sales or not ( based on some type of word in the description ).
 * - Test if the product is imported ( based on imported word in the description ).
 * 
 * @author jonathan
 *
 */
public class ParserTest {
	/**
	 * Test input file 1.
	 */
	@Test
	public void testParserInputFile1(){
		 
		List<ProductDto>products = null;
		ProductDto productDto 	 = null;
		
		products = InputDataParser.getInstance().parse(resolveFileName("input_1.txt"));
		assertEquals(products.size(),3); 
		
		productDto = products.get(0);
		assertEquals(productDto.getQuantity(), 1 );
		assertEquals(productDto.getDescription(), "book");
		assertEquals(productDto.getPrice(), 12.49);
		assertEquals(productDto.getProductType(), ProductType.NO_TAX);
		
		productDto = products.get(1);
		assertEquals(productDto.getQuantity(), 1);
		assertEquals(productDto.getDescription(), "music CD");
		assertEquals(productDto.getPrice(), 14.99);
		assertEquals(productDto.getProductType(), ProductType.TAX);
		
		productDto = products.get(2);
		assertEquals(productDto.getQuantity(), 1);
		assertEquals(productDto.getDescription(), "chocolate bar");
		assertEquals(productDto.getPrice(), 0.85);
		assertEquals(productDto.getProductType(), ProductType.NO_TAX);
		
	}
	
	/**
	 * Test input file 2.
	 */
	@Test
	public void testParserInputFile2(){
		
		List<ProductDto>products = null;
		ProductDto productDto 	 = null;
		
		products = InputDataParser.getInstance().parse(resolveFileName("input_2.txt"));
		assertEquals(products.size(),2);
		
		productDto = products.get(0);
		assertEquals(productDto.getQuantity(), 1 );
		assertEquals(productDto.getDescription(), "imported box of chocolates");
		assertEquals(productDto.getPrice(), 10.0);
		assertTrue(productDto.isImported());
		assertEquals(productDto.getProductType(), ProductType.NO_TAX);
		
		productDto = products.get(1);
		assertEquals(productDto.getQuantity(), 1 );
		assertEquals(productDto.getDescription(), "imported bottle of perfume");
		assertEquals(productDto.getPrice(), 47.50);
		assertTrue(productDto.isImported()); 
		assertEquals(productDto.getProductType(), ProductType.TAX);
	}
	
	/**
	 * Test input file 3.
	 */
	@Test
	public void testParserInputFile3(){
		List<ProductDto>products = null;
		ProductDto productDto 	 = null;
		
		products = InputDataParser.getInstance().parse(resolveFileName("input_3.txt"));
		assertEquals(products.size(),4);
		
		productDto = products.get(0);
		assertEquals(productDto.getQuantity(), 1 );
		assertEquals(productDto.getDescription(), "imported bottle of perfume");
		assertEquals(productDto.getPrice(), 27.99);
		assertTrue(productDto.isImported());
		assertEquals(productDto.getProductType(), ProductType.TAX);
		
		productDto = products.get(1);
		assertEquals(productDto.getQuantity(), 1 );
		assertEquals(productDto.getDescription(), "bottle of perfume");
		assertEquals(productDto.getPrice(), 18.99);
		assertFalse(productDto.isImported());
		assertEquals(productDto.getProductType(), ProductType.TAX);
		
		productDto = products.get(2);
		assertEquals(productDto.getQuantity(), 1 );
		assertEquals(productDto.getDescription(), "packet of headache pills");
		assertEquals(productDto.getPrice(), 9.75);
		assertFalse(productDto.isImported());
		assertEquals(productDto.getProductType(), ProductType.NO_TAX);
		
		productDto = products.get(3);
		assertEquals(productDto.getQuantity(), 1 );
		assertEquals(productDto.getDescription(), "box of imported chocolates");
		assertEquals(productDto.getPrice(), 11.25);
		assertTrue(productDto.isImported()); 
		
	}
	
	private static File resolveFileName(String fileName){
		return new File(ParserTest.class.getClassLoader().getResource("inputfiles/" + fileName).getFile());
	}
	 
	
}
