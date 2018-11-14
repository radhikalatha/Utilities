package me.util;

import java.math.BigInteger;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

/**
 * StringAccumalator utility add(String)  
 * Split and add the input String numbers 
 * Splits with default delimiters or as provided in input
 *  
 * @author Radhika.C-Soma
 *
 */

public class StringAccumalator {

	public static void main(String[] args) {		
		String input = "1,2\n45";		
		add(input);
	}
	
	/**
	 * Split and add the input String numbers 
	 * Splits with default delimiters or as provided in input
	 * 
	 * @param numbers
	 * @return sum of numbers as String
	 */
	public static String add(String numbers){	
		try {		
	
			// Considered BigInteger for unlimited length of numbers to sum
			BigInteger sum = new BigInteger("0");
			
			// Default delimiter
			String delimiter = ",\n";	
			
			// Logic to pick new delimiters to split numbers
			if(numbers.startsWith("//")) {
				String[] splits = numbers.substring(2).split("\n",2);
				delimiter = splits[0].replace('|', '\0');
				numbers = splits[1];
			}
			
			// Gauva Splitter defined with delimiter chars to split and omit empty chars
			Splitter niceAnyCharSplitter = Splitter.on(CharMatcher.anyOf(delimiter))		
											       .omitEmptyStrings();	
			
			// numbers got tokenized with defined Splitter
			Iterable<String> tokens = niceAnyCharSplitter.split(numbers);
			
			// Loop through each token number to sum 
			for(String element : tokens) {
				sum = sum.add(new BigInteger(element));
			}				
			return sum.toString();
		}catch(NumberFormatException nexception) {
			return null;
		}catch(Exception exception) {
			return null;
		}
	}
		
}
