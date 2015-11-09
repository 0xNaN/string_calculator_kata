package string_calculator_kata;

import static java.lang.Integer.valueOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringCalculatorParameterizedTest {
	
	@Rule public JUnitRuleMockery context = new JUnitRuleMockery();
	
	final ILogger logger = context.mock(ILogger.class);
	final IWebService webService = context.mock(IWebService.class);
	
	StringCalculator calculator;

	String numbers;
	int sum;

	public StringCalculatorParameterizedTest(String numbers, Integer sum) {
		this.numbers = numbers;
		this.sum = sum;
	}

	@Before
	public void setUp() {
		calculator = new StringCalculator(logger, webService);	
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
	public void checkAll() throws Exception {
		context.checking(new Expectations() {{
			oneOf(logger).write(valueOf(sum).toString());
		}});
		
		try {
			assertEquals(sum, calculator.add(numbers));
		} catch (NegativeNotAllowed e) {
			fail("should not throw NegativeNotAllowed Exception with: " + this.numbers);
		}
	}
	
}