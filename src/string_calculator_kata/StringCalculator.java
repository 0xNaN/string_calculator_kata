package string_calculator_kata;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

	private static final String EMTY_LINE = "";
	private static final String SEPARATOR = ",";

	public int add(String numbers) {
		if(isEmpty(numbers))
			return 0;
		else if (hasOneValue(numbers))
			return Integer.parseInt(numbers);
		
		return computeLine(numbers);
   }

	private boolean isEmpty(String numbers) {
		return EMTY_LINE.equals(numbers);
	}

	private boolean hasOneValue(String numbers) {
		return ! numbers.contains(SEPARATOR);
	}

	private int computeLine(String numbers) {
		int total = 0;
		
		List<String> nums = Arrays.asList(numbers.split(SEPARATOR));
		for(String number: nums) 
			total += Integer.parseInt(number);
	
		return total;
	}

}
