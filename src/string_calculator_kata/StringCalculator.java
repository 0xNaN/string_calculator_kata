package string_calculator_kata;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StringCalculator {

	private static final String SEPARATOR_PREFIX = "//";
	private static final String DEFAULT_SEPARATOR = ",";
	private static final String SEPARATOR_PATTERN = SEPARATOR_PREFIX + ".*";
	private static final String NEW_LINE_SEQUENCE = "\n";
	private ILogger logger;

	public StringCalculator(ILogger logger) {
		this.logger = logger;
	}

	public int add(String numbers) throws NegativeNotAllowed {
		Integer total = 0;
		for(Integer num: positiveNumbersFrom(numbers))
			total += num;
		logger.write(total.toString());
		return total;
	}

	private List<Integer> positiveNumbersFrom(String numbers) throws NegativeNotAllowed {
		List<Integer> allNumbers = numbersFrom(numbers);
		checkPositiveness(allNumbers);
		return allNumbers;
	}
	

	private List<Integer> numbersFrom(String data) {
		List<String> lines = linesFrom(data);	
		
		String separatorHeader = lines.get(0);
		if(isSeparatorHeader(separatorHeader))
			lines.remove(0);
		
		String separator = separatorFrom(separatorHeader);
		return numbersFrom(collapseToALine(data, separator), separator);
	}
	

	private List<Integer> numbersFrom(String line, String separator) {
		List<Integer> numbers = new LinkedList<Integer>();	
		List<String> stringNumbers = splitNumbers(line, separator);
		
		for(String num: stringNumbers)
			numbers.add(stringToNumber(num));

		return numbers;
	}
	

	private List<String> splitNumbers(String line, String separator) {
		return Arrays.asList(line.split(separator));
	}
	

	private void checkPositiveness(List<Integer> numbers) throws NegativeNotAllowed {
		List<Integer> negativeNumbers = new LinkedList<Integer>();
		for(Integer n: numbers) {
			if(n < 0)
				negativeNumbers.add(n);
		}
		if(! negativeNumbers.isEmpty())
			throw new NegativeNotAllowed(negativeNumbers.toString());
	}
	

	private String separatorFrom(String line) {
		return isSeparatorHeader(line)
				? parseSeparator(line)
				: DEFAULT_SEPARATOR;
	}
	

	private boolean isSeparatorHeader(String line) {
		return line.matches(SEPARATOR_PATTERN);
	}
	

	private String parseSeparator(String line) {
		return line.substring(SEPARATOR_PREFIX.length());
	}
	

	private String collapseToALine(String data, String separator) {
		return data.replaceFirst(SEPARATOR_PATTERN, "")
				.replace(NEW_LINE_SEQUENCE, separator);
	}
	

	private List<String> linesFrom(String data) {
		return new LinkedList<String>(Arrays.asList(data.split(NEW_LINE_SEQUENCE)));
	}
	

	private Integer stringToNumber(String num) {
		return "".equals(num) ? 0 : Integer.parseInt(num);
	}
}
