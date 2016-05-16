package classroom.io;

/**
 * Created by stran on 10.05.2016.
 */
public class WeakPasswordException extends FormException {
    public WeakPasswordException(String message) {
        super(message);
    }

    public WeakPasswordException(String message, String field) {
        super(message, field);
    }

    public WeakPasswordException() {
    }
}
