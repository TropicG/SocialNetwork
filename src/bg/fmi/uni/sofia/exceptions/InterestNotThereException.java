package bg.fmi.uni.sofia.exceptions;

public class InterestNotThereException extends Exception{

    public InterestNotThereException(String message) {
        super(message);
    }

    public InterestNotThereException(String message, Throwable cause) {
        super(message);
    }
}
