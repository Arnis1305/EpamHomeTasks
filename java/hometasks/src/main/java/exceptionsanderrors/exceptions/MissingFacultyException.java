package exceptionsanderrors.exceptions;

public class MissingFacultyException extends Exception {
    public MissingFacultyException() {
    }

    public MissingFacultyException(String message) {
        super(message);
    }

    public MissingFacultyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissingFacultyException(Throwable cause) {
        super(cause);
    }
}
