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
	
	@Test
	public void
	should_return_one_for_a_string_with_only_one() {
		StringCalculator sc = new StringCalculator();
		assertEquals(1, sc.add("1"));
	}
}
