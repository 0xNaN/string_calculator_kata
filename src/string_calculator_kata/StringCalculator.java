package string_calculator_kata;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

	private static final String EMTY_LINE = "";
	private static final String SEPARATOR = ",";

	public int add(String numbers) {
		int total = 0;
		for(String line: numbers.split("\n")) {
			if(isEmpty(line))
				total += 0;
			else
				total += computeLine(line);
		}
		return total;
   }

	private boolean isEmpty(String numbers) {
		return EMTY_LINE.equals(numbers);
	}

	private int computeLine(String numbers) {
		int total = 0;
		
		List<String> nums = Arrays.asList(numbers.split(SEPARATOR));
		for(String number: nums) 
			total += Integer.parseInt(number);
	
		return total;
	}

}
