package string_calculator_kata;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StringCalculator {

	private static final String SEPARATOR_HEADER_PREFIX = "//";
	private static final String NEW_LINE_SEQUENCE = "\n";
	private static final String EMTY_LINE = "";
	private static final String DEFAULT_SEPARATOR = ",";

	public int add(String numbers) throws NegativeNotAllowed {
		List<String> lines = getLines(numbers);
		String separator = getSeparator(lines.get(0));
		
		if(isSeparatorHeader(lines.get(0)))
				lines.remove(0);
		
		int total = 0;
		for(String line: lines)
				total += computeLine(line, separator);
		return total;
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

	private int computeLine(String line, String separator) throws NegativeNotAllowed {
		if(isEmpty(line))
			return 0;
		
		int total = 0;
		for(String number: getNumbersFrom(line, separator)) {
			int num = Integer.parseInt(number);
			if(num < 0)
				throw new NegativeNotAllowed(String.valueOf(num));
			total += num;
		}
		return total;
	}

	private List<String> getNumbersFrom(String lineNumbers, String separator) {
		return Arrays.asList(lineNumbers.split(separator));
	}

	private List<String> getLines(String data) {
		return new LinkedList(Arrays.asList(data.split(NEW_LINE_SEQUENCE)));
	}

	private boolean isEmpty(String line) {
		return EMTY_LINE.equals(line);
	}
}
