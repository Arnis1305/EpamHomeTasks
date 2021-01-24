package exceptionsanderrors.exceptions;

public class MissingSubjectException extends Exception {
    public MissingSubjectException() {
    }

    public MissingSubjectException(String message) {
        super(message);
    }

    public MissingSubjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingSubjectException(Throwable cause) {
        super(cause);
    }
}
