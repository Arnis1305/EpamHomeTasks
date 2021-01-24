package exceptionsanderrors.exceptions;

public class MissingGroupException extends Exception{
    public MissingGroupException() {
    }

    public MissingGroupException(String message) {
        super(message);
    }

    public MissingGroupException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingGroupException(Throwable cause) {
        super(cause);
    }
}
