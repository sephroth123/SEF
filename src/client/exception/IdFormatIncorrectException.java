package client.exception;

public class IdFormatIncorrectException extends Exception {

	public IdFormatIncorrectException(String s) {
		super("the format of " + s + " id is incorrect!");
	}

}
