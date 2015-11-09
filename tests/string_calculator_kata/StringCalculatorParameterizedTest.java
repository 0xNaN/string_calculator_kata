package string_calculator_kata;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringCalculatorParameterizedTest {
	StringCalculator sc;
	
	String numbers;
	int sum;
	
	public StringCalculatorParameterizedTest(String numbers, Integer sum) {
		this.numbers = numbers;
		this.sum = sum;
	}
	
	@Before
	public void setUp() {
		sc = new StringCalculator();	
	}
	
	@Parameters
	public static Collection<Object[]> testCases() {
		return Arrays.asList(new Object[][] {
				{"0", 0},
				{"1", 1},
				{"10", 10},
				{"1,1", 2},
				{"1,1,1", 3},
				{"1,2,3,4,5", 15},
				{"1,1,1,1,1,1,1", 7}
				});
	}
	
	@Test
	public void checkAll() {
		assertEquals(sum, sc.add(numbers));
	}
	
	@Test
	public void
	should_return_zero_for_empty_string() {
		assertEquals(0, sc.add(""));
	}
	
}