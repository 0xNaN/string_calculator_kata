package string_calculator_kata;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StringCalculator {

	private static final String SEPARATOR_PATTERN = "//.*\n";
	private static final String SEPARATOR_HEADER_PREFIX = "//";
	private static final String NEW_LINE_SEQUENCE = "\n";
	private static final String EMTY_LINE = "";
	private static final String DEFAULT_SEPARATOR = ",";

	public int add(String numbers) throws NegativeNotAllowed {
		int total = 0;
		for(Integer num: getNumbersIfPositive(numbers))
			total += num;
		return total;
	}


	private List<Integer> getNumbersIfPositive(String numbers) throws NegativeNotAllowed {
		List<Integer> allNumbers = getNumbersFrom(numbers);
		checkPositivness(allNumbers);
		return allNumbers;
	}


	private List<Integer> getNumbersFrom(String data) {
		List<String> lines = getLines(data);
		String separator = getSeparator(lines.get(0));

		if(isSeparatorHeader(lines.get(0)))
			lines.remove(0);
		
		return getNumbersFrom(collapseToALine(data, separator), separator);
	}



	private List<Integer> getNumbersFrom(String line, String separator) {
		List<Integer> numbers = new LinkedList<Integer>();	
		List<String> stringNumbers = splitNumbers(line, separator);
		
		for(String num: stringNumbers)
			numbers.add(stringToNumber(num));
		
		return numbers;
	}


	private List<String> splitNumbers(String line, String separator) {
		return Arrays.asList(line.split(separator));
	}

	private void checkPositivness(List<Integer> numbers) throws NegativeNotAllowed {
		List<Integer> negativeNumbers = new LinkedList<Integer>();
		for(Integer n: numbers) {
			if(n < 0)
				negativeNumbers.add(n);
		}
		if(negativeNumbers.size() > 0)
			throw new NegativeNotAllowed(negativeNumbers.toString());
	}


	private String getSeparator(String line) {
		String separator = DEFAULT_SEPARATOR;
		if(isSeparatorHeader(line)) {
			separator = parseSeparator(line);
		}
		return separator;
	}

	private boolean isSeparatorHeader(String line) {
		return line.startsWith(SEPARATOR_HEADER_PREFIX);
	}

	private String parseSeparator(String line) {
		return line.substring(SEPARATOR_HEADER_PREFIX.length());
	}

	private String collapseToALine(String data, String separator) {
		data = data.replaceFirst(SEPARATOR_PATTERN, "");
		data = data.replace(NEW_LINE_SEQUENCE, separator);
		return data;
	}

	private List<String> getLines(String data) {
		return new LinkedList(Arrays.asList(data.split(NEW_LINE_SEQUENCE)));
	}

	private boolean isEmpty(String line) {
		return EMTY_LINE.equals(line);
	}
	
	private Integer stringToNumber(String num) {
		return "".equals(num) ? 0 : Integer.parseInt(num);
	}
}
