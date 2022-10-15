package itmo.soa.exceptions;

public class IllegalAgeException extends Exception{

    public IllegalAgeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalAgeException(String message) {
        super(message);
    }

    public IllegalAgeException() {
    }
}
