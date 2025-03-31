package bg.fmi.uni.sofia.exceptions;

public class InterestAlreadyAddedException extends Exception {

    public InterestAlreadyAddedException(String message) {
        super(message);
    }

    public InterestAlreadyAddedException(String message, Throwable cause) {
        super(message, cause);
    }
}
