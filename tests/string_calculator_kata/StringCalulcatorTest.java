package string_calculator_kata;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringCalulcatorTest {
	StringCalculator sc;
	
	@Before
	public void setUp() {
		sc = new StringCalculator();	
	}
	
	@Test
	public void
	should_return_zero_for_empty_string() {
		assertEquals(0, sc.add(""));
	}
	
	@Test
	public void
	should_return_one_for_a_string_with_only_one() {
		assertEquals(1, sc.add("1"));
	}
	
	@Test
	public void
	should_return_ten_for_a_string_with_only_ten() {
		assertEquals(10, sc.add("10"));
	}
	
	@Test
	public void
	should_return_the_sum_two_numbers_in_the_line() {
		assertEquals(2, sc.add("1,1"));
	}
	
	@Test
	public void
	should_Return_the_sum_of_multiple_numbers() {
		assertEquals(3, sc.add("1,1,1"));
	}
}