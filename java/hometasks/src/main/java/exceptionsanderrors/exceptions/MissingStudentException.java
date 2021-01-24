package exceptionsanderrors.exceptions;

public class MissingStudentException extends Exception {
    public MissingStudentException() {
    }

    public MissingStudentException(String message) {
        super(message);
    }

    public MissingStudentException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingStudentException(Throwable cause) {
        super(cause);
    }
}
