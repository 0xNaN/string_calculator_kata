package string_calculator_kata;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

	private static final String NEW_LINE_SEQUENCE = "\n";
	private static final String EMTY_LINE = "";
	private static final String SEPARATOR = ",";

	public int add(String numbers) {
		int total = 0;
		String[] lines = getLines(numbers);
		String separator = getSeparator(lines[0]);
		for(String line: lines) {
				total += computeLine(line, separator);
		}
		return total;
   }

	private String getSeparator(String string) {
		return SEPARATOR;
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

	private String[] getLines(String data) {
		return data.split(NEW_LINE_SEQUENCE);
	}

	private boolean isEmpty(String line) {
		return EMTY_LINE.equals(line);
	}
}
