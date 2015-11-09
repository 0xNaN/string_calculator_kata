package string_calculator_kata;

public class StringCalculator {

	public int add(String numbers) {
		if("".equals(numbers))
			return 0;
		return Integer.parseInt(numbers);
	}

}
