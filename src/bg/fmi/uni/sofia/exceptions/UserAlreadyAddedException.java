package bg.fmi.uni.sofia.exceptions;

public class UserAlreadyAddedException extends Exception{

    public UserAlreadyAddedException(String message) {
        super(message);
    }

    public UserAlreadyAddedException(String message, Throwable cause) {
        super(message);
    }

}
