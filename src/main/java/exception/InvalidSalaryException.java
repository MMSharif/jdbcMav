package exception;

@SuppressWarnings("serial")
public class InvalidSalaryException extends RuntimeException{

	public InvalidSalaryException(String message) {
		super(message);
	}
}
