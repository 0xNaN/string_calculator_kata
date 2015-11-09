package string_calculator_kata;

public class StringCalculator {

	public int add(String numbers) {
		if("".equals(numbers))
			return 0;
		if(! numbers.contains(","))
			return Integer.parseInt(numbers);
		
		String[] nums = numbers.split(",");
		int first = Integer.parseInt(nums[0]);
		int second = Integer.parseInt(nums[1]);
		return first + second;
   }

}
