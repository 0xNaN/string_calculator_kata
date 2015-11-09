package string_calculator_kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalulcatorTest {
	
	@Test
	public void
	should_return_zero_for_empty_string() {
		StringCalculator sc = new StringCalculator();
		assertEquals(0, sc.add(""));
	}
}
