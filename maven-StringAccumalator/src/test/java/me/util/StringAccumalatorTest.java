package me.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
	    String sum = "";
		try {
			sum = StringAccumalator.add(inputWithDelimiters);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	    
	    assertEquals("48", sum);	    
	}
	
	/**
	 * Delimiter on runtime - "-|,$"
	 * String to split - "1-2,$45"
	 */
	@Test
	public void string_accumalator_custom_delimiter () {
	    String inputWithDelimiters = "//-|,$\n1-2,$45";
	    String sum = "";
		try {
			sum = StringAccumalator.add(inputWithDelimiters);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	    assertEquals("48", sum);	    
	}

	/**
	 * Delimiter default - ",\n"
	 * String to split - "1,2-45"
	 */
	@Test
	public void split_accumalator_invalid_number () {
	    String inputWithDelimiters = "1,2-45";
	    String sum = "";
		try {
			sum = StringAccumalator.add(inputWithDelimiters);
		}catch (NumberFormatException e) {
			assertNotNull(e.getMessage(), e);
		} catch (Exception e) {
			assertEquals("Negative numbers not allowed", e.getMessage());
		}	    
	}
	
	/**
	 * Delimiter default - ",\n"
	 * String to split - long numbers
	 */
	@Test
	public void split_accumalator_long_number () {
	    String inputWithDelimiters = "214748364,214748364";
	    String sum = "";
		try {
			sum = StringAccumalator.add(inputWithDelimiters);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    assertEquals("0", sum);
	    //assertEquals("429496728", sum);	    
	}
	
	/**
	 * Delimiter default - ",\n"
	 * String to split - number > 1000
	 */
	@Test
	public void split_accumalator_bigger_acceptable () {
	    String inputWithDelimiters = "0,1002,300,5";
	    String sum = "";
		try {
			sum = StringAccumalator.add(inputWithDelimiters);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    assertEquals("305", sum);
	    //assertEquals("429496728", sum);	    
	}	
	
	/**
	 * Delimiter on runtime - "***\"
	 * String to split - "//***\n1***2***3"
	 */
	@Test
	public void string_accumalator_multiple_delimiters () {
	    String inputWithDelimiters = "//***\n1***2***3";
	    String sum = "";
		try {
			sum = StringAccumalator.add(inputWithDelimiters);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	    assertEquals("6", sum);	    
	}
	
	/**
	 * Delimiter on runtime - "***\"
	 * String to split - "1\n2,3"
	 */
	@Test
	public void string_accumalator_default_delimiter_case2 () {
	    String inputWithDelimiters = "1\n2,3";
	    String sum="";
		try {
			sum = StringAccumalator.add(inputWithDelimiters);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	    assertEquals("6", sum);	    
	}
	
	
	/**
	 * String split has negative numbers
	 * Delimiter on runtime - "***\"
	 * String to split - "1\n2,-3"
	 */
	@Test
	public void string_accumalator_negative_values () {
	    String inputWithDelimiters = "1\n2,-3,-5";	    
		try {
			String sum = StringAccumalator.add(inputWithDelimiters);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertNotNull(e.getMessage(),e);	
		}  
	}

}
