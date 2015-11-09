package string_calculator_kata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class StringCalculatorTest {
	final String exceptionMessage = "a message";
	@Rule public JUnitRuleMockery context = new JUnitRuleMockery();
	
	final ILogger logger = context.mock(ILogger.class);
	final IWebService webService = context.mock(IWebService.class);
	
	StringCalculator calculator;

	@Before
	public void setUp() {
		calculator = new StringCalculator(logger, webService);	
	}

	@Test
	public void
	should_return_zero_for_empty_string() throws Exception {
		context.checking(new Expectations() {{
			oneOf(logger).write("0");
		}});
		
		try {
			assertEquals(0, calculator.add(""));
		} catch (NegativeNotAllowed e) {
			fail("should not throw NegativeNotAllowed Exception");
		}
	}

	@Test
	public void
	should_raise_an_exception_for_a_negative_number() {
		try {
			calculator.add("-1");
			fail("Should raise an exception");
		} catch (NegativeNotAllowed e) {
			assertEquals("[-1]", e.getMessage());
		}
	}
	
	@Test
	public void
	should_raise_an_exception_showing_all_negative_numbers() {
		try {
			calculator.add("-1,-3\n0\n4,-2");
			fail("Should raise an exception");
		} catch (NegativeNotAllowed e) {
			assertEquals("[-1, -3, -2]", e.getMessage());
		}
	}
	
	@Test
	public void
	should_log_the_sum_on_the_logger() throws Exception {
		context.checking(new Expectations() {{
			oneOf(logger).write("1");
		}});
		
		try {
			calculator.add("1");
		} catch (NegativeNotAllowed e) {
			fail("should not throw NegativeNotAllowed Exception");
		}
	}
	
	@Test
	public void
	should_notify_web_service_if_logger_fails() throws Exception {		
		context.checking(new Expectations() {{
			allowing(logger).write(with(any(String.class)));
				will(throwException(new Exception(exceptionMessage)));
			oneOf(webService).send(exceptionMessage);
		}});
		
		try {
			calculator.add("1");
		} catch (NegativeNotAllowed e) {
			fail("should not throw NegativeNotAllowed Exception");
		}
	}
}