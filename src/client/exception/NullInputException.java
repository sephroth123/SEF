package client.exception;

public class NullInputException extends Exception {

	public NullInputException(String s) {
		super(s + "can not be null !");
	}
}
