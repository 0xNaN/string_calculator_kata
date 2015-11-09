package string_calculator_kata;

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
		String[] nums = numbers.split(SEPARATOR);
		int first = Integer.parseInt(nums[0]);
		int second = Integer.parseInt(nums[1]);
		return first + second;
	}

}
