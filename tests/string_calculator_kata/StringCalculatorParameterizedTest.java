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
				{"1,1,1,1,1,1,1", 7},
				{"0\n", 0},
				{"1\n1", 2},
				{"1\n2,3", 6},
				{"1,2\n3,4,5", 15},
				{"//;\n1;2", 3},
				{"//;\n1;2;3\n1\n4;5", 16},
				{"//-\n1-2", 3},
				{"//:\n1:1\n1\n10:10", 23}
		});
	}

	@Test
	public void checkAll() {
		try {
			assertEquals(sum, sc.add(numbers));
		} catch (NegativeNotAllowed e) {
			fail("should not throw NegativeNotAllowed Exception with: " + this.numbers);
		}
	}

	@Test
	public void
	should_return_zero_for_empty_string() {
		try {
			assertEquals(0, sc.add(""));
		} catch (NegativeNotAllowed e) {
			fail("should not throw NegativeNotAllowed Exception");
		}
	}

	@Test
	public void
	should_raise_an_exception_for_a_negative_number() {
		try {
			sc.add("-1");
			fail("Should raise an exception");
		} catch (NegativeNotAllowed e) {
			assertEquals("-1", e.getMessage());
		}
	}
	
}