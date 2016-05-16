package classroom.io;

/**
 * Created by stran on 10.05.2016.
 */
public class InvalidNumberException extends FormException {
    public InvalidNumberException(String message) {
        super(message);
    }

    public InvalidNumberException(String message, String field) {
        super(message, field);
    }

    public InvalidNumberException() {
    }
}
