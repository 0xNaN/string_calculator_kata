package string_calculator_kata;

public class NegativeNotAllowed extends Exception {
	private static final long serialVersionUID = 1L;

	public NegativeNotAllowed(String message) {
		super(message);
	}
}
