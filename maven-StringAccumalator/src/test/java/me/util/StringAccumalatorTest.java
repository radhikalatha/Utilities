package me.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test cases for String accumulater add(String)
 * 
 * @author Radhika.C-Soma
 *
 */
public class StringAccumalatorTest {
	
	/**
	 * Delimiter default - ",\n"
	 * String to split - "1,2,\n45"
	 */
	@Test
	public void string_accumalator_default_delimiter () {
	    String inputWithDelimiters = "1,2,\n45";
	    String sum = StringAccumalator.add(inputWithDelimiters);	    
	    assertEquals("48", sum);	    
	}
	
	/**
	 * Delimiter on runtime - "-|,$"
	 * String to split - "1-2,$45"
	 */
	@Test
	public void string_accumalator_custom_delimiter () {
	    String inputWithDelimiters = "//-|,$\n1-2,$45";
	    String sum = StringAccumalator.add(inputWithDelimiters);	
	    assertEquals("48", sum);	    
	}

	/**
	 * Delimiter default - ",\n"
	 * String to split - "1,2-45"
	 */
	@Test
	public void split_accumalator_invalid_number () {
	    String inputWithDelimiters = "1,2-45";
	    String sum = StringAccumalator.add(inputWithDelimiters);	    
	    assertEquals(null, sum);	    
	}
	
	/**
	 * Delimiter default - ",\n"
	 * String to split - long numbers
	 */
	@Test
	public void split_accumalator_long_number () {
	    String inputWithDelimiters = "214748364,214748364";
	    String sum = StringAccumalator.add(inputWithDelimiters);	    
	    assertEquals("429496728", sum);	    
	}
	
}
