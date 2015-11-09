package string_calculator_kata;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StringCalculator {

	private static final String SEPARATOR_HEADER_PREFIX = "//";
	private static final String NEW_LINE_SEQUENCE = "\n";
	private static final String EMTY_LINE = "";
	private static final String SEPARATOR = ",";

	public int add(String numbers) {
		int total = 0;
		List<String> lines = getLines(numbers);
		
		String separator = getSeparator(lines);
		
		for(String line: lines) {
				total += computeLine(line, separator);
		}
		return total;
   }

	private String getSeparator(List<String> lines) {
		String separator = SEPARATOR;
		if(isSeparatorHeader(lines.get(0))) {
			separator = parseSeparator(lines.get(0));
			lines.remove(0);
		}
		return separator;
	}

	private boolean isSeparatorHeader(String line) {
		return line.startsWith(SEPARATOR_HEADER_PREFIX);
	}

	private String parseSeparator(String line) {
		return line.substring(SEPARATOR_HEADER_PREFIX.length());
	}

	private int computeLine(String line, String separator) {
		if(isEmpty(line))
			return 0;
		
		int total = 0;
		for(String number: getNumbersFrom(line, separator)) 
			total += Integer.parseInt(number);
		
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
