package bg.fmi.uni.sofia.exceptions;

public class UserNotThereException extends Exception{
    public UserNotThereException(String message) {
        super(message);
    }

    public UserNotThereException(String message, Throwable cause) {
        super(message);
    }
}
